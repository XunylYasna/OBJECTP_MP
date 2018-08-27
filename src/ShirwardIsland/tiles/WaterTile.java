package ShirwardIsland.tiles;

import ShirwardIsland.gfx.Assets;



public class WaterTile extends Tile
{
    public WaterTile(int id)
    {
        super(Assets.water, id);
    }

    public boolean isSolid(){
        return true;
    }

    public void animate(){
        this.texture = Assets.darkWater;
    }
}
