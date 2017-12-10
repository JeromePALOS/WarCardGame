
package UI;

import Model.Store;
import Model.Player;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
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

public class StoreUI{
    private JFrame store_frame = new JFrame();
    private JPanel parent;
    private Player player;
    private PanelCardUI panel;
    private JPanel panel_info;
    private InformationPlayerUI info;
    private Store store = new Store();
    
    public StoreUI(Player player, JPanel panel, PanelCardUI panel_card, JPanel panel_info, InformationPlayerUI info){
        this.player = player;
        this.parent = panel;
        this.panel = panel_card;
        this.panel_info = panel_info;
        this.info = info;
    }
    public void changeStore(){
        store.changeStore();
    }
    public void viewStore(){
        this.store_frame.setSize(900, 350);
        this.store_frame.setTitle("STORE");
        this.store_frame.setContentPane(panelStore());
        
        this.store_frame.setLocationRelativeTo(null);
        this.store_frame.setVisible(true);        
    }
    
    public JPanel panelStore(){//principal panel
        JPanel panel_store = new JPanel(new BorderLayout());
        panel_store.add(panelCards(), BorderLayout.CENTER);
        panel_store.add(panelMenu(), BorderLayout.SOUTH);
        
        return panel_store;
    }
    
 
    
    public JPanel panelCards(){
        
        JPanel panel_store = new JPanel();
        panel_store.setLayout(new BoxLayout(panel_store, BoxLayout.LINE_AXIS));
        
        for(int i = 0; i<6; i++){
            panel_store.add(panelCard(i));
        }
        
        return panel_store;
    }
    public JPanel panelCard(int i){
            JPanel panel_card = new JPanel(new BorderLayout());
            panel_card.setBackground(Color.LIGHT_GRAY);

            Border border = BorderFactory.createLineBorder(Color.BLACK);
            panel_card.setBorder(border);
            //panel_card.setMaximumSize(new Dimension(90, 150));
            
            
            //info card
            JPanel panel_card_info = new JPanel(new BorderLayout());
                //Name
                JLabel name = new JLabel();
                name.setText(String.valueOf(store.viewCard(i).viewName()));
                panel_card.add(name, BorderLayout.NORTH);

                //Damage
                JLabel damage = new JLabel();
                damage.setText("Damage : " + String.valueOf(store.viewCard(i).viewDamage()));
                panel_card_info.add(damage, BorderLayout.CENTER);

                //Price
                JLabel price = new JLabel();
                price.setText("Price  : " + String.valueOf(store.viewCard(i).viewPrice())+ " Gold");
                panel_card_info.add(price, BorderLayout.NORTH);
                
                //buy
                JButton btn_buy = new JButton("Buy this card");
                btn_buy.addActionListener(new ActionListener(){

                    public void actionPerformed(ActionEvent e){
                        buy(i);
                    }        

                });
                panel_card_info.add(btn_buy, BorderLayout.SOUTH);
                
            //End card_info
            //img
            
            JLabel pic = new JLabel(new ImageIcon(store.viewCard(i).viewImage()));
            panel_card.add(pic, BorderLayout.CENTER);
            panel_card.add(panel_card_info, BorderLayout.SOUTH); 
            return panel_card;
        
        
    }
    
    public JPanel panelMenu(){
        JPanel panel_menu = new JPanel(new GridLayout(1, 3));
        //Back
        JButton btn_store = new JButton(" <- BACK");
        btn_store.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0){
                store_frame.setVisible(false);
                store_frame.dispose();
                
            }        
        });
        panel_menu.add(btn_store);
        return panel_menu;
    }
    
    public void buy(int i){
        if(player.viewDeckSize()<=8 && player.viewGold()>=store.viewCard(i).viewPrice()){
            player.removeGold(store.viewCard(i).viewPrice());
            store.picCard(player, i);
            player.viewDeck();
            panel.update();
            panel_info.updateUI();
            panel_info.add(info.viewHp(player));
            panel_info.add(info.viewGold(player));
        }else{
            System.out.println("max card deck or gold, ouais ouais msg error pas le time");
        }
    }
    public void buyIA(){
        changeStore();
        if(player.viewGold()>=store.viewCard(1).viewPrice()){    
            player.removeGold(store.viewCard(1).viewPrice());
            player.addCardBoard(store.viewCard(1));
            
            
            if(player.viewDeckSize()<=1 && player.viewGold()>=store.viewCard(2).viewPrice()){
                player.removeGold(store.viewCard(2).viewPrice());
                store.picCard(player, 2);
            }
        }
    }
}
