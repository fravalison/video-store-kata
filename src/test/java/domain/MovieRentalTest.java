package domain;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class MovieRentalTest {

    PriceService priceService = new PriceService();
    FidelityPointsService fidelityPointsService = new FidelityPointsService();

    @Test
    public void price_should_be_2_euros_when_rent_a_regular_movie_for_1_day() {
        MovieRental rental = new MovieRental(1, priceService, fidelityPointsService);
        rental.addMovie(new Movie("Matrix", MovieType.REGULAR));

        assertEquals(2.0, rental.getPrice());
    }

    @Test
    public void price_should_be_3_5_euros_when_rent_a_regular_movie_for_3_days() {
        MovieRental rental = new MovieRental(3, priceService, fidelityPointsService);
        rental.addMovie(new Movie("Matrix", MovieType.REGULAR));

        assertEquals(3.5, rental.getPrice());
    }

    @Test
    public void price_should_be_6_euros_when_rent_a_new_release_movie_for_2_days() {
        MovieRental rental = new MovieRental(2, priceService, fidelityPointsService);
        rental.addMovie(new Movie("Matrix", MovieType.NEW_RELEASE));

        assertEquals(6.0, rental.getPrice());
    }

    @Test
    public void price_should_be_1_5_euros_when_rent_a_childrens_movie_for_2_days() {
        MovieRental rental = new MovieRental(2, priceService, fidelityPointsService);
        rental.addMovie(new Movie("La reine des neiges", MovieType.CHILDREN));

        assertEquals(1.5, rental.getPrice());
    }

    @Test
    public void price_should_be_3_euros_when_rent_a_childrens_movie_for_4_days() {
        MovieRental rental = new MovieRental(4, priceService, fidelityPointsService);
        rental.addMovie(new Movie("La reine des neiges", MovieType.CHILDREN));

        assertEquals(3.0, rental.getPrice());
    }

    @Test
    public void should_win_1_fidelity_point_when_rent_a_regular_movie_for_1_day() {
        MovieRental rental = new MovieRental(1, priceService, fidelityPointsService);
        rental.addMovie(new Movie("Pulp fiction", MovieType.REGULAR));

        assertEquals(1, rental.getFidelityPoints());
    }

    @Test
    public void should_win_2_fidelity_points_when_rent_a_new_release_movie_for_2_days() {
        MovieRental rental = new MovieRental(2, priceService, fidelityPointsService);
        rental.addMovie(new Movie("Venom", MovieType.NEW_RELEASE));

        assertEquals(2, rental.getFidelityPoints());
    }

    @Test
    public void display_a_new_release_movie_for_1_days() {
        MovieRental rental = new MovieRental(1, priceService, fidelityPointsService);
        rental.addMovie(new Movie("Venom", MovieType.NEW_RELEASE));

        String expected = "Venom 3.0\n"
                + "You owed 3.0\n"
                + "You earned 1 frequent renter points\n";
        assertEquals(expected, rental.format());
    }

}