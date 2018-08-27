package ShirwardIsland.entities.statics;

import ShirwardIsland.Handler;
import ShirwardIsland.gfx.Assets;
import ShirwardIsland.tiles.Tile;

import java.awt.*;

public class Tree extends StaticEntity
{
    public Tree(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILEWIDTH*2, Tile.TILEHEIGHT*3);

        bounds.x = 10;
        bounds.y = (int) (height / 1.5f);
        bounds.width = width - 30;
        bounds.height = (int) (height - height / 1.5f);
        type = "tere";
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.tree, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
    }

}
