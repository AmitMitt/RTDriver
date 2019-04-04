package com.roadTransport.RTDriver.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Table
@Entity
public class DriverTemporaryDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long id;

    @Column
    @NotNull
    private String driverName;

    @Column
    @NotNull
    @Size(min = 10,max = 10)
    private String mobileNumber;

    @Column
    @NotNull
    private String licenceNumber;

    @Column
    @NotNull
    private long aadharCardNumber;

    @Column
    @NotNull
    private String panCardNumber;

    @Column(columnDefinition ="Text")
    @NotNull
    private String adhaarCardImage;

    @Column(columnDefinition = "Text")
    @NotNull
    private String panCardImage;

    @Column(columnDefinition = "Text")
    @NotNull
    private String driverImage;

    @Column(columnDefinition = "Text")
    @NotNull
    private String licenceImage;

    @Column
    private String vehicleNumber;

    @Column
    private String TransportName;

    @Column
    private long createdDate;

    @Column
    private long modifiedDate;

    @Column
    private String vehicleType;

    @NotNull
    @Column
    private String driverAddress;

    @NotNull
    @Column
    private long driverAge;

    @Column
    @NotNull
    private String dob;

    @Column
    private boolean status;

    @Column
    private String description;

    @Column
    private String TransportNumber;

    @Column
    private long otp;

    @Column
    private boolean kyc;

    public boolean isKyc() {
        return kyc;
    }

    public void setKyc(boolean kyc) {
        this.kyc = kyc;
    }

    public long getOtp() {
        return otp;
    }

    public void setOtp(long otp) {
        this.otp = otp;
    }

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

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
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

    public long getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(long createdDate) {
        this.createdDate = createdDate;
    }

    public long getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(long modifiedDate) {
        this.modifiedDate = modifiedDate;
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

    @Override
    public String toString() {
        return "DriverDetails{" +
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
                ", modifiedDate='" + modifiedDate + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", driverAddress='" + driverAddress + '\'' +
                ", driverAge=" + driverAge +
                ", dob='" + dob + '\'' +
                ", status=" + status +
                ", description='" + description + '\'' +
                ", TransportNumber='" + TransportNumber + '\'' +
                ", otp='" + otp + '\'' +
                ", kyc='" + kyc + '\'' +
                '}';
    }

}
