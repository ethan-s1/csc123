//Ethan Seng (eseng1@csudh.edu)

package finalExam;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
public class Bank {
    private List<Account> accounts;
    private int nextAccountNumber;
    private Map<String, Currency> exchangeRates;
    //Change to accomodate exchange rates
    public Bank(Map<String, Currency> exchangeRates) {
        this.exchangeRates = exchangeRates;
        this.accounts = new ArrayList<>();
        this.nextAccountNumber = 1000; // Starting account number
    }

    public void openCheckingAccount(Scanner scanner) {
        System.out.print("Enter first name: ");
        String firstName = scanner.next();

        System.out.print("Enter last name: ");
        String lastName = scanner.next();

        System.out.print("Enter social security number: ");
        String ssn = scanner.next();

        LocalDate dob = null;//Raw date
        String dobInput = null;//Passed into the account creation method
        
        while (dob == null) {
            System.out.print("Enter date of birth (MM-dd-yyyy): ");
            dobInput = scanner.next();
            try {
                dob = LocalDate.parse(dobInput, DateTimeFormatter.ofPattern("MM-dd-yyyy"));
            } catch (DateTimeParseException e) {//Specific catch so an incorrect date pattern doesn't cause an exception
                System.out.println("Invalid date format. Please use MM-dd-yyyy.");
            }
        }
        
        LocalDate now = LocalDate.now();
        int age = Period.between(dob, now).getYears();

        if (age < 16) {
            System.out.println("Sorry, you must be at least 16 years old to open a checking account.");
            return;
        }
        
        String currencyCode = "USD"; // Default currency
        if (!exchangeRates.isEmpty()) {
            System.out.print("Enter currency code (e.g., USD, CAD): ");
            currencyCode = scanner.next().toUpperCase();
            if (!exchangeRates.containsKey(currencyCode)) {
                System.out.println("Currency code not found. Using USD.");
                currencyCode = "USD";
            }
        }
        
        double overdraftLimit = 0.0;
        if (age >= 18) {
        	while (true) {
                System.out.print("Enter overdraft limit: $");
                if (scanner.hasNextDouble()) {
                    overdraftLimit = scanner.nextDouble();
                    if (overdraftLimit < 0) {
                        System.out.println("Overdraft limit cannot be negative.");
                        scanner.nextLine();
                        continue;
                    }
                    break; // Exit the loop if valid input is received
                } else {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.nextLine();
                }
            }
        }

        // Create an account based on age and information provided
        Account newAccount;
        newAccount = new CheckingAccount(firstName + " " + lastName, ssn, dobInput, nextAccountNumber, overdraftLimit, currencyCode);
        
        accounts.add(newAccount);
        System.out.println("Thank you, the account number is " + nextAccountNumber);
        nextAccountNumber++; // Increment for the next account number
    }

