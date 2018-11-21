package domain;

import java.util.function.BiFunction;

public enum MovieType {
    REGULAR(PriceService::computeRegularPrice, FidelityPointsService::getDefaultFidelityPoints)
    , NEW_RELEASE(PriceService::computeNewReleasePrice, FidelityPointsService::getNewReleaseFidelityPoints)
    , CHILDREN(PriceService::computeChildrenPrice, FidelityPointsService::getDefaultFidelityPoints);

    BiFunction<PriceService, Integer, Double> computePrice;
    BiFunction<FidelityPointsService, Integer, Integer> getFidelityPoints;

    MovieType(BiFunction<PriceService, Integer, Double> computePrice, BiFunction<FidelityPointsService, Integer, Integer> getFidelityPoints) {
        this.computePrice = computePrice;
        this.getFidelityPoints = getFidelityPoints;
    }
}
