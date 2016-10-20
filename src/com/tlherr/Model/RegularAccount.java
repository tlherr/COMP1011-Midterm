package com.tlherr.Model;

public class RegularAccount extends BaseAccount implements AccountInterface {

    private double maxOverdraft = 300.00;
    private double overdrafted = 0.00;

    public RegularAccount(double balance) {
        super(balance, 1.04, 800.00, 9.99);
    }

    @Override
    public double calcInterest() {
        return 0;
    }

    public boolean canOverdraft(double amount) {
        return (this.overdrafted + amount) < this.maxOverdraft;
    }

    @Override
    public double doWithdrawal(double amount) {
        if(this.canWithdraw(amount)) {
            //Can do this amount, so do it
            this.setBalance(this.getBalance()-amount);
        } else {
            //Tried to withdraw more then we have, can we overdraft?
            if(this.canOverdraft(amount)) {
                //Can overdraft, do it but warn the user it is happening
                System.out.println("Warning: Account is now overdrawn by: "+this.overdrafted);
                this.overdrafted += amount;
                this.setBalance(this.getBalance()-amount);
            } else {
                //Not enough money and cant overdraft
                System.out.println("Unable to complete transaction ("+amount+"), amount exceeds max withdrawl or overdraft limit");
            }
        }

        return this.getBalance();
    }

}
