class Employee {
    String name; int id; double salary;
    Employee(String name, int id, double salary) {
        this.name=name; this.id=id; this.salary=salary;
    }
    void displayDetails() {
        System.out.println("Name:"+name+" ID:"+id+" Salary:"+salary);
    }
}
class Manager extends Employee {
    int teamSize;
    Manager(String name,int id,double salary,int teamSize){
        super(name,id,salary); this.teamSize=teamSize;
    }
    @Override void displayDetails(){ super.displayDetails(); System.out.println("Team Size:"+teamSize);}
}
class Developer extends Employee {
    String programmingLanguage;
    Developer(String name,int id,double salary,String pl){
        super(name,id,salary); programmingLanguage=pl;
    }
    @Override void displayDetails(){ super.displayDetails(); System.out.println("Language:"+programmingLanguage);}
}
class Intern extends Employee {
    String mentor;
    Intern(String name,int id,double salary,String mentor){
        super(name,id,salary); this.mentor=mentor;
    }
    @Override void displayDetails(){ super.displayDetails(); System.out.println("Mentor:"+mentor);}
}
public class EmployeeManagement{
    public static void main(String[]args){
        Employee[] list={ new Manager("Alice",101,90000,10), new Developer("Bob",102,80000,"Java"), new Intern("Clara",103,30000,"Alice")};
        for(Employee e: list){ e.displayDetails(); System.out.println(); }
    }
}