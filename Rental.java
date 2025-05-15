class Rental extends TransactionItem{
    private Movie movie;
    private int daysRented;
    private RentalPriceStrategy priceStrategy;
    private PointsStrategy pointsStrategy;

    public Rental(Movie movie, int daysRented, RentalPriceStrategy pStrategy, PointsStrategy frpStrategy) {
        this.movie = movie;
        this.daysRented = daysRented;
        priceStrategy = pStrategy;
        pointsStrategy = frpStrategy;
    }

    public Movie getMovie() {
        return movie;
    }

    public double getCharge() {
        return priceStrategy.calcRentalPrice(movie, daysRented);
    }

    public int getFrequentRenterPoints() {
        return pointsStrategy.getFrequentPoints(daysRented);
    }
}