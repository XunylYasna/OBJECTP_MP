package ShirwardIsland.tiles;

import ShirwardIsland.gfx.Assets;


public class PlowedTile extends Tile{

    int waterlevel;
    int fertilizerlevel;

    public PlowedTile()
    {
        super(Assets.plowedland, 20);
        waterlevel = 0;
        fertilizerlevel = 0;
        this.description = "Taniman mo ako senpai";
    }

    public void dilig(){
        waterlevel++;
    }

    public void fertilize(){
        fertilizerlevel++;
    }

    public int getWaterlevel() {
        return waterlevel;
    }

    public int getFertilizerlevel() {
        return fertilizerlevel;
    }

}

