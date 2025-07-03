// Sample Program 6 – Vehicle Registration System
class Vehicle {
    private static double registrationFee = 5000;

    private final String registrationNumber;
    private String ownerName;
    private String vehicleType;

    Vehicle(String registrationNumber, String ownerName, String vehicleType) {
        this.registrationNumber = registrationNumber;
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
        System.out.println("Registration fee updated to " + registrationFee);
    }

    public void displayDetails() {
        if (this instanceof Vehicle) {
            System.out.println("Reg#: " + registrationNumber + " | Owner: " + ownerName +
                               " | Type: " + vehicleType + " | Fee: " + registrationFee);
        }
    }

    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("KA01AB1234", "Ramesh", "Car");
        Vehicle v2 = new Vehicle("KA02CD5678", "Suresh", "Bike");
        v1.displayDetails();
        Vehicle.updateRegistrationFee(5500);
        v2.displayDetails();
    }
}