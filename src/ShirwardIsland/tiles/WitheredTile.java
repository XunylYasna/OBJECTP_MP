package ShirwardIsland.tiles;

import ShirwardIsland.gfx.Assets;

import java.awt.image.BufferedImage;

public class WitheredTile extends Tile {

    double costtoremove;
    double timetoremove;

    public WitheredTile( int costtoremove, double timetoremove) {
        super(Assets.witheredland, 50);
        this.costtoremove = costtoremove * 0.1;
        this.timetoremove = timetoremove * 2;
        this.description = "King ng ena mo ka mag tatanim ka na nga lang di mo pa \nayusin kaya ka nayayari ng ermats mo eh tapos kung ano ano pang sinasabi mo\n";

    }

    public double getTimetoremove() {
        return timetoremove;
    }

    public double getCosttoremove() {
        return costtoremove;
    }
}
