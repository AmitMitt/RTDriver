package com.roadTransport.RTDriver.walletService;

public class WalletRequest {

    private String ownerName;
    private long walletId;
    private String walletPin;
    private double balance;
    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public long getWalletId() {
        return walletId;
    }

    public void setWalletId(long walletId) {
        this.walletId = walletId;
    }

    public String getWalletPin() {
        return walletPin;
    }

    public void setWalletPin(String walletPin) {
        this.walletPin = walletPin;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "WalletRequest{" +
                "ownerName='" + ownerName + '\'' +
                ", walletId=" + walletId +
                ", walletPin='" + walletPin + '\'' +
                ", balance=" + balance +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
