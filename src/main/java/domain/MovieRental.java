package domain;

import java.util.ArrayList;
import java.util.List;

public class MovieRental {

    PriceService priceService;

    private List<Movie> movies = new ArrayList<>();
    private int duration;

    public MovieRental(int duration, PriceService priceService) {
        this.duration = duration;
        this.priceService = priceService;
    }

    public double getPrice() {
        return movies.stream()
                .mapToDouble(movie -> movie.getType().calculPrice.apply(priceService, duration))
                .sum();
    }

    public int getFidelityPoints() {
        return movies.stream()
                .mapToInt(movie -> movie.getFidelityPoint(duration))
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
