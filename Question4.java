class Item {
    protected String title;
    protected int releaseYear;
    protected double price;

    public Item(String title, int releaseYear, double price) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.price = price;
    }

    public void getDescription() {
        System.out.println("Title: " + title);
        System.out.println("Year: " + releaseYear);
        System.out.println("Price: " + price);
    }
}

class Dvd extends Item {
    private final double runtime;

    public Dvd(String title, int releaseYear, double price, double runtime) {
        super(title, releaseYear, price);
        this.runtime = runtime;
    }

    @Override
    public void getDescription() {
        super.getDescription();
        System.out.println("Runtime: " + runtime + " minutes");
        System.out.println();
    }
}

class Magazine extends Item {
    private final String author;
    private final int numPages;

    public Magazine(String title, int releaseYear, double price, String author, int numPages) {
        super(title, releaseYear, price);
        this.author = author;
        this.numPages = numPages;
    }

    @Override
    public void getDescription() {
        super.getDescription();
        System.out.println("Author: " + author);
        System.out.println("Pages: " + numPages);
        System.out.println();
    }
}

class Vinyl extends Item {
    private final int size;

    public Vinyl(String title, int releaseYear, double price, int size) {
        super(title, releaseYear, price);
        this.size = size;
    }

    @Override
    public void getDescription() {
        super.getDescription();
        System.out.println("Size: " + size + " inches");
        System.out.println();
    }
}

public class Question4 {
    public static void main(String[] args) {

        Item i1 = new Dvd("Baby be Mine", 1982, 50000, 4);
        Item i2 = new Magazine("Nintendo Power #82", 1997, 25000, "Nintendo", 36);
        Item i3 = new Vinyl("Song of The Wind", 1967, 350000, 12);

        i1.getDescription();
        i2.getDescription();
        i3.getDescription();
    }
}
