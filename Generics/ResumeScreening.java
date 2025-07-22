
import java.util.*;

abstract class JobRole {
    String roleName;
    JobRole(String roleName) {
        this.roleName = roleName;
    }
    public String toString() {
        return roleName;
    }
}

class SoftwareEngineer extends JobRole {
    SoftwareEngineer() {
        super("Software Engineer");
    }
}

class DataScientist extends JobRole {
    DataScientist() {
        super("Data Scientist");
    }
}

class ProductManager extends JobRole {
    ProductManager() {
        super("Product Manager");
    }
}

class Resume<T extends JobRole> {
    T jobRole;

    Resume(T jobRole) {
        this.jobRole = jobRole;
    }

    public void process() {
        System.out.println("Processing resume for: " + jobRole);
    }

    public static void processAll(List<? extends JobRole> roles) {
        for (JobRole role : roles) {
            System.out.println("Screening: " + role);
        }
    }
}

public class ResumeScreening {
    public static void main(String[] args) {
        Resume<SoftwareEngineer> resume = new Resume<>(new SoftwareEngineer());
        resume.process();

        List<JobRole> roles = new ArrayList<>();
        roles.add(new DataScientist());
        roles.add(new ProductManager());
        Resume.processAll(roles);
    }
}
