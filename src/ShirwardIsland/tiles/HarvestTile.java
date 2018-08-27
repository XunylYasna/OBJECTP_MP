package ShirwardIsland.tiles;


import ShirwardIsland.item.seeds.Seed;

import java.util.concurrent.ThreadLocalRandom;


public class HarvestTile extends Tile {
    PlantedTile plantedTile;
    Seed seed;
    int fertilizer;
    int water;
    int cropproduced;

    public HarvestTile(PlantedTile plantedTile) {
        super(plantedTile.getFinalTubo(), 40);
        this.plantedTile = plantedTile;
        this.seed = plantedTile.getSeed();
        this.fertilizer = plantedTile.getCurrentfertilizer();
        this.water = plantedTile.getCurrentwater();
        this.cropproduced = ThreadLocalRandom.current().nextInt(seed.getProductproducedmin(), seed.getProductproducedmax()+1); // stak ober plow
        this.description = "Ang tanim mo dito ay " + seed.getName() + "\nAaron ikaw na mag lagay ng harvest cost pati crop produced";

    }

    public Seed getSeed() {
        return seed;
    }

    public int getFertilizer() {
        return fertilizer;
    }

    public int getWater() {
        return water;
    }

    public int getCropproduced() {
        return cropproduced;
    }
}
