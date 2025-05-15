import java.util.ArrayList;
import java.util.List;

class Customer {
    private String name;
    private int frequentRenterPoints = 0;
    private List<disTransaction> transactionsList = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addTransaction(disTransaction transaction) {
        // System.out.println(Integer.toString(transaction.transItemList.size()));
        // System.exit(0);
        transactionsList.add(transaction);
        for (TransactionItem item: transaction.transItemList){
            frequentRenterPoints += item.getFrequentRenterPoints(); // Update the frequentRenterPoints in customer
        }
    }

    public String getName() {
        return name;
    }

    public int getFrequentRenterPoints() {
        return frequentRenterPoints;
    }

    public void setFrequentRenterPoints(int frp) {
        frequentRenterPoints = frp;
    }

    public List<disTransaction> getTransactionsList(){
        return transactionsList;
    }
}