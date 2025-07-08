import Model.*;

import java.time.Year;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BookStore store = new BookStore();

        Ebook ebook = new Ebook("Java Basics", "111", Year.of(2015), 150.0, 10, "PDF", false);
        PaperBook paperBook = new PaperBook("OOP Concepts", "222", Year.of(2012), 250.0, 5, 30, true);
        DemoBook demoBook = new DemoBook("Trial Version", "333", Year.of(2018), 0.0, 100);

        store.addBook(ebook);
        store.addBook(paperBook);
        store.addBook(demoBook);



        System.out.println("Books have been added to the store.");

        System.out.println(" Buying an Ebook:");
        store.buyBook("111", 1, "user@example.com", "some address");

        System.out.println("Buying a PaperBook:");
        store.buyBook("222", 2, "user@example.com", "25 El-Madina St, Cairo");

        System.out.println(" Trying to buy a DemoBook:");
        try {
            store.buyBook("333", 1, "user@example.com", "anywhere");
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println(" Removing book by ISBN:");
        store.removeBook("111");

        System.out.println(" Outdated books (older than 8 years):");
        List<Book> oldBooks = store.ReturnOutDatedBooks(8);
        for (Book b : oldBooks) {
            System.out.println( b.getTitle() + " - Published in: " + b.getYear());
        }
    }
}