    public void openSavingAccount(Scanner scanner) {
        System.out.print("Enter first name: ");
        String firstName = scanner.next();

        System.out.print("Enter last name: ");
        String lastName = scanner.next();

        System.out.print("Enter social security number: ");
        String ssn = scanner.next();

        LocalDate dob = null;//Raw date
        String dobInput = null;//Passed into the account creation method
        
        while (dob == null) {
            System.out.print("Enter date of birth (MM-dd-yyyy): ");
            dobInput = scanner.next();
            try {
                dob = LocalDate.parse(dobInput, DateTimeFormatter.ofPattern("MM-dd-yyyy"));
            } catch (DateTimeParseException e) {//Specific catch so an incorrect date pattern doesn't cause an exception
                System.out.println("Invalid date format. Please use MM-dd-yyyy.");
            }
        }
        
        LocalDate now = LocalDate.now();
        int age = Period.between(dob, now).getYears();

        if (age < 5) {
            System.out.println("Sorry, you must be at least 5 years old to open a savings account.");
            return;
        }
        //No need to check for overdraft stuff in saving account, so just check currency type
        String currencyCode = "USD"; // Default currency
        if (!exchangeRates.isEmpty()) {
            System.out.print("Enter currency code (e.g., USD, CAD): ");
            currencyCode = scanner.next().toUpperCase();
            if (!exchangeRates.containsKey(currencyCode)) {
                System.out.println("Currency code not found. Using USD.");
                currencyCode = "USD";
            }
        }
        
        Account newAccount = new SavingAccount(firstName + " " + lastName, ssn, dobInput, nextAccountNumber, currencyCode);
        accounts.add(newAccount);
        System.out.println("Thank you, your savings account number is " + nextAccountNumber);
        nextAccountNumber++; // Increment for the next account number
    }
    public void listAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts to display.");
            return;
        }

        // Iterate over each account
        for (Account account : accounts) {
        	//...to display account info
            String accountStatus = account.isOpen() ? "Account Open" : "Account Closed";
            System.out.println(account.getAccountNumber() + "(" + account.getAccountType() + ") : " +
                    account.getAccountHolder() + " : " + account.getSSN() + " : $" +
                    account.getBalance() + " : " + accountStatus);
        }
    }
    public void printAccountStatement(int accountNumber) {
        Account account = findAccountByNumber(accountNumber);
        if (account == null) {
            System.out.println("Account number " + accountNumber + " does not exist.");
            return;
        }

        // Print transactions
        for (Transaction transaction : account.getTransactions()) {
            System.out.println(transaction);
        }

        // Print balance
        System.out.println("Balance: $" + String.format("%.2f", account.getBalance()));
    }
    
    public void depositFunds(Scanner scanner) {
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();
        
        Account account = findAccountByNumber(accountNumber);
        if (account == null) {
            System.out.println("Account not found");
            return;
        }
        
        System.out.print("Enter the amount to deposit: $");
        double amount = scanner.nextDouble();

        

        boolean depositSuccessful = false;
        //Check if the account is open. If it isn't open, check to see if the amount is less or equal to the balance of the account (if it is negative)
        if (account.isOpen() || (!account.isOpen() && amount <= -account.getBalance() && account.getBalance() < 0) && amount > 0) {//Also check if deposit amount is above 0
            account.deposit(amount);
            depositSuccessful = true;
        }

        if (depositSuccessful) {
            System.out.println("Deposit successful, the new balance is: $" + account.getBalance());
        } else {
            System.out.println("Deposit failed, the balance is: $" + account.getBalance());
        }
    }
    public void withdrawFunds(Scanner scanner) {
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();

        System.out.print("Enter the withdrawal amount: ");
        double amount = scanner.nextDouble();

        Account account = findAccountByNumber(accountNumber);
        if (account == null) {
            System.out.println("Account not found");
            return;
        }

        //Move withdrawal to a separate method
        String message = doWithdrawal(account, amount);
        System.out.println(message);
    }

    private String doWithdrawal(Account account, double amount) {
    	double effectiveBalance = account.getBalance();
        
        // For CheckingAccount, consider the overdraft limit if the account is open
    	//Assuming that a closed account does not take into account overdraft limits
        if (account.isOpen() && account instanceof CheckingAccount) {
            effectiveBalance += ((CheckingAccount) account).getOverdraftLimit();
        }

        // Check if the withdrawal is possible
        if (effectiveBalance - amount < 0) {
            return "Withdrawal failed, The balance is: $" + account.getBalance();
        }

        account.withdraw(amount);
        return "Withdrawal successful, the new balance is: " + account.getBalance();
    }
    
    //Close a bank account
    public void closeAccount(Scanner scanner) {
        System.out.print("Enter account number to close: ");
        int accountNumber = scanner.nextInt();

        //Check if the account exists
        Account account = findAccountByNumber(accountNumber);
        if (account == null) {
            System.out.println("Account not found");
            return;
        }

        account.close();
    }
    
    //Used by multiple methods
    private Account findAccountByNumber(int accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {//Attribute given account number with the account list
                return account;
            }
        }
        return null;
    }
}