package ShirwardIsland.entities.player;

import ShirwardIsland.Handler;
import ShirwardIsland.entities.Entity;

import ShirwardIsland.gfx.Assets;
import ShirwardIsland.item.Item;
import ShirwardIsland.item.ItemManager;
import ShirwardIsland.item.seeds.CropType;
import ShirwardIsland.item.seeds.Seed;
import ShirwardIsland.tiles.HarvestTile;
import ShirwardIsland.tiles.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


public class Player extends Entity {

	public static final float DEFAULT_SPEED = 3.0f;
	public static final int PLAYER_WIDTH = 64,
			PLAYER_HEIGHT = 64;

	private float speed;
	private float xMove, yMove;
	private boolean moving;
	private BufferedImage playersprite;
	private int dir = 1;
	private int anim = 0;
	private int equipped = 0;
	private int xtile;
	private int ytile;

	///Below are the game experience na
	private String name;
	private FarmerType farmerType;
	private ArrayList<Item> inventory = new ArrayList<>();
	private Item equippeditem;
	private int cexp; // current exp
	private int nexp; // to next exp
	private ItemManager itemManager;

	private double objectcoins;
	private int level;




	public Player(Handler handler) {
		super(handler, 5 * 32, 5 * 32, PLAYER_WIDTH, PLAYER_HEIGHT);
		speed = DEFAULT_SPEED;
		bounds.x = 22;
		bounds.y = 44;
		bounds.width = 19;
		bounds.height = 19;

		itemManager = new ItemManager(handler);

		this.inventory = itemManager.getItems();
		equippeditem = inventory.get(0);

		xtile = (Math.round(x/Tile.TILEWIDTH));
		ytile = (Math.round(y/Tile.TILEHEIGHT));

		farmerType = FarmerType.FARMER;
		name = "Shirward";
		cexp = 0;
		nexp = 100;
		level = 100;
		objectcoins = 10000.0;
	}


	@Override
	public void tick() {
		if(anim < 7400) anim++;
		else anim = 0;
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);

