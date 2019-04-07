package com.roadTransport.RTDriver.serviceImpl;

import com.roadTransport.RTDriver.entity.DriverDetails;
import com.roadTransport.RTDriver.model.DriverDetailsRequest;
import com.roadTransport.RTDriver.model.SignUpRequest;
import com.roadTransport.RTDriver.model.otp.OtpRequest;
import com.roadTransport.RTDriver.otpService.OtpService;
import com.roadTransport.RTDriver.repository.DriverDetailsPageRepository;
import com.roadTransport.RTDriver.repository.DriverDetailsRepository;
import com.roadTransport.RTDriver.service.DriverDetailsService;
import com.roadTransport.RTDriver.walletService.WalletPinRequest;
import com.roadTransport.RTDriver.walletService.WalletRequest;
import com.roadTransport.RTDriver.walletService.WalletResponse;
import com.roadTransport.RTDriver.walletService.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Base64;
import java.util.Calendar;
import java.util.TimeZone;

@Service
public class DriverDetailsServiceImpl implements DriverDetailsService {

   @Autowired
   private OtpService otpService;

   @Autowired
   private DriverDetailsRepository driverDetailsRepository;

   @Autowired
   private DriverDetailsPageRepository driverDetailsPageRepository;

   @Autowired
   private WalletService walletService;

    @Override
    public DriverDetails add(SignUpRequest signUpRequest) throws Exception {


        DriverDetails driverDetails = new DriverDetails();
        driverDetails.setDeleted(false);
        driverDetails.setStatus(false);
        driverDetails.setKyc(false);
        driverDetails.setDriverName(signUpRequest.getName());
        driverDetails.setMobileNumber(signUpRequest.getMobile());
        driverDetails.setCreatedDate(Calendar.getInstance(TimeZone.getTimeZone("UTC")).getTimeInMillis());
        driverDetails.setEmail(signUpRequest.getEmail());

        WalletRequest walletRequest = new WalletRequest();
        walletRequest.setOwnerName(signUpRequest.getName());
        walletRequest.setWalletId(Long.parseLong(signUpRequest.getMobile()));
        long pin = Long.parseLong(signUpRequest.getMobile()) % 10000;
        walletRequest.setWalletPin(String.valueOf(pin));
        walletService.add(walletRequest);

        driverDetailsRepository.saveAndFlush(driverDetails);

        return driverDetails;
    }

    @Override
    public DriverDetails get(String  mobileNumber) throws Exception {

       DriverDetails driverDetails = driverDetailsRepository.findByMdn(mobileNumber);
       if(driverDetails==null){
           throw new Exception("Driver not Exist.");
       }
       return driverDetails;
    }

    @Override
    public Page<DriverDetails> listAllByPage(Pageable pageable) {
        return driverDetailsPageRepository.findAll(pageable);
    }

    @Override
    public DriverDetails updateDriverDetails(DriverDetailsRequest driverDetailsRequest) {

        DriverDetails driverDetails = driverDetailsRepository.findByMdn(driverDetailsRequest.getMobileNumber());

        driverDetails.setAadharCardNumber(driverDetailsRequest.getAadharCardNumber());
        driverDetails.setModifiedDate(Calendar.getInstance(TimeZone.getTimeZone("UTC")).getTimeInMillis());
        driverDetails.setDescription(driverDetailsRequest.getDescription());
        driverDetails.setDob(driverDetailsRequest.getDob());
        driverDetails.setDriverAddress(driverDetailsRequest.getDriverAddress());
        driverDetails.setDriverAge(driverDetailsRequest.getDriverAge());
        driverDetails.setDriverName(driverDetailsRequest.getDriverName());
        driverDetails.setKyc(true);
        driverDetails.setLicenceNumber(driverDetailsRequest.getLicenceNumber());
        driverDetails.setPanCardNumber(driverDetailsRequest.getPanCardNumber());
        driverDetails.setStatus(true);
        driverDetails.setTransportName(driverDetailsRequest.getTransportName());
        driverDetails.setTransportNumber(driverDetailsRequest.getTransportNumber());
        driverDetails.setVehicleNumber(driverDetailsRequest.getVehicleNumber());
        driverDetails.setVehicleType(driverDetailsRequest.getVehicleType());
        driverDetails.setDeleted(false);
        driverDetailsRepository.saveAndFlush(driverDetails);
        return driverDetails;
    }

    @Override
    public DriverDetails updateLicenceImage(DriverDetailsRequest driverDetailsRequest) {

        DriverDetails driverDetails = driverDetailsRepository.findByMdn(driverDetailsRequest.getMobileNumber());
        driverDetails.setLicenceImage(Base64.getEncoder().encodeToString(driverDetailsRequest.getLicenceImage().getBytes()));
        driverDetailsRepository.saveAndFlush(driverDetails);
        return driverDetails;
    }

    @Override
    public DriverDetails updatePanCardImage(DriverDetailsRequest driverDetailsRequest) {

        DriverDetails driverDetails = driverDetailsRepository.findByMdn(driverDetailsRequest.getMobileNumber());
        driverDetails.setPanCardImage(Base64.getEncoder().encodeToString(driverDetailsRequest.getPanCardImage().getBytes()));
        driverDetailsRepository.saveAndFlush(driverDetails);
        return driverDetails;
    }

    @Override
    public DriverDetails updateAadharCardImage(DriverDetailsRequest driverDetailsRequest) {

        DriverDetails driverDetails = driverDetailsRepository.findByMdn(driverDetailsRequest.getMobileNumber());
        driverDetails.setAdhaarCardImage(Base64.getEncoder().encodeToString(driverDetailsRequest.getAdhaarCardImage().getBytes()));
        driverDetailsRepository.saveAndFlush(driverDetails);
        return driverDetails;
    }

    @Override
    public DriverDetails updateDriverImage(DriverDetailsRequest driverDetailsRequest) {

        DriverDetails driverDetails = driverDetailsRepository.findByMdn(driverDetailsRequest.getMobileNumber());
        driverDetails.setDriverImage(Base64.getEncoder().encodeToString(driverDetailsRequest.getDriverImage().getBytes()));
        driverDetailsRepository.saveAndFlush(driverDetails);
        return driverDetails;
    }

    @Override
    public DriverDetails updateDriverStatus(DriverDetailsRequest driverDetailsRequest) {

        DriverDetails driverDetails = driverDetailsRepository.findByMdn(driverDetailsRequest.getMobileNumber());
        driverDetails.setStatus(driverDetailsRequest.isStatus());
        driverDetailsRepository.saveAndFlush(driverDetails);
        return driverDetails;
    }

    @Override
    public DriverDetails deleteByOtp(OtpRequest otpRequest) throws Exception {

        DriverDetails driverDetails = driverDetailsRepository.findByMdn(String.valueOf(otpRequest.getUserMobileNumber()));

        boolean verify = otpService.verify(otpRequest.getOtp(),otpRequest.getUserMobileNumber());

        if(verify == false){

            throw new Exception("Otp is Expired.");
        }
        driverDetails.setDeleted(true);
        driverDetailsRepository.saveAndFlush(driverDetails);
        return null;
    }

    @Override
    public WalletResponse updatePin(WalletPinRequest walletPinRequest){

        walletService.updatePin(walletPinRequest);
        return null;
    }
}