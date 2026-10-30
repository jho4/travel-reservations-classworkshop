package strategy;

/** High season fare: base fare plus 25%. */
public class HighSeasonFare implements PricingStrategy {

    private static final double INCREASE = 0.25;

    @Override
    public double calculate(double baseFare) {
        return baseFare * (1 + INCREASE);
    }

    @Override
    public String getName() {
        return "High season fare";
    }
}