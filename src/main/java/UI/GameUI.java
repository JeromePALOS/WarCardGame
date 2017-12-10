
package UI;
import Controller.IA;
import Model.Player;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;


public class GameUI{
     //player
    private Player player1 = new Player("player1", 200, 50);
    private Player player2 = new Player("player2", 200, 50);
    
    
    
    //board
    private JPanel panel_board_player1 = new JPanel ();
    private JPanel panel_board_player2 = new JPanel ();

    
    
    //panel
    private JPanel panel_game = new JPanel(new BorderLayout());
    private JPanel panel_top = new JPanel(new GridLayout(1, 2));
    private InformationPlayerUI info = new InformationPlayerUI();
    //sous-panel
    private JPanel panel_info = new JPanel(new GridLayout(2, 1));
    private JPanel panel_HUD = new JPanel(new GridLayout(1, 3));
    
    //ouais interface et tout mais pas le temps en 2 semaines
    private PanelCardUI panel_card = new PanelCardUI(player1, player2, panel_board_player1, panel_board_player2, panel_info, info);
    private PanelCardUI panel_card2 = new PanelCardUI(player2, player2, panel_board_player2, panel_board_player1, panel_info, info);
    
    
    
    //store
    private StoreUI st1 = new StoreUI(player1, panel_game, panel_card, panel_info, info);
    private StoreUI st2 = new StoreUI(player2, panel_game, panel_card2, panel_info, info);
   
    private IA ia = new IA(player1, player2, st2, panel_card2, panel_board_player2);


    public JPanel gamePanel(){

        this.panel_game.add(panelTop(), BorderLayout.NORTH);
        this.panel_game.add(panelBoard(), BorderLayout.CENTER);
        this.panel_game.add(panelBottom(), BorderLayout.SOUTH);
        return this.panel_game;
        
    }
    
    public JPanel panelTop(){
        //card
        
        panel_top.add(panel_card2.viewButtonCardEnemy(player2));
       
        //text HP
        InformationPlayerUI info_player2 = new InformationPlayerUI();
        panel_top.add(info_player2.viewHp(player2));
            
        return panel_top;
    }
    
    public JPanel title(){
        JPanel titles = new JPanel(new BorderLayout());
        
        Font font_size = new Font("Serif", Font.PLAIN, 36);
        JLabel text = new JLabel("Card Game - PALOS Jerome");
        text.setFont(font_size);
        titles.add(text, BorderLayout.NORTH);

        return titles;
    } 
    
    public JPanel panelBottom(){
        JPanel panel_bottom = new JPanel();
        panel_bottom.setLayout(new GridLayout(1,2));
        
        
        panel_bottom.add(panel_card.viewButtonCard(player1)); //Deck
        panel_bottom.add(panelHUD());  // gold, hp, next turn, store

        return panel_bottom;
    }
    
    public JPanel panelHUD(){
        this.panel_info.add(info.viewHp(player1));
        this.panel_info.add(info.viewGold(player1));
        this.panel_HUD.add(this.panel_info);

        //Btn store
        JButton btn_store = new JButton("Store");
        btn_store.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0){
                st1.changeStore();
                st1.viewStore();
            }        
        });        
        panel_HUD.add(btn_store);
        
        //next turn
        
        panel_HUD.add(btnNext());
        
        
        return panel_HUD;
    }
    
    public JPanel panelBoard(){
        JPanel panel_board = new JPanel (new GridLayout(2, 1, 0, 20));

        for (int i = 0; i<player1.board.size(); i++){
            PanelBoard panel_card = new PanelBoard();
            panel_board_player1.add(panel_card.affCard(player1.board.get(i), player1, player2, panel_board_player1, panel_board_player2, panel_info, info));
        }
        for (int i = 0; i<player2.board.size(); i++){
            PanelBoard panel_card = new PanelBoard();
            panel_board_player2.add(panel_card.affCard(player2.board.get(i), player2, player1, panel_board_player1, panel_board_player2, panel_info, info));
        }
       panel_board.add(panel_board_player2);
       panel_board.add(panel_board_player1);
        return panel_board;
        
    }  
    public JButton btnNext(){
        JButton btn_next = new JButton("Next Turn -> ");
        btn_next.addActionListener(new ActionListener(){
               //private Player player;
                    public void actionPerformed(ActionEvent arg0){
                        player1.addGold(50);
                        player2.addGold(50);
                        ia.turn();
                        
                        
                        
                        //panel_game.removeAll();
                        //panel_info.validate();
                        player1.removeHp(2);
                        System.out.println(player1.viewHp());
                        //panel_game.updateUI();
                        //panel_info.removeAll();
                        panel_info.updateUI();
                        
                        panel_info.add(info.viewHp(player1));
                        panel_info.add(info.viewGold(player1));
                    }        
        });
        return btn_next;
    }
    public void update(){
                
       System.out.println("oui");
        
    } 
}