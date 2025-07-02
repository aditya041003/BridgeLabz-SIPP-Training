class Course {
    String courseName; int duration;
    Course(String name,int duration){ courseName=name; this.duration=duration;}
    void display(){ System.out.println("Course:"+courseName+" Duration:"+duration+" weeks"); }
}
class OnlineCourse extends Course{
    String platform; boolean isRecorded;
    OnlineCourse(String name,int duration,String platform,boolean rec){
        super(name,duration); this.platform=platform; this.isRecorded=rec;
    }
    @Override void display(){ super.display(); System.out.println("Platform:"+platform+" Recorded:"+isRecorded);}
}
class PaidOnlineCourse extends OnlineCourse{
    double fee,discount;
    PaidOnlineCourse(String name,int duration,String platform,boolean rec,double fee,double discount){
        super(name,duration,platform,rec); this.fee=fee; this.discount=discount;
    }
    @Override void display(){ super.display(); System.out.println("Fee:"+fee+" Discount:"+discount+"%");}
}
public class EducationalCourse{
    public static void main(String[]args){
        PaidOnlineCourse course=new PaidOnlineCourse("Java",6,"Udemy",true,49.99,10);
        course.display();
    }
}