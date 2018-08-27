package ShirwardIsland.input;

import ShirwardIsland.display.Shop.ShopFrame;
import ShirwardIsland.display.Shop.StatusPane;
import ShirwardIsland.entities.player.FarmerType;
import ShirwardIsland.entities.player.Player;
import ShirwardIsland.item.Item;
import ShirwardIsland.item.seeds.Seed;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShopListener implements ActionListener {

    Player player;
    ShopFrame shopFrame;
    Item itemtodisplay;
    Boolean buyable;

    public ShopListener(Player player, ShopFrame shopFrame) {
        this.player = player;
        this.shopFrame = shopFrame;
        itemtodisplay = player.getInventory().get(3);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand().equals("RegisterFarmer")){
            //System.out.println("Register");
            buyable = registerable(player);
            shopFrame.getSptest().updatef(player.getFarmerType(),buyable);
            System.out.println(buyable);
        }

        else if(e.getActionCommand().equals("Register")){
            player.register();
            buyable = registerable(player);
            shopFrame.getSptest().updatef(player.getFarmerType(),buyable);
        }

        else if(e.getActionCommand().equals("Buy")){
            player.buy(itemtodisplay);
            System.out.println(itemtodisplay.getName());
            buyable = boyable(itemtodisplay,player);
            shopFrame.getSptest().update(itemtodisplay,buyable);
        }

        else{
            itemtodisplay = itemfinder(e.getActionCommand());
            buyable = boyable(itemtodisplay,player);
            shopFrame.getSptest().update(itemtodisplay,true);
//            System.out.println("else");
        }

    }


    private Item itemfinder(String name){
        for(int i = 0; i < player.getInventory().size(); i++){
            if(player.getInventory().get(i).getName().contains(name))
                return player.getInventory().get(i);
        }

        return null;
    }

    private boolean boyable(Item item, Player player){

        if(item.getPrice() <= player.getObjectcoins() + player.getFarmerType().getEarningbuying())
            return true;

        else
            return false;
    }

    private boolean registerable(Player player){

        if(player.getFarmerType() == FarmerType.HONORABLE_FARMER)
            return false;

        FarmerType next = player.getFarmerType().nextFarmerType(player.getFarmerType());

        if(player.getLevel() >= next.getLevelreq() && player.getObjectcoins() >= next.getRegistrationfee())
            return true;

        else
            return false;
    }
}
