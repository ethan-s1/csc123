//Ethan Seng (eseng1@csudh.edu)
package finalExam;
import java.util.Map;
import java.util.Scanner;


public class BankApplication {

	private Bank bank;
    private UiManager uiManager;
    private Scanner scanner;
    
    public BankApplication(Map<String, Currency> exchangeRates) {
        this.bank = new Bank(exchangeRates);
        this.scanner = new Scanner(System.in);
        this.uiManager = new UiManager(scanner);
    }

    public void run() {
        int choice;
        do {
            uiManager.showMenu();
            choice = uiManager.readUserInput();

            switch (choice) {
                case 1:
                	bank.openCheckingAccount(scanner);
                    break;
                case 2:
                    bank.openSavingAccount(scanner);
                    break;
                case 3:
                    bank.listAccounts();
                    break;
                case 4:
                	System.out.print("Enter account number: ");
                    int accountNumber = scanner.nextInt();
                    bank.printAccountStatement(accountNumber);
                    break;
                case 5:
                	bank.depositFunds(scanner);
                    break;
                case 6:
                	bank.withdrawFunds(scanner);
                    break;
                case 7:
                    bank.closeAccount(scanner);
                    break;
                case 8:
                    System.out.println("Thank you for using the bank program.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 8);
        scanner.close();
    }
       
    public static void main(String[] args) {
    	ExchangeRateLoader exchangeRateLoader = new ExchangeRateLoader();
        exchangeRateLoader.loadExchangeRates("exchange-rate.csv");

        BankApplication app = new BankApplication(exchangeRateLoader.getExchangeRates());
        app.run();
    }

}
