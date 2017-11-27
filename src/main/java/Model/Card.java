package Model;

public class Card {
    private String name;
    private int price;
    private int damage;
    


   
    public Card(String name, int price, int damage){
        this.name = name;
        this.damage = damage;
        this.price = price;
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
}
