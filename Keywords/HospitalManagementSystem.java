// Sample Program 7 – Hospital Management System
class Patient {
    private static String hospitalName = "City Hospital";
    private static int totalPatients = 0;

    private final int patientID;
    private String name;
    private int age;
    private String ailment;

    Patient(int patientID, String name, int age, String ailment) {
        this.patientID = patientID;
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        totalPatients++;
    }

    public static int getTotalPatients() {
        return totalPatients;
    }

    public void displayDetails() {
        if (this instanceof Patient) {
            System.out.println("Hospital: " + hospitalName + " | ID: " + patientID +
                               " | Name: " + name + " | Age: " + age + " | Ailment: " + ailment);
        }
    }

    public static void main(String[] args) {
        Patient p1 = new Patient(1, "Lakshmi", 35, "Fever");
        Patient p2 = new Patient(2, "Arun", 28, "Fracture");
        p1.displayDetails();
        p2.displayDetails();
        System.out.println("Total Patients: " + Patient.getTotalPatients());
    }
}