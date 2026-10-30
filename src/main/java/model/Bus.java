package model;

/** A bus. */
public class Bus extends Vehicle {

    public Bus(String id, String name, double baseFare) {
        super(id, name, baseFare);
    }

    @Override
    public String getKind() {
        return "Bus";
    }
}