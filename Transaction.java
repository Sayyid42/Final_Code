import java.util.ArrayList;
import java.util.List;

public class Transaction extends disTransaction{

    public Transaction(){
        transItemList = new ArrayList<>();
    }

    public void addTransactionItem(TransactionItem item) {
        transItemList.add(item);
    }
    
    public List<TransactionItem> getTransactionItems(){
        return transItemList;
    }

    public double getCharge(){
        double totalCharge = 0.0;
        for (TransactionItem item : transItemList){
            totalCharge += item.getCharge();
        }
        return totalCharge;
    }

    public List<Movie> getMovie() {
        List<Movie> movieList = new ArrayList<>();
        for (TransactionItem item : transItemList){
            movieList.add(item.getMovie());
        }
        return movieList;
    }

    public int getFrequentRenterPoints() {
        int totalPoints = 0;
        for (TransactionItem item : transItemList){
            totalPoints += item.getFrequentRenterPoints();
        }
        return totalPoints;
    }
}
