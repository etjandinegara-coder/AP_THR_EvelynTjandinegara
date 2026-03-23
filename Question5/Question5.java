import java.util.ArrayList;
import java.util.Scanner;

class Book {
    protected String title;
    protected String author;
    protected int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public void getInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Year of Publication: " + year);
    }
}

class GeneralBook extends Book {
    private final String genre;

    public GeneralBook(String title, String author, int year, String genre) {
        super(title, author, year);
        this.genre = genre;
    }

    @Override
    public void getInfo() {
        super.getInfo();
        System.out.println("Genre: " + genre);
    }
}

class ChildrenBook extends Book {
    private final int minAge;
    private final boolean hasVisualisation;

    public ChildrenBook(String title, String author, int year, int minAge, boolean hasVisualisation) {
        super(title, author, year);
        this.minAge = minAge;
        this.hasVisualisation = hasVisualisation;
    }

    @Override
    public void getInfo() {
        super.getInfo();
        System.out.println("Min Age: " + minAge);
        System.out.println("Has Visualisation: " + hasVisualisation);
    }
}

public class Question5 {
    static ArrayList<Book> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        books.add(new Book("Why Black Moves First", "Wesley So", 2025));
        books.add(new GeneralBook("Inside Black Mesa", "Dr. Isaac Kleiner", 1997, "Documentary"));
        books.add(new ChildrenBook("Got Science?", "Rachel Dawes", 2015, 5, true));
        books.add(new GeneralBook("History of Java", "James Gosling", 2000, "Education"));
        books.add(new ChildrenBook("Fun Math", "Alice", 2010, 7, false));

        int choice;
        do {
            System.out.println("\n=== Library Menu ===");
            System.out.println("1. View Books");
            System.out.println("2. Add Book");
            System.out.println("3. Delete Book");
            System.out.println("4. Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> viewBooks();
                case 2 -> addBook();
                case 3 -> deleteBook();
            }

        } while (choice != 4);
    }

    static void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        for (int i = 0; i < books.size(); i++) {
            System.out.println("\n");
            books.get(i).getInfo();
        }
    }

    static void addBook() {
        System.out.println("Choose type:");
        System.out.println("1. Book");
        System.out.println("2. GeneralBook");
        System.out.println("3. ChildrenBook");
        System.out.print("Choice: ");
        int type = sc.nextInt();
        sc.nextLine();

        System.out.print("Title: ");
        String title = sc.nextLine();

        System.out.print("Author: ");
        String author = sc.nextLine();

        System.out.print("Year: ");
        int year = sc.nextInt();

        switch (type) {
            case 1 -> books.add(new Book(title, author, year));
            case 2 -> {
                sc.nextLine();
                System.out.print("Genre: ");
                String genre = sc.nextLine();
                books.add(new GeneralBook(title, author, year, genre));
            }
            case 3 -> {
                System.out.print("Min Age: ");
                int minAge = sc.nextInt();
                System.out.print("Has Visualisation (true/false): ");
                boolean vis = sc.nextBoolean();
                books.add(new ChildrenBook(title, author, year, minAge, vis));
            }
            default -> {
            }
        }

        System.out.println("Book added!");
    }

    static void deleteBook() {
        viewBooks();
        System.out.print("Enter index to delete: ");
        int idx = sc.nextInt();

        if (idx >= 0 && idx < books.size()) {
            books.remove(idx);
            System.out.println("Book deleted!");
        } else {
            System.out.println("Invalid index!");
        }
    }
}
