
package UI;

import Model.Player;
import javax.swing.JLabel;

public class InformationPlayerUI {
    
    private JLabel hp = new JLabel();
    
    public JLabel viewHp(Player player){
        hp.setText("HP : " + String.valueOf(player.viewHp()));
        return hp;
    }
}
