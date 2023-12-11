//Ethan Seng (eseng1@csudh.edu)

package finalExam;

public class Transaction {
    private static int nextTransactionId = 1; // Static to ensure unique IDs across all transactions
    private final int transactionId;
    private final String type; // credit/debit
    private final double amount;

    public Transaction(String type, double amount) {
        this.transactionId = nextTransactionId++;
        this.type = type;//Instead of extending Transaction with DebitTransaction and CreditTransaction, logic can be handled here
        this.amount = amount;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
    	return transactionId + " : " + type + " :$" + String.format("%.2f", amount);
    }
}