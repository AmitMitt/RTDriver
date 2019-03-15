package com.roadTransport.RTDriver.controller;

import com.roadTransport.RTDriver.entity.DriverTemporaryDetails;
import com.roadTransport.RTDriver.model.DriverDetailsRequest;
import com.roadTransport.RTDriver.model.DriverDetailsResponse;
import com.roadTransport.RTDriver.service.DriverTemporaryDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/DriverTemporaryDetails")
public class DriverTemporaryDetailsController {

    @Autowired
    private DriverTemporaryDetailsService driverTemporaryDetailsService;

    @PostMapping("/add")
    public ResponseEntity<DriverDetailsResponse> add(@RequestBody DriverDetailsRequest driverDetailsRequest) throws Exception {

        DriverTemporaryDetails driverTemporaryDetails = driverTemporaryDetailsService.add(driverDetailsRequest);
        DriverDetailsResponse driverDetailsResponse = new DriverDetailsResponse();
        driverDetailsResponse.setMessage("please enter the otp for verification.");
        driverDetailsResponse.setOtp(driverTemporaryDetails.getOtp());
        return ResponseEntity.ok(driverDetailsResponse);
    }

    @Cacheable(value = "DriverTemporaryDetails", key = "#driverMobileNumber")
    @GetMapping("/getData/{driverMobileNumber}")
    public ResponseEntity<DriverTemporaryDetails> getDataByMdn(@PathVariable("driverMobileNumber") long driverMobileNumber) throws Exception {

        DriverTemporaryDetails driverTemporaryDetails = driverTemporaryDetailsService.getListByMdn(driverMobileNumber);
        return ResponseEntity.ok(driverTemporaryDetails);
    }

    @Cacheable(value = "DriverTemporaryDetails", key = "#driverMobileNumber")
    @GetMapping("/getlistByPage")
    public Page<DriverTemporaryDetails> getList(Pageable pageable){

        Page<DriverTemporaryDetails> list = driverTemporaryDetailsService.listAllByPage(pageable);
        return list;
    }

}
