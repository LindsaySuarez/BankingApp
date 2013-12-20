package BankApp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import BankApp.CheckingAccount;
import BankApp.Account;
import java.util.ArrayList;

/**
 * Create a ListOfAccounts class that uses an ArrayList<Account> of Savings and Checking accounts.
 * @author lindsua
 */
public class ListOfAccounts {
    
    private static ArrayList<Account> account = new ArrayList<Account>();
   
    
     public static void addSavings(String name, double balance)      
    {
         account.add(new SavingsAccount(name, balance));
         
    }
     
     public static void addChecking(String name, double balance)
     {
         account.add(new CheckingAccount(name, balance));
     }
    
     
   
    public static  ArrayList<Account> getList() {
       return account;
   }
    
}
