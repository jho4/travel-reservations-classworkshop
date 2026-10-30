package factory;

import model.Bus;
import model.Vehicle;

/** Creates bus vehicles. */
public class BusFactory implements VehicleFactory {

    @Override
    public Vehicle createVehicle(String id, String name, double baseFare) {
        return new Bus(id, name, baseFare);
    }
}