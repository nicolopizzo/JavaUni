package library;
import java.util.*;

public class Dictionary extends Book{
    private String language;

    public Dictionary(ArrayList<Author> authors, String title, String editor, String language) {
        super(authors, title, editor);
        this.language = language;
    }

    @Override
    public String getInfo() {
        return "This dictionary is written by " + this.authors + " and is for " + this.language;
    }

    @Override
    public String toString() {
        return "Dictionary: " + this.title + ", Language: " + this.language + ", Authors: " + this.authors;
    }

}