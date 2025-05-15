import java.util.List;

abstract class disTransaction {
    List<TransactionItem> transItemList;

    abstract List<Movie> getMovie();
    abstract double getCharge();
    abstract int getFrequentRenterPoints();
}