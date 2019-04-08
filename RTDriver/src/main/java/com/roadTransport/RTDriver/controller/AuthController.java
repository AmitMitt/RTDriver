package com.roadTransport.RTDriver.controller;

import com.roadTransport.RTDriver.entity.Driver;
import com.roadTransport.RTDriver.entity.Role;
import com.roadTransport.RTDriver.entity.RoleName;
import com.roadTransport.RTDriver.exception.AppException;
import com.roadTransport.RTDriver.model.ApiResponse;
import com.roadTransport.RTDriver.model.JwtAuthenticationResponse;
import com.roadTransport.RTDriver.model.LoginRequest;
import com.roadTransport.RTDriver.model.SignUpRequest;
import com.roadTransport.RTDriver.repository.DriverRepository;
import com.roadTransport.RTDriver.repository.RoleRepository;
import com.roadTransport.RTDriver.security.JwtTokenProvider;
import com.roadTransport.RTDriver.service.DriverDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Collections;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    DriverRepository driverRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider tokenProvider;

    @Autowired
    DriverDetailsService driverDetailsService;

    @PostMapping("/signin/driver")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsernameOrEmail(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }

    @PostMapping("/signup/driver")
    public ResponseEntity<?> registerdriver(@Valid @RequestBody SignUpRequest signUpRequest) {
        if(driverRepository.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity(new ApiResponse(false, "Username is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }

        if(driverRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity(new ApiResponse(false, "Email Address already in use!"),
                    HttpStatus.BAD_REQUEST);
        }

        if(driverRepository.existsByMobile(signUpRequest.getMobile())){
            return new ResponseEntity(new ApiResponse(false, "Mobile already in use!"),
                    HttpStatus.BAD_REQUEST);
        }

        // Creating admin's account
        Driver driver = new Driver(signUpRequest.getName(), signUpRequest.getUsername(),
                signUpRequest.getEmail(), signUpRequest.getPassword(), signUpRequest.getMobile());

        driver.setPassword(passwordEncoder.encode(driver.getPassword()));

        Role userRole = roleRepository.findByName(RoleName.ROLE_DRIVER)
                .orElseThrow(() -> new AppException("User Role not set."));

        driver.setRoles(Collections.singleton(userRole));

        Driver result = driverRepository.save(driver);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/users/{username}")
                .buildAndExpand(result.getUsername()).toUri();

        driverDetailsService.add(signUpRequest);

        long pin = Long.parseLong(signUpRequest.getMobile()) % 10000;

        return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully and wallet pin is: "+pin + "  Please update it."));
    }

}
