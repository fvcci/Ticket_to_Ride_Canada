package Application;

import model.CardColour;
import view.PlayerPanel;

import javax.swing.*;
import java.awt.*;

public class Main {
    
    public static void main (String[] args) {
    
        // Testing
        JFrame frame = new JFrame();
        int width = 400, height = 800;
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        PlayerPanel playerPanel = new PlayerPanel(0, 0, width, height);
        frame.add(playerPanel);
        
        frame.setVisible(true);
    
    }
    
}
