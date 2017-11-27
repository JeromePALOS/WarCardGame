
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

class StoreUI{
    private JFrame store_frame = new JFrame();
    private JPanel parent;
    private Player player;
    
    public StoreUI(Player player, JPanel panel){
        this.player = player;
        this.parent = panel;
        
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
        Store store = new Store();
        store.changeStore();
        
        for(int i = 0; i<6; i++){
  
            panel_store.add(panelCard(store, i));


        }
        
        return panel_store;
    }
    public JPanel panelCard(Store store, int i){
        try {
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
               //private Player player;
                    public void actionPerformed(ActionEvent arg0){
                        
                    }        
                });
                panel_card_info.add(btn_buy, BorderLayout.SOUTH);
                
            //End card_info
            //img
            BufferedImage picture = ImageIO.read(new File("Ressources/faible.png"));
            JLabel pic = new JLabel(new ImageIcon(picture));
            panel_card.add(pic, BorderLayout.CENTER);
            panel_card.add(panel_card_info, BorderLayout.SOUTH); 
            return panel_card;
            
        } catch (IOException ex) {
            Logger.getLogger(GameUI.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        
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
}
