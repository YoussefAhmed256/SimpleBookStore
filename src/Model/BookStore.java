package Model;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class BookStore {
    private List<Book>books;

    public BookStore() {
        books = new ArrayList<Book>();
    }

    public List<Book> ReturnOutDatedBooks(int year) {
        List<Book> outDatedBooks = new ArrayList<>();
        Year currentYear = Year.now();

        for (Book book : books) {
            Year bookYear = book.getYear();
            Year thresholdYear = bookYear.plusYears(year);

            if (currentYear.isAfter(thresholdYear)) {
                outDatedBooks.add(book);
            }
        }
        return outDatedBooks;
    }

    public void RemoveOutDatedBooks(int year) {
        Year currentYear = Year.now();

        for (Book book : books) {
            Year bookYear = book.getYear();
            Year thresholdYear = bookYear.plusYears(year);

            if (currentYear.isAfter(thresholdYear)) {
               books.remove(book);
            }
        }
    }
    public void addBook(Book newBook) {
        if (newBook.getYear().isAfter(Year.now())) {
            throw new IllegalArgumentException("Book year should be before year now");
        }
        for (Book book : books) {
            if (book.getISBN().equals(newBook.getISBN())) {
                throw new IllegalArgumentException("Book ISBN already exists");
            }
        }
        books.add(newBook);
    }
    public void removeBook(String ISBN) {
        for (Book book : books) {
            if (book.getISBN().equals(ISBN)) {
                books.remove(book);
                System.out.println("Book With ISBN " + ISBN + " deleted");
                return;
            }
        }
        throw new IllegalArgumentException("Book With ISBN " + ISBN + " not found");
    }
    public void buyBook(String ISBN,int quantity, String email , String address) {
        boolean found = false;
        for (Book book : books) {
            if (book.getISBN().equals(ISBN)) {
                if (book.getQuantity() >= quantity) {
                    book.setQuantity(book.getQuantity() - quantity);
                    found=true;
                }
                else throw new IllegalArgumentException("Book quantity in inventory not enough for your need");
                if (book instanceof Ebook)
                    ((Ebook) book).send(email);
                else if (book instanceof PaperBook)
                    ((PaperBook) book).send(address);
                else
                    throw new IllegalArgumentException("Demo Books is not for sale");
            }
        }
        if (!found)
            throw new IllegalArgumentException("Book With ISBN " + ISBN + " not found");
    }

    public List<Book> getBooks() {
        return books;
    }
}
