package ShirwardIsland;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame implements ActionListener{


    private Game game;

    private ImageIcon start = new ImageIcon(new ImageIcon("res/mainmenu/startn.png").getImage().getScaledInstance(150, 40, Image.SCALE_SMOOTH));
    private ImageIcon about = new ImageIcon(new ImageIcon("res/mainmenu/about.png").getImage().getScaledInstance(150, 40, Image.SCALE_SMOOTH));
    private ImageIcon exit = new ImageIcon(new ImageIcon("res/mainmenu/exit.png").getImage().getScaledInstance(150, 40, Image.SCALE_SMOOTH));


    private JButton startbtn = new JButton(start);
    private JButton aboutbtn = new JButton(about);
    private JButton exitbtn = new JButton(exit);

    private final ImageIcon backgroundgif = new ImageIcon("res/mainmenu/sizetest.gif");
    private final JLabel background = new JLabel(backgroundgif);


    public MainMenu(){

        super("Shirward Island Launcher");

        this.setContentPane(this.background);

        this.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.insets = new Insets(15,0,0,0);

        this.add(new JLabel(new ImageIcon("res/mainmenu/shirwardislandtext.png")),gbc);

        this.add(new JLabel(),gbc);

        startbtn.setPreferredSize(new Dimension(150,40));
        startbtn.setActionCommand("Start");
        startbtn.addActionListener(this);
        this.add(startbtn, gbc);

        aboutbtn.setPreferredSize(new Dimension(150,40));
        aboutbtn.setActionCommand("About");
        aboutbtn.addActionListener(this);
        this.add(aboutbtn, gbc);

        exitbtn.setPreferredSize(new Dimension(150,40));
        exitbtn.setActionCommand("Exit");
        exitbtn.addActionListener(this);
        this.add(exitbtn, gbc);

        this.setDefaultCloseOperation(3);
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
        setVisible(true);


    }



    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "Start" :
                System.out.println("Start");
                dispose();
                game = new Game("Shirward Island", 1000,800);
                game.start();
                break;
            case "About" :
                System.out.println("About");break;
            case"Exit":
                System.out.println("Exit");
                System.exit(0);
                break;
        }
    }

}




