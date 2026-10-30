package model;

/**
 * Anything a customer can travel in. Every vehicle has an id, a name and a base fare.
 */
public abstract class Vehicle {

    private final String id;
    private final String name;
    private final double baseFare;

    protected Vehicle(String id, String name, double baseFare) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("The vehicle id cannot be empty");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("The vehicle name cannot be empty");
        }
        if (baseFare <= 0) {
            throw new IllegalArgumentException("The base fare must be greater than zero");
        }
        this.id = id.trim();
        this.name = name.trim();
        this.baseFare = baseFare;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getBaseFare() {
        return baseFare;
    }

    /** Human readable kind of vehicle (Plane, Train, Bus...). */
    public abstract String getKind();
}