// Problem 7 – Hospital Patient Management
abstract class PatientHP {
    private int patientId;
    private String name;
    private int age;
    PatientHP(int id, String name, int age) { this.patientId = id; this.name = name; this.age = age; }
    public void getPatientDetails() { System.out.println("ID:"+patientId+" Name:"+name+" Age:"+age); }
    public abstract double calculateBill();
}

interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

class InPatient extends PatientHP implements MedicalRecord {
    private double dailyCharge;
    private int days;
    private String record = "";
    InPatient(int id, String name, int age, double charge, int days) {
        super(id, name, age); this.dailyCharge = charge; this.days = days;
    }
    @Override public double calculateBill() { return dailyCharge * days; }
    @Override public void addRecord(String record) { this.record += record + "; "; }
    @Override public void viewRecords() { System.out.println("Records: " + record); }
}

class OutPatient extends PatientHP implements MedicalRecord {
    private double consultationFee;
    private String record = "";
    OutPatient(int id, String name, int age, double fee) {
        super(id, name, age); this.consultationFee = fee;
    }
    @Override public double calculateBill() { return consultationFee; }
    @Override public void addRecord(String record) { this.record += record + "; "; }
    @Override public void viewRecords() { System.out.println("Records: " + record); }
}

public class HospitalPatientManagement {
    public static void main(String[] args) {
        PatientHP[] patients = {
            new InPatient(1, "Rahul", 30, 2000, 3),
            new OutPatient(2, "Sita", 25, 500)
        };
        for (PatientHP p : patients) {
            p.getPatientDetails();
            System.out.println("Bill: " + p.calculateBill());
        }
    }
}