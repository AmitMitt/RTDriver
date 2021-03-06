package com.roadTransport.RTDriver.service;

import com.roadTransport.RTDriver.entity.DriverDetails;
import com.roadTransport.RTDriver.model.DriverDetailsRequest;
import com.roadTransport.RTDriver.model.SignUpRequest;
import com.roadTransport.RTDriver.model.otp.OtpRequest;
import com.roadTransport.RTDriver.walletService.WalletPinRequest;
import com.roadTransport.RTDriver.walletService.WalletResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface DriverDetailsService {

    public DriverDetails add (SignUpRequest signUpRequest);
    public DriverDetails get(String mobileNumber) throws Exception;
    public Page<DriverDetails> listAllByPage(Pageable pageable);
    public DriverDetails updateDriverDetails(DriverDetailsRequest driverDetailsRequest);
    public DriverDetails updateLicenceImage(DriverDetailsRequest driverDetailsRequest);
    public DriverDetails updatePanCardImage(DriverDetailsRequest driverDetailsRequest);
    public DriverDetails updateAadharCardImage(DriverDetailsRequest driverDetailsRequest);
    public DriverDetails updateDriverImage(DriverDetailsRequest driverDetailsRequest);
    public DriverDetails updateDriverStatus(DriverDetailsRequest driverDetailsRequest);
    public DriverDetails deleteByOtp(OtpRequest otpRequest) throws Exception;
    public WalletResponse updatePin(WalletPinRequest walletPinRequest);

}
