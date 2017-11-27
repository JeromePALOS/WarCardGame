package Model;

import java.util.ArrayList;

public class Player {
    private String name;
    private int hp;
    public ArrayList<Card> deck = new ArrayList<Card>();
    public ArrayList<Card> board = new ArrayList<Card>();
    private int gold;
    
    
    public Player(String name, int hp, int gold){
        this.gold = gold;
        this.hp = hp;
        this.name = name;
        //test
        deck.add(new Card("Hammer", 20, 30));
        board.add(new Card("Bow", 20, 30));
        board.add(new Card("Bow", 20, 30));
        board.add(new Card("Bow", 20, 30));
        board.add(new Card("Bow", 20, 30));
        board.add(new Card("Bow", 20, 30));
        board.add(new Card("Bow", 20, 30));
        //deck.get(0).viewName();
    }
    
    public void addCardDeck(Card card){
        this.deck.add(card);
    }
    public void addCardBoard(Card card){
        
        this.board.add(card);
    }
    public void addGold(int gold){
        this.gold += gold;
    }
    public void removeGold(int gold){
        this.gold -= gold;
    }
    
    
    
    public void removeHp(int hp){
        this.hp-=hp;
    }
    
    
    //get and view
    public String viewName(){
        return this.name;
    }
    public int viewGold(){
        return this.gold;
    }

    public int viewHp(){
        return this.hp;
    }
    public void viewDeck(){
        for(int i=3; i<deck.size() ;i++){
            System.out.println(deck.get(i));
        }
    }
    public ArrayList deck(){
        return this.deck;
    }
    public int viewDeckSize(){
        return this.deck.size();
    }
}
