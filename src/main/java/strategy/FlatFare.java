package strategy;

/** Standard fare: you pay the base fare. */
public class FlatFare implements PricingStrategy {

    @Override
    public double calculate(double baseFare) {
        return baseFare;
    }

    @Override
    public String getName() {
        return "Standard fare";
    }
}