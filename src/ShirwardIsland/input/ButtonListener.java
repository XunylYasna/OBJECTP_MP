package ShirwardIsland.input;

import ShirwardIsland.Handler;
import ShirwardIsland.display.Display;
import ShirwardIsland.entities.player.Player;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {

    Player player;
    Display display;

    public ButtonListener(Player player, Display display) {
        this.player = player;
        this.display = display;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        int intventory = Integer.parseInt(e.getActionCommand()); // nc joke nc joookkkeeee

        if(intventory == 99){
            System.out.println("hi");
            display.setStatus();
        }

        else{
            player.setEquippeditem(intventory);
//            handler.getGame().getDisplay().log("You are equipped with " + player.getEquippeditem().getName());
        }

        player.dikoalambatnagbubug();
        display.getCanvas().requestFocus();

    }
}
