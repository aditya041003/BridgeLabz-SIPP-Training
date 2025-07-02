interface WorkerRM { void performDuties(); }
class PersonRM {
    String name; int id;
    PersonRM(String name,int id){ this.name=name; this.id=id; }
}
class Chef extends PersonRM implements WorkerRM {
    Chef(String name,int id){ super(name,id); }
    public void performDuties(){ System.out.println(name+" cooks"); }
}
class Waiter extends PersonRM implements WorkerRM {
    Waiter(String name,int id){ super(name,id); }
    public void performDuties(){ System.out.println(name+" serves"); }
}
public class RestaurantManagement{
    public static void main(String[]args){
        WorkerRM[] staff={ new Chef("Gordon",1), new Waiter("Sam",2) };
        for(WorkerRM w: staff) w.performDuties();
    }
}