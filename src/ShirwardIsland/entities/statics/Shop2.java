package ShirwardIsland.entities.statics;

import ShirwardIsland.Handler;
import ShirwardIsland.gfx.Assets;
import ShirwardIsland.tiles.Tile;

import java.awt.*;

public class Shop2 extends StaticEntity
{
    public Shop2(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILEWIDTH*3, Tile.TILEHEIGHT*4);
        bounds.x = 0;
        bounds.y = (int) (height / 4f);
        bounds.width = width;
        bounds.height = (int)(height - height/4f);
        type = "shop2";
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.shop2, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
    }


    public Rectangle getClickBounds() {
        return new Rectangle((int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), width, height);
    }

}