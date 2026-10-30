package strategy;

/** Strategy: a way of turning the base fare into the final cost. */
public interface PricingStrategy {

    double calculate(double baseFare);

    String getName();
}