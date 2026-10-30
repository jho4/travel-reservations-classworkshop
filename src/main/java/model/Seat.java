package model;

import java.util.Locale;

/**
 * A seat is a reservation: a place saved for a customer in a vehicle.
 */
public class Seat {

    private final String id;
    private final String customerName;
    private final Vehicle vehicle;
    private final double finalCost;
    private ReservationState state;

    public Seat(String id, String customerName, Vehicle vehicle, double finalCost) {
        this.id = id;
        this.customerName = customerName;
        this.vehicle = vehicle;
        this.finalCost = finalCost;
        this.state = ReservationState.CONFIRMED;
    }

    public String getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public ReservationState getState() {
        return state;
    }

    public void cancel() {
        this.state = ReservationState.CANCELLED;
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "%s | %s | %s %s (%s) | cost: %,.2f | %s",
                id, customerName, vehicle.getId(), vehicle.getName(), vehicle.getKind(), finalCost, state);
    }
}