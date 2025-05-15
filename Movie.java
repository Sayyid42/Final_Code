public class Movie {
    private String title;
    double priceMultiplier = 1.5;

    public Movie(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}