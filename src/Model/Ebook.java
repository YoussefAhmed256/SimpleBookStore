package Model;

import Services.Sendable;

import java.time.Year;

public class Ebook extends Book implements Sendable {

    private String fileType;
    private boolean shipping;

    public Ebook(String title, String ISBN, Year year, double price,int quantity , String fileType , boolean shipping) {
        super(title, ISBN, year, price,quantity);
        this.fileType = fileType;
        this.shipping = shipping;
    }
    public boolean isShipping() {
        return shipping;
    }

    @Override
    public void send(String email) {
        System.out.println("Sending ebook " + getTitle() + " to MailService with email: " + email +" and it's Price: " + getPrice());
    }
}
