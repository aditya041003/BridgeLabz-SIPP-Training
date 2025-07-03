class Employee{
    String name; int id; double salary;
    Employee(String name,int id,double salary){ this.name=name; this.id=id; this.salary=salary;}
    void displayDetails(){ System.out.println("ID:"+id+" Name:"+name+" Salary:"+salary); }
}
class Manager extends Employee{
    int teamSize;
    Manager(String name,int id,double salary,int teamSize){ super(name,id,salary); this.teamSize=teamSize;}
    void displayDetails(){ super.displayDetails(); System.out.println("Team size:"+teamSize); }
}
class Developer extends Employee{
    String programmingLanguage;
    Developer(String name,int id,double salary,String lang){ super(name,id,salary); this.programmingLanguage=lang;}
    void displayDetails(){ super.displayDetails(); System.out.println("Language:"+programmingLanguage); }
}
class Intern extends Employee{
    String mentor;
    Intern(String name,int id,double salary,String mentor){ super(name,id,salary); this.mentor=mentor;}
    void displayDetails(){ super.displayDetails(); System.out.println("Mentor:"+mentor); }
}
public class EmployeeManagementSystem{
    public static void main(String[] args){
        Employee[] e={ new Manager("Alice",101,90000,12), new Developer("Bob",102,80000,"Java"), new Intern("Cara",103,30000,"Alice")};
        for(Employee emp:e){ emp.displayDetails(); System.out.println("---");}
    }
}