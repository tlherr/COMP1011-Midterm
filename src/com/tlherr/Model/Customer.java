package com.tlherr.Model;

public class Customer {

    private String firstName;
    private String lastName;
    private BaseAccount account;


    public Customer(String firstName, String lastName, BaseAccount account) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAccount(account);
    }

    public BaseAccount getAccount() {
        return account;
    }

    public void setAccount(BaseAccount account) {
        this.account = account;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {

        return  String.format(
                "First Name: %1$s\n"+
                "Last Name: %2$s\n",
                this.getFirstName(), this.getLastName())+this.getAccount().toString();
    }
}
