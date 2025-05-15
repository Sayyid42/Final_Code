public class Purchase extends TransactionItem{
    private Movie movie;
    private PurchasePriceStrategy priceStrategy;
    private PointsStrategy pointsStrategy;

    public Purchase(Movie movie, PurchasePriceStrategy pStrategy, PointsStrategy fpStrategy) {
        this.movie = movie;
        priceStrategy = pStrategy;
        pointsStrategy = fpStrategy;
    }

    public Movie getMovie() {
        return movie;
    }

    public double getCharge() {
        return priceStrategy.calcPurchasePrice(movie);
    }

    public int getFrequentRenterPoints() {
        return pointsStrategy.getFrequentPoints(0);
    }
}
