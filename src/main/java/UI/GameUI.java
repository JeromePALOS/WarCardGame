
package UI;
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


public class GameUI extends JPanel{
    //panel
    private JPanel panel_game = new JPanel(new BorderLayout());
    JPanel panel_info = new JPanel(new GridLayout(2, 1));
    //player
    private Player player1 = new Player("first", 200, 50);
    private Player player2 = new Player("second", 200, 50);
    
    //board
    private JPanel panel_board_player1 = new JPanel ();
    private JPanel panel_board_player2 = new JPanel ();


    

    public JPanel gamePanel(/*Graphics g*/){

        this.panel_game.add(panelTop(), BorderLayout.NORTH);
        this.panel_game.add(panelBoard(), BorderLayout.CENTER);
        this.panel_game.add(panelBottom(), BorderLayout.SOUTH);
        return this.panel_game;
    }
    
    public JPanel panelTop(){
        JPanel panel_top = new JPanel(new GridLayout(1, 2));

        //card
        JPanel panel_card = new JPanel(new GridLayout(2, player2.viewDeckSize()));  
        for(int i=0; i<player2.viewDeckSize(); i++){
            JButton btn_store = new JButton("Card n'"+ (i+1));
            panel_card.add(btn_store);
        }
        panel_top.add(panel_card);
        
        //text HP
        JLabel hp = new JLabel();
        hp.setText("HP : " + String.valueOf(this.player2.viewHp()));
        panel_top.add(hp);
            
        
        

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
        //JPanel panel_bottom = new JPanel(new BorderLayout());
        JPanel panel_bottom = new JPanel();
        panel_bottom.setLayout(new GridLayout(1,2));
        
        panel_bottom.add(panelCard()); //Deck
        panel_bottom.add(panelMenuStore());
        
        
        return panel_bottom;
    }
    
    public JPanel panelMenuStore(){
        JPanel panel_menu_store = new JPanel(new GridLayout(1, 3));
        
        //Panel info
            
            //text HP
            this.panel_info.add(viewHp());

            //text Gold
            JLabel gold = new JLabel();
            gold.setText("GOLD : " + String.valueOf(this.player1.viewGold()));
            this.panel_info.add(gold);


            panel_menu_store.add(this.panel_info);
        //end panel info
        
        
        
        //Btn store
        JButton btn_store = new JButton("Store");
        btn_store.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0){
                StoreUI st = new StoreUI(player1, panel_game);
            }        
        });        
        panel_menu_store.add(btn_store);
        
        //next turn
        JButton btn_next = new JButton("Next Turn -> ");
        btn_next.addActionListener(new ActionListener(){
               //private Player player;
                    public void actionPerformed(ActionEvent arg0){
                        //panel_game.removeAll();
                        //panel_info.validate();
                        player1.removeHp(2);
                        System.out.println(player1.viewHp());
                        //panel_game.updateUI();
                        //panel_info.removeAll();
                        panel_info.updateUI();
                        //panel_info.add(viewHp());
                        //panel_info.revalidate();
                        //panel_info.repaint();
                        //updateUI();
                    }        
                });
        panel_menu_store.add(btn_next);
        
        
        return panel_menu_store;
    }
    
    public JPanel panelCard(){
        JPanel panel_card = new JPanel(new GridLayout(2, player1.viewDeckSize()));
        System.out.println(player1.viewDeckSize());
        
        for(int i=0; i<player1.viewDeckSize(); i++){
            
            //System.out.println(player1.deck.get(i).viewName());
            JButton btn_store = new JButton(player1.deck.get(i).viewName());
            panel_card.add(btn_store);
        }
        
        return panel_card;
    }
    
    public JPanel panelBoard(){
               
        JPanel panel_board = new JPanel (new GridLayout(2, 1, 0, 20));
        
        for (int i = 0; i<player1.board.size(); i++){
            affCard(player1);
        }
        for (int i = 0; i<player2.board.size(); i++){
            affCard(player2);
        }
        
        panel_board.add(panel_board_player2);
        panel_board.add(panel_board_player1);
        return panel_board;
        
    }
    
    public void affCard(Player player){
        try {
            JPanel panel_card = new JPanel(new BorderLayout());
            panel_card.setBackground(Color.LIGHT_GRAY);

            Border border = BorderFactory.createLineBorder(Color.BLACK);
            panel_card.setBorder(border);
            panel_card.setMaximumSize(new Dimension(90, 150));


            //Damage
            JLabel damage = new JLabel();
            damage.setText("DAMAGE : " + String.valueOf(player.viewGold()));
            panel_card.add(damage, BorderLayout.SOUTH);

            //img
            BufferedImage picture = ImageIO.read(new File("Ressources/faible.png"));
            JLabel pic = new JLabel(new ImageIcon(picture));
            panel_card.add(pic, BorderLayout.CENTER);
            
            if(player==player1){
                panel_board_player1.add(panel_card);
            }else if(player==player2){
                panel_board_player2.add(panel_card);
            }else{
                System.out.println("Error");
            }

        } catch (IOException ex) {
            Logger.getLogger(GameUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public JLabel viewHp(){
        JLabel hp = new JLabel();
        hp.setText("HP : " + String.valueOf(this.player1.viewHp()));
        
        return hp;
    }
    
    
}    
    /*public GameUI(){
        JPanel bottom_Panel = new JPanel(new BorderLayout());
        JButton btn_store = new JButton("Store");
        JLabel gold = new JLabel("23");
        bottom_Panel.add(btn_store, BorderLayout.EAST);
        
        
        //this.game_panel.add(bottomPanel(), BorderLayout.SOUTH);


    }
    
    public JPanel bottomPanel(){
        JPanel bottom_Panel = new JPanel(new BorderLayout());
        JButton btn_store = new JButton("Store");
        JLabel gold = new JLabel("23");
        bottom_Panel.add(btn_store, BorderLayout.EAST);
        return bottom_Panel;
    }
}*/
