package ShirwardIsland.item;
import ShirwardIsland.Handler;
import ShirwardIsland.entities.Entity;
import ShirwardIsland.entities.player.Player;
import ShirwardIsland.entities.statics.Rock;
import ShirwardIsland.entities.statics.Tree;
import ShirwardIsland.tiles.PlowedTile;
import ShirwardIsland.tiles.Tile;


import java.awt.*;
import java.awt.image.BufferedImage;

public class Plow extends Item {


    public Plow(Handler handler) {
        super(handler, 5, 0, "Plow", "dahil sa MP na to baka bumagsak kami sa mga PLOW ting \nsubjects -- RIP ENGLECOM paper");
    }


    @Override
    public void use(Player player) {
        if(usable(player)) {
            if(handler.getWorld().getTile(player.getXtile(), player.getYtile()).getId() == 0)
                handler.getWorld().modifyTile(new PlowedTile(), player.getXtile(), player.getYtile());

            if(handler.getWorld().getTile(player.getXtile(), player.getYtile()).getId() == 50)
            {
                handler.getWorld().modifyTile(Tile.grassTile, player.getXtile(), player.getYtile());
                System.out.print("Pulubi ka na. Pera mo: " + player.getObjectcoins());
            }
            handler.getGame().getDisplay().log("You used the Plow tool.");
        }

        else
            handler.getWorld().setMessage("Bawal ka magplow dito gago");

    }

    @Override
    protected boolean usable(Player player) {
        boolean usable = false;

        if(handler.getWorld().getTile(player.getXtile(),player.getYtile()).getId() == 0 ||
                handler.getWorld().getTile(player.getXtile(),player.getYtile()).getId() == 50){ //grass or withered lang pwede mo i plow men
            usable = true;
        }

        //Since entity yung rocks what this does is create a collision bound na kung may enity ka na katabi (except player)

        Rectangle ar = player.getCollisionBounds(-20,-20);
        int arSize = 40;
        ar.width = arSize;
        ar.height = arSize;

        for(Entity e : handler.getWorld().getEntityManager().getEntities())
        {
            if(e.getCollisionBounds(0,0).intersects(ar))
            {
                if(!(e instanceof Player))
                    usable = false;
            }
        }

        return usable;
    }

}
