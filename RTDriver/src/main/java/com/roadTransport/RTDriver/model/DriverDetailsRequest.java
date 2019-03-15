package com.roadTransport.RTDriver.model;

public class DriverDetailsRequest {

    private String driverName;
    private long mobileNumber;
    private String licenceNumber;
    private long aadharCardNumber;
    private String panCardNumber;
    private String adhaarCardImage;
    private String panCardImage;
    private String driverImage;
    private String licenceImage;
    private String vehicleNumber;
    private String TransportName;
    private String vehicleType;
    private String driverAddress;
    private long driverAge;
    private String dob;
    private boolean status;
    private String description;
    private String TransportNumber;
    private long otp;

    public long getOtp() {
        return otp;
    }

    public void setOtp(long otp) {
        this.otp = otp;
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

    public void setDob(String dob) throws Exception {
        String pattern = "yyyy-MM-dd";
        if(dob.matches(pattern)){
        this.dob = dob;}
        else{
            throw new Exception("Enter DOB in yyyy-MM-dd format");
        }
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
        return "DriverDetailsRequest{" +
                "driverName='" + driverName + '\'' +
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
                ", vehicleType='" + vehicleType + '\'' +
                ", driverAddress='" + driverAddress + '\'' +
                ", driverAge=" + driverAge +
                ", dob='" + dob + '\'' +
                ", status=" + status +
                ", description='" + description + '\'' +
                ", TransportNumber='" + TransportNumber + '\'' +
                ", otp='" + otp + '\'' +
                '}';
    }
}
