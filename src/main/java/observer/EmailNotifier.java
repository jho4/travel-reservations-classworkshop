package observer;

/** Observer that sends the email notification to the customer (printed on the console). */
public class EmailNotifier implements Observer {

    @Override
    public void update(ReservationEvent event) {
        System.out.println("   [EMAIL] Message for " + event.customerName() + ": " + event.message());
    }
}