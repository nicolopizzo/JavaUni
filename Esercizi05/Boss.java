public class Boss extends Employee {
    private String department;

    public Boss(String firstName, String lastName, double salary, String department) {
        super(firstName, lastName, salary);
        this.department = department;
    }

    public String presentation() {
        return super.presentation() + "and I'm boss of " + department + "department";
    }

    public String toString() {
        return super + "Boss of department: " + department; 
    }
}