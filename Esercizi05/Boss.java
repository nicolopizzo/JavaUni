public class Boss extends Employee {
    private String department;

    public Boss(String firstName, String lastName, String workingPlace, String department, double salary) {
        super(firstName, lastName, workingPlace, salary);
        this.department = department;
    }

    public String presentation() {
        return super.presentation() + " and I'm boss of " + department + " department";
    }

    public String toString() {
        return super.toString() + "\nBoss of department: " + department; 
    }
}