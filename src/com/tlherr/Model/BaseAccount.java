package com.tlherr.Model;

public class BaseAccount {

    private double balance;
    private double interestRate;
    private double maxWithdrawl;
    private double penalty;
    private double fee;

    protected BaseAccount(double balance, double interestRate, double maxWithdrawl, double fee){
        this.setBalance(balance);
        this.setInterestRate(interestRate);
        this.setMaxWithdrawl(maxWithdrawl);
        this.setFee(fee);
    };

    public boolean canWithdraw(double amount) {
        //If the amount requested is not larger then the max and if the balance - amount + currently available overdraft protection is greater than zero
        return amount < this.getMaxWithdrawl() && (this.getBalance() - amount) > 0;
    }

    public double getBalanceWithFee() {
        return (this.getBalance()-this.getFee());
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getMaxWithdrawl() {
        return maxWithdrawl;
    }

    public void setMaxWithdrawl(double maxWithdrawl) {
        this.maxWithdrawl = maxWithdrawl;
    }

    public double getPenalty() {
        return penalty;
    }

    public void setPenalty(double penalty) {
        this.penalty = penalty;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return  String.format(
                "Balance (Fee not included): %1$.3f\n"+
                "Balance (Fee included): %2$.3f\n"+
                "Interest Rate: %3$.2f\n" +
                "Current Penalties: %4$.3f\n",
        this.getBalance(), this.getBalanceWithFee(), this.getInterestRate(), this.getPenalty());
    }
}
