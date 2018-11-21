package domain;

import java.util.ArrayList;
import java.util.List;

public class MovieRental {

    private List<Movie> movies;
    private int duration;

    private PriceService priceService;
    private FidelityPointsService fidelityPointsService;

    public MovieRental(int duration, PriceService priceService, FidelityPointsService fidelityPointsService) {
        this.movies = new ArrayList<>();
        this.duration = duration;
        this.priceService = priceService;
        this.fidelityPointsService = fidelityPointsService;
    }

    public double getPrice() {
        return movies.stream()
                .mapToDouble(movie -> movie.getType().computePrice.apply(priceService, duration))
                .sum();
    }

    public int getFidelityPoints() {
        return movies.stream()
                .mapToInt(movie -> movie.getType().getFidelityPoints.apply(fidelityPointsService, duration))
                .sum();
    }

    public MovieRental addMovie(Movie movie) {
        movies.add(movie);
        return this;
    }

    public String format() {
       String result = movies.stream()
               .map(movie -> movie.format(getPrice()))
               .reduce("", (s, s2) -> s + s2);
       result += "You owed " + getPrice() + "\n";
       result += "You earned " + getFidelityPoints() + " frequent renter points\n";
       return result;
    }

}
