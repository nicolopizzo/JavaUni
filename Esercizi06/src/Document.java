package library;
import java.util.ArrayList;

public abstract class Document implements Comparable<Document>{
    private static int counter;
    private int id;

    public Document() {
        this.id = counter++;
    }

    public abstract String getTitle();

    public abstract String getInfo();

    @Override
    public int compareTo(Document d) {
        if (this instanceof Book)
            return ((Book) this).compareTo(d);
        else if (this instanceof Paper)
            return ((Paper) this).compareTo(d);
        else if (d instanceof Book || d instanceof Paper)
            return 1;
        else
            return 0;
    }
}