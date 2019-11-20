package library;
import java.util.*;

public class Author implements Comparable<Author>{
    String name;
    String surname;

    public Author(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return this.name + " " + this.surname;
    }

    public boolean equals(Author a) {
        if (this.name.equals(a.name) && this.surname.equals(a.surname))
            return true;

        return false;
    }

    @Override
    public int compareTo(Author a) {
        return this.surname.compareTo(a.surname);
    }
}