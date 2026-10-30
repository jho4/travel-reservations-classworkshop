package factory;

import model.Train;
import model.Vehicle;

/** Creates train vehicles. */
public class TrainFactory implements VehicleFactory {

    @Override
    public Vehicle createVehicle(String id, String name, double baseFare) {
        return new Train(id, name, baseFare);
    }
}