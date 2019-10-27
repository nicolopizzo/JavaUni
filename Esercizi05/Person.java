public class Person {
    protected String firstName;
    protected String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String presentation() {
        return "Hi! I'm " + firstName + " " + lastName;
    }

    @override
    public String toString() {
        return "Name: " + firstName + "\nLast Name: " + lastName;
    }

}