package assignment;
import java.util.Scanner;
import java.util.Date;
//Ethan Seng (eseng1@csudh.edu)

public class Driver {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Publication");
            System.out.println("2. Add Food");
            System.out.println("3. Add General Item");
            System.out.println("4. View Cart");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Add publication
                    System.out.print("Enter name: ");
                    String pubName = scanner.next();
                    System.out.print("Enter vendor: ");
                    String pubVendor = scanner.next();
                    System.out.print("Enter price: ");
                    double pubPrice = scanner.nextDouble();
                    System.out.print("Enter cost: ");
                    double pubCost = scanner.nextDouble();
                    System.out.print("Enter weight: ");
                    double pubWeight = scanner.nextDouble();
                    System.out.print("Enter tax rate: ");
                    double pubTaxRate = scanner.nextDouble();
                    System.out.print("Enter author: ");
                    String author = scanner.next();
                    System.out.print("Enter publication month: ");
                    String pubMonth = scanner.next();
                    System.out.print("Enter number of pages: ");
                    int numPages = scanner.nextInt();

                    Publication pub = new Publication(pubName, pubVendor, pubPrice, pubCost, pubWeight, pubTaxRate, author, pubMonth, numPages);
                    cart.addItem(pub);
                    break;
                case 2:
                	// Add Food
                    System.out.print("Enter name: ");
                    String foodName = scanner.next();
                    System.out.print("Enter vendor: ");
                    String foodVendor = scanner.next();
                    System.out.print("Enter price: ");
                    double foodPrice = scanner.nextDouble();
                    System.out.print("Enter cost: ");
                    double foodCost = scanner.nextDouble();
                    System.out.print("Enter weight: ");
                    double foodWeight = scanner.nextDouble();
                    System.out.print("Enter tax rate: ");
                    double foodTaxRate = scanner.nextDouble();
                    scanner.nextLine(); // consume the newline
                    System.out.print("Enter sell by date: ");
                    String sellBy = scanner.nextLine();
                    System.out.print("Enter use by date: ");
                    String useBy = scanner.nextLine();

                    Food food = new Food(foodName, foodVendor, foodPrice, foodCost, foodWeight, foodTaxRate, sellBy, useBy);
                    cart.addItem(food);
                    break;
                case 3:
                	// Add general grocery item
                    System.out.print("Enter name: ");
                    String itemName = scanner.next();
                    System.out.print("Enter vendor: ");
                    String itemVendor = scanner.next();
                    System.out.print("Enter price: ");
                    double itemPrice = scanner.nextDouble();
                    System.out.print("Enter cost: ");
                    double itemCost = scanner.nextDouble();
                    System.out.print("Enter weight: ");
                    double itemWeight = scanner.nextDouble();
                    System.out.print("Enter tax rate: ");
                    double itemTaxRate = scanner.nextDouble();
                    scanner.nextLine(); // consume the newline

                    GeneralGroceryItem generalItem = new GeneralGroceryItem(itemName, itemVendor, itemPrice, itemCost, itemWeight, itemTaxRate);
                    cart.addItem(generalItem);
                    break;
                case 4:
                    // View Cart
                    cart.printItems();
                    break;
                case 5:
                    // Exit
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
    }
}