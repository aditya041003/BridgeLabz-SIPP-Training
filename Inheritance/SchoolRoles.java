class PersonSR {
    String name; int age;
    PersonSR(String name,int age){ this.name=name; this.age=age; }
    void displayRole(){ System.out.println("Person"); }
}
class Teacher extends PersonSR {
    String subject;
    Teacher(String name,int age,String sub){ super(name,age); subject=sub; }
    @Override void displayRole(){ System.out.println("Teacher of "+subject); }
}
class StudentRole extends PersonSR {
    int grade;
    StudentRole(String name,int age,int grade){ super(name,age); this.grade=grade; }
    @Override void displayRole(){ System.out.println("Student grade "+grade); }
}
class Staff extends PersonSR {
    String department;
    Staff(String name,int age,String dept){ super(name,age); department=dept; }
    @Override void displayRole(){ System.out.println("Staff in "+department); }
}
public class SchoolRoles{
    public static void main(String[]args){
        PersonSR[] people={ new Teacher("Mr Smith",40,"Math"), new StudentRole("Jane",15,10), new Staff("Bob",45,"Maintenance") };
        for(PersonSR p: people) p.displayRole();
    }
}