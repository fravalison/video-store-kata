package domain;

public class PriceService {

    public Double computeRegularPrice(int duration) {
        double price = 2.0;
        if (duration > 2) {
            price += (duration - 2) * 1.5;
        }
        return price;
    }

    public Double computeNewReleasePrice(int duration) {
        return duration * 3.0;
    }

    public Double computeChildrenPrice(int duration) {
        double price = 1.5;
        if (duration > 3) {
            price += (duration - 3) * 1.5;
        }
        return price;
    }
}
