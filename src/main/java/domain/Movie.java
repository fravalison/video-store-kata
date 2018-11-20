package domain;

public class Movie {

    private String title;
    private MovieType type;
    private int fidelityPoint = 0;

    public Movie(String title, MovieType type) {
        this.title = title;
        this.type = type;
    }

    public MovieType getType() {
        return type;
    }

    public int getFidelityPoint(int duration) {
        fidelityPoint++;
        if(type == MovieType.NEW_RELEASE && duration > 1) {
            fidelityPoint++;
        }
        return fidelityPoint;
    }

    public String format(double price) {
        return title + " " + price + "\n";
    }

}
