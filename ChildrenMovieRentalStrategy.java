public class ChildrenMovieRentalStrategy extends RentalPriceStrategy {
    public double calcRentalPrice(Movie movie, int daysRented){
        double price = 1.5;
        if (daysRented > 3) {
            price += (daysRented - 3) * movie.priceMultiplier;
        }
        return price;
    }
}
