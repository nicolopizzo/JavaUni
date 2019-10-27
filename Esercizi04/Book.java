import java.util.*;

public class Book {
    public final int id;
    public static int counter;
    public ArrayList<Author> authors;
    public String title;
    public double price;
    public String editor;

    public Book(ArrayList<Author> authors, String title, double price, String editor) {
        this.authors = authors;
        this.title = title;
        this.price = price;
        this.editor = editor;
        this.id = ++counter;

    }

    public String toString() {
        return  "Title: " + this.title + "\nPrice: €" + this.price + "\nAuthors: " + this.authors + "\nEditor: " + this.editor + "\n";
    }

    public static void main(String[] args) {
        ArrayList<Author> authors = new ArrayList<>();
        authors.add(new Author("Mario", "Rossi"));
        authors.add(new Author("Franco", "Bianchi"));
        authors.add(new Author("Giovanni", "Verdi"));

        Book b = new Book(authors, "Babbaluci", 13, "Mondadori");
        System.out.println(b);
    }
}