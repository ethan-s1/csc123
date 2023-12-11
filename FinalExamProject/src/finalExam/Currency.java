//Ethan Seng (eseng1@csudh.edu)

package finalExam;

public class Currency {//Extra credit
    private String code;
    private String name;
    private double exchangeRate;

    public Currency(String code, String name, double exchangeRate) {
        this.code = code;
        this.name = name;
        this.exchangeRate = exchangeRate;
    }

    // Getters and setters
    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }
}