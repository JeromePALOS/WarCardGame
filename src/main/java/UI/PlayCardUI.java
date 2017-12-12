
package UI;

import Model.Card;
import Model.Player;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class PlayCardUI{
    private JFrame frame = new JFrame();
    private JPanel panel_global = new JPanel(new BorderLayout());
    private JPanel panel_top = new JPanel(new BorderLayout());
    private JPanel panel_center = new JPanel(new BorderLayout());
    private JPanel panel_bottom = new JPanel(new GridLayout(2, 1));
    
    private Player player;
    private Player player2;
    private Card card;
    private int card_num;
    private JPanel panel;
    private JPanel panel_board_j1;
    private JPanel panel_board_j2;
    private JPanel panel_info;
    private InformationPlayerUI info;
    
    public PlayCardUI (Player player, Player player2, Card card, int card_num, JPanel panel, JPanel panel_board_j1, JPanel panel_board_j2, JPanel panel_info, InformationPlayerUI info){
        
        this.player = player;
        this.card = card;
        this.card_num = card_num;
        this.panel = panel;
        this.player2 = player2;
        this.panel_board_j1= panel_board_j1;
        this.panel_board_j2 = panel_board_j2;
        this.panel_info = panel_info;
        this.panel = panel;

    }
    public void viewFrame(){
        this.frame.setSize(150, 300);
        this.frame.setTitle("Play Card");
        this.frame.setContentPane(panelGlobal());
        
        this.frame.setLocationRelativeTo(null);
        this.frame.setVisible(true); 
    }
    public JPanel panelGlobal(){
        panel_global.add(panelTop(), BorderLayout.NORTH);
        panel_global.add(panelCenter(), BorderLayout.CENTER);
        panel_global.add(panelBottom(), BorderLayout.SOUTH);
        return panel_global;
    }
    public JPanel panelTop(){
        JLabel name = new JLabel(this.card.viewName());
        panel_top.add(name);
        return this.panel_top;
    }
    public JPanel panelCenter(){
        JPanel info = new JPanel();
        JLabel damage = new JLabel();
        damage.setText("Damage : " + String.valueOf(this.card.viewDamage()));
        JLabel or = new JLabel();
        or.setText("Price : " + String.valueOf(this.card.viewPrice()));
        JLabel pic = new JLabel(new ImageIcon(this.card.viewImage()));
        panel_center.add(pic, BorderLayout.CENTER);
        info.add(damage);
        info.add(or);
        panel_center.add(info, BorderLayout.SOUTH);
        return panel_center;
    }
    public JPanel panelBottom(){
        JButton btn_play = new JButton("Play this card");
        btn_play.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(player.viewBoardSize()<9){
                    player.addCardBoard(card);
                    player.removeCardDeck(card_num);

                    frame.setVisible(false);
                    frame.dispose();
                    panel.removeAll();
                    for(int i=0; i<player.viewDeckSize(); i++){
                        int card_num = i;
                        JButton btn = new JButton(player.deck.get(i).viewName()+ " (" + player.deck.get(i).viewDamage() + ")");
                        btn.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent arg0){
                                PlayCardUI frame = new PlayCardUI(player, player2, player.deck.get(card_num), card_num, panel, panel_board_j1, panel_board_j2, panel_info, info);
                                frame.viewFrame();
                            }        
                        });
                        panel.add(btn);
                    }
                    panel.updateUI();

                    panel_board_j1.removeAll();
                    for (int i = 0; i<player.board.size(); i++){
                        PanelBoard panel_card = new PanelBoard();
                        panel_board_j1.add(panel_card.affCard(player.viewCardBoard(i), player, player2, panel_board_j1, panel_board_j2, panel_info, info));
                    }
                    panel_board_j1.updateUI();
                }else{
                    System.out.println("max card");
                }
            }
        });
        //Back
        JButton btn_back = new JButton(" <- BACK");
        btn_back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0){
                frame.setVisible(false);
                frame.dispose();   
           
            }        
        });
        panel_bottom.add(btn_play);
        panel_bottom.add(btn_back);
        return panel_bottom;
    }

}
