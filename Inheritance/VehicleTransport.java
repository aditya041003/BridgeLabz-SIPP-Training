class Vehicle {
    int maxSpeed; String fuelType;
    Vehicle(int maxSpeed,String fuelType){ this.maxSpeed=maxSpeed; this.fuelType=fuelType;}
    void displayInfo(){ System.out.println("MaxSpeed:"+maxSpeed+" Fuel:"+fuelType); }
}
class Car extends Vehicle {
    int seatCapacity;
    Car(int speed,String fuel,int seat){ super(speed,fuel); seatCapacity=seat;}
    @Override void displayInfo(){ super.displayInfo(); System.out.println("Seats:"+seatCapacity);}
}
class Truck extends Vehicle {
    int loadCapacity;
    Truck(int speed,String fuel,int load){ super(speed,fuel); loadCapacity=load;}
    @Override void displayInfo(){ super.displayInfo(); System.out.println("Load:"+loadCapacity+" tons");}
}
class Motorcycle extends Vehicle {
    boolean hasCarrier;
    Motorcycle(int speed,String fuel,boolean carrier){ super(speed,fuel); hasCarrier=carrier;}
    @Override void displayInfo(){ super.displayInfo(); System.out.println("Carrier:"+(hasCarrier?"Yes":"No"));}
}
public class VehicleTransport{
    public static void main(String[]args){
        Vehicle[] arr={ new Car(200,"Petrol",5), new Truck(120,"Diesel",10), new Motorcycle(150,"Petrol",true)};
        for(Vehicle v: arr){ v.displayInfo(); System.out.println(); }
    }
}