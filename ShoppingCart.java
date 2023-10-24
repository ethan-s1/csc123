package assignment;
import java.util.ArrayList;
import java.util.List;
//Ethan Seng (eseng1@csudh.edu)

public class ShoppingCart {
    private List<Item> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public int getNumberOfItems() {
        return items.size();
    }

    public double getTotalCost() {
        double total = 0;
        for(Item item : items) {
            total += item.getTotalPrice();
        }
        return total;
    }

    public void printItems() {
        for(Item item : items) {
            item.printDetails();
            System.out.println();
        }
    }
}