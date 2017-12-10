
package UI;

import Model.Player;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class InformationPlayerUI {
    
    private JLabel hp = new JLabel("hp", SwingConstants.CENTER);
    private JLabel gold = new JLabel("gold", SwingConstants.CENTER);
    
    public JLabel viewHp(Player player){
        hp.setText("HP : " + String.valueOf(player.viewHp()));
        return hp;
    }
    
    public JLabel viewGold(Player player){
        gold.setText("GOLD : " + String.valueOf(player.viewGold()));
        return gold;
    }
}