		if(cexp > nexp){
			cexp = cexp - nexp;
			level++;
		}

	}

	private void getInput(){
		xMove = 0;
		yMove = 0;

		if(handler.getKeyManager().down){
			dir = 0;
			yMove = speed;
		}
		if(handler.getKeyManager().right){
			dir = 1;
			xMove = speed;
		}

		if(handler.getKeyManager().up){
			dir = 2;
			yMove = -speed;
		}
		if(handler.getKeyManager().left){
			dir = 3;
			xMove = -speed;
		}

		if(xMove != 0 || yMove != 0){
			moving = true;
		}
		else
			moving = false;

		if(handler.getKeyManager().iteme){
			equipped = (equipped + 1) % inventory.size();
			System.out.println(equipped);
			equippeditem = inventory.get(equipped);
			handler.getGame().getDisplay().log("You are equipped with " + equippeditem.getName());
		}
		if(handler.getKeyManager().itemq){
			equipped = (equipped + inventory.size() - 1)  % inventory.size();
			System.out.println(equipped);
			equippeditem = inventory.get(equipped);
			handler.getGame().getDisplay().log("You are equipped with " + equippeditem.getName());
		}

		if(handler.getKeyManager().action){
			action();
			cexp += 5;
		}

		if(handler.getKeyManager().harvest){
			if(handler.getWorld().getTileMap(xtile,ytile).getId() == 40 && // kapag harvest tile
					objectcoins > ((HarvestTile) handler.getWorld().getTileMap(xtile,ytile)).getSeed().getHarvestcost()){// ka pag may pera ka pang harvest
				objectcoins-= ((HarvestTile) handler.getWorld().getTileMap(xtile,ytile)).getSeed().getHarvestcost();
				harvest();
				cexp += 10;
			}
		}
	}

	public void setEquippeditem(int equipindex){
		equippeditem = inventory.get(equipindex);
		equipped = equipindex;
		handler.getGame().getDisplay().log("You are equipped with " + equippeditem.getName());
	}

	public void dikoalambatnagbubug(){
		handler.getKeyManager().restart();
	}

	@Override
	public void render(Graphics g) {
		if(dir == 0){
			playersprite = Assets.player_w1;
			if(moving){

				if(anim % 40 > 10 && anim % 40 <=20){
					playersprite = Assets.player_w0;
				}

				if(anim % 40 > 30 && anim % 40 <=40){
					playersprite = Assets.player_w2;
				}
			}
		}
		if(dir == 1){
			playersprite = Assets.player_d1;
			if(moving){

				if(anim % 40 > 10 && anim % 40 <=20){
					playersprite = Assets.player_d0;
				}

				if(anim % 40 > 30 && anim % 40 <=40){
					playersprite = Assets.player_d2;
				}
			}
		}
		if(dir == 2){

			playersprite = Assets.player_s1;
			if(moving){

				if(anim % 40 > 10 && anim % 40 <=20){
					playersprite = Assets.player_s0;
				}

				if(anim % 40 > 30 && anim % 40 <=40){
					playersprite = Assets.player_s2;
				}
			}
		}
		if(dir == 3){
			playersprite = Assets.player_a1;
			if(moving){

				if(anim % 40 > 10 && anim % 40 <=20){
					playersprite = Assets.player_a0;
				}

				if(anim % 40 > 30 && anim % 40 <=40){
					playersprite = Assets.player_a2;
				}
			}
		}

		g.drawImage(playersprite, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);

		g.drawString("Equipped item = " + equippeditem.getName() + " || x tile: " + xtile + " || y tile: " + ytile, (int) (x - handler.getGameCamera().getxOffset()) + 50, (int) (y - handler.getGameCamera().getyOffset())) ;

//		g.setColor(Color.red);
//		g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
//				(int) (y + bounds.y - handler.getGameCamera().getyOffset()),
//				bounds.width, bounds.height);
	}

	public void move(){
		if(!checkEntityCollisions(xMove, 0f))
			moveX();
		if(!checkEntityCollisions(0f, yMove))
			moveY();
		xtile = (Math.round(x/Tile.TILEWIDTH));
		ytile = (Math.round(y/Tile.TILEHEIGHT));

	}

	public void moveX(){
		if(xMove > 0){//Moving right
			int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;

			if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
					!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)){
				x += xMove;
			}else{
				x = tx * Tile.TILEWIDTH - bounds.x - bounds.width - 1;
			}

		}else if(xMove < 0){//Moving left
			int tx = (int) (x + xMove + bounds.x) / Tile.TILEWIDTH;

			if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
					!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)){
				x += xMove;
			}else{
				x = tx * Tile.TILEWIDTH + Tile.TILEWIDTH - bounds.x;
			}

		}
	}

	public void moveY(){
		if(yMove < 0){//Up
			int ty = (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT;

			if(!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
					!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)){
				y += yMove;
			}else{
				y = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y;
			}

		}else if(yMove > 0){//Down
			int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;

			if(!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
					!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)){
				y += yMove;
			}else{
				y = ty * Tile.TILEHEIGHT - bounds.y - bounds.height - 1;
			}

		}
	}

	private void action(){
		equippeditem.use(this);
	}

	private void harvest(){
		double income = 0;
		int ground = handler.getWorld().getTileMap(xtile,ytile).getId();
		if(ground == 40){
			income = computeincome((HarvestTile) handler.getWorld().getTileMap(xtile,ytile));
			objectcoins = objectcoins + income;
			handler.getGame().getDisplay().log("yun oh naka ani si kuya. income is " + income);
			handler.getWorld().modifyTile(Tile.grassTile ,xtile,ytile);
		}


	}

	public double computeincome(HarvestTile harvestTile){
		double sellingprice;
		double baseprice = harvestTile.getSeed().getBaseprice();
        double waterbonus;
        double fertilzerbonus;
        double cropbonus = 0;
        int water = harvestTile.getWater();
        int fertilizer = harvestTile.getFertilizer();
        if(harvestTile.getSeed().getCropType() == CropType.FLOWER)
            cropbonus = 0.5;

        if(water > harvestTile.getSeed().getWaterbl() + farmerType.wfbonus){
        	water = harvestTile.getSeed().getWaterbl() + farmerType.wfbonus;
		}

		if(fertilizer > harvestTile.getSeed().getFertilizerbl() + farmerType.wfbonus){
			water = harvestTile.getSeed().getFertilizerbl() + farmerType.wfbonus;
		}

		waterbonus = water * (baseprice/4);
		fertilzerbonus = fertilizer * (baseprice/2);

        sellingprice = (baseprice + waterbonus + fertilzerbonus) + cropbonus * (baseprice + waterbonus + fertilzerbonus);
		sellingprice = sellingprice * harvestTile.getCropproduced();
		sellingprice = sellingprice + (sellingprice * farmerType.getEarningbuying());

		return sellingprice;
	}


	protected boolean collisionWithTile(int x, int y){
		return handler.getWorld().getTile(x, y).isSolid();
	}

	//GETTERS SETTERS

	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public int getXtile() {
		return xtile;
	}

	public int getYtile() {
		return ytile;
	}

	public double getHarvesTimeBonus(){
		return this.farmerType.getHarvesttime();
	}

	public int getDir() {
		return dir;
	}

	public double getObjectcoins() {
		return objectcoins;
	}

	public int getLevel() {
		return level;
	}

	public FarmerType getFarmerType() {
		return farmerType;
	}

	public String getName() {
		return name;
	}

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public int getCexp() {
		return cexp;
	}

	public Item getEquippeditem() {
		return equippeditem;
	}

	public String getDescriptionnginaapakan(){
		return handler.getWorld().getTileMap(xtile,ytile).getDescription();
	}

	public void buy(Item item){
		objectcoins = objectcoins - (item.getPrice() - farmerType.getEarningbuying());
		item.addQuantity();
	}

	public void register(){
		objectcoins = objectcoins - (farmerType.nextFarmerType(this.getFarmerType()).getRegistrationfee());
		this.farmerType = farmerType.nextFarmerType(farmerType);
	}
}


