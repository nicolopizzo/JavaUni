import java.util.*;

public class Author {
    public String name;
    public String surname;

    public Author(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    // @override
    public String toString() {
        return this.name + " " + this.surname;
    }

    public boolean equals(Author a) {
        if (this.name.equals(a.name) && this.surname.equals(a.surname))
            return true;

        return false;
    }

    public static void main(String[] args) {
        ArrayList<Author> a0 = new ArrayList<>();
        ArrayList<Author> a1 = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            a0.add(new Author("a", "b"));
            a1.add(new Author("a", "b"));
        }
    }
}