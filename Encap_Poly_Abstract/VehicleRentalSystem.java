// Problem 3 – Vehicle Rental System
abstract class VehicleVR {
    private String vehicleNumber;
    private String type;
    private double rentalRate;
    VehicleVR(String num, String type, double rate) {
        this.vehicleNumber = num;
        this.type = type;
        this.rentalRate = rate;
    }
    public String getVehicleNumber() { return vehicleNumber; }
    public double getRentalRate() { return rentalRate; }

    public abstract double calculateRentalCost(int days);
}

interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

class CarVR extends VehicleVR implements Insurable {
    CarVR(String num, double rate) { super(num, "Car", rate); }
    @Override public double calculateRentalCost(int days) { return days * getRentalRate(); }
    @Override public double calculateInsurance() { return 1000; }
    @Override public String getInsuranceDetails() { return "Car Insurance: ₹1000"; }
}

class BikeVR extends VehicleVR implements Insurable {
    BikeVR(String num, double rate) { super(num, "Bike", rate); }
    @Override public double calculateRentalCost(int days) { return days * getRentalRate(); }
    @Override public double calculateInsurance() { return 300; }
    @Override public String getInsuranceDetails() { return "Bike Insurance: ₹300"; }
}

class TruckVR extends VehicleVR implements Insurable {
    TruckVR(String num, double rate) { super(num, "Truck", rate); }
    @Override public double calculateRentalCost(int days) { return days * getRentalRate() + 500 * days; }
    @Override public double calculateInsurance() { return 2000; }
    @Override public String getInsuranceDetails() { return "Truck Insurance: ₹2000"; }
}

public class VehicleRentalSystem {
    public static void main(String[] args) {
        VehicleVR[] fleet = { new CarVR("KA‑01‑AA‑1111", 1500), new BikeVR("KA‑09‑BB‑2222", 500), new TruckVR("KA‑05‑CC‑3333", 3000) };
        for (VehicleVR v : fleet) {
            Insurable ins = (Insurable) v;
            System.out.println(v.getVehicleNumber() + " | Rent 3 days: " + v.calculateRentalCost(3)
                               + " | " + ins.getInsuranceDetails());
        }
    }
}