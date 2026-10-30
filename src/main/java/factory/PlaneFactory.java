package factory;

import model.Plane;
import model.Vehicle;

/** Creates plane vehicles. */
public class PlaneFactory implements VehicleFactory {

    @Override
    public Vehicle createVehicle(String id, String name, double baseFare) {
        return new Plane(id, name, baseFare);
    }
}