package app;

import command.BookCommand;
import command.CancelCommand;
import command.CheckCommand;
import command.CommandInvoker;
import factory.BusFactory;
import factory.PlaneFactory;
import factory.TrainFactory;
import factory.VehicleFactory;
import model.Seat;
import model.Vehicle;
import observer.EmailNotifier;
import observer.LogObserver;
import observer.Subject;
import service.ReservationService;
import strategy.FlatFare;
import strategy.HighSeasonFare;
import strategy.PricingStrategy;

public class Main {

    public static void main(String[] args) {
        // Observer: the subject notifies the customer (email) and the activity log
        Subject subject = new Subject();
        LogObserver logObserver = new LogObserver();
        subject.attach(new EmailNotifier());
        subject.attach(logObserver);

        ReservationService reservationService = new ReservationService(subject);
        CommandInvoker invoker = new CommandInvoker();

        // Factory Method: each factory builds its own kind of vehicle
        VehicleFactory planes = new PlaneFactory();
        VehicleFactory trains = new TrainFactory();
        VehicleFactory buses = new BusFactory();

        Vehicle plane = planes.createVehicle("P-100", "Bogota - Miami", 800000);
        Vehicle train = trains.createVehicle("T-200", "Bogota - Tunja", 120000);
        Vehicle bus = buses.createVehicle("B-300", "Bogota - Medellin", 60000);

        // Strategy: two ways of calculating the cost
        PricingStrategy standard = new FlatFare();
        PricingStrategy highSeason = new HighSeasonFare();

        System.out.println("=== Booking seats ===");
        invoker.invoke(new BookCommand(reservationService, "Ana", plane, standard));
        invoker.invoke(new BookCommand(reservationService, "Luis", train, highSeason));
        invoker.invoke(new BookCommand(reservationService, "Marta", bus, highSeason));
        invoker.invoke(new BookCommand(reservationService, "Pedro", bus, standard));

        System.out.println("\n=== Cancelling a valid seat ===");
        invoker.invoke(new CancelCommand(reservationService, "SEAT-002"));

        System.out.println("\n=== Invalid operations (no notifications expected) ===");
        invoker.invoke(new CancelCommand(reservationService, "SEAT-999"));              // does not exist
        invoker.invoke(new CancelCommand(reservationService, "SEAT-002"));              // already cancelled
        invoker.invoke(new CancelCommand(reservationService, "  "));                    // empty id
        invoker.invoke(new BookCommand(reservationService, "", train, standard));       // empty customer
        invoker.invoke(new BookCommand(reservationService, "Sofia", null, standard));   // no vehicle
        invoker.invoke(new BookCommand(reservationService, "Sofia", plane, null));      // no pricing strategy
        invoker.invoke(new CheckCommand(reservationService, "SEAT-777"));               // does not exist

        System.out.println("\n=== Checking states ===");
        invoker.invoke(new CheckCommand(reservationService, "SEAT-001"));
        invoker.invoke(new CheckCommand(reservationService, "SEAT-002"));

        System.out.println("\n=== Final state of all seats ===");
        for (Seat seat : reservationService.listAll()) {
            System.out.println(seat);
        }

        System.out.println("\n=== Activity history ===");
        logObserver.getEntries().forEach(System.out::println);
    }
}