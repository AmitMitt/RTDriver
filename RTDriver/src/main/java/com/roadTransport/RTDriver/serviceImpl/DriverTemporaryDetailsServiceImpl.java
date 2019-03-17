package com.roadTransport.RTDriver.serviceImpl;

import com.roadTransport.RTDriver.entity.DriverDetails;
import com.roadTransport.RTDriver.entity.DriverTemporaryDetails;
import com.roadTransport.RTDriver.model.DriverDetailsRequest;
import com.roadTransport.RTDriver.model.otp.OtpDetails;
import com.roadTransport.RTDriver.otpService.OtpService;
import com.roadTransport.RTDriver.repository.DriverDetailsRepository;
import com.roadTransport.RTDriver.repository.DriverTemporaryDetailsPageRepository;
import com.roadTransport.RTDriver.repository.DriverTemporaryDetailsRepository;
import com.roadTransport.RTDriver.service.DriverTemporaryDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;

@Service
public class DriverTemporaryDetailsServiceImpl implements DriverTemporaryDetailsService {

    @Autowired
    private DriverDetailsRepository driverDetailsRepository;

    @Autowired
    private OtpService otpService;

    @Autowired
    private DriverTemporaryDetailsPageRepository driverTemporaryDetailsPageRepository;

    @Autowired
    private DriverTemporaryDetailsRepository driverTemporaryDetailsRepository;


    @Override
    public DriverTemporaryDetails add(DriverDetailsRequest driverDetailsRequest) throws Exception {

        DriverTemporaryDetails driverTemporaryDetails = driverTemporaryDetailsRepository.findByMdn(driverDetailsRequest.getMobileNumber());
        DriverDetails driverDetails = driverDetailsRepository.findByMdn(driverDetailsRequest.getMobileNumber());

        if(driverDetails!=null){
            throw new Exception("Mobile Number Already Exist.");
        }

        if(driverTemporaryDetails==null){

            DriverTemporaryDetails driverTemporaryDetails1 = new DriverTemporaryDetails();
            driverTemporaryDetails1.setAadharCardNumber(driverDetailsRequest.getAadharCardNumber());
            driverTemporaryDetails1.setAdhaarCardImage(driverDetailsRequest.getAdhaarCardImage());
            driverTemporaryDetails1.setCreatedDate(new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()));
            driverTemporaryDetails1.setDescription(driverDetailsRequest.getDescription());
            driverTemporaryDetails1.setDob(driverDetailsRequest.getDob());
            driverTemporaryDetails1.setDriverAddress(driverDetailsRequest.getDriverAddress());
            driverTemporaryDetails1.setDriverAge(driverDetailsRequest.getDriverAge());
            driverTemporaryDetails1.setDriverImage(Base64.getEncoder().encodeToString(driverDetailsRequest.getDriverImage().getBytes()));
            driverTemporaryDetails1.setDriverName(driverDetailsRequest.getDriverName());
            driverTemporaryDetails1.setLicenceImage(Base64.getEncoder().encodeToString(driverDetailsRequest.getLicenceImage().getBytes()));
            driverTemporaryDetails1.setLicenceNumber(driverDetailsRequest.getLicenceNumber());
            driverTemporaryDetails1.setMobileNumber(driverDetailsRequest.getMobileNumber());
            driverTemporaryDetails1.setPanCardImage(Base64.getEncoder().encodeToString(driverDetailsRequest.getPanCardImage().getBytes()));
            driverTemporaryDetails1.setPanCardNumber(driverDetailsRequest.getPanCardNumber());
            driverTemporaryDetails1.setStatus(false);
            driverTemporaryDetails1.setKyc(false);
            driverTemporaryDetails1.setTransportName(driverDetailsRequest.getTransportName());
            driverTemporaryDetails1.setTransportNumber(driverDetailsRequest.getTransportNumber());
            driverTemporaryDetails1.setVehicleNumber(driverDetailsRequest.getVehicleNumber());
            driverTemporaryDetails1.setVehicleType(driverDetailsRequest.getVehicleType());

            OtpDetails otpDetails = otpService.getOtp(driverDetailsRequest.getMobileNumber());
            driverTemporaryDetails1.setOtp(otpDetails.getOtpNumber());
            driverTemporaryDetailsRepository.saveAndFlush(driverTemporaryDetails1);
            return driverTemporaryDetails1;
        }
        else{

            driverTemporaryDetails.setAadharCardNumber(driverDetailsRequest.getAadharCardNumber());
            driverTemporaryDetails.setAdhaarCardImage(driverDetailsRequest.getAdhaarCardImage());
            driverTemporaryDetails.setModifiedDate(new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()));
            driverTemporaryDetails.setDescription(driverDetailsRequest.getDescription());
            driverTemporaryDetails.setDob(driverDetailsRequest.getDob());
            driverTemporaryDetails.setDriverAddress(driverDetailsRequest.getDriverAddress());
            driverTemporaryDetails.setDriverAge(driverDetailsRequest.getDriverAge());
            driverTemporaryDetails.setDriverImage(Base64.getEncoder().encodeToString(driverDetailsRequest.getDriverImage().getBytes()));
            driverTemporaryDetails.setDriverName(driverDetailsRequest.getDriverName());
            driverTemporaryDetails.setLicenceImage(Base64.getEncoder().encodeToString(driverDetailsRequest.getLicenceImage().getBytes()));
            driverTemporaryDetails.setLicenceNumber(driverDetailsRequest.getLicenceNumber());
            driverTemporaryDetails.setMobileNumber(driverDetailsRequest.getMobileNumber());
            driverTemporaryDetails.setPanCardImage(Base64.getEncoder().encodeToString(driverDetailsRequest.getPanCardImage().getBytes()));
            driverTemporaryDetails.setPanCardNumber(driverDetailsRequest.getPanCardNumber());
            driverTemporaryDetails.setStatus(false);
            driverTemporaryDetails.setKyc(false);
            driverTemporaryDetails.setTransportName(driverDetailsRequest.getTransportName());
            driverTemporaryDetails.setTransportNumber(driverDetailsRequest.getTransportNumber());
            driverTemporaryDetails.setVehicleNumber(driverDetailsRequest.getVehicleNumber());
            driverTemporaryDetails.setVehicleType(driverDetailsRequest.getVehicleType());

            OtpDetails otpDetails = otpService.getOtp(driverDetailsRequest.getMobileNumber());
            driverTemporaryDetails.setOtp(otpDetails.getOtpNumber());
            driverTemporaryDetailsRepository.saveAndFlush(driverTemporaryDetails);
            return driverTemporaryDetails;
        }
    }

    @Override
    public DriverTemporaryDetails getListByMdn(long driverMobileNumber) throws Exception {

        DriverTemporaryDetails driverTemporaryDetails = driverTemporaryDetailsRepository.findByMdn(driverMobileNumber);

        return driverTemporaryDetails;
    }

    @Override
    public Page<DriverTemporaryDetails> listAllByPage(Pageable pageable) {
        return driverTemporaryDetailsPageRepository.findAll(pageable);
    }

}
