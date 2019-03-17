package com.roadTransport.RTDriver.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class DeletedDriverDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long id;

    @Column
    private String driverName;

    @Column
    private long mobileNumber;

    @Column
    private String licenceNumber;

    @Column
    private long aadharCardNumber;

    @Column
    private String panCardNumber;

    @Column(columnDefinition = "Text")
    private String adhaarCardImage;

    @Column(columnDefinition = "Text")
    private String panCardImage;

    @Column(columnDefinition = "Text")
    private String driverImage;

    @Column(columnDefinition = "Text")
    private String licenceImage;

    @Column
    private String vehicleNumber;

    @Column
    private String TransportName;

    @Column
    private String createdDate;

    @Column
    private String vehicleType;

    @Column
    private String driverAddress;

    @Column
    private long driverAge;

    @Column
    private String dob;

    @Column
    private boolean status;

    @Column
    private String description;

    @Column
    private String TransportNumber;

    @Column
    private long otp;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getLicenceNumber() {
        return licenceNumber;
    }

    public void setLicenceNumber(String licenceNumber) {
        this.licenceNumber = licenceNumber;
    }

    public long getAadharCardNumber() {
        return aadharCardNumber;
    }

    public void setAadharCardNumber(long aadharCardNumber) {
        this.aadharCardNumber = aadharCardNumber;
    }

    public String getPanCardNumber() {
        return panCardNumber;
    }

    public void setPanCardNumber(String panCardNumber) {
        this.panCardNumber = panCardNumber;
    }

    public String getAdhaarCardImage() {
        return adhaarCardImage;
    }

    public void setAdhaarCardImage(String adhaarCardImage) {
        this.adhaarCardImage = adhaarCardImage;
    }

    public String getPanCardImage() {
        return panCardImage;
    }

    public void setPanCardImage(String panCardImage) {
        this.panCardImage = panCardImage;
    }

    public String getDriverImage() {
        return driverImage;
    }

    public void setDriverImage(String driverImage) {
        this.driverImage = driverImage;
    }

    public String getLicenceImage() {
        return licenceImage;
    }

    public void setLicenceImage(String licenceImage) {
        this.licenceImage = licenceImage;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getTransportName() {
        return TransportName;
    }

    public void setTransportName(String transportName) {
        TransportName = transportName;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getDriverAddress() {
        return driverAddress;
    }

    public void setDriverAddress(String driverAddress) {
        this.driverAddress = driverAddress;
    }

    public long getDriverAge() {
        return driverAge;
    }

    public void setDriverAge(long driverAge) {
        this.driverAge = driverAge;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTransportNumber() {
        return TransportNumber;
    }

    public void setTransportNumber(String transportNumber) {
        TransportNumber = transportNumber;
    }

    public long getOtp() {
        return otp;
    }

    public void setOtp(long otp) {
        this.otp = otp;
    }

    @Override
    public String toString() {
        return "DeletedDriverDetails{" +
                "id=" + id +
                ", driverName='" + driverName + '\'' +
                ", mobileNumber=" + mobileNumber +
                ", licenceNumber='" + licenceNumber + '\'' +
                ", aadharCardNumber=" + aadharCardNumber +
                ", panCardNumber='" + panCardNumber + '\'' +
                ", adhaarCardImage='" + adhaarCardImage + '\'' +
                ", panCardImage='" + panCardImage + '\'' +
                ", driverImage='" + driverImage + '\'' +
                ", licenceImage='" + licenceImage + '\'' +
                ", vehicleNumber='" + vehicleNumber + '\'' +
                ", TransportName='" + TransportName + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", driverAddress='" + driverAddress + '\'' +
                ", driverAge=" + driverAge +
                ", dob='" + dob + '\'' +
                ", status=" + status +
                ", description='" + description + '\'' +
                ", TransportNumber='" + TransportNumber + '\'' +
                ", otp=" + otp +
                '}';
    }
}
