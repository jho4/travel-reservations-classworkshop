package command;

import model.Seat;
import service.ReservationService;

/** Command that asks for the state of a seat. */
public class CheckCommand implements Command {

    private final ReservationService reservationService;
    private final String seatId;

    public CheckCommand(ReservationService reservationService, String seatId) {
        this.reservationService = reservationService;
        this.seatId = seatId;
    }

    @Override
    public String execute() {
        Seat seat = reservationService.find(seatId);
        return "State of " + seat.getId() + ": " + seat.getState();
    }
}