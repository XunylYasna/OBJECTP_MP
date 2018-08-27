package ShirwardIsland.item.seeds;

import ShirwardIsland.gfx.Assets;

import java.awt.image.BufferedImage;

public enum CropType {

    VEGETABLE(1, Assets.vegetable0, Assets.vegetable1, Assets.vegetable2, Assets.vegetable3),
    FLOWER(2, Assets.flower0, Assets.flower1, Assets.flower2, Assets.flower3),
    TREE(3, Assets.tree0, Assets.tree1, Assets.tree2, Assets.tree3);

    private int harvestcost;
    private BufferedImage[] pagtubo = new BufferedImage[5];

    CropType(int harvestcost, BufferedImage g0, BufferedImage g1, BufferedImage g2, BufferedImage g3){
        this.harvestcost = harvestcost;
        this.pagtubo[0] = g0;
        this.pagtubo[1] = g1;
        this.pagtubo[2] = g2;
        this.pagtubo[3] = g3;
    }

    public int getHarvestcost() {
        return harvestcost;
    }

    public BufferedImage[] getPagtubo() {
        return pagtubo;
    }
}
