package library;
import java.util.*;

public class Paper extends Document {
    ArrayList<Author> authors;
    String title;
    String category;

    public Paper(ArrayList<Author> authors, String title, String category) {
        this.authors = new ArrayList<>();
        for (Author a : authors) 
            this.authors.add(a);
        this.title = title;
        this.category = category;
    }

    @Override
    public String getInfo() {
        return "The paper " + this.title + " is written by " + this.authors + ". You can find it in the " + this.category + " section";
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public String toString() {
        return "Paper: " + this.title + ", Authors: " + this.authors + ", Category: " + this.category;
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