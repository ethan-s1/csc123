package assignment;
//Ethan Seng (eseng1@csudh.edu)

public class Food extends Item {
    private String sellBy;
    private String useBy;

    public Food(String name, String vendor, double price, double cost, double weight, double taxRate, String sellBy, String useBy) {
        super(name, vendor, price, cost, weight, taxRate);
        this.sellBy = sellBy;
        this.useBy = useBy;
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println(
        		"Sell By: " + sellBy + 
        		"\nUse By: " + useBy);
    }
}