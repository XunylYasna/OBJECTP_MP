package ShirwardIsland.entities.statics;

import ShirwardIsland.Handler;
import ShirwardIsland.gfx.Assets;
import ShirwardIsland.tiles.Tile;

import java.awt.*;

public class Shop extends StaticEntity
{
    public Shop(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILEWIDTH*4, Tile.TILEHEIGHT*6);

        bounds.x = 35;
        bounds.y = (int) (height / 3f);
        bounds.width = width - 35;
        bounds.height = (int) (height - height / 3f);
        type = "shop";
        //bounds = new Rectangle(0, 0, width, height);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

        g.drawImage(Assets.shop1, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
    }

    public Rectangle getClickBounds() {
        return new Rectangle((int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), width, height);
    }
}