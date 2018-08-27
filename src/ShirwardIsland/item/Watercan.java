package ShirwardIsland.item;

import ShirwardIsland.Handler;
import ShirwardIsland.entities.player.Player;
import ShirwardIsland.tiles.PlantedTile;
import ShirwardIsland.tiles.PlowedTile;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Watercan extends Item {


    public Watercan(Handler handler) {
        super(handler, 5, 1, "Water Can", "WATERCAN -- pang basa ng mga bagay bagay");
    }



    @Override
    public void use(Player player) {
        if(usable(player)){
            if(handler.getWorld().getTileMap(player.getXtile(),player.getYtile()) instanceof PlowedTile)
                ((PlowedTile) handler.getWorld().getTileMap(player.getXtile(),player.getYtile())).dilig();

            else
                ((PlantedTile) handler.getWorld().getTileMap(player.getXtile(),player.getYtile())).dilig();

            //handler.getWorld().getTileMap(player.getXtile(),player.getYtile()).status();

            handler.getGame().getDisplay().log("You used the Watercan tool.");
        }

        else
            handler.getWorld().setMessage("Ano dinidiligan mo tropa");

    }

    @Override
    protected boolean usable(Player player) {
        boolean usable = false;
        int ground = handler.getWorld().getTile(player.getXtile(),player.getYtile()).getId();
        if(ground == 20 ||ground == 30){ // plowed or planted lang pwede mo diligan men
            usable = true;
        }

        return usable;
    }

}
