package factory;

import model.Vehicle;

/**
 * Factory Method (creator). Each factory knows how to build one kind of vehicle.
 * To add a new kind of transport, write a new vehicle class and a new factory;
 * nothing else in the program has to change.
 */
public interface VehicleFactory {

    Vehicle createVehicle(String id, String name, double baseFare);
}