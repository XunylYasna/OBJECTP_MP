package ShirwardIsland.tiles;

import ShirwardIsland.gfx.Assets;

import java.awt.Graphics;
import java.awt.image.BufferedImage;


public class Tile {


	//Tile index
	// 0 grass
	// 1 - 10 water and sand ( 2,4 water)
	//
	//Below are the ones created by the actions of the player
	// 20 plowed
	// 30 planted
	// 40 harvest
	// 50 withered // di na siya static


	//STATIC STUFF HERE

	public static Tile[] tiles = new Tile[256];
	public static Tile grassTile = new GrassTile(Assets.grass); //id == 0



	//SandTiles
	public static Tile lsandTile = new SandTile(Assets.lsand, 1);
	public static Tile drsandTile = new SandTile(Assets.drsand, 3);
	public static Tile usandTile = new SandTile(Assets.usand, 5);
	public static Tile ulsandTile = new SandTile(Assets.ulsand, 6);
	public static Tile ursandTile = new SandTile(Assets.ursand, 7);
	public static Tile dsandTile = new SandTile(Assets.dsand, 8);
	public static Tile rsandTile = new SandTile(Assets.rsand, 9);
	public static Tile dlsandTile = new SandTile(Assets.dlsand, 10);


	//WaterTiles
	public static Tile waterTile = new WaterTile(2);
	public static Tile darkWaterTile = new DarkWaterTile(4);


	public int animclock = 0;

	//CLASS

	public static final int TILEWIDTH = 64, TILEHEIGHT = 64;

	protected BufferedImage texture;
	protected final int id;
	protected String description;

	public Tile(BufferedImage texture, int id){
		this.texture = texture;
		this.id = id;

		tiles[id] = this;
	}

	public void tick(){
	}

	public void render(Graphics g, int x, int y){
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
	}

	public boolean isSolid(){
		return false;
	}

	public int getId(){
		return id;
	}

	public String getDescription(){
		return description;
	}

}
