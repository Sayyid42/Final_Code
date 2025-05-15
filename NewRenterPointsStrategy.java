public class NewRenterPointsStrategy extends PointsStrategy {
    public int getFrequentPoints(int daysRented){
        return (daysRented > 1) ? 2 : 1;
    }
}
