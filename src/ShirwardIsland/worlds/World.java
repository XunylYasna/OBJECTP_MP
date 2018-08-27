package ShirwardIsland.worlds;

import ShirwardIsland.Handler;
import ShirwardIsland.entities.EntityManager;
import ShirwardIsland.entities.Message;
import ShirwardIsland.entities.statics.Rock;
import ShirwardIsland.entities.statics.Shop;
import ShirwardIsland.entities.statics.Shop2;
import ShirwardIsland.entities.statics.Tree;
import ShirwardIsland.item.ItemManager;
import ShirwardIsland.tiles.*;
import ShirwardIsland.utils.Utils;

import java.awt.*;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class World {

	private Handler handler;
	private int width, height;
	private int spawnX, spawnY;
	private int[][] tiles;
	private Tile[][] tilemap;
	private int animcounter = 0;
	private EntityManager entityManager;
	private ItemManager itemManager;
	private Message message;
	private Random random = new Random();

	public World(Handler handler, String path){
		loadWorld(path);

		this.handler = handler;


		entityManager = new EntityManager(handler);

		entityManager.addEntity(new Shop(handler, 16 * 32, 19*32));
		entityManager.addEntity(new Shop2(handler, 24 * 32, 21 * 32));

		entityManager.addEntity(new Tree(handler, 10*32, 10*32));

		for(int i = 0; i < 10; i++){
			entityManager.addEntity(new Rock(handler, random.nextInt(32)*32, random.nextInt(32)*32));
		}

		for(int i = 0; i < entityManager.getEntities().size(); i++){
			System.out.println(entityManager.getEntities().get(i).getType());
		}

		message = new Message(handler,"");
		//Seeds
		//entityManager.addEntity(new );

	}

	public void tick(){
		//if lalagyan natin ng animation yung tubig hehe xd
//		animcounter ++;
//		if(animcounter == 50){
//			animate1();
//		}
//
//		if(animcounter == 100){
//			animcounter = 0;
//			animate0();
//		}
		entityManager.tick();
		message.tick();
	}

	public void render(Graphics g){
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
		int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
		int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);

		for(int y = yStart;y < yEnd;y++){
			for(int x = xStart;x < xEnd;x++){
				getTileMap(x, y).render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),
						(int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
			}
		}

		entityManager.render(g);
		message.render(g);
	}

	public void setMessage(String message){
		this.message.setMessage(message);
	}

	public Tile getTile(int x, int y){
		if(x < 0 || y < 0 || x >= width || y >= height)
			return Tile.grassTile;

		Tile t = Tile.tiles[tiles[x][y]];

		if(t == null)
			return Tile.grassTile;

		return t;
	}

	public Tile getTileMap(int x, int y){
		if(x < 0 || y < 0 || x >= width || y >= height)
			return Tile.grassTile;

		Tile t = tilemap[x][y];

		if(t == null)
			return Tile.grassTile;

		return t;
	}

	//// WORLD PLAYER INTERACTIONS

	public void modifyTile(Tile tile, int x, int y){
		tilemap[x][y] = tile;
		tiles[x][y] = tile.getId();
	}



	public void papatubuin(int x, int y, double minutes){
		PlantedTile plantedTile = (PlantedTile) handler.getWorld().getTileMap(x,y);
		Timer timer = new Timer();
		minutes = 10; // gagawin muna natin 10 seconds for testing purposes *1000 = 1 sec so babaguhin pa yung 1000 to 60 000
		//minutes = minutes - (minutes * handler.getWorld().getEntityManager().getPlayer().getHarvesTimeBonus());

		timer.schedule(new Tubo(plantedTile), ((int)minutes/3 * 1 * 1000));
		timer.schedule(new Tubo(plantedTile), ((int)minutes/3 * 2 * 1000));
		timer.schedule(new Finaltubo(plantedTile, x,y), (int) minutes * 1000);

	}

	class Tubo extends TimerTask {
		PlantedTile plantedTile;

		Tubo(PlantedTile plantedTile){
			this.plantedTile = plantedTile;
		}

		@Override
		public void run() {
			this.plantedTile.tubo();
		}
	}

	class Finaltubo extends TimerTask{
		PlantedTile plantedTile;
		int x;
		int y;

		Finaltubo(PlantedTile plantedTile, int x, int y){
			this.plantedTile = plantedTile;
			this.x = x;
			this.y = y;
		}

		@Override
		public void run() {
			Timer lanta = new Timer();
			if(plantedTile.tutubo()){
				handler.getWorld().modifyTile(new HarvestTile(plantedTile), x,y);
				handler.getGame().getDisplay().log("U can harvest the tile at (" + (x-3) + "," + (y-3) + ").");
				lanta.schedule(new Lanta(x,y, (HarvestTile)handler.getWorld().getTileMap(x,y)), 5 * 1000); // 5 seconds siya ngayon pero dapat 1 min
			}

			else{
				WitheredTile nalanta = new WitheredTile(plantedTile.getSeed().getHarvestcost(), plantedTile.getSeed().getHarvesTime());
				handler.getWorld().modifyTile(nalanta, x,y);
				handler.getGame().getDisplay().log("Nalanta na tanim mo sa (" + (x-3) + "," + (y-3) + ") boi!!");
				lanta.schedule(new AntiLanta(x,y), (int) nalanta.getTimetoremove() + 3 * 1000); // times 60 din para minutes yung time tapos tanggalin 3
			}
		}
	}

	// Lanta is used to if yung planted tile na ignore it will become lanta eventually
	class Lanta extends TimerTask{
		HarvestTile harvestTile;
		int x;
		int y;

		public Lanta(int x, int y, HarvestTile harvestTile) {
			this.x = x;
			this.y = y;
			this.harvestTile = harvestTile;
		}

		@Override
		public void run() {
			if(handler.getWorld().getTileMap(x,y).getId() == 40){ //if harvest tile pa rin siya
				Timer anti = new Timer();
				WitheredTile nalanta = new WitheredTile(harvestTile.getSeed().getHarvestcost(), harvestTile.getSeed().getHarvesTime());
				handler.getWorld().modifyTile(nalanta, x,y);
				anti.schedule(new AntiLanta(x,y), (int) nalanta.getTimetoremove() + 3 * 1000); // times 60 din para minutes yung time tapos tanggalin yung 3
			}
		}
	}


	//Anti lanta is used if yung withered tile is ignored it will become a grass tile eventally
	class AntiLanta extends TimerTask{
		int x;
		int y;

		public AntiLanta(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public void run() {
			if(handler.getWorld().getTileMap(x,y).getId() == 50){ //if withered tile pa rin siya
				handler.getWorld().modifyTile(Tile.grassTile,x,y);
			}
		}
	}




	private void loadWorld(String path){
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);

		tiles = new int[width][height];
		for(int y = 0;y < height;y++){
			for(int x = 0;x < width;x++){
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
			}
		}

		tilemap = new Tile[width][height];

		for(int y = 0;y < height;y++){
			for(int x = 0;x < width;x++){
				tilemap[x][y] = getTile(x,y);
			}
		}
	}

	private void animate0(){
		for(int w = 0; w < width; w++){
			for(int h = 0; h < height; h++){
				if(tiles[w][h] == 1)
					tiles[w][h] = 2;
			}
		}
	}

	private void animate1(){
		for(int w = 0; w < width; w++){
			for(int h = 0; h < height; h++){
				if(tiles[w][h] == 2)
					tiles[w][h] = 1;
			}
		}
	}

	public int getWidth(){
		return width;
	}

	public int getHeight(){
		return height;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public ItemManager getItemManager() {
		return itemManager;
	}

	public Rectangle getShop1bounds(){

		int shop = 0;
//		for(int i = 0; i < entityManager.getEntities().size();i++){
//			System.out.println(entityManager.getEntities().get(i).getType() + " " + i);
//		} //sobrang nakaka stress to gago

		for(int i = 0; i < entityManager.getEntities().size();i++){
			if(entityManager.getEntities().get(i) instanceof Shop)
				shop = i;
		} //sobrang nakaka stress to gago


		return ((Shop) entityManager.getEntities().get(shop)).getClickBounds();
	}

	public Rectangle getShop2bounds(){

		int shop = 0;
//		for(int i = 0; i < entityManager.getEntities().size();i++){
//			System.out.println(entityManager.getEntities().get(i).getType() + " " + i);
//		} //sobrang nakaka stress to gago

		for(int i = 0; i < entityManager.getEntities().size();i++){
			if(entityManager.getEntities().get(i) instanceof Shop2)
				shop = i;
		} //sobrang nakaka stress to gago

		return ((Shop2) entityManager.getEntities().get(shop)).getClickBounds();
	}
}








