package Model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Card {
    private String name;
    private int price;
    private int damage;
    private BufferedImage picture;


   
    public Card(String name, int price, int damage){
        try {
            this.name = name;
            this.damage = damage;
            this.price = price;
            this.picture = ImageIO.read(new File("Ressources/"+name+".png"));
        } catch (IOException ex) {
            Logger.getLogger(Card.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    //Get
    public int viewPrice(){
        return this.price;
    }
    
    public int viewDamage(){
        return this.damage;
    }

    public String viewName(){
        return this.name;
    }
    
    public BufferedImage viewImage(){
        return this.picture;
    }
}
