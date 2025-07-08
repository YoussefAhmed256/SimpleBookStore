package Model;

import javax.swing.plaf.PanelUI;
import java.time.Year;
import java.util.List;

public class Book  {
    private String title;
    private String ISBN;
    private Year year;
    private double price;
    private int quantity;

    public Book(String title, String ISBN, Year year, double price, int quantity) {
        this.title = title;
        this.ISBN = ISBN;
        this.year = year;
        this.price = price;
        this.quantity = quantity;
    }


    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getTitle() {
        return title;
    }

    public String getISBN() {
        return ISBN;
    }
    public Year getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book other = (Book) obj;
        return ISBN.equals(other.ISBN);
    }
}
