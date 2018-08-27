package ShirwardIsland.display.Shop;

import ShirwardIsland.entities.player.Player;
import ShirwardIsland.input.ShopListener;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ShopFrame extends JFrame {

    int itemselected = 5;
    ShopListener shopListener;
    JScrollPane istest;
    StatusPane sptest;
    ItemPanel iptest;

    public ShopFrame(Player player){

        this.setTitle("SM Island");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        this.setSize(new Dimension(750,500));
        //this.pack();
        this.setResizable(false);

        shopListener = new ShopListener(player,this);

        JLabel shopl = new JLabel(new ImageIcon("res/DisplayUI/shopbar.png"));
        shopl.setSize(new Dimension(750,500));
        shopl.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0,0,0,15);

        iptest = new ItemPanel(player,shopListener);

        istest = new JScrollPane(iptest);
        istest.setBackground(Color.BLACK);
        istest.setPreferredSize(new Dimension(260,380));
        istest.setMaximumSize(new Dimension(260,380));
        istest.setMinimumSize(new Dimension(260,380));
        istest.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        istest.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        Border border = BorderFactory.createCompoundBorder();
        istest.setBorder(border);

        gbc.gridx = 0;
        shopl.add(istest,gbc);

        sptest = new StatusPane(player.getInventory().get(3), shopListener);


        gbc.gridx = 1;
        shopl.add(sptest, gbc);

//        ScrollPane sp = new ScrollPane();
//        sp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        sp.setSize(1024,300);
//        sp.setVisible(true);


        this.add(shopl);
        this.setLocationRelativeTo(null);
        this.setFocusable(true);
        this.setVisible(true);

    }

    public StatusPane getSptest() {
        return sptest;
    }
}
