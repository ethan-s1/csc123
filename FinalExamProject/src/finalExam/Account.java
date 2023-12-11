//Ethan Seng (eseng1@csudh.edu)

package finalExam;
import java.util.ArrayList;
import java.util.List;
public abstract class Account {
    protected int accountNumber;
    protected String accountHolder;
    protected double balance;
    protected boolean isOpen;
    protected String ssn;
    protected String dateOfBirth;
    protected String currencyCode;
    protected List<Transaction> transactions;
    
    // Constructor
    public Account(String accountHolder, String ssn, String dateOfBirth, int accountNumber, String currencyCode) {
        this.accountHolder = accountHolder;//Instead of creating an AccountHolder class, we can keep track of it in Account
        this.ssn = ssn;
        this.dateOfBirth = dateOfBirth;
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        this.isOpen = true;
        this.currencyCode = currencyCode;//Extra credit
        this.transactions = new ArrayList<>();
    }

    // Deposit method
    public void deposit(double amount) {
    	balance += amount;
        addTransaction("Credit", amount);
    }

    // Withdraw method
    public void withdraw(double amount) {
    	balance -= amount;
        addTransaction("Debit", amount);
    }
    
    protected void addTransaction(String type, double amount) {//Credit (deposit) or Debit (withdrawal)
        Transaction transaction = new Transaction(type, amount);
        this.transactions.add(transaction);
    }
    
    public List<Transaction> getTransactions() {
        return transactions;
    }

    // Get balance
    public double getBalance() {
        return balance;
    }
    //Get social security
    public String getSSN() {
        return ssn;
    }
    //Get currency code
    public String getCurrencyCode() {
        return currencyCode;
    }
    // Get account holder's name
    public String getAccountHolder() {
        return accountHolder;
    }

    // Get account number
    public int getAccountNumber() {
        return accountNumber;
    }

    // Check if account is open
    public boolean isOpen() {
        return isOpen;
    }

    // Close account method
    public void close() {
        if (!isOpen) {
            System.out.println("Account is already closed.");
            return;
        }
        isOpen = false;
        System.out.println("Account closed, current balance is $" + getBalance());
    }

    // Abstract method to get account type, to be implemented in subclasses
    public abstract String getAccountType();
}