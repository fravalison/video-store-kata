package domain;

import java.util.function.BiFunction;

public enum MovieType {
    REGULAR(PriceService::computeRegularPrice)
    , NEW_RELEASE(PriceService::computeNewReleasePrice)
    , CHILDREN(PriceService::computeChildrenPrice);

    BiFunction<PriceService, Integer, Double> calculPrice;

    MovieType(BiFunction<PriceService, Integer, Double> calculPrice) {
        this.calculPrice = calculPrice;
    }
}
