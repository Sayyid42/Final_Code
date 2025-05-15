import java.util.List;

public abstract class couponDecorator extends disTransaction {
    protected disTransaction decoratedTransaction;

    public couponDecorator(disTransaction decoratedTransaction) {
        this.decoratedTransaction = decoratedTransaction;
        transItemList = decoratedTransaction.transItemList;
    }

    public List<Movie> getMovie() {
        return decoratedTransaction.getMovie();
    }

    public double getCharge() {
        return decoratedTransaction.getCharge();
    }

    public int getFrequentRenterPoints() {
        return decoratedTransaction.getFrequentRenterPoints();
    }
}