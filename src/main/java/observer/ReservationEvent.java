package observer;

/** The news that travels around: what happened, to which seat and to whom. */
public record ReservationEvent(String seatId, String customerName, String message) {
}