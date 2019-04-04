package com.roadTransport.RTDriver.service;

import com.roadTransport.RTDriver.entity.DriverTemporaryDetails;
import com.roadTransport.RTDriver.model.DriverDetailsRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface DriverTemporaryDetailsService {

    public DriverTemporaryDetails add (DriverDetailsRequest driverDetailsRequest) throws Exception;
    public DriverTemporaryDetails getListByMdn(String mobileNumber) throws Exception;
    public Page<DriverTemporaryDetails> listAllByPage(Pageable pageable);

}
