interface Refuelable{ void refuel(); }
class VehicleVH{
    int maxSpeed; String model;
    VehicleVH(int speed,String model){ maxSpeed=speed; this.model=model;}
}
class ElectricVehicle extends VehicleVH{
    ElectricVehicle(int speed,String model){ super(speed,model);}
    void charge(){ System.out.println(model+" charging"); }
}
class PetrolVehicle extends VehicleVH implements Refuelable{
    PetrolVehicle(int speed,String model){ super(speed,model);}
    public void refuel(){ System.out.println(model+" refueling"); }
}
public class VehicleHybridInheritance{
    public static void main(String[] args){
        ElectricVehicle ev=new ElectricVehicle(250,"Tesla S");
        PetrolVehicle pv=new PetrolVehicle(180,"Honda Civic");
        ev.charge();
        pv.refuel();
    }
}