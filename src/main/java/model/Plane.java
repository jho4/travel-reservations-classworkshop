package model;

/** A plane. */
public class Plane extends Vehicle {

    public Plane(String id, String name, double baseFare) {
        super(id, name, baseFare);
    }

    @Override
    public String getKind() {
        return "Plane";
    }
}