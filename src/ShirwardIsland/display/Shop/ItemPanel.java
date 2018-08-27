package ShirwardIsland.display.Shop;

import ShirwardIsland.entities.player.Player;
import ShirwardIsland.input.ShopListener;

import javax.swing.*;
import java.awt.*;

public class ItemPanel extends JPanel{

    public ItemPanel(Player player, ShopListener shopListener){

        this.setLayout(new BoxLayout(this,1));
//        this.setPreferredSize(new Dimension(900,900));
//        this.setMinimumSize(new Dimension(900,900));
//        this.setMaximumSize(new Dimension(900,900));
        //System.out.println(player.getInventory().size());

        this.add(new ItemButton("Fertilizer",shopListener));

        this.add(new ItemButton("Turnip",shopListener));
        this.add(new ItemButton("Carrot",shopListener));
        this.add(new ItemButton("Tomato",shopListener));
        this.add(new ItemButton("Potato",shopListener));

        this.add(new ItemButton("Rose",shopListener));
        this.add(new ItemButton("Tulip",shopListener));
        this.add(new ItemButton("Stargazer",shopListener));
        this.add(new ItemButton("Sunflower",shopListener));

        this.add(new ItemButton("Mango",shopListener));
        this.add(new ItemButton("Apple",shopListener));
        this.add(new ItemButton("Banana",shopListener));
        this.add(new ItemButton("Orange",shopListener));

        this.add(new ItemButton("RegisterFarmer",shopListener));

    }
}
