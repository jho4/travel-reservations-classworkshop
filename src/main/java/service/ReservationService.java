package service;

import model.Seat;
import model.ReservationState;
import model.Vehicle;
import observer.ReservationEvent;
import observer.Subject;
import strategy.PricingStrategy;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Service where customers book, cancel and ask about their seats.
 * It is the receiver of the commands. Everything is stored in memory.
 */
public class ReservationService {

    private final Map<String, Seat> seats = new LinkedHashMap<>();
    private final Subject subject;
    private int lastNumber = 0;

    public ReservationService(Subject subject) {
        this.subject = subject;
    }

    public Seat book(String customerName, Vehicle vehicle, PricingStrategy pricingStrategy) {
        if (customerName == null || customerName.isBlank()) {
            throw new IllegalArgumentException("The customer name cannot be empty");
        }
        if (vehicle == null) {
            throw new IllegalArgumentException("The vehicle cannot be null");
        }
        if (pricingStrategy == null) {
            throw new IllegalArgumentException("The pricing strategy cannot be null");
        }

        double finalCost = pricingStrategy.calculate(vehicle.getBaseFare());
        lastNumber++;
        Seat seat = new Seat(String.format("SEAT-%03d", lastNumber), customerName.trim(), vehicle, finalCost);
        seats.put(seat.getId(), seat);

        subject.notifyObservers(new ReservationEvent(seat.getId(), seat.getCustomerName(), "Seat booked -> " + seat));
        return seat;
    }

    public Seat cancel(String seatId) {
        Seat seat = find(seatId);
        if (seat.getState() == ReservationState.CANCELLED) {
            throw new IllegalStateException("The seat " + seat.getId() + " is already cancelled");
        }
        seat.cancel();

        subject.notifyObservers(new ReservationEvent(seat.getId(), seat.getCustomerName(), "Seat cancelled -> " + seat));
        return seat;
    }

    public Seat find(String seatId) {
        if (seatId == null || seatId.isBlank()) {
            throw new IllegalArgumentException("The seat id cannot be empty");
        }
        Seat seat = seats.get(seatId.trim());
        if (seat == null) {
            throw new IllegalArgumentException("The seat " + seatId.trim() + " does not exist");
        }
        return seat;
    }

    public Collection<Seat> listAll() {
        return seats.values();
    }
}