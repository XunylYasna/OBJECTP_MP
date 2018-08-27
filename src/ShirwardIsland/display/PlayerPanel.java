package ShirwardIsland.display;

import ShirwardIsland.entities.player.Player;
import ShirwardIsland.input.ButtonListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.DefaultCaret;
import java.awt.*;

public class PlayerPanel extends JPanel {

    private Player player;
    private JButton switchstatus;
    private JProgressBar exp;
    private JLabel player_name;
    private JLabel manny;
    private JLabel level;
    private JLabel ftype;
    private JTextArea log;
    private JScrollPane logscroll;
    private JTextArea description;
    JLabel itemdes;

    public PlayerPanel(Player player, int width, ButtonListener buttonListener){
        this.player = player;
        this.setMinimumSize(new Dimension(width, 150));
        this.setMaximumSize(new Dimension(width, 150));
        this.setLayout(new GridBagLayout());

        JLabel playerbg = new JLabel(new ImageIcon("res/DisplayUI/playerbar.png"));

        playerbg.setLayout(new GridBagLayout());
        GridBagConstraints gbcp = new GridBagConstraints();

        switchstatus = new JButton(new ImageIcon("res/DisplayUI/Untitled.png"));
        switchstatus.setPreferredSize(new Dimension(32,32));
        switchstatus.setMinimumSize(new Dimension(32,32));
        switchstatus.setMaximumSize(new Dimension(32,32));
        switchstatus.setActionCommand("99");
        switchstatus.addActionListener(buttonListener);


        gbcp.insets = new Insets(5,0,0,5);
        gbcp.gridx = 0;
        gbcp.gridy = 0;
        playerbg.add(switchstatus,gbcp);

        JLabel avatar = new JLabel(new ImageIcon("res/DisplayUI/avatar.png"));
        avatar.setPreferredSize(new Dimension(96,96));
        gbcp.gridx = 1;
        gbcp.gridy = 0;
        gbcp.gridheight = 4;
        playerbg.add(avatar,gbcp);


        exp = new JProgressBar(0,100);
        exp.setPreferredSize(new Dimension(96,15));
        exp.setMinimumSize(new Dimension(96,15));
        exp.setMaximumSize(new Dimension(96,15));


        gbcp.gridheight = 1;
        gbcp.gridx = 1;
        gbcp.gridy = GridBagConstraints.RELATIVE;
        playerbg.add(exp, gbcp);

        player_name = new JLabel("Player Name");
        manny = new JLabel("Coins bitch");
        level = new JLabel("Level");
        ftype = new JLabel("Farmertype");
        //JLabel exp = new JLabel("Experience");


        gbcp.insets = new Insets(0,5,0,5);
        gbcp.anchor = GridBagConstraints.FIRST_LINE_START;
        gbcp.gridx = 2;
        gbcp.gridy = 0;
        playerbg.add(player_name, gbcp);
        gbcp.gridy = 1;
        playerbg.add(manny,gbcp);
        gbcp.gridy = 2;
        playerbg.add(level,gbcp);
        gbcp.gridy = 3;
        playerbg.add(ftype,gbcp);


        itemdes = new JLabel();
        gbcp.gridx = 3;
        gbcp.gridy = 0;
        gbcp.insets = new Insets(0,30,0,10);
        playerbg.add(itemdes,gbcp);

        description = new JTextArea(); // for items
        description.setPreferredSize(new Dimension(350,35));
        description.setMaximumSize(new Dimension(350,35));
        description.setMinimumSize(new Dimension(350,35));
        description.setEditable(false);
        description.setOpaque(false);

        gbcp.gridx = 3;
        gbcp.gridy = 1;
        gbcp.gridheight = 0;
        playerbg.add(description,gbcp);


        log = new JTextArea();
        log.setEditable(false);
        log.getCaret().deinstall(log);
        log.setLineWrap(true);

        log.setBackground(Color.decode("#C39753"));
        gbcp.gridx = 4;
        gbcp.gridy = 0;
        gbcp.insets = new Insets(10,30,0,10);

        logscroll = new JScrollPane(log);
        logscroll.setPreferredSize(new Dimension(400, 101));
        logscroll.setMaximumSize(new Dimension(400, 101));
        logscroll.setMinimumSize(new Dimension(400, 101));
        logscroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        Border border = BorderFactory.createLoweredSoftBevelBorder();
        logscroll.setBackground(Color.decode("#C39753"));
        logscroll.setBorder(border);
        playerbg.add(logscroll, gbcp);


        this.add(playerbg);

    }



    public void tick(boolean status){

        player_name.setText(player.getName());
        manny.setText("Object Coins: " + player.getObjectcoins());
        level.setText("Level: " + player.getLevel());
        ftype.setText(player.getFarmerType().getFarmertype());
        exp.setString("Experience");
        exp.setValue(player.getCexp());

        if(status){
            itemdes.setText("Item Description");
            description.setText(player.getEquippeditem().getDescription());
        }

        else{
            itemdes.setText("Tile Status");
            description.setText(player.getDescriptionnginaapakan());
        }

    }

    public void log(String message){
        log.append(message + "\n");
        JScrollBar scroll = logscroll.getVerticalScrollBar();
        scroll.setValue(scroll.getMaximum());

    }



}
