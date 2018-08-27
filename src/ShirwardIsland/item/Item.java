package ShirwardIsland.item;

import ShirwardIsland.Handler;
import ShirwardIsland.entities.player.Player;
import java.awt.image.BufferedImage;

public abstract class Item{

    protected Handler handler;
    protected String name;
    protected BufferedImage texture;
    protected int qty = 1;
    protected final int id; // for texture similar to tiles
    protected String description;
    protected double price = 0;

    public Item(Handler handler,int qty, int id, String name, String description)
    {
        this.handler = handler;
        this.qty = qty;
        this.description = description;
        this.id = id;
        this.name = name;
    }

    public String getDescription(){
        return description;
    }

    public abstract void use(Player player);

    protected abstract boolean usable(Player player);

    public String getName(){
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void addQuantity(){
        this.qty++;
    }
}
