package com.tlherr.Model;

public class StudentAccount extends BaseAccount implements AccountInterface {

    public StudentAccount(double balance) {
        super(balance, 1.02, 300.00, 0.00);
    }

    @Override
    public double calcInterest() {
        return 0;
    }

    @Override
    public double doWithdrawal(double amount) {
        if(this.canWithdraw(amount)) {
            //Can handle the withdrawl, do it
            this.setBalance(this.getBalance()-amount);
        }

        return this.getBalance();
    }
}
