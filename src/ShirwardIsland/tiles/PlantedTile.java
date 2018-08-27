package ShirwardIsland.tiles;



import ShirwardIsland.item.seeds.Seed;

import java.awt.image.BufferedImage;

public class PlantedTile extends Tile{

    Seed seed;
    int waterneeded;
    int fertilizerneeded;
    int currentwater;
    int currentfertilizer;

    int tubostage = 0;

    public PlantedTile(PlowedTile plowedTile, Seed seed){
        super(seed.getPagtubo()[0], 30);
        this.seed = seed;

        currentwater = plowedTile.getWaterlevel();
        currentfertilizer = plowedTile.getFertilizerlevel();

        fertilizerneeded = seed.getFertilizern();
        waterneeded = seed.getWatern();

        this.description = "Ang tanim mo dito ay " + seed.getName() + "\nMeron kang " + currentwater +" na dilig at " + currentfertilizer + " na pataba";
    }

    public void status(){
        System.out.println("Seed planted: " + seed.getName());
        System.out.println("Current Time");
    }

    public void tubo(){
        this.tubostage++;
        this.texture = seed.getPagtubo()[tubostage];
    }

    public boolean tutubo(){
        boolean ttb = false;

        if(currentwater >= waterneeded && currentfertilizer >= fertilizerneeded){
            ttb = true;
        }

        return ttb;
    }

    public void dilig(){
        this.currentwater++;
        this.description = "Ang tanim mo dito ay " + seed.getName() + "\nMeron kang " + currentwater +" na dilig at " + currentfertilizer + " na pataba";
    }

    public void fertilize(){
        this.currentfertilizer++;
        this.description = "Ang tanim mo dito ay " + seed.getName() + "\nMeron kang " + currentwater +" na dilig at " + currentfertilizer + " na pataba";
    }


    public BufferedImage getFinalTubo(){
        tubo();
        return this.texture;
    }

    public Seed getSeed() {
        return seed;
    }

    public int getCurrentfertilizer() {
        return currentfertilizer;
    }

    public int getCurrentwater() {
        return currentwater;
    }
}
