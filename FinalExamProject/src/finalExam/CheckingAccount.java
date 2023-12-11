//Ethan Seng (eseng1@csudh.edu)

package finalExam;
public class CheckingAccount extends Account {
    private double overdraftLimit;

    // Constructor
    public CheckingAccount(String accountHolder, String ssn, String dateOfBirth, int accountNumber, double overdraftLimit, String currencyCode) {
        super(accountHolder, ssn, dateOfBirth, accountNumber, currencyCode); // Call the superclass constructor
        this.overdraftLimit = overdraftLimit;
    }

    // Getter for overdraft limit
    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    // Overridden method to get account type
    @Override
    public String getAccountType() {
        return "Checking";
    }
    
    // Method to set a new overdraft limit
    public void setOverdraftLimit(double newLimit) {
        overdraftLimit = newLimit;
        System.out.println("New overdraft limit set: " + overdraftLimit);
    }

    // Overridden toString method for displaying account information
    @Override
    public String toString() {
        return String.format("%d(Checking) : %s : %s : %s : %.2f %s : %.2f : %s",
                getAccountNumber(),
                getAccountHolder(),
                getSSN(),
                getCurrencyCode(),
                getBalance(),
                getOverdraftLimit(),
                isOpen() ? "Account Open" : "Account Closed");
    }
}