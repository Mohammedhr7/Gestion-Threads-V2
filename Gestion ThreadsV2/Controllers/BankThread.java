package Controllers;

import models.*;

public class BankThread extends Thread {

    // attributs
    private String clientName;
    private Account account;

    // constructeur
    public BankThread() {
    }

    public BankThread(String clientName, Account account) {
        this.clientName = clientName;
        this.account = account;
    }

    // methods
    public synchronized void deposit(double amount) {

        double balance = account.getBalance();
        balance += amount;
        account.setBalance(balance);
        System.out.println(clientName + "a déposé " + amount + "euros. nouveau solde :" + balance);
    }

    // ::::::::::: :::::::::

    public synchronized void withdraw(double amount) {

        double balance = account.getBalance();
        if (balance >= amount) {
            balance -= amount;
            account.setBalance(balance);
            System.out.println(clientName + "a retiré " + amount + "euros. nouveau solde :" + balance);
        } else {
            System.out.println(clientName + "n'a pas retirer " + amount + "euros. solde insuffisant. :");
        }

    }

    //
    public synchronized void transfer(double amount, Account recipient) {
        double balance = account.getBalance();
        if (balance >= amount) {
            balance -= amount;
            account.setBalance(balance);
            System.out.println(clientName + "a transfere " + amount + "euros. nouveau solde :" + balance);
        } else {
            System.out.println(clientName + "n'a pas pu transférer " + amount + "euros. solde insuffisant. :");
        }
    }

    //
    public void run() {
        deposit(500);
        withdraw(200);
        transfer(300, new Account("HJ15456", 3, 300, "CC2"));

    }

    // main

    public static void main(String[] args) {

        System.out.println("hello transaction");
        Account sharedAccount = new Account("C1", 2, 1000, "CC1");
        BankThread accountClient1 = new BankThread("client 1", sharedAccount);
        BankThread accountClient2 = new BankThread("client 2", sharedAccount);

        accountClient1.start();
        accountClient2.start();

    }

}
