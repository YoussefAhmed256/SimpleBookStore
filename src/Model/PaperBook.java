package Model;

import Services.Sendable;

import java.time.Year;

public class PaperBook extends Book implements Sendable {
    private int stock;
    private boolean shipping;

    public PaperBook(String title, String ISBN, Year year, double price,int quantity, int stock, boolean shipping) {
        super(title, ISBN, year, price,quantity);
        this.stock = stock;
        this.shipping = shipping;
    }

    @Override
    public void send(String address) {
        System.out.println("Sending paper book '" + getTitle() + "' to ShippingService with address: " + address +" and it's Price: " + getPrice());
    }
}

