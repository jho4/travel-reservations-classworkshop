package observer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Observer that writes every event in the activity history. */
public class LogObserver implements Observer {

    private final List<String> entries = new ArrayList<>();

    @Override
    public void update(ReservationEvent event) {
        entries.add(String.format("#%d | %s", entries.size() + 1, event.message()));
    }

    public List<String> getEntries() {
        return Collections.unmodifiableList(entries);
    }
}