// Problem 8 – Ride‑Hailing Application
abstract class RideVehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;
    RideVehicle(String id, String driver, double rate) {
        this.vehicleId = id; this.driverName = driver; this.ratePerKm = rate;
    }
    public void getVehicleDetails() { System.out.println("ID:"+vehicleId+" Driver:"+driverName+" Rate:"+ratePerKm); }
    public abstract double calculateFare(double distance);
}

interface GPS {
    String getCurrentLocation();
    void updateLocation(String loc);
}

class CarRide extends RideVehicle implements GPS {
    private String location = "Depot";
    CarRide(String id, String driver, double rate) { super(id, driver, rate); }
    @Override public double calculateFare(double dist) { return dist * 15; }
    @Override public String getCurrentLocation() { return location; }
    @Override public void updateLocation(String loc) { location = loc; }
}

class BikeRide extends RideVehicle implements GPS {
    private String location = "Station";
    BikeRide(String id, String driver, double rate) { super(id, driver, rate); }
    @Override public double calculateFare(double dist) { return dist * 8; }
    @Override public String getCurrentLocation() { return location; }
    @Override public void updateLocation(String loc) { location = loc; }
}

class AutoRide extends RideVehicle implements GPS {
    private String location = "Stand";
    AutoRide(String id, String driver, double rate) { super(id, driver, rate); }
    @Override public double calculateFare(double dist) { return dist * 10; }
    @Override public String getCurrentLocation() { return location; }
    @Override public void updateLocation(String loc) { location = loc; }
}

public class RideHailingApplication {
    public static void main(String[] args) {
        RideVehicle[] rides = {
            new CarRide("C1", "Arun", 15),
            new BikeRide("B1", "Vijay", 8),
            new AutoRide("A1", "Kumar", 10)
        };
        double[] distances = {12.5, 7.0, 5.3};
        for (int i = 0; i < rides.length; i++) {
            rides[i].getVehicleDetails();
            System.out.println("Fare: " + rides[i].calculateFare(distances[i]));
        }
    }
}