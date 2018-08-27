package ShirwardIsland.display.Shop;

import ShirwardIsland.entities.player.FarmerType;
import ShirwardIsland.input.ShopListener;
import ShirwardIsland.item.Item;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class StatusPane extends JPanel{

    JLabel name;
    JTextArea description;
    JButton buy;
    Item itemselected;

    public StatusPane(Item itemselected, ShopListener shopListener){

        this.setOpaque(false);
        this.setPreferredSize(new Dimension(400,400));
        this.setMaximumSize(new Dimension(400,400));
        this.setMinimumSize(new Dimension(400,400));
        this.itemselected = itemselected;
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        name = new JLabel(itemselected.getName());
        name.setFont(new Font("pix PixelFJVerdana12pt", Font.BOLD, 16));
        name.setAlignmentX(name.CENTER_ALIGNMENT);
        this.add(name);

        this.add(Box.createRigidArea(new Dimension(5,3)));

        description = new JTextArea(itemselected.getDescription());
        description.setPreferredSize(new Dimension(300,310));
        description.setMaximumSize(new Dimension(300,310));
        description.setMinimumSize(new Dimension(300,310));
        description.setLineWrap(true);
        description.setEditable(false);
        description.setFont(new Font("pix PixelFJVerdana12pt", Font.BOLD, 10));
        description.setBackground(Color.decode("#C39753"));
        Border des = BorderFactory.createEtchedBorder(Color.decode("#C15013"), Color.black);
        description.setBorder(des);

        this.add(description);

        this.add(Box.createRigidArea(new Dimension(5,3)));

        buy = new JButton();
        buy.setIcon(new ImageIcon("res/DisplayUI/buy.png"));
        buy.setPreferredSize(new Dimension(80,30));
        buy.setMaximumSize(new Dimension(80,30));
        buy.setMinimumSize(new Dimension(80,30));
        buy.setActionCommand("Buy");
        buy.addActionListener(shopListener);
        buy.setAlignmentX(name.CENTER_ALIGNMENT);

        this.add(buy);

    }

    public void update(Item itemselected, Boolean buyable){
        System.out.println("update item");
        System.out.println(itemselected.getName());
        name.setText(itemselected.getName());

        name.setAlignmentX(name.CENTER_ALIGNMENT);

        description.setText(itemselected.getDescription());


        buy.setAlignmentX(name.CENTER_ALIGNMENT);
        buy.setActionCommand("Buy");
        buy.setIcon(new ImageIcon("res/DisplayUI/buy.png"));
        buy.setEnabled(buyable);
    }

    public void updatef(FarmerType farmerType, Boolean buyable){

        if(farmerType != FarmerType.HONORABLE_FARMER){
            farmerType = farmerType.nextFarmerType(farmerType);
            name.setText(farmerType.getFarmertype());
            description.setText(farmerType.getDescription());

            buy.setActionCommand("Register");
            buy.setIcon(new ImageIcon("res/DisplayUI/register.png"));
            buy.setEnabled(buyable);
        }

        else{
            name.setText("Bossing na u");
            description.setText("Sobrang advance mo na \nmag isip tama na");
            buy.setIcon(new ImageIcon("res/DisplayUI/register2.png"));
            buy.setEnabled(false);
        }

    }
}
