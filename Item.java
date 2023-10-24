package assignment;
//Ethan Seng (eseng1@csudh.edu)

public class Item {
	public String name;
	public String vendor;
	public double price;
	public double cost;
	public double weight;
	public double taxRate;

    public Item(String name, String vendor, double price, double cost, double weight, double taxRate) {
        this.name = name;
        this.vendor = vendor;
        this.price = price;
        this.cost = cost;
        this.weight = weight;
        this.taxRate = taxRate;
    }

    public double calculateTax() {
        return this.price * this.taxRate / 100;
    }

    public double getTotalPrice() {
        return this.price + this.calculateTax();
    }

    public void printDetails() {
        System.out.println(
        		"Name: " + name + 
        		"\nVendor: " + vendor + 
        		"\nPrice: $" + price + 
        		"\nTax: $" + calculateTax() + 
        		"\nTotal: $" + getTotalPrice());
    }
}
