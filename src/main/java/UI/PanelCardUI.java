package UI;

import Model.Player;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelCardUI {
 
    private JPanel panel_card = new JPanel();
    private Player player;
    private Player player2;
    private JPanel panel_board_j2;
    private JPanel panel_board_j1;
    private JPanel panel_info;
    private InformationPlayerUI info;
    
    public PanelCardUI(Player player, Player player2, JPanel panel_board_j1, JPanel panel_board_j2, JPanel panel_info, InformationPlayerUI info){
        this.player = player;
        this.player2 = player2;
        this.panel_board_j1 = panel_board_j1;
        this.panel_board_j2 = panel_board_j2;
        this.panel_card.setLayout(new GridLayout(2, player.viewDeckSize()));
        this.panel_info = panel_info;
        this.info = info;
    }
    
    public JPanel viewButtonCardEnemy(Player player){
        for(int i=0; i<player.viewDeckSize(); i++){
            JButton btn_store = new JButton("Card n'"+ (i+1));
            panel_card.add(btn_store);
        }
        panel_card.updateUI();
        return panel_card;
    }
    
    public JPanel viewButtonCard(Player player){
        
        for(int i=0; i<player.viewDeckSize(); i++){
            int card_num = i;
            JButton btn = new JButton(player.deck.get(i).viewName()+ " (" + player.deck.get(i).viewDamage() + ")");
            btn.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent arg0){
                    PlayCardUI frame = new PlayCardUI(player, player2, player.deck.get(card_num), card_num, panel_card, panel_board_j1, panel_board_j2, panel_info, info);
                    frame.viewFrame();

                    
                    
                }        
            });
            panel_card.add(btn);
        }
        
        return panel_card;
    }
    public void update(){
        panel_card.removeAll();
        viewButtonCard(player);
        panel_card.updateUI();
    }
}
