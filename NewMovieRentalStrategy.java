public class NewMovieRentalStrategy extends RentalPriceStrategy {
    public double calcRentalPrice(Movie movie, int daysRented){
        movie.priceMultiplier = 3;
        return daysRented * movie.priceMultiplier;
    }
}
