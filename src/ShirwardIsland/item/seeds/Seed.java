package ShirwardIsland.item.seeds;

import ShirwardIsland.Handler;
import ShirwardIsland.entities.player.Player;
import ShirwardIsland.item.Item;
import ShirwardIsland.tiles.HarvestTile;
import ShirwardIsland.tiles.PlantedTile;
import ShirwardIsland.tiles.PlowedTile;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Seed extends Item {

    // private String seedname; yung item kasi may name na eh so bale yun na gagamitin
    private CropType cropType;
    private double harvesTime;
    private int watern; //waterneeded
    private int waterbl; //waterbonuslimit
    private int fertilizern;
    private int fertilizerbl;
    private int harvestcost;
    private int productproducedmin; // min
    private int productproducedmax;//max
    private int seedcost;
    private double baseprice;
    private BufferedImage[] pagtubo = new BufferedImage[5];

    public Seed(Handler handler, int id, String seedname, CropType cropType, float harvesTime, int watern, int waterbl, int fertilizern, int fertilizerbl, int productproducedmin, int productproducedmax, int seedcost, double baseprice) {
        super(handler, 5, id, seedname, null);
        this.name = seedname;
        this.cropType = cropType;
        this.harvesTime = harvesTime;
        this.watern = watern;
        this.waterbl = waterbl;
        this.fertilizern = fertilizern;
        this.fertilizerbl = fertilizerbl;
        this.productproducedmin = productproducedmin;
        this.productproducedmax = productproducedmax;
        this.seedcost = seedcost;
        this.baseprice = baseprice;

        this.harvestcost = this.cropType.getHarvestcost();
        this.pagtubo = this.cropType.getPagtubo();

        this.description = seedname;

        this.price = seedcost;
    }


    @Override
    protected boolean usable(Player player) {
        boolean usable = false;

        if (handler.getWorld().getTile(player.getXtile(), player.getYtile()).getId() == 20 && qty > 0) {
            usable = true;
        }

        int x = player.getXtile() - 1;
        int y = player.getYtile() - 1;

        for(int xx = x; xx < x + 3; xx++){
            for(int yy = y; yy < y + 3; yy++){
                if(handler.getWorld().getTileMap(xx,yy) instanceof PlantedTile){
                    if(this.getCropType() == CropType.TREE)
                        usable = false;

                    if(((PlantedTile) handler.getWorld().getTileMap(xx,yy)).getSeed().getCropType() == CropType.TREE) // pag may tree sa paligid its a big no no
                        usable = false;
                }

                if(handler.getWorld().getTileMap(xx,yy) instanceof HarvestTile){
                    if(this.getCropType() == CropType.TREE)
                        usable = false;

                    if(((HarvestTile) handler.getWorld().getTileMap(xx,yy)).getSeed().getCropType() == CropType.TREE) // goes the same if ready to harvest na yung ibang plants
                        usable = false;
                }
            }
        }

        return usable;
    }

    @Override
    public void use(Player player) {
        if (usable(player)) {
            qty--;
            handler.getWorld().modifyTile(new PlantedTile((PlowedTile) handler.getWorld().getTileMap(player.getXtile(),player.getYtile()),this), player.getXtile(), player.getYtile());
            handler.getWorld().papatubuin(player.getXtile(), player.getYtile(), this.harvesTime);
            handler.getGame().getDisplay().log("You planted " + name);
        } else
            handler.getWorld().setMessage("Ang magtanim dito ay ipinagbabawwal");
    }

    public String getName() {
        return name;
    }

    public BufferedImage[] getPagtubo() {
        return pagtubo;
    }

    public int getFertilizern() {
        return fertilizern;
    }

    public int getWatern() {
        return watern;
    }

    public double getHarvesTime() {
        return harvesTime;
    }

    public int getWaterbl() {
        return waterbl;
    }

    public int getFertilizerbl() {
        return fertilizerbl;
    }

    public int getHarvestcost() {
        return harvestcost;
    }

    public int getProductproducedmin() {
        return productproducedmin;
    }

    public int getProductproducedmax() {
        return productproducedmax;
    }

    public int getSeedcost() {
        return seedcost;
    }

    public double getBaseprice() {
        return baseprice;
    }

    public CropType getCropType() {
        return cropType;
    }

    @Override
    public String getDescription() {
        return description + "\nQuantity: " + qty;
    }
}
