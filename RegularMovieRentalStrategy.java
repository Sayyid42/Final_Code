public class RegularMovieRentalStrategy extends RentalPriceStrategy {
    public double calcRentalPrice(Movie movie, int daysRented){
        double price = 2;
        if (daysRented > 2) {
            price += (daysRented - 2) * movie.priceMultiplier;
        }
        return price;
    }
}
