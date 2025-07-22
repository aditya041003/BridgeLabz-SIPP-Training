
import java.util.*;

abstract class CourseType {
    String title;
    CourseType(String title) {
        this.title = title;
    }

    public String toString() {
        return title;
    }
}

class ExamCourse extends CourseType {
    ExamCourse(String title) {
        super(title);
    }
}

class AssignmentCourse extends CourseType {
    AssignmentCourse(String title) {
        super(title);
    }
}

class ResearchCourse extends CourseType {
    ResearchCourse(String title) {
        super(title);
    }
}

class Course<T extends CourseType> {
    T courseType;

    Course(T courseType) {
        this.courseType = courseType;
    }

    public void display() {
        System.out.println("Course: " + courseType);
    }

    public static void displayAllCourses(List<? extends CourseType> courses) {
        for (CourseType ct : courses) {
            System.out.println(ct);
        }
    }
}

public class UniversityCourses {
    public static void main(String[] args) {
        List<ExamCourse> list = new ArrayList<>();
        list.add(new ExamCourse("Math 101"));
        Course.displayAllCourses(list);
    }
}
