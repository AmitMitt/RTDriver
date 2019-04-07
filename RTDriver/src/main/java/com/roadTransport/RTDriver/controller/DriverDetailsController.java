package com.roadTransport.RTDriver.controller;

import com.roadTransport.RTDriver.entity.DriverDetails;
import com.roadTransport.RTDriver.model.DriverDetailsRequest;
import com.roadTransport.RTDriver.model.DriverDetailsResponse;
import com.roadTransport.RTDriver.model.SignUpRequest;
import com.roadTransport.RTDriver.model.otp.OtpRequest;
import com.roadTransport.RTDriver.service.DriverDetailsService;
import com.roadTransport.RTDriver.walletService.WalletPinRequest;
import com.roadTransport.RTDriver.walletService.WalletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/DriverDetails")
public class DriverDetailsController {

    @Autowired
    private DriverDetailsService driverDetailsService;

    @PostMapping("/addDriver")
    public ResponseEntity<DriverDetailsResponse> addDriver(@RequestBody SignUpRequest signUpRequest) throws Exception {

        driverDetailsService.add(signUpRequest);
        DriverDetailsResponse driverDetailsResponse = new DriverDetailsResponse();
        driverDetailsResponse.setMessage("Driver Add Successfully.");
        return ResponseEntity.ok(driverDetailsResponse);
    }

    @Cacheable(value = "DriverDetails", key = "#mobileNumber")
    @GetMapping("/getlistByPage")
    public Page<DriverDetails> getList(Pageable pageable){

        Page<DriverDetails> list = driverDetailsService.listAllByPage(PageRequest.of(0,10, Sort.Direction.ASC));
        return list;
    }

    @Cacheable(value = "DriverDetails", key = "#mobileNumber")
    @GetMapping("/getlist/{mobileNumber}")
    public ResponseEntity<DriverDetails> getListByMdn(@PathVariable("mobileNumber") String mobileNumber) throws Exception {

        DriverDetails driverDetails = driverDetailsService.get(mobileNumber);
        return ResponseEntity.ok(driverDetails);
    }

    @CachePut(value = "DriverDetails", key = "#mobileNumber")
    @PutMapping("/update")
    public ResponseEntity<DriverDetailsResponse> update (@RequestBody DriverDetailsRequest driverDetailsRequest){

        driverDetailsService.updateDriverDetails(driverDetailsRequest);
        DriverDetailsResponse driverDetailsResponse = new DriverDetailsResponse();
        driverDetailsResponse.setMessage("Successfully Updated.");
        return ResponseEntity.ok(driverDetailsResponse);
    }

    @CacheEvict(value = "DriverDetails", allEntries=true)
    @DeleteMapping("/delete")
    public ResponseEntity<DriverDetailsResponse> delete(@RequestBody OtpRequest otpRequest) throws Exception {

        driverDetailsService.deleteByOtp(otpRequest);
        DriverDetailsResponse driverDetailsResponse = new DriverDetailsResponse();
        driverDetailsResponse.setMessage("User Successfully Deleted.");
        driverDetailsResponse.setOtp(otpRequest.getOtp());
        return ResponseEntity.ok(driverDetailsResponse);
    }

    @CachePut(value = "DriverDetails", key = "#mobileNumber")
    @PutMapping("/updateDriverImage")
    public ResponseEntity<DriverDetailsResponse> updateUserImage(@RequestBody DriverDetailsRequest driverDetailsRequest){

        driverDetailsService.updateDriverImage(driverDetailsRequest);
        DriverDetailsResponse driverDetailsResponse = new DriverDetailsResponse();
        driverDetailsResponse.setMessage("Image Updated Successfully.");
        return ResponseEntity.ok(driverDetailsResponse);
    }

    @CachePut(value = "DriverDetails", key = "#mobileNumber")
    @PutMapping("/updateAdhaarImage")
    public ResponseEntity<DriverDetailsResponse> updateAdhaarImage(@RequestBody DriverDetailsRequest driverDetailsRequest){

        driverDetailsService.updateAadharCardImage(driverDetailsRequest);
        DriverDetailsResponse driverDetailsResponse = new DriverDetailsResponse();
        driverDetailsResponse.setMessage("Image Updated Successfully.");
        return ResponseEntity.ok(driverDetailsResponse);
    }

    @CachePut(value = "DriverDetails", key = "#mobileNumber")
    @PutMapping("/updatePanImage")
    public ResponseEntity<DriverDetailsResponse> updatePanImage(@RequestBody DriverDetailsRequest driverDetailsRequest){

        driverDetailsService.updatePanCardImage(driverDetailsRequest);
        DriverDetailsResponse driverDetailsResponse = new DriverDetailsResponse();
        driverDetailsResponse.setMessage("Image Updated Successfully.");
        return ResponseEntity.ok(driverDetailsResponse);
    }

    @CachePut(value = "DriverDetails", key = "#mobileNumber")
    @PutMapping("/updateLicenceImage")
    public ResponseEntity<DriverDetailsResponse> updateLicenceImage(@RequestBody DriverDetailsRequest driverDetailsRequest){

        driverDetailsService.updateLicenceImage(driverDetailsRequest);
        DriverDetailsResponse driverDetailsResponse = new DriverDetailsResponse();
        driverDetailsResponse.setMessage("Image Updated Successfully.");
        return ResponseEntity.ok(driverDetailsResponse);
    }

    @CachePut(value = "DriverDetails", key = "#mobileNumber")
    @PutMapping("/updateStatus")
    public ResponseEntity<DriverDetailsResponse> updateStatus(@RequestBody DriverDetailsRequest driverDetailsRequest){

        driverDetailsService.updateDriverStatus(driverDetailsRequest);
        DriverDetailsResponse driverDetailsResponse = new DriverDetailsResponse();
        driverDetailsResponse.setMessage("Status has been change.");
        return ResponseEntity.ok(driverDetailsResponse);
    }

    @PostMapping("/updatePin")
    public ResponseEntity<WalletResponse> updatePin(@RequestBody WalletPinRequest walletPinRequest){

        driverDetailsService.updatePin(walletPinRequest);
        WalletResponse walletResponse = new WalletResponse();
        walletResponse.setMessage("Pin Updated.");
        return ResponseEntity.ok(walletResponse);
    }
}