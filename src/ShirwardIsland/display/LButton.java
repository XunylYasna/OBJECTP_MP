package ShirwardIsland.display;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LButton {

    JButton button;

    public LButton(String text){
        this.button = new JButton();
        this.button.setMinimumSize(new Dimension(64,64));
        this.button.setPreferredSize(new Dimension(64,64));
        this.button.setMaximumSize(new Dimension(64,64));
        //this.button.setIcon(new ImageIcon());
        this.button.setOpaque(false);
        this.button.setContentAreaFilled(false);
        this.button.setBorderPainted(false);
    }

    public void setActionCommand(String string){
        this.button.setActionCommand(string);
    }

    public void addActionListener(ActionListener actionListener){
        this.button.addActionListener(actionListener);
    }

    public JButton ret(){
        return button;
    }
}
