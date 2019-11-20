package library;
import java.util.*;

public class Book extends Document {
    ArrayList<Author> authors;
    protected String title;
    protected String editor;

    public Book(ArrayList<Author> authors, String title, String editor) {
        this.authors = new ArrayList<>();
        for (Author a : authors)
            this.authors.add(a);
        this.title = title;
        this.editor = editor;
    }

    @Override
    public String getInfo() {
        return "This book's title is " + this.title + ". It is written by " + this.authors;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public String toString() {
        return "Book: " + this.title + ", Authors: " + this.authors;
    }

    @Override
    public int compareTo(Document d) {
        if (d instanceof Book) {
            return this.authors.get(0).compareTo(((Book) d).authors.get(0));
        }
        else if (d instanceof Paper) {
            return this.authors.get(0).compareTo(((Paper) d).authors.get(0));
        }
        else
            return -1;
    }
}