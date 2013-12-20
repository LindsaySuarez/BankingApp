package BankApp;


import BankApp.Account;
import java.text.DecimalFormat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *  A Checking account has a transaction fee of $.10 per check, deposits are free.
 * @author lindsua
 */
public class CheckingAccount extends Account{
    
    CheckingAccount acc;
    
    //Creates Checking Account object
    public CheckingAccount(String aname, double abalance){
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
