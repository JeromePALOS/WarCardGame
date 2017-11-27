package UI;


import java.awt.*;
import javax.swing.*;


public class MainUI {
    public MainUI(){
        GameUI gameui = new GameUI();
        Frame frame = new Frame("War Card Game", 900, 600, gameui.gamePanel());

    }
    
    
    
}    
   /* 
    private JPanel gameUI;
    private JPanel menuUI = new JPanel(new BorderLayout());
    
    //create window
    public MainUI(){
        
        
        //window
        JFrame window = new JFrame("Card Game");
        window.setSize(900, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        GameUI game = new GameUI();
        this.gameUI = game.jpanel_GameUI();
        
        //add menu_panel
        window.setContentPane(affMenuUI());
        //window.setLayout(new FlowLayout());
        //window.add(menu.affMenuUI());

        window.setVisible(true);
    }
    
    public void changeJPanel(){
         GameUI game = new GameUI();
        window.setContentPane(game.jpanel_GameUI());
        this.revalidate();
    }
    
    
    
    
    
    
     
    public JPanel affMenuUI(){
        
        this.menuUI.add(title(), BorderLayout.NORTH);
        this.menuUI.add(button(), BorderLayout.SOUTH);
        
        
        return this.menuUI;
    }
    
    
    
    public JPanel button(){
        //menu_panel
        JPanel btn_panel = new JPanel(new BorderLayout());
        
        //Btn play
        JButton btn_play = new JButton("PLAY");
        btn_play.addActionListener(new GameUI());
        btn_panel.add(btn_play, BorderLayout.CENTER);
        
        //Btn quit
        JButton btn_quit = new JButton("Quit");
        btn_quit.addActionListener(new quit());
        btn_panel.add(btn_quit, BorderLayout.SOUTH);
        
        return btn_panel;
    } 
    
    public JPanel title(){
        //title
        JPanel title = new JPanel(new BorderLayout());
        
        Font font_size = new Font("Serif", Font.PLAIN, 36);
        JLabel text = new JLabel("Card Game - PALOS Jerome");
        text.setFont(font_size);
        title.add(text, BorderLayout.CENTER);
        return title;
    } 
    
    
    
    
}*/
