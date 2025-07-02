class Device {
    String deviceId,status;
    Device(String id,String status){ deviceId=id; this.status=status;}
    void displayStatus(){ System.out.println("ID:"+deviceId+" Status:"+status);}
}
class Thermostat extends Device {
    double temperatureSetting;
    Thermostat(String id,String status,double temp){ super(id,status);temperatureSetting=temp;}
    @Override void displayStatus(){ super.displayStatus(); System.out.println("Temp:"+temperatureSetting+"°C");}
}
public class SmartHomeDevice{
    public static void main(String[]args){
        Thermostat t=new Thermostat("TH001","ON",22.5);
        t.displayStatus();
    }
}