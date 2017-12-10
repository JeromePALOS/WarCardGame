package Controller;

import Model.Player;
import UI.PanelBoard;
import UI.PanelCardUI;
import UI.StoreUI;
import javax.swing.JPanel;

public class IA {
    private Player player1;
    private Player player2;
    private StoreUI st2;
    private PanelCardUI panel_card2;
    private JPanel panel_board_player2;
    
    
    public IA(Player player1, Player player2, StoreUI st2, PanelCardUI panel_card2, JPanel panel_board_player2 ){
        this.player1 = player1;
        this.player2 = player2;
        this.st2 = st2;
        this.panel_card2 = panel_card2;
        this.panel_board_player2 = panel_board_player2;
        
        
    }
    
    public void turn(){
        st2.buyIA();
        
        panel_card2.viewButtonCardEnemy(player2);
        panel_board_player2.removeAll();
        for (int i = 0; i<player2.board.size(); i++){
            PanelBoard panel_card = new PanelBoard();
            panel_board_player2.add(panel_card.affCardEnemy(player2.viewCardBoard(i)));
        }
    }
}
