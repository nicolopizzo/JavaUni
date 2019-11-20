package library;
import java.util.*;

public class Library {
    private ArrayList<Document> documents;
    private Scanner scanInt = new Scanner(System.in);
    private Scanner scanString = new Scanner(System.in);
    private Scanner scanLine = new Scanner(System.in);

    public Library() {
        this.documents = new ArrayList<>();
    }

    public void showMenu() {
        int choice = 1, choice2 = 0;
        String title = "", language = "", editor = "", category = "", date = "";
        ArrayList<Author> authors = new ArrayList<>();

        do {
            System.out.println("Menu\n0)Exit\n1)Show all the documents\n2)Insert a new Document\n3)Edit a document\n4)Delete a document\n5)Search for a document");
            System.out.print("What do you want to do? ");
            switch (choice = scanInt.nextInt()) {
                case 1:
                    showDocuments();
                    break;
                case 2:
                    System.out.println("What kind of document are you inserting?\n1)Book\n2)Dictionary\n3)Newspaper\n4)Paper");
                    switch(choice2 = scanInt.nextInt()) {
                        case 2:
                            System.out.print("Language: ");
                            language = scanLine.nextLine();

                        case 1:
                            System.out.print("Insert the authors: ");
                            for (String a : scanLine.nextLine().split("\\, "))
                                authors.add(new Author(a.split(" ")[0], a.split(" ")[1]));

                            System.out.print("Insert the title: ");
                            title = scanLine.nextLine();

                            System.out.print("Insert the editor: ");
                            editor = scanLine.nextLine();

                            insertDocument((choice2 == 1 ? new Book(authors, title, editor) : new Dictionary(authors, title, editor, language)));
                            break;
                        
                        case 3:
                            System.out.print("Insert the title: ");
                            title = scanLine.nextLine();
                            
                            System.out.print("Insert the date: ");
                            date = scanLine.nextLine();

                            insertDocument(new Newspaper(title, date));
                            break;
                        
                        case 4:
                            System.out.print("Insert the authors: ");
                            for (String a : scanLine.nextLine().split("\\, "))
                                authors.add(new Author(a.split(" ")[0], a.split(" ")[1]));

                            System.out.print("Insert the title: ");
                            title = scanLine.nextLine();

                            System.out.print("Insert the category: ");
                            category = scanLine.nextLine();

                            insertDocument(new Paper(authors, title, category));
                            break;
                    }
                    break;
                case 3:
                    System.out.print("Insert the title of the book: ");
                    title = scanLine.nextLine();
                    Document d1 = searchByTitle(title);
                    if (d1 == null)
                        break;
                    System.out.println("What do you want to change?\n1)Title\n2)Authors\n3)Editor");
                    switch(scanInt.nextInt()) {
                        case 1:
                            System.out.print("Insert the new title: ");
                            editTitle(d1, scanLine.nextLine());
                            break;
                        case 2:
                            System.out.print("Insert the new authors: ");
                            for (String a : scanLine.nextLine().split("\\, "))
                                authors.add(new Author(a.split(" ")[0], a.split(" ")[1]));
                            editAuthors(d1, authors);
                            break;
                        case 3:
                            System.out.print("Insert the new editor: ");
                            editEditor(d1, scanLine.nextLine());
                            break;
                    }
                    break;
                case 4:
                    System.out.print("Insert the title of the book you want to delete: ");
                    System.out.println(this.documents.remove(searchByTitle(scanLine.nextLine())) ? "Book deleted." : "Book not found.");
                    break;
                case 5:
                    System.out.println("Which parameter do you want to insert?\n1)Author\n2)Title\n3)Editor\n4)Category\n5)Date");
                    switch (scanInt.nextInt()) {
                        case 1:
                            System.out.print("Insert first name and last name of the author: ");
                            System.out.println(searchByAuthor(new Author(scanString.next(), scanString.next())));
                            break;

                        case 2:
                            System.out.print("Insert the title: ");
                            System.out.println(searchByTitle(scanLine.nextLine()));
                            break;

                        case 3:
                            System.out.print("Insert the editor: ");
                            System.out.println(searchByEditor(scanLine.nextLine()));
                            break;

                        case 4:
                            System.out.print("Insert the category of the paper: ");
                            System.out.println(searchByCategory(scanLine.nextLine()));
                            break;

                        case 5:
                            System.out.print("Insert the date of the newspaper");
                            System.out.println(searchByDate(scanLine.nextLine()));
                            break;
                    }
                    break;
            }
            authors.clear();
        } while (choice != 0);
    }

    public void showDocuments() {
        for (Document d : this.documents)
            System.out.println(d.getInfo());
        System.out.println();
    }

    public void insertDocument(Document d) {
        this.documents.add(d);
    }

    public Document searchByTitle(String title) {
        for (Document d : this.documents)
            if (d.getTitle().equals(title))
                return d;
        return null;
    }

    public ArrayList<Document> searchByAuthor(Author author) {
        ArrayList<Document> docs = new ArrayList<>();

        for (Document d : this.documents)
            for (Author a : (d instanceof Book ? ((Book) d).authors : (d instanceof Paper ? ((Paper) d).authors : null)))
                if (a.equals(author))
                    docs.add(d);

        return docs;
    }

    public ArrayList<Document> searchByEditor(String editor) {
        ArrayList<Document> docs = new ArrayList<>();

        for (Document d : this.documents)
            if (d instanceof Book && ((Book) d).editor.equals(editor))
                docs.add(d);
            
        return docs;
    }

