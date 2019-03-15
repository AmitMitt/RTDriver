package com.roadTransport.RTDriver.service;

import com.roadTransport.RTDriver.entity.DriverDetails;
import com.roadTransport.RTDriver.model.DriverDetailsRequest;
import com.roadTransport.RTDriver.model.OtpRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface DriverDetailsService {

    public DriverDetails add (OtpRequest otpRequest) throws Exception;
    public DriverDetails get(long driverMobileNumber) throws Exception;
    public DriverDetails delete(long driverMobileNumber) throws Exception;
    public Page<DriverDetails> listAllByPage(Pageable pageable);
    public DriverDetails updateDriverDetails(DriverDetailsRequest driverDetailsRequest);
    public DriverDetails updateLicenceImage(DriverDetailsRequest driverDetailsRequest);
    public DriverDetails updatePanCardImage(DriverDetailsRequest driverDetailsRequest);
    public DriverDetails updateAadharCardImage(DriverDetailsRequest driverDetailsRequest);
    public DriverDetails updateDriverImage(DriverDetailsRequest driverDetailsRequest);
    public DriverDetails updateDriverStatus(DriverDetailsRequest driverDetailsRequest);

}
