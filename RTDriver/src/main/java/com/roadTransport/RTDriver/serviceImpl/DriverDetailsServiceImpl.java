package com.roadTransport.RTDriver.serviceImpl;

import com.roadTransport.RTDriver.entity.DeletedDriverDetails;
import com.roadTransport.RTDriver.entity.DriverDetails;
import com.roadTransport.RTDriver.entity.DriverTemporaryDetails;
import com.roadTransport.RTDriver.model.DriverDetailsRequest;
import com.roadTransport.RTDriver.model.otp.OtpDetails;
import com.roadTransport.RTDriver.model.otp.OtpRequest;
import com.roadTransport.RTDriver.otpService.OtpService;
import com.roadTransport.RTDriver.repository.DriverDetailsPageRepository;
import com.roadTransport.RTDriver.repository.DriverDetailsRepository;
import com.roadTransport.RTDriver.repository.DriverTemporaryDetailsRepository;
import com.roadTransport.RTDriver.repository.deletedRepository.DeletedDriverRepository;
import com.roadTransport.RTDriver.service.DriverDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;

@Service
public class DriverDetailsServiceImpl implements DriverDetailsService {

   @Autowired
   private OtpService otpService;

   @Autowired
   private DriverTemporaryDetailsRepository driverTemporaryDetailsRepository;

   @Autowired
   private DriverDetailsRepository driverDetailsRepository;

   @Autowired
   private DriverDetailsPageRepository driverDetailsPageRepository;

   @Autowired
   private DeletedDriverRepository deletedDriverRepository;

