package com.roadTransport.RTDriver.controller;

import com.roadTransport.RTDriver.entity.Driver;
import com.roadTransport.RTDriver.exception.ResourceNotFoundException;
import com.roadTransport.RTDriver.model.UserIdentityAvailability;
import com.roadTransport.RTDriver.model.UserProfile;
import com.roadTransport.RTDriver.model.UserSummary;
import com.roadTransport.RTDriver.repository.DriverRepository;
import com.roadTransport.RTDriver.security.CurrentUser;
import com.roadTransport.RTDriver.security.UserPrincipal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private DriverRepository driverRepository;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER')")
    public UserSummary getCurrentUser(@CurrentUser UserPrincipal currentUser) {
        UserSummary userSummary = new UserSummary(currentUser.getId(), currentUser.getUsername(), currentUser.getName());
        return userSummary;
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public UserSummary getCurrentAdmin(@CurrentUser UserPrincipal currentUser) {
        UserSummary userSummary = new UserSummary(currentUser.getId(), currentUser.getUsername(), currentUser.getName());
        return userSummary;
    }

    @GetMapping("/user/checkUsernameAvailability")
    public UserIdentityAvailability checkUsernameAvailability(@RequestParam(value = "username") String username) {
        Boolean isAvailable = driverRepository.existsByUsername(username);
        return new UserIdentityAvailability(isAvailable);
    }

    @GetMapping("/user/checkEmailAvailability")
    public UserIdentityAvailability checkEmailAvailability(@RequestParam(value = "email") String email) {
        Boolean isAvailable = driverRepository.existsByEmail(email);
        return new UserIdentityAvailability(isAvailable);
    }

    @GetMapping("/users/{username}")
    public UserProfile getUserProfile(@PathVariable(value = "username") String username) {
        Driver driver = driverRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));

        UserProfile userProfile = new UserProfile(driver.getId(), driver.getUsername(), driver.getName(), driver.getCreatedAt());

        return userProfile;
    }
}