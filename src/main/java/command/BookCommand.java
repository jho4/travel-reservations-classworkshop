package command;

import model.Seat;
import model.Vehicle;
import service.ReservationService;
import strategy.PricingStrategy;

/** Command that books a seat. */
public class BookCommand implements Command {

    private final ReservationService reservationService;
    private final String customerName;
    private final Vehicle vehicle;
    private final PricingStrategy pricingStrategy;

    public BookCommand(ReservationService reservationService, String customerName, Vehicle vehicle, PricingStrategy pricingStrategy) {
        this.reservationService = reservationService;
        this.customerName = customerName;
        this.vehicle = vehicle;
        this.pricingStrategy = pricingStrategy;
    }

    @Override
    public String execute() {
        Seat seat = reservationService.book(customerName, vehicle, pricingStrategy);
        return "Booked with " + pricingStrategy.getName() + ": " + seat.getId();
    }
}