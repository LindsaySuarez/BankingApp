package BankApp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import BankApp.Account;
import java.text.DecimalFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *  A Savings account earns interest of 0.01% daily and has no fees.
 * @author lindsua
 */
public class SavingsAccount extends Account{
    
    SavingsAccount acc;
    //Creates Savings Acoount object
    public SavingsAccount(String aname, double abalance){
        super(aname, abalance);
        name = aname;
        balance = abalance;
    }
    
    public String getName(){
        return name;
    }
    public double getBalance(){
        return balance;
    }
    
    
}
