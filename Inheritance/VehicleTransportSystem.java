class Vehicle{
    int maxSpeed; String fuelType;
    Vehicle(int speed,String fuel){ this.maxSpeed=speed; this.fuelType=fuel; }
    void displayInfo(){ System.out.println("Speed:"+maxSpeed+" Fuel:"+fuelType); }
}
class Car extends Vehicle{
    int seatCapacity;
    Car(int speed,String fuel,int seats){ super(speed,fuel); seatCapacity=seats;}
    void displayInfo(){ super.displayInfo(); System.out.println("Seats:"+seatCapacity); }
}
class Truck extends Vehicle{
    int loadCapacity;
    Truck(int speed,String fuel,int load){ super(speed,fuel); loadCapacity=load;}
    void displayInfo(){ super.displayInfo(); System.out.println("Load:"+loadCapacity+"kg"); }
}
class Motorcycle extends Vehicle{
    boolean hasCarrier;
    Motorcycle(int speed,String fuel,boolean carrier){ super(speed,fuel); hasCarrier=carrier;}
    void displayInfo(){ super.displayInfo(); System.out.println("Carrier:"+hasCarrier); }
}
public class VehicleTransportSystem{
    public static void main(String[] args){
        Vehicle[] v={ new Car(180,"Petrol",5), new Truck(120,"Diesel",5000), new Motorcycle(140,"Petrol",true)};
        for(Vehicle ve:v){ ve.displayInfo(); System.out.println("---"); }
    }
}