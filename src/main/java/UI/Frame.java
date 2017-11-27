
package UI;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.*;
        
public class Frame extends JFrame{
    
    public Frame (String title, int x, int y, JPanel ui){
        setTitle(title);
        setSize(x, y);
        setContentPane(ui);
//add(new JLabel(new ImageIcon("Ressources/map.jpg")));
//pack();

   
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);   
        
        
    }
    
}