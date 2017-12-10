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
        //deck.get(0).viewName();
    }
    
    public void addCardDeck(Card card){
        this.deck.add(card);
    }
    public void removeCardDeck(int i){
        this.deck.remove(i);
    }
    public void addCardBoard(Card card){
        this.board.add(card);
    }
    public void removeCardBoard(int i){
        this.board.remove(i);
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
        for(int i=0; i<deck.size() ;i++){
            System.out.println(deck.get(i));
        }
    }
    public ArrayList deck(){
        return this.deck;
    }
    public int viewDeckSize(){
        return this.deck.size();
    }
    public int viewBoardSize(){
        return this.board.size();
    }
    public Card viewCardBoard(int i){
        return this.board.get(i);
    }
    public Card viewCardDeck(int i){
        return this.deck.get(i);
    }
}