    public ArrayList<Document> searchByCategory(String category) {
        ArrayList<Document> docs = new ArrayList<>();

        for (Document d : this.documents)
            if (d instanceof Paper && ((Paper) d).category.equals(category))
                docs.add(d);

        return docs;
    }

    public ArrayList<Document> searchByDate(String date) {
        ArrayList<Document> docs = new ArrayList<>();

        for (Document d : this.documents)
            if (d instanceof Newspaper && ((Newspaper) d).date.equals(date))
                docs.add(d);

        return docs;
    }

    private static void editTitle(Document d, String title) {
        if (d instanceof Book)
            ((Book) d).title = title;
        else if (d instanceof Newspaper)
            ((Newspaper) d).title = title;
        else if (d instanceof Paper)
            ((Paper) d).title = title;
        else
            System.out.println("You cannot edit this attribute.");
    }

    private static void editAuthors(Document d, ArrayList<Author> authors) {
        if (d instanceof Book) {
            ((Book) d).authors.clear();
            for (Author a : authors)
                ((Book) d).authors.add(a);
        }
        else if (d instanceof Paper) {
            ((Paper) d).authors.clear();
            for (Author a : authors)
                ((Paper) d).authors.add(a);
        }
        else
            System.out.println("You cannot edit this attribute.");
    }

    private static void editEditor(Document d, String editor) {
        if (d instanceof Book)
            ((Book) d).editor = editor;
        else
            System.out.println("You cannot edit this attribute.");
    }

    public void sortByTitle() {
        Collections.sort(this.documents, new Comparator<Document>() {
            @Override
            public int compare(Document d1, Document d2) {
                if (d1 instanceof Book && d2 instanceof Book)
                    return ((Book) d1).title.compareTo(((Book) d2).title);
                else if (d1 instanceof Book && d2 instanceof Paper)
                    return ((Book) d1).title.compareTo(((Paper) d2).title);
                else if (d1 instanceof Paper && d2 instanceof Book)
                    return ((Paper) d1).title.compareTo(((Book) d2).title);
                else if (d1 instanceof Paper && d2 instanceof Paper)
                    return ((Paper) d1).title.compareTo(((Paper) d2).title);
                else if (d1 instanceof Book || d1 instanceof Paper)
                    return 1;
                else if (d2 instanceof Book || d2 instanceof Paper)
                    return -1;
                else
                    return 0;
            }
        });
    }

    public void sortByAuthorName() {
        Collections.sort(this.documents, new Comparator<Document>() {
            @Override
            public int compare(Document d1, Document d2) {
                if (d1 instanceof Book && d2 instanceof Book)
                    return ((Book) d1).authors.get(0).name.compareTo(((Book) d2).authors.get(0).name);
                else if (d1 instanceof Book && d2 instanceof Paper)
                    return ((Book) d1).authors.get(0).name.compareTo(((Paper) d2).authors.get(0).name);
                else if (d1 instanceof Paper && d2 instanceof Book)
                    return ((Paper) d1).authors.get(0).name.compareTo(((Book) d2).authors.get(0).name);
                else if (d1 instanceof Paper && d2 instanceof Paper)
                    return ((Paper) d1).authors.get(0).name.compareTo(((Paper) d2).authors.get(0).name);
                else if (d1 instanceof Book || d1 instanceof Paper)
                    return 1;
                else if (d2 instanceof Book || d2 instanceof Paper)
                    return -1;
                else    
                    return 0;
            }
        });
    }

    public void sortByAuthorSurname() {
        Collections.sort(this.documents, new Comparator<Document>() {
            @Override
            public int compare(Document d1, Document d2) {
                if (d1 instanceof Book && d2 instanceof Book)
                    return ((Book) d1).authors.get(0).surname.compareTo(((Book) d2).authors.get(0).surname);
                else if (d1 instanceof Book && d2 instanceof Paper)
                    return ((Book) d1).authors.get(0).surname.compareTo(((Paper) d2).authors.get(0).surname);
                else if (d1 instanceof Paper && d2 instanceof Book)
                    return ((Paper) d1).authors.get(0).surname.compareTo(((Book) d2).authors.get(0).surname);
                else if (d1 instanceof Paper && d2 instanceof Paper)
                    return ((Paper) d1).authors.get(0).surname.compareTo(((Paper) d2).authors.get(0).surname);
                else if (d1 instanceof Book || d1 instanceof Paper)
                    return 1;
                else if (d2 instanceof Book || d2 instanceof Paper)
                    return -1;
                else    
                    return 0;
            }
        });
    }

    public void sortByEditor() {
        Collections.sort(this.documents, new Comparator<Document>() {
            @Override
            public int compare(Document d1, Document d2) {
                if (d1 instanceof Book && d2 instanceof Book)
                    return ((Book) d1).editor.compareTo(((Book) d2).editor);
                else if (d1 instanceof Book)
                    return 1;
                else if (d2 instanceof Book)
                    return -1;
                else
                    return 0;
            }
        });
    }

    public void sortByDate() {
        Collections.sort(this.documents, new Comparator<Document>() {
            @Override
            public int compare(Document d1, Document d2) {
                if (d1 instanceof Newspaper && d2 instanceof Newspaper)
                    return ((Newspaper) d1).date.compareTo(((Newspaper) d2).date);
                else if (d1 instanceof Newspaper)
                    return 1;
                else if (d2 instanceof Newspaper)
                    return -1;
                else
                    return 0;
            }
        });
    }
}