package command;

import model.Seat;
import service.ReservationService;

/** Command that cancels a seat. */
public class CancelCommand implements Command {

    private final ReservationService reservationService;
    private final String seatId;

    public CancelCommand(ReservationService reservationService, String seatId) {
        this.reservationService = reservationService;
        this.seatId = seatId;
    }

    @Override
    public String execute() {
        Seat seat = reservationService.cancel(seatId);
        return "Cancelled: " + seat.getId();
    }
}