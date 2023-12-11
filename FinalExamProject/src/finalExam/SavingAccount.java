//Ethan Seng (eseng1@csudh.edu)

package finalExam;

public class SavingAccount extends Account {

    // Constructor for SavingAccount
    public SavingAccount(String accountHolder, String ssn, String dateOfBirth, int accountNumber, String currencyCode) {
        super(accountHolder, ssn, dateOfBirth, accountNumber, currencyCode); // Call the superclass constructor
    }

    // Overridden method to get account type
    @Override
    public String getAccountType() {
        return "Saving";
    }

    // Overridden toString method for displaying account information
    @Override
    public String toString() {
        return String.format("%d(Saving) : %s : %s : %s : %.2f %s : %s",
                getAccountNumber(),
                getAccountHolder(),
                getSSN(),
                getCurrencyCode(),
                getBalance(),
                isOpen() ? "Account Open" : "Account Closed");
    }
}