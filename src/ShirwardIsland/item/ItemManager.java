package ShirwardIsland.item;

import ShirwardIsland.Handler;
import ShirwardIsland.entities.player.Player;
import ShirwardIsland.gfx.Assets;
import ShirwardIsland.item.seeds.CropType;
import ShirwardIsland.item.seeds.Seed;

import java.util.ArrayList;

public class ItemManager {
    private Player player;
    private ArrayList<Item> items;
    private Handler handler;

    public ItemManager(Handler handler){
        this.handler = handler;
        this.items = new ArrayList<>();
        initItems();
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    private void initItems(){
        items.add(new Plow(handler));
        items.add(new Watercan(handler));
        items.add(new Pickaxe(handler));
        items.add(new Fertilizer(handler));
        items.add(new Seed(handler,4,"Turnip Seed", CropType.VEGETABLE,1,1,1,0,1,1,1,5,6 ));
        items.add(new Seed(handler,5,"Carrot Seed", CropType.VEGETABLE,1.5f,1,1,0,1,1,2,10,9));
        items.add(new Seed(handler,6,"Tomato Seed", CropType.VEGETABLE,2.5f,3,4,1,2,1,3,20,15));
        items.add(new Seed(handler,7,"Potato Seed", CropType.VEGETABLE,5,4,5,2,3,1,6,25,13));
        items.add(new Seed(handler,8,"Rose Seed", CropType.FLOWER,1,1,2,0,1,1,1,5,5));
        items.add(new Seed(handler,9,"Tulip Seed", CropType.FLOWER,1.5f,2,3,0,1,1,1,7, 7));
        items.add(new Seed(handler,10,"Stargazer Seed", CropType.FLOWER,2.5f,2,3,0,1,1,1,10,9));
        items.add(new Seed(handler,11,"Sunflower Seed", CropType.FLOWER,3.5f,2,3,1,2,1,1,20,19));
        items.add(new Seed(handler,12,"Mango Seed", CropType.TREE,7,7,7,4,4,5,10,50,4));
        items.add(new Seed(handler,13,"Apple Seed", CropType.TREE,7,7,7,5,5,7,10,55,3.5));
        items.add(new Seed(handler,14,"Banana Seed", CropType.TREE,8,8,8,5,5,10,15,60,3.5));
        items.add(new Seed(handler,15,"Orange Seed", CropType.TREE,8,8,8,6,6,13,15,65,4.5));

        //items.add(new Seed(handler,"Rose", CropType.FLOWER,1,1,2,0,1,1,1,5,5 ));

    }
}
