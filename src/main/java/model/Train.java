package model;

/** A train. */
public class Train extends Vehicle {

    public Train(String id, String name, double baseFare) {
        super(id, name, baseFare);
    }

    @Override
    public String getKind() {
        return "Train";
    }
}