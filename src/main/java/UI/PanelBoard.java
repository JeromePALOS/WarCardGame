package UI;

import Model.Card;
import Model.Player;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;


public class PanelBoard extends GameUI{
    
    private JPanel panel_card = new JPanel(new BorderLayout());
    private Player player1;
    private Player player2;
    private Card card;
    private JPanel panel_board_j1;
    private JPanel panel_board_j2;
    

    public JPanel affCard(Card card, Player player1, Player player2, JPanel panel_board_j1, JPanel panel_board_j2, JPanel panel_info,  InformationPlayerUI info){
        this.player1 = player1;
        this.player2 = player2;
        this.card = card;
        this.panel_board_j1 = panel_board_j1;
        this.panel_board_j2 = panel_board_j2;
        
  
            panel_card.setBackground(Color.LIGHT_GRAY);

            Border border = BorderFactory.createLineBorder(Color.BLACK);
            panel_card.setBorder(border);
            panel_card.setMaximumSize(new Dimension(90, 150));


            //Damage
            JLabel damage = new JLabel();
            damage.setText("DAMAGE : " + String.valueOf(card.viewDamage()));
            panel_card.add(damage, BorderLayout.SOUTH);

            //img
            JLabel pic = new JLabel(new ImageIcon(card.viewImage()));
            panel_card.add(pic, BorderLayout.CENTER);
            if(player1.viewName()=="player1"){
                panel_card.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        AttackUI attackui = new AttackUI(player1, player2, card, panel_board_j1, panel_board_j2, panel_info, info);
                        attackui.viewFrame();
                    }
                });       
            }
            return panel_card;
    }
    public JPanel affCardEnemy(Card card){
        JPanel panel_card = new JPanel(new BorderLayout());
        panel_card.setBackground(Color.LIGHT_GRAY);

        Border border = BorderFactory.createLineBorder(Color.BLACK);
        panel_card.setBorder(border);
        panel_card.setMaximumSize(new Dimension(90, 90));

        //Damage
        JLabel damage = new JLabel();
        damage.setText("DAMAGE : " + String.valueOf(card.viewDamage()));
        panel_card.add(damage, BorderLayout.SOUTH);

        //img
        JLabel pic = new JLabel(new ImageIcon(card.viewImage()));
        panel_card.add(pic, BorderLayout.CENTER);
        return panel_card;
    }
}
