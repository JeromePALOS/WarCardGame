package UI;

import Model.Card;
import Model.Player;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;





public class AttackUI {
    
    private Player player1;
    private Player player2;
    private Card card_attack;
    private JPanel panel_board_j1;
    private JPanel panel_board_j2;
    
    private JFrame frame = new JFrame();
    private JPanel panel_global = new JPanel(new BorderLayout());
    private JPanel panel_top = new JPanel(new BorderLayout());
    private JPanel panel_center = new JPanel();
    private JPanel panel_bottom = new JPanel(new GridLayout(1, 1));
    private JPanel panel_info;
    private InformationPlayerUI info;
    
    public AttackUI(Player player1, Player player2, Card card_attack, JPanel panel_board_j1, JPanel panel_board_j2, JPanel panel_info, InformationPlayerUI info){
       this.player1 = player1;
       this.player2 = player2;
       this.card_attack = card_attack;
       this.panel_board_j1 = panel_board_j1;
       this.panel_board_j2 = panel_board_j2;
       this.info = info;
       this.panel_info = panel_info;
    }
    public void viewFrame(){
        this.frame.setSize(900, 350);
        this.frame.setTitle("Attack");
        this.frame.setContentPane(panelGlobal());
        
        this.frame.setLocationRelativeTo(null);
        this.frame.setVisible(true);        
    }
    
    public JPanel panelGlobal(){
       // panel_global.add(panelTop(), BorderLayout.NORTH);
        panel_global.add(panelCenter(), BorderLayout.CENTER);
        panel_global.add(panelBottom(), BorderLayout.SOUTH);
        return panel_global;
    }
    public JPanel panelTop(){
        return panel_top;
    }
    public JPanel panelCenter(){
        
        for (int i = 0; i<player2.viewBoardSize(); i++){
            int j = i;
            JPanel panel_card_global = new JPanel(new BorderLayout());
            
            JLabel img = new JLabel(new ImageIcon( player2.viewCardBoard(i).viewImage()));
            panel_card_global.add(img, BorderLayout.CENTER);
            
            JPanel panel_card_info = new JPanel(new BorderLayout());
            JLabel name = new JLabel();
            name.setText("Name : " + player2.viewCardBoard(i).viewName());
            panel_card_info.add(name, BorderLayout.NORTH);   
            
            JLabel damage = new JLabel();
            damage.setText("Damage : " + String.valueOf(player2.viewCardBoard(i).viewDamage()));
            panel_card_info.add(damage, BorderLayout.CENTER);
            
            JButton btn_attack = new JButton("Attack");
            btn_attack.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent arg0){
                    frame.setVisible(false);
                    frame.dispose(); 
                    
                    if(card_attack.viewDamage()>= player2.viewCardBoard(j).viewDamage()){
                        player1.addGold(50);
                        panel_board_j2.removeAll();
                        player2.removeCardBoard(j);
                        for (int i = 0; i<player2.board.size(); i++){
                            PanelBoard panel_card = new PanelBoard();
                            panel_board_j2.add(panel_card.affCard(player1.board.get(i), player1, player2, panel_board_j1, panel_board_j2, panel_info, info));
                        }
                        panel_board_j2.updateUI();
                        panel_info.add(info.viewHp(player1));
                        panel_info.add(info.viewGold(player1));
                    }
                }        
            });
            panel_card_info.add(btn_attack, BorderLayout.SOUTH);
            panel_card_global.add(panel_card_info, BorderLayout.SOUTH);
            panel_center.add(panel_card_global);  

        }
        return panel_center;
    }
    
    public JPanel panelBottom(){
        JButton btn_back = new JButton(" <- BACK");
        btn_back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0){
                frame.setVisible(false);
                frame.dispose();   
            }        
        });
        panel_bottom.add(btn_back);
        return panel_bottom;
    }
    
}
