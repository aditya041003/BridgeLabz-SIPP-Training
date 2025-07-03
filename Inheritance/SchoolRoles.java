class PersonRole{
    String name; int age;
    PersonRole(String name,int age){ this.name=name; this.age=age;}
    void displayRole(){ System.out.println("Person"); }
}
class Teacher extends PersonRole{
    String subject;
    Teacher(String name,int age,String subject){ super(name,age); this.subject=subject;}
    void displayRole(){ System.out.println("Teacher of "+subject); }
}
class StudentRole extends PersonRole{
    int grade;
    StudentRole(String name,int age,int grade){ super(name,age); this.grade=grade;}
    void displayRole(){ System.out.println("Student grade "+grade); }
}
class Staff extends PersonRole{
    String department;
    Staff(String name,int age,String dept){ super(name,age); department=dept;}
    void displayRole(){ System.out.println("Staff "+department+" dept"); }
}
public class SchoolRoles{
    public static void main(String[] args){
        PersonRole[] roles={ new Teacher("Mr Smith",40,"Math"), new StudentRole("Jane",15,10), new Staff("Robert",50,"Admin")};
        for(PersonRole r:roles) r.displayRole();
    }
}