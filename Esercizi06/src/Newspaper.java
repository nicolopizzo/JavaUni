package library;
import java.util.ArrayList;

public class Newspaper extends Document {
    String title;
    String date;

    public Newspaper(String title, String date) {
        this.title = title;
        this.date = (date.matches("[0-2][0-9]{3}\\:[0-1][0-9]\\:[0-3][0-9]") ? date : "unknown");
    }

    @Override
    public String getInfo() {
        return "This is the \"" + this.title + "\"" + (this.date.equals("unknown") ? ", unknown date" : " of the " + this.date);
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public String toString() {
        return "Newspaper: " + this.title + ", Date: " + this.date;
    }
}