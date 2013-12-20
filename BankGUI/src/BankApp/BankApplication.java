package BankApp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *  The BankApplication should create a single list of accounts of various types.
 * It should be able to deposit and withdraw from each account with appropriate fees and interest.
 * It should be able to display the account list, showing the correct fields for each subtype.
 * @author lindsua
 */
public class BankApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        new PopupBank().run();
    }
    
}
