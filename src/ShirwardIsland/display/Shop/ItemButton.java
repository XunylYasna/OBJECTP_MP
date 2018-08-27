package ShirwardIsland.display.Shop;

import ShirwardIsland.input.ShopListener;
import ShirwardIsland.item.Item;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ItemButton extends JButton{
    public ItemButton(String name, ShopListener shopListener){ //Item item
        this.setIcon(new ImageIcon("res/DisplayUI/ButtonIcon/" + name + ".png"));
        this.setPreferredSize(new Dimension(242, 84));
        this.setMinimumSize(new Dimension(242, 84));
        this.setMaximumSize(new Dimension(242, 84));

        this.setActionCommand(name);
        this.addActionListener(shopListener);


        Border border = BorderFactory.createEtchedBorder(Color.decode("#C39753"), Color.black);
        this.setBorder(border);
    }
}
