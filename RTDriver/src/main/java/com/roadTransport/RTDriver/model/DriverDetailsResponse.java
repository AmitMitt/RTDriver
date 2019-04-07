package com.roadTransport.RTDriver.model;

public class DriverDetailsResponse {

    private String message;
    private long otp;
    private String walletPin;

    public String getWalletPin() {
        return walletPin;
    }

    public void setWalletPin(String walletPin) {
        this.walletPin = walletPin;
    }

    public long getOtp() {
        return otp;
    }

    public void setOtp(long otp) {
        this.otp = otp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "DriverDetailsResponse{" +
                "message='" + message + '\'' +
                ", otp=" + otp +
                ", walletPin='" + walletPin + '\'' +
                '}';
    }
}
