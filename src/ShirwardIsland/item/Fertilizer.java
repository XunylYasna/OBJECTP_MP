package ShirwardIsland.item;

import ShirwardIsland.Handler;
import ShirwardIsland.entities.player.Player;
import ShirwardIsland.tiles.PlantedTile;
import ShirwardIsland.tiles.PlowedTile;
import ShirwardIsland.tiles.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Fertilizer extends Item {
    public Fertilizer(Handler handler) {
        super(handler, 5, 3, "Fertilizer", "Fertilizer ni Miggi");
        this.price = 10;
    }


    @Override
    public String getDescription() {
        return description + "\nQuantity: " + qty;
    }

    @Override
    public void use(Player player) {
        if(usable(player)){
            if(handler.getWorld().getTileMap(player.getXtile(),player.getYtile()) instanceof PlowedTile)
                ((PlowedTile) handler.getWorld().getTileMap(player.getXtile(),player.getYtile())).fertilize();

            else
                ((PlantedTile) handler.getWorld().getTileMap(player.getXtile(),player.getYtile())).fertilize();

            handler.getGame().getDisplay().log("You used a Fertilizer.");
            qty--;
        }

        else
            handler.getWorld().setMessage("Nani to fertilize");

    }

    @Override
    protected boolean usable(Player player) {
        boolean usable = false;
        int ground = handler.getWorld().getTile(player.getXtile(),player.getYtile()).getId();
        if(ground == 20 /*||ground == 30*/ && qty > 0){ //plowed tile lang pwede
            usable = true;
        }

        return usable;
    }


}
