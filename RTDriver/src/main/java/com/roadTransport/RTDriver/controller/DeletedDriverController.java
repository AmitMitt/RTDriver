package com.roadTransport.RTDriver.controller;

import com.roadTransport.RTDriver.entity.DeletedDriverDetails;
import com.roadTransport.RTDriver.service.DeletedDriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/DeletedData")
public class DeletedDriverController {

    @Autowired
    private DeletedDriverService deletedDriverService;

    @Cacheable(value = "DeletedDriver", key = "#driverMobileNumber")
    @GetMapping("/getDeletedData/{driverMobileNumber}")
    public ResponseEntity<DeletedDriverDetails> getByMdn(@PathVariable("driverMobileNumber") Long driverMobileNumber) throws Exception {

        DeletedDriverDetails deletedDriverDetails = deletedDriverService.findByMdn(driverMobileNumber);
        return ResponseEntity.ok(deletedDriverDetails);
    }

    @Cacheable(value = "DeletedDriver", key = "#driverMobileNumber")
    @GetMapping("/getListOfDeletedData")
    public Page<DeletedDriverDetails> getData(Pageable pageable){

        Page<DeletedDriverDetails> list = deletedDriverService.listAllByPage(PageRequest.of(0, 10, Sort.Direction.ASC));
        return list;
    }
}
