//Ethan Seng (eseng1@csudh.edu)

package finalExam;
import java.util.Scanner;

public class UiManager {
	private Scanner scanner;

	public UiManager(Scanner scanner) {
        this.scanner = scanner;
    }
    
    public void showMenu() {
        System.out.println("\nMenu of Options:");
        System.out.println("1 – Open a Checking account");
        System.out.println("2 – Open Saving Account");
        System.out.println("3 – List Accounts");
        System.out.println("4 – Account Statement");
        System.out.println("5 – Deposit funds");
        System.out.println("6 – Withdraw funds");
        System.out.println("7 – Close an account");
        System.out.println("8 – Exit");
    }

    public int readUserInput() {
        System.out.print("Enter choice (1-8): ");
        while (!scanner.hasNextInt()) {
        	// if non-int input, get rid of it
            scanner.next();
            System.out.print("Please enter a number (1-8): ");
        }
        return scanner.nextInt();
    }
}
