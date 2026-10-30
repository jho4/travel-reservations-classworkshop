package observer;

/** Observer: anyone who wants to be told about reservation events. */
public interface Observer {

    void update(ReservationEvent event);
}