class Course{
    String courseName; int duration;
    Course(String name,int duration){ courseName=name; this.duration=duration;}
}
class OnlineCourse extends Course{
    String platform; boolean isRecorded;
    OnlineCourse(String name,int duration,String platform,boolean recorded){ super(name,duration); this.platform=platform; this.isRecorded=recorded;}
}
class PaidOnlineCourse extends OnlineCourse{
    double fee,discount;
    PaidOnlineCourse(String name,int duration,String platform,boolean recorded,double fee,double discount){
        super(name,duration,platform,recorded); this.fee=fee; this.discount=discount;}
    void display(){ System.out.println(courseName+" Fee:"+fee+" Discount:"+discount+"%"); }
}
public class EducationalCourseHierarchy{
    public static void main(String[] args){
        PaidOnlineCourse poc=new PaidOnlineCourse("Java",6,"Udemy",true,49.99,10);
        poc.display();
    }
}