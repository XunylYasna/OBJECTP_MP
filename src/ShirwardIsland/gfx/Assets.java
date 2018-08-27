package ShirwardIsland.gfx;

import java.awt.image.BufferedImage;

public class Assets {

	private static final int width = 32, height = 32;

	//Tiles
	public static BufferedImage dirt, grass, plowedland, plantedland, witheredland;
	public static BufferedImage water, /*urwater, ulwater, lwater, dlwater, dwater, drwater, rwater,*/ darkWater;
	public static BufferedImage usand, ursand, ulsand, lsand, dlsand, dsand, drsand, rsand;

	//Items
	public static BufferedImage fertilizer, plow, pickaxe, wateringCan;

	//Seeds
    public static BufferedImage turnip, carrot, tomato, potato, rose, tulip,
								stargazer, sunflower, mango, apple, banana, orange;

    //Plants
	public static BufferedImage vegetable0, vegetable1, vegetable2, vegetable3;
	public static BufferedImage flower0, flower1, flower2, flower3;
	public static BufferedImage tree0, tree1, tree2, tree3;

    //Entities
	public static BufferedImage tree, rock, shop1 , shop2;
	//public static BufferedImage

	public static BufferedImage player_w0, player_w1, player_w2;
	public static BufferedImage player_s0, player_s1, player_s2;
	public static BufferedImage player_d0, player_d1, player_d2;
	public static BufferedImage player_a0, player_a1, player_a2;

	public static void init(){
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("res/SpriteSheets/sheet.png"));
		SpriteSheet playersheet = new SpriteSheet(ImageLoader.loadImage("res/SpriteSheets/playersheet.png"));
		SpriteSheet plantsheet = new SpriteSheet(ImageLoader.loadImage("res/SpriteSheets/plantsheet.png"));
		SpriteSheet entitysheet = new SpriteSheet(ImageLoader.loadImage("res/SpriteSheets/entitysheet.png"));
		SpriteSheet shopsheet = new SpriteSheet(ImageLoader.loadImage("res/SpriteSheets/shopshit.png"));

		//PLAYER SPRITES
		player_w0 = playersheet.crop(width * 0, 0 * height, width, height);
		player_w1 = playersheet.crop(width * 1, 0 * height, width, height);
		player_w2 = playersheet.crop(width * 2, 0, width, height);

		player_a0 = playersheet.crop(width * 0, 1 * height, width, height);
		player_a1 = playersheet.crop(width * 1, 1 * height, width, height);
		player_a2 = playersheet.crop(width * 2, 1 * height, width, height);

		player_d1 = playersheet.crop(width * 1, 2 * height, width, height);
		player_d2 = playersheet.crop(width * 2, 2 * height, width, height);
		player_d0 = playersheet.crop(width * 0, 2 * height, width, height);

		player_s1 = playersheet.crop(width * 1, 3 * height, width, height);
		player_s2 = playersheet.crop(width * 2, 3 * height, width, height);
		player_s0 = playersheet.crop(width * 0, 3 * height, width, height);



		dirt = sheet.crop(width, 0, width, height);
		grass = sheet.crop(width * 0, 0, width, height);

		rock = entitysheet.crop(width *2, 0, width, height);
		tree = entitysheet.crop(0, 0, width*2, height*3);
		shop1 = shopsheet.crop(0, 0, width*5, height*6);
		shop2 = shopsheet.crop(width * 5, height * 1,width * 3, height * 4);

		plowedland = sheet.crop(width * 3, 0, width, height);
		plantedland = sheet.crop(width * 4, 0, width, height);
		witheredland = sheet.crop(width * 4, height * 3, width, height);

		//Sands
		usand = sheet.crop(width * 5, 0, width, height);
		ursand = sheet.crop(width * 2, height, width, height);
		ulsand = sheet.crop(0, height, width, height);
		drsand = sheet.crop(width * 2, height * 3, width, height);
		dsand = sheet.crop(width, height * 3, width, height);
		dlsand = sheet.crop(0, height * 3, width, height);
		lsand = sheet.crop(0, height * 2, width, height);
		rsand = sheet.crop(width * 2, height * 2, width, height);

		//Water
		water = sheet.crop(width, 0, width, height);
		/*
		urwater = sheet.crop(width * 2, height, width, height);
		ulwater = sheet.crop(0, height, width, height);
		drwater = sheet.crop(width * 2, height * 3, width, height);
		dwater = sheet.crop(width, height * 3, width, height);
		dlwater = sheet.crop(0, height * 3, width, height);
		lwater = sheet.crop(0, height * 2, width, height);
		rwater = sheet.crop(width * 2, height * 2, width, height);
		*/
		darkWater = sheet.crop(width * 2, height * 0, width, height);

		//Seeds
		apple = entitysheet.crop(0, height*5, width, height);
		banana = entitysheet.crop(width, height*5, width, height);
		carrot = entitysheet.crop(width*2, height*5, width, height);
		mango = entitysheet.crop(width*3, height*5, width, height);
		orange = entitysheet.crop(0, height*6, width, height);
		potato = entitysheet.crop(width, height*6, width, height);
		rose = entitysheet.crop(width*2, height*6, width, height);
		stargazer = entitysheet.crop(width*3, height*6, width, height);
		sunflower = entitysheet.crop(0, height*7, width, height);
		tomato = entitysheet.crop(width, height*7, width, height);
		tulip = entitysheet.crop(width*2, height*7, width, height);
		turnip = entitysheet.crop(width*3, height*7, width, height);

		//Plantsprites
		vegetable0 = plantsheet.crop(0,0,width,height);
		vegetable1 = plantsheet.crop(width * 1,0,width,height);
		vegetable2 = plantsheet.crop(width * 2,0,width,height);
		vegetable3 = plantsheet.crop(width * 3,0,width,height);

		flower0 = plantsheet.crop(0,1 * height,width,height);
		flower1 = plantsheet.crop(width * 1,1 * height,width,height);
		flower2 = plantsheet.crop(width * 2,1 * height,width,height);
		flower3 = plantsheet.crop(width * 3,1 * height,width,height);

		tree0 = plantsheet.crop(0,2 * height,width,height);
		tree1 = plantsheet.crop(width * 1,2 * height,width,height);
		tree2 = plantsheet.crop(width * 2,2 * height,width,height);
		tree3 = plantsheet.crop(width * 3,2 * height,width,height);

	}

}
