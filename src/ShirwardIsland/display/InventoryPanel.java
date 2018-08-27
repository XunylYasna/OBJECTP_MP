package ShirwardIsland.display;

import ShirwardIsland.input.ButtonListener;

import javax.swing.*;
import java.awt.*;

public class InventoryPanel extends JPanel {
    JPanel itemcontainer;

    public InventoryPanel(ButtonListener buttonListener, int height) {
        this.setOpaque(true);
        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(250, height - 150));

        this.setLayout(new GridBagLayout());
//		gbci.gridwidth = GridBagConstraints.REMAINDER;
//		gbci.anchor = GridBagConstraints.PAGE_START;
//		gbci.insets = new Insets(15,0,0,0);

        JLabel inventorybg = new JLabel(new ImageIcon("res/DisplayUI/inventorybbar.png"));
        inventorybg.setLayout(new GridBagLayout());
        GridBagConstraints gcbi = new GridBagConstraints();


        LButton plow = new LButton("Plow");
        plow.setActionCommand("0");
        plow.addActionListener(buttonListener);

        LButton waterc = new LButton("WaterCan");
        waterc.setActionCommand("1");
        waterc.addActionListener(buttonListener);

        LButton pickaxe = new LButton("PickAxe");
        pickaxe.setActionCommand("2");
        pickaxe.addActionListener(buttonListener);

        LButton fertilizer = new LButton("Fertilizer");
        fertilizer.setActionCommand("3");
        fertilizer.addActionListener(buttonListener);

        LButton turnip = new LButton("Turnip");
        turnip.setActionCommand("4");
        turnip.addActionListener(buttonListener);

        LButton carrot = new LButton("Carrot");
        carrot.setActionCommand("5");
        carrot.addActionListener(buttonListener);

        LButton tomato = new LButton("Tomato");
        tomato.setActionCommand("6");
        tomato.addActionListener(buttonListener);

        LButton potato = new LButton("Potato");
        potato.setActionCommand("7");
        potato.addActionListener(buttonListener);

        LButton rose = new LButton("Rose");
        rose.setActionCommand("8");
        rose.addActionListener(buttonListener);

        LButton tulip = new LButton("Tulip");
        tulip.setActionCommand("9");
        tulip.addActionListener(buttonListener);

        LButton stargazer = new LButton("Stargazer");
        stargazer.setActionCommand("10");
        stargazer.addActionListener(buttonListener);

        LButton sunflower = new LButton("Sunflower");
        sunflower.setActionCommand("11");
        sunflower.addActionListener(buttonListener);

        LButton mango = new LButton("Mango");
        mango.setActionCommand("12");
        mango.addActionListener(buttonListener);

        LButton apple = new LButton("Apple");
        apple.setActionCommand("13");
        apple.addActionListener(buttonListener);

        LButton banana = new LButton("Banana");
        banana.setActionCommand("14");
        banana.addActionListener(buttonListener);

        LButton orange = new LButton("Orange");
        orange.setActionCommand("15");
        orange.addActionListener(buttonListener);

        itemcontainer = new JPanel(new GridLayout(8, 2, 0, 0));
        itemcontainer.setSize((new Dimension(32 * 2 + 10, (32 + 10) * 8)));
        itemcontainer.setMaximumSize((new Dimension(32 * 2 + 10, (32 + 10) * 8)));


        itemcontainer.add(plow.ret());
        itemcontainer.add(waterc.ret());
        itemcontainer.add(pickaxe.ret());
        itemcontainer.add(fertilizer.ret());

        itemcontainer.add(turnip.ret());
        itemcontainer.add(carrot.ret());
        itemcontainer.add(tomato.ret());
        itemcontainer.add(potato.ret());

        itemcontainer.add(rose.ret());
        itemcontainer.add(tulip.ret());
        itemcontainer.add(stargazer.ret());
        itemcontainer.add(sunflower.ret());

        itemcontainer.add(mango.ret());
        itemcontainer.add(apple.ret());
        itemcontainer.add(banana.ret());
        itemcontainer.add(orange.ret());

        //itemcontainer.setBackground(Color.decode("#6D5023"));
        itemcontainer.setOpaque(false);
        inventorybg.add(new JLabel("Inventory"), gcbi);
        gcbi.gridy = 1;
        inventorybg.add(itemcontainer, gcbi);
        this.add(inventorybg);
    }


}
