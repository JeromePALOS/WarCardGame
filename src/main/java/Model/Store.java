package Model;

import java.util.ArrayList;
import java.util.Random;


public class Store {
    //store
    private ArrayList<Card> store_cards = new ArrayList<Card>();
    
    //AllCard
    private ArrayList<Card> cards= new ArrayList<Card>();
    private String name[] = {"sword1","sword2","sword3","sword4","sword5","hammer1","bow"}; 
    private int price[] = {20, 15, 40, 35, 25, 60, 50}; 
    private int damage[] = {30, 30, 50, 45, 35, 50, 60}; 
    
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
    
    //add card to player
    public void picCard(Player player, int i){
        player.addCardDeck(this.store_cards.get(i));
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
