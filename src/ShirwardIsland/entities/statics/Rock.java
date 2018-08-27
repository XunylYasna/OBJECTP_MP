package ShirwardIsland.entities.statics;

import ShirwardIsland.Handler;
import ShirwardIsland.gfx.Assets;
import ShirwardIsland.tiles.Tile;

import java.awt.*;

public class Rock extends StaticEntity
{
    public Rock(Handler handler, float x, float y) {
        super(handler, x + 10, y + 10, Tile.TILEWIDTH, Tile.TILEHEIGHT);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.rock, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
    }

}
