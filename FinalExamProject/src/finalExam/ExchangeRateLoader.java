//Ethan Seng (eseng1@csudh.edu)
package finalExam;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ExchangeRateLoader {
    private Map<String, Currency> exchangeRates;

    public ExchangeRateLoader() {
        exchangeRates = new HashMap<>();//The equivalent of dictionary, uses key/value pairs
    }

    public void loadExchangeRates(String fileName) {
        try (Scanner scanner = new Scanner(new File(System.getProperty("user.dir") + "/src/finalExam/" + fileName))) {
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(",");
                String code = data[0].trim();//The 3 letter code
                String name = data[1].trim();//
                double rate = Double.parseDouble(data[2].trim());//The rate of the currency exchanging to USD
                exchangeRates.put(code, new Currency(code, name, rate));//Map the input to the HashMap and use the Currency class to define the currency (later on, use the 3 letter code to refer to the currency)
            }
        } catch (FileNotFoundException exception) {
            System.out.println("Currency file could not be loaded, Currency Conversion Service and Foreign Currency accounts are not available");
            // Set default USD currency
            exchangeRates.put("USD", new Currency("USD", "US Dollar", 1.0));
        } catch (Exception exception) {
            System.out.println("Currency file could not be loaded, Currency Conversion Service and Foreign Currency accounts are not available");
        }
    }

    public Map<String, Currency> getExchangeRates() {
        return exchangeRates;
    }
}