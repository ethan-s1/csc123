package assignment;
//Ethan Seng (eseng1@csudh.edu)

public class Publication extends Item {
	
	private String author;
    private String pubMonth;
    private int numPages;
	
	public Publication(String name, String vendor, double price, double cost, double weight, double taxRate, String author, String pubMonth, int numPages) {
        super(name, vendor, price, cost, weight, taxRate);
        this.author = author;
        this.pubMonth = pubMonth;
        this.numPages = numPages;
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Author: " + author + 
        		"\nPublication Month: " + pubMonth + 
        		"\nNumber of Pages: " + numPages);
    }
}
