package com.roadTransport.RTDriver.service;

import com.roadTransport.RTDriver.entity.DeletedDriverDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface DeletedDriverService {

    public Page<DeletedDriverDetails> listAllByPage(Pageable pageable);
    public DeletedDriverDetails findByMdn(long driverMobileNumber) throws Exception;
}
