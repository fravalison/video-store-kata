package domain;

public class FidelityPointsService {

    public int getDefaultFidelityPoints(int duration) {
        return 1;
    }

    public int getNewReleaseFidelityPoints(int duration) {
        int fidelityPoint = getDefaultFidelityPoints(duration);
        if(duration > 1) {
            fidelityPoint++;
        }
        return fidelityPoint;
    }
}
