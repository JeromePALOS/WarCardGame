package Model;

import java.util.ArrayList;
import java.util.Random;


public class Store {
    //store
    private ArrayList<Card> store_cards = new ArrayList<Card>();
    
    //AllCard
    private ArrayList<Card> cards= new ArrayList<Card>();
    private String name[] = {"Weapon","Hammer", "SUPER HAMMER DU FLEAU"}; 
    private int price[] = {20, 30, 2300}; 
    private int damage[] = {40, 50, 4000}; 
    
    public Store(){
        createCard();
    }
    //Store
    public ArrayList changeStore(){
        this.store_cards.clear();
        for(int i = 1; i<=6; i++){
            Random r = new Random();
            int rng = r.nextInt(cards.size());
            this.store_cards.add(cards.get(rng));

        }
        return store_cards;
    }
    
    public Card viewCard(int i){
        return this.store_cards.get(i);
    }
    
    
    
    
 //All Card   
    
    public void createCard(){
        for(int i = 0; i< name.length; i++){
            cards.add(new Card(this.name[i], this.price[i], this.damage[i]));
        }
    }
        
    public ArrayList returnCards(){
        return cards;
    }
    
    public void viewAllNameCards(){
        for(int i=0; i<cards.size() ;i++){
            System.out.println(cards.get(i).viewName());
        }
    }
    
}
