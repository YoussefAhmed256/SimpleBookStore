package Model;

import java.time.Year;

public class DemoBook extends Book {
    private boolean forSale ;

    public DemoBook(String title, String ISBN, Year year, double price,int quantity) {
        super(title, ISBN, year, price,quantity);
        forSale = false;
    }
}
