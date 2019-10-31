package library;
import java.util.ArrayList;

public abstract class Document {
    private static int counter;
    private int id;

    public Document() {
        this.id = counter++;
    }

    public abstract String getTitle();

    public abstract String getInfo();
}