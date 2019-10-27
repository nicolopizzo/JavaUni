import java.util.*;

public class BookCatalogue {
    private ArrayList<Book> books;
    private Scanner scanNumber = new Scanner(System.in);
    private Scanner scanString = new Scanner(System.in);

    public BookCatalogue() {
        this.books = new ArrayList<>();
    }

    public void displayFrame() {
        String editor, title;
        ArrayList<Author> authors = new ArrayList<>();
        double price;
        System.out.println("\nMenu\n1.Insert a book\n2.Search for a book\n3.Display all the books");
        System.out.print("What do you want to do? ");
        switch(scanNumber.nextInt()) {
            case 1:
                System.out.print("How many authors? ");
                int n = scanNumber.nextInt();
                for (int i = 0; i < n; i++) {
                    System.out.print("Insert the name: ");
                    String name = scanString.nextLine();
                    System.out.print("Insert the surname: ");
                    String surname = scanString.nextLine();
                    authors.add(new Author(name, surname));
                }

                System.out.print("Insert the title: ");
                title = scanString.nextLine();

                System.out.print("Insert the price: ");
                price = scanNumber.nextDouble();

                System.out.print("Insert the editor: ");
                editor = scanString.nextLine();

                this.books.add(new Book(authors, title, price, editor));
                break;
            
            case 2:
                System.out.println("What parameter do you want to use?\n1.Author\n2.Title\n3.Editor");
                switch (scanNumber.nextInt()) {
                    case 1:
                        System.out.print("Insert the name: ");
                        String name = scanString.nextLine();
                        System.out.print("Insert the surname: ");
                        String surname = scanString.nextLine();
                        System.out.println(searchByAuthor(new Author(name, surname)));
                        break;

                    case 2:
                        System.out.println(searchByTitle(scanString.nextLine()));
                        break;

                    case 3:
                        System.out.println(searchByEditor(scanString.nextLine()));
                        break;
                }
                break;

            case 3:
                System.out.println(this.books);
                break;
        }
    }

    private ArrayList<Book> searchByAuthor(Author a) {
        ArrayList<Book> books1 = new ArrayList<>();

        for (Book book : this.books)
            for (Author a1 : book.authors)
                if (a1.equals(a))
                    books1.add(book);

        return books1;
    }

    private ArrayList<Book> searchByTitle(String t) {
        ArrayList<Book> books = new ArrayList<>();

        for (Book book : this.books)
            if (t.equals(book.title))
                books.add(book);

        return books;
    }

    private ArrayList<Book> searchByEditor(String e) {
        ArrayList<Book> books = new ArrayList<>();

        for (Book book : this.books)
            if (e.equals(book.editor))
                books.add(book);

        return books;
    }

    public static void main(String[] args) {
        BookCatalogue b1 = new BookCatalogue();
        b1.displayFrame();
        b1.displayFrame();
        b1.displayFrame();
    }
}