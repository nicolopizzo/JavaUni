public final class Student extends Person {
    private String university;
    private final String number;

    public Student(String firstName, String lastName, String university, String number) {
        super(firstName, lastName);
        this.university = university;
        this.number = number;
    }

    @override
    public String presentation() {
        return super.presentation() + "and I study at " + university;
    }

    @override
    public String toString() {
        return super + "\nUniversity: " + university + "\nNumber: " + number;
    }
}