    @Override
    public DriverDetails add(OtpRequest otpRequest) throws Exception {

        DriverTemporaryDetails driverTemporaryDetails = driverTemporaryDetailsRepository.findByMdn(otpRequest.getUserMobileNumber());

        if(driverTemporaryDetails == null){
            throw new Exception("Driver not exist.");
        }

        boolean verify = otpService.verify(otpRequest.getOtp(),otpRequest.getUserMobileNumber());

        if(verify == false){

            throw new Exception("Otp is Expired.");
        }

        else{

            DriverDetails driverDetails = new DriverDetails();
            driverDetails.setAadharCardNumber(driverTemporaryDetails.getAadharCardNumber());
            driverDetails.setAdhaarCardImage(driverTemporaryDetails.getAdhaarCardImage());
            driverDetails.setCreatedDate(new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()));
            driverDetails.setDescription(driverTemporaryDetails.getDescription());
            driverDetails.setDob(driverTemporaryDetails.getDob());
            driverDetails.setDriverAddress(driverTemporaryDetails.getDriverAddress());
            driverDetails.setDriverAge(driverTemporaryDetails.getDriverAge());
            driverDetails.setDriverImage(driverTemporaryDetails.getDriverImage());
            driverDetails.setDriverName(driverTemporaryDetails.getDriverName());
            driverDetails.setKyc(true);
            driverDetails.setLicenceImage(driverTemporaryDetails.getLicenceImage());
            driverDetails.setLicenceNumber(driverTemporaryDetails.getLicenceNumber());
            driverDetails.setMobileNumber(driverTemporaryDetails.getMobileNumber());
            driverDetails.setPanCardImage(driverTemporaryDetails.getPanCardImage());
            driverDetails.setPanCardNumber(driverTemporaryDetails.getPanCardNumber());
            driverDetails.setStatus(true);
            driverDetails.setTransportName(driverTemporaryDetails.getTransportName());
            driverDetails.setTransportNumber(driverTemporaryDetails.getTransportNumber());
            driverDetails.setVehicleNumber(driverTemporaryDetails.getVehicleNumber());
            driverDetails.setVehicleType(driverTemporaryDetails.getVehicleType());

            driverDetailsRepository.saveAndFlush(driverDetails);
            return driverDetails;
        }
    }

    @Override
    public DriverDetails get(long driverMobileNumber) throws Exception {

       DriverDetails driverDetails = driverDetailsRepository.findByMdn(driverMobileNumber);
       if(driverDetails==null){
           throw new Exception("Driver not Exist.");
       }
       return driverDetails;
    }

    @Override
    public DeletedDriverDetails delete(long driverMobileNumber) throws Exception {

        DriverDetails driverDetails = driverDetailsRepository.findByMdn(driverMobileNumber);
        DeletedDriverDetails deletedDriverDetails = new DeletedDriverDetails();

        deletedDriverDetails.setAadharCardNumber(driverDetails.getAadharCardNumber());
        deletedDriverDetails.setAdhaarCardImage(driverDetails.getAdhaarCardImage());
        deletedDriverDetails.setCreatedDate(new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()));
        deletedDriverDetails.setDescription(driverDetails.getDescription());
        deletedDriverDetails.setDob(driverDetails.getDob());
        deletedDriverDetails.setDriverAddress(driverDetails.getDriverAddress());
        deletedDriverDetails.setDriverAge(driverDetails.getDriverAge());
        deletedDriverDetails.setDriverImage(driverDetails.getDriverImage());
        deletedDriverDetails.setDriverName(driverDetails.getDriverName());
        deletedDriverDetails.setLicenceImage(driverDetails.getLicenceImage());
        deletedDriverDetails.setLicenceNumber(driverDetails.getLicenceNumber());
        deletedDriverDetails.setMobileNumber(driverDetails.getMobileNumber());
        deletedDriverDetails.setPanCardImage(driverDetails.getPanCardImage());
        deletedDriverDetails.setPanCardNumber(driverDetails.getPanCardNumber());
        deletedDriverDetails.setStatus(false);
        deletedDriverDetails.setTransportName(driverDetails.getTransportName());
        deletedDriverDetails.setTransportNumber(driverDetails.getTransportNumber());
        deletedDriverDetails.setVehicleNumber(driverDetails.getVehicleNumber());
        deletedDriverDetails.setVehicleType(driverDetails.getVehicleType());
        OtpDetails otpDetails = otpService.getOtp(driverMobileNumber);
        deletedDriverDetails.setOtp(otpDetails.getOtpNumber());

        deletedDriverRepository.saveAndFlush(deletedDriverDetails);

        return deletedDriverDetails;
    }

    @Override
    public Page<DriverDetails> listAllByPage(Pageable pageable) {
        return driverDetailsPageRepository.findAll(pageable);
    }

    @Override
    public DriverDetails updateDriverDetails(DriverDetailsRequest driverDetailsRequest) {

        DriverDetails driverDetails = driverDetailsRepository.findByMdn(driverDetailsRequest.getMobileNumber());

        driverDetails.setAadharCardNumber(driverDetailsRequest.getAadharCardNumber());
        driverDetails.setModifiedDate(new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()));
        driverDetails.setDescription(driverDetailsRequest.getDescription());
        driverDetails.setDob(driverDetailsRequest.getDob());
        driverDetails.setDriverAddress(driverDetailsRequest.getDriverAddress());
        driverDetails.setDriverAge(driverDetailsRequest.getDriverAge());
        driverDetails.setDriverName(driverDetailsRequest.getDriverName());
        driverDetails.setKyc(true);
        driverDetails.setLicenceNumber(driverDetailsRequest.getLicenceNumber());
        driverDetails.setMobileNumber(driverDetailsRequest.getMobileNumber());
        driverDetails.setPanCardNumber(driverDetailsRequest.getPanCardNumber());
        driverDetails.setStatus(true);
        driverDetails.setTransportName(driverDetailsRequest.getTransportName());
        driverDetails.setTransportNumber(driverDetailsRequest.getTransportNumber());
        driverDetails.setVehicleNumber(driverDetailsRequest.getVehicleNumber());
        driverDetails.setVehicleType(driverDetailsRequest.getVehicleType());

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

        DriverDetails driverDetails = driverDetailsRepository.findByMdn(otpRequest.getUserMobileNumber());

        boolean verify = otpService.verify(otpRequest.getOtp(),otpRequest.getUserMobileNumber());

        if(verify == false){

            throw new Exception("Otp is Expired.");
        }

        driverDetailsRepository.delete(driverDetails);
        return null;
    }
}