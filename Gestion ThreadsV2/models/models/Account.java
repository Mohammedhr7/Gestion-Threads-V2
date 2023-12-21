package models;

public class Account {

    // Attributs
    private String Account_Number;
    private int accountHolder;
    private double balance;
    private String NextAccountNumber;
    private String fullname;

    // constructor

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getFullname() {
        return fullname;
    }

    public Account(String account_Number, int accountHolder, double balance, String nextAccountNumber) {
        Account_Number = account_Number;
        this.accountHolder = accountHolder;
        this.balance = balance;
        NextAccountNumber = null;
    }

    // geeeeet
    // public Account(String account_Number, int accountHolder, double balance, ,String fullname) {
    //     Account_Number = account_Number;
    //     this.accountHolder = accountHolder;
    //     this.balance = balance;
    //     this.fullname = fullname;
    // }

    // getters & setters
    public String getAccount_Number() {
        return Account_Number;
    }

    public void setAccount_Number(String account_Number) {
        Account_Number = account_Number;
    }

    public int getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(int accountHolder) {
        this.accountHolder = accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getNextAccountNumber() {
        return NextAccountNumber;
    }

    public void setNextAccountNumber(String nextAccountNumber) {
        NextAccountNumber = nextAccountNumber;
    }

}
