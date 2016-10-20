package com.tlherr;

import com.tlherr.Model.BaseAccount;
import com.tlherr.Model.Customer;
import com.tlherr.Model.RegularAccount;
import com.tlherr.Model.StudentAccount;

public class Main {

    public static void main(String[] args) {
        //Make two customer objects, one of type student and one of type regular
        Customer cust1 = new Customer("Bob", "Smith", new StudentAccount(315.00));
        Customer cust2 = new Customer("Jim", "Johnson", new RegularAccount(1800.00));

        /*
         * Operations for Student
         * Opening balance: $315.00
         * Withdrawal of $300.00
         * Attempt to withdraw another $20.00
         * Call the toString() method
         */

        StudentAccount cust1Account = (StudentAccount) cust1.getAccount();
        cust1Account.doWithdrawal(300.00);
        cust1Account.doWithdrawal(20.00);
        System.out.println(cust1.toString());

        /*
         * Opening balance: $1800.00
         * Attempt to withdrawal of $1000.00
         * Withdraw $800.00
         * Withdraw another $800.00
         * Withdraw another $400
         * Call the toString() method (which should include the account-cost deduction)
         */
        RegularAccount cust2Account = (RegularAccount) cust2.getAccount();
        cust2Account.doWithdrawal(1000.00);
        cust2Account.doWithdrawal(800.00);
        cust2Account.doWithdrawal(800.00);
        cust2Account.doWithdrawal(400.00);
        System.out.println(cust2.toString());

    }
}
