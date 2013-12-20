package BankApp;


import BankApp.ListOfAccounts;
import BankApp.CheckingAccount;
import BankApp.Account;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author lindsua
 */
public class PopupBank {

    ArrayList<Account> accy = ListOfAccounts.getList();
    String participate;

    public void run() {
        do {
            String answer;
            answer = JOptionPane.showInputDialog(null, "Welcome to Wobbs Bank! "
                    + "\n What would you like to do today? \n"
                    + "1) Open a savings account \n"
                    + "2) Open a checking account \n"
                    + "3) Write a check\n"
                    + "4) Make a deposit\n"
                    + "5) Make a withdrawal\n"
                    + "6) Check the balance of an account\n"
                    + "Please enter your choice.");

            double swer = Double.parseDouble(answer);
            if (swer == 1) {
                //Open a Savings Account
                String makeAccountName;
                String makeAccountBalance;

                makeAccountName = JOptionPane.showInputDialog(null, "Please enter"
                        + " a name:");
                makeAccountBalance = JOptionPane.showInputDialog(null, "Please "
                        + "enter the balance of the account: $");
                double accbal = Double.parseDouble(makeAccountBalance);
                SavingsAccount acc = new SavingsAccount(makeAccountName, accbal);
                JOptionPane.showMessageDialog(null, acc.getName() + " has opened"
                        + " a savings account with a balance of $:" + acc.balance);
                ListOfAccounts.addSavings(acc.getName(), acc.getBalance());

                participate = JOptionPane.showInputDialog(null, "Would you like "
                        + "to do anything else today? y/n");

            } else if (swer == 2) {
                //Open a Checking Account
                String makeAccountName;
                String makeAccountBalance;

                makeAccountName = JOptionPane.showInputDialog(null, "Please enter"
                        + " a name:");
                makeAccountBalance = JOptionPane.showInputDialog(null, "Please "
                        + "enter the balance of the account: $");
                double accbal = Double.parseDouble(makeAccountBalance);
                CheckingAccount acc = new CheckingAccount(makeAccountName, accbal);
                JOptionPane.showMessageDialog(null, acc.getName() + " has opened"
                        + " a checking account with a balance of $:" + acc.balance);
                ListOfAccounts.addChecking(acc.getName(), acc.getBalance());

                participate = JOptionPane.showInputDialog(null, "Would you like "
                        + "to do anything else today? y/n");
            } else if (swer == 3) {
                //Write a check
                String getAccountName;
                Account acc = new Account("", 0);
                getAccountName = JOptionPane.showInputDialog(null, "Please enter"
                        + " the name of an account holder:");

                for (int i = 0; i < accy.size(); i++) {

                    if (getAccountName.equals(accy.get(i).name)) {

                        acc = accy.get(i);
                        if (acc.getClass().equals(CheckingAccount.class)) {

                            String newbal = JOptionPane.showInputDialog(null, "Please enter "
                                    + "the check amount: $");
                            double newbalan = Double.parseDouble(newbal);
                            acc.check(acc, newbalan);
                            JOptionPane.showMessageDialog(null, acc.name + "'s new balance "
                                    + "is $:" + acc.balance);
                        }
                    }
                }
                participate = JOptionPane.showInputDialog(null, "Would you like "
                        + "to do anything else today? y/n");
            } else if (swer == 4) {
                //Make a deposit
                String getAccountName;
                Account acc = new Account("", 0);

                getAccountName = JOptionPane.showInputDialog(null, "Please"
                        + " enter the name of an account holder:");

                for (int i = 0; i < accy.size(); i++) {

                    if (getAccountName.equals(accy.get(i).name)) {

                        acc = accy.get(i);
                        if (acc.getClass().equals(CheckingAccount.class)) {

                            String newbal = JOptionPane.showInputDialog(null, "Please"
                                    + " enter your deposit: $");
                            double newbalan = Double.parseDouble(newbal);
                            acc.deposit(acc, newbalan);
                            JOptionPane.showMessageDialog(null, acc.name + "'s new "
                                    + "balance is $: " + acc.balance);
                        }
                    }
                }
                participate = JOptionPane.showInputDialog(null, "Would you like "
                        + "to do anything else today? y/n");
            } else if (swer == 5) {
                //make a withdrawal
                String getAccountName;
                Account acc = new Account("", 0);

                getAccountName = JOptionPane.showInputDialog(null, "Please"
                        + " enter the name of an account holder:");

                for (int i = 0; i < accy.size(); i++) {

                    if (getAccountName.equals(accy.get(i).name)) {

                        acc = accy.get(i);
                        if (acc.getClass().equals(SavingsAccount.class)) {

                            String newbal = JOptionPane.showInputDialog(null, "Please enter "
                                    + "the amount you are withdrawing: $");
                            double newbalan = Double.parseDouble(newbal);
                            acc.withdrawal(acc, newbalan);
                            JOptionPane.showMessageDialog(null, acc.name + "'s new balance is"
                                    + " $:" + acc.balance);
                        }
                    }
                }
                participate = JOptionPane.showInputDialog(null, "Would you like "
                        + "to do anything else today? y/n");
            } else if (swer == 6) {
                //Check account balance
                String getAccountName;
                Account acc = new Account("", 0);

                getAccountName = JOptionPane.showInputDialog(null, "Please"
                        + " enter the name of an account holder:");

                for (int i = 0; i < accy.size(); i++) {

                    if (getAccountName.equals(accy.get(i).name)) {

                        acc = accy.get(i);
                        if (acc.getClass() == SavingsAccount.class) {

                            String time = JOptionPane.showInputDialog(null, "How many days"
                                    + " has this account existed? ");
                            int date = Integer.parseInt(time);
                            acc.balance = acc.interest(acc, date);
                            JOptionPane.showMessageDialog(null, acc.name + "'s balance is"
                                    + " $:" + acc.balance);
                        } else if (acc.getClass() == SavingsAccount.class) {
                            JOptionPane.showMessageDialog(null, acc.name + "'s balance is"
                                    + " $:" + acc.balance);
                        }
                    }
                }
                participate = JOptionPane.showInputDialog(null, "Would you like "
                        + "to do anything else today? y/n");
            } else {
                JOptionPane.showMessageDialog(null, "That is not a viable option. "
                        + "Please select one of the offered choices.");
                participate = "y";
            }

        } while (participate.matches("y"));
        //Keep asking about further transactions
        System.exit(0);
    }
}
