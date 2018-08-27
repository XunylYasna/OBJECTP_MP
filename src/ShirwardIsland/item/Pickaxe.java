package ShirwardIsland.item;

import ShirwardIsland.Handler;
import ShirwardIsland.entities.Entity;
import ShirwardIsland.entities.player.Player;
import ShirwardIsland.entities.statics.Rock;
import ShirwardIsland.entities.statics.Tree;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Pickaxe extends Item {

    public Pickaxe(Handler handler) {
        super(handler, 1, 2, "PickAxe", "Eto ang aking PICKAXE pang warak ng bato at puno");
}


    @Override
    public void use(Player player) {
        Rectangle cb = player.getCollisionBounds(0,0); // Collision Bounds
        Rectangle ar = new Rectangle();
        int arSize = 20;
        ar.width = arSize;
        ar.height = arSize;

        if(player.getDir() == 0)
        {
            ar.x = cb.x + cb.width / 2 - arSize;
            ar.y = cb.y + cb.height;
        }

        else if(player.getDir() == 1)
        {
            ar.x = cb.x + cb.width;
            ar.y = cb.y + cb.height / 2 - arSize;
        }

        else if(player.getDir() == 2)
        {
            ar.x = cb.x + cb.width / 2 - arSize;
            ar.y = cb.y - arSize;
        }

        else if(player.getDir() == 3)
        {
            ar.x = cb.x - arSize;
            ar.y = cb.y + cb.height / 2 - arSize;
        }



        for(Entity e : handler.getWorld().getEntityManager().getEntities())
        {
            if(e.getCollisionBounds(0,0).intersects(ar))
            {
                if(e instanceof Rock || e instanceof Tree)
                    handler.getWorld().getEntityManager().removeEntity(e);
                handler.getGame().getDisplay().log("You used the Pickaxe tool.");
                return;
            }
        }

    }

    @Override
    protected boolean usable(Player player) {
        boolean usable = true;

        return usable;
    }

}
