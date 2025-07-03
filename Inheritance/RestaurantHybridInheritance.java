interface Worker{
    void performDuties();
}
class PersonRH{
    String name; int id;
    PersonRH(String name,int id){ this.name=name; this.id=id;}
}
class Chef extends PersonRH implements Worker{
    Chef(String name,int id){ super(name,id);}
    public void performDuties(){ System.out.println(name+" cooks dishes"); }
}
class Waiter extends PersonRH implements Worker{
    Waiter(String name,int id){ super(name,id);}
    public void performDuties(){ System.out.println(name+" serves tables"); }
}
public class RestaurantHybridInheritance{
    public static void main(String[] args){
        Worker[] staff={ new Chef("Gordon",1), new Waiter("Sam",2)};
        for(Worker w:staff) w.performDuties();
    }
}