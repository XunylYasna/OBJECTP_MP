package ShirwardIsland.display;

import ShirwardIsland.Game;
import ShirwardIsland.entities.player.Player;
import ShirwardIsland.input.ButtonListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Display{

	private JFrame frame;
	private Canvas canvas;
	private JPanel framepanel;
	private JPanel gamepanel;
	private PlayerPanel playerpanel;

	private String title;
	private int width, height;
	private ButtonListener buttonListener;
	private Player player;

	private Boolean status = true;


	public Display(String title, int width, int height, Player player) {
		this.title = title;
		this.width = width;
		this.height = height;
		this.player = player;

		buttonListener = new ButtonListener(player, this);
		createDisplay();


	}

	private void createDisplay() {

		framepanel = new JPanel();
		framepanel.setSize(width, height);

		frame = new JFrame(title);
		frame.setContentPane(framepanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width - 150, height - 150));
		canvas.setMaximumSize(new Dimension(width - 150, height - 150));
		canvas.setMinimumSize(new Dimension(width - 150, height - 150));
		canvas.setFocusable(true);

		framepanel.setLayout(new GridBagLayout());
		framepanel.setBackground(Color.decode("#6D5023"));
		GridBagConstraints gbc = new GridBagConstraints();

//		framepanel = new JPanel(new GridBagLayout());
//		framepanel.setSize(new Dimension(width + 100, height + 100));




		// Inventory Panel

//		JLabel inventorylbl = new JLabel("Inventory", JLabel.CENTER);
//		inventorylbl.setFont(new CFont("Courier", CFont.BOLD, 36));
//
//		inventorypanel.add(inventorylbl,gbci);
//		inventorypanel.add(itemcontainer,gbci);

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.ipadx = 0;
		//gbc.fill = GridBagConstraints.VERTICAL;
		framepanel.add(new InventoryPanel(buttonListener,height), gbc);


		// Game Panel

		gamepanel = new JPanel();
		gamepanel.setSize(new Dimension(width, height));
		gamepanel.add(canvas);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.ipadx = 0;
		framepanel.add(gamepanel, gbc);


		//Player Panel

		//gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = 2;
		gbc.gridx = 0;
		gbc.gridy = 1;
		//gbc.ipady = 150;
		playerpanel = new PlayerPanel(player,width, buttonListener);
		framepanel.add(playerpanel, gbc);

		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setFocusable(true);
//		frame.add(inventorypanel);
//		frame.add(playerpanel);
//		frame.add(gamepanel);
	}

	public Canvas getCanvas() {
		return canvas;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setStatus() {
		this.status = !status;
		System.out.println(status);
	}

	public void tick(){
		playerpanel.tick(status);
	}

	public void log(String log){
		playerpanel.log(log);
	}


}
