public class Employee extends Person {
    protected String workingPlace;
    protected double salary;

    public Employee(String firstName, String lastName, String workingPlace, double salary) {
        super(firstName, lastName);
        this.salary = salary;
        this.workingPlace = workingPlace;
    }

    public String presentation() {
        return super.presentation() + "and I work at " + workingPlace;
    }

    public String toString() {
        return super + "\nWorking Place: " + workingPlace + "\nSalary: " + salary;
    }

}