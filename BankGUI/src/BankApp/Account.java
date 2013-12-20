package BankApp;


import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * An Account has a name and balance.
 *
 * @author lindsua
 */
public class Account {

    String name;
    double balance;
    ArrayList<Account> bank = new ArrayList<Account>();
    Account acc;

    //Creates an account object
    public Account(String name, double balance) {
        name = this.name;
        balance = this.balance;
    }
//Writing a check costs 10 cents

    public double check(Account Account, double check) {
        if (check >= Account.balance) {
            JOptionPane.showMessageDialog(null, "The check amount is greater than"
                    + " the account balance.");
        } else {
            Account.balance = Account.balance - (check + .1);
            //Round to two decimal places
            DecimalFormat df = new DecimalFormat("#.##");
            Account.balance = Double.parseDouble(df.format(Account.balance));
        }
        return Account.balance;

    }

    //Deposits are free
    public double deposit(Account Account, double deposit) {
        //Round to two decimal places
        DecimalFormat df = new DecimalFormat("#.##");
        deposit = Double.parseDouble(df.format(deposit));
        Account.balance = Account.balance + deposit;
        return Account.balance;
    }

    //Savings accounts earn .01% interest per day
    public double interest(Account account, int day) {
        while (day > 0) {
            account.balance = balance + account.balance * .0001;
            //Round to two decimal places
            DecimalFormat df = new DecimalFormat("#.##");
            account.balance = Double.parseDouble(df.format(balance));
            day--;
        }
        return account.balance;
    }
     //As long as the accounts balance is greater than the withdrawal amount
    //Withdrawal is allowed. However, if it is greater, the transaction won't 
    //go through, and instead the account will be charged an overdraft fee of
    //$20.
    public double withdrawal(Account Account, double withdraw) {
        DecimalFormat df = new DecimalFormat("#.##");
        withdraw = Double.parseDouble(df.format(withdraw));
        if (Account.balance >= withdraw) {
            Account.balance = Account.balance - withdraw;
        } else {
            //Overdraft Charge
            Account.balance = Account.balance - 20;
            JOptionPane.showMessageDialog(null, "The amount you were withdrawing "
                    + "is greater than the account balance. You have been charged "
                    + "an overdraft fee of $20.");
        }
        return Account.balance;

    }
}
