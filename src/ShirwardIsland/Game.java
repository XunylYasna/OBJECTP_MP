package ShirwardIsland;

import ShirwardIsland.display.Display;
import ShirwardIsland.display.Shop.ShopFrame;
import ShirwardIsland.gfx.Assets;
import ShirwardIsland.gfx.GameCamera;
import ShirwardIsland.input.ButtonListener;
import ShirwardIsland.input.KeyManager;
import ShirwardIsland.input.MouseManager;
import ShirwardIsland.worlds.World;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferStrategy;



public class Game implements Runnable {

    private Display display;
    private int width, height;
    public String title;

    private boolean running = false;
    private Thread thread;

    private BufferStrategy bs;
    private Graphics g;

//    //States
//    private State gameState;
//    private State menuState;

    //Input
    private KeyManager keyManager;
    private MouseManager mouseManager;

    //Camera
    private GameCamera gameCamera;

    //Handler
    private Handler handler;

    private World world;

    public ButtonListener buttonListener;

    public Game(String title, int width, int height){
        this.width = width;
        this.height = height;
        this.title = title;
        keyManager = new KeyManager();
        mouseManager = new MouseManager();
    }

    private void init(){


        Assets.init();

        handler = new Handler(this);
        gameCamera = new GameCamera(handler, 0, 0);

        handler.setWorld(new World(handler, "res/world1.txt"));


        display = new Display(title, width, height,handler.getWorld().getEntityManager().getPlayer());
//        display.getFrame().addKeyListener(keyManager);
        display.getCanvas().addKeyListener(keyManager);
        display.getCanvas().addMouseListener(mouseManager);

        display.getCanvas().requestFocus();

    }

    private void tick(){

        handler.getWorld().tick();
        keyManager.tick();
        display.tick();

        if(mouseManager.wasKeyPressed(MouseEvent.BUTTON1)){
            if(handler.getWorld().getShop1bounds().intersects(mouseManager.getX(), mouseManager.getY(),1,1) ||handler.getWorld().getShop2bounds().intersects(mouseManager.getX(), mouseManager.getY(),1,1)){
                keyManager.restart();
                new ShopFrame(handler.getWorld().getEntityManager().getPlayer());
                handler.getGame().getDisplay().log("You opened the shop");
            }
        }

        mouseManager.tick();
    }

    private void render(){
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        //Clear Screen
        g.clearRect(0, 0, width, height);
        //Draw Here!

//        if(State.getState() != null)
//            State.getState().render(g);
        handler.getWorld().render(g);

        //End Drawing!
        bs.show();
        g.dispose();
    }

    public void run(){

        init();

        int fps = 60;
        double timePerTick = 1000000000 / 60;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while(running){
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if(delta >= 1){
                tick();
                render();
                ticks++;
                delta--;
            }

            if(timer >= 1000000000){
                System.out.println("Ticks and Frames: " + ticks);
                ticks = 0;
                timer = 0;
            }
        }

        stop();

    }

    public KeyManager getKeyManager(){
        return keyManager;
    }

    public MouseManager getMouseManager() {
        return mouseManager;
    }

    public GameCamera getGameCamera(){
        return gameCamera;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public synchronized void start(){
        if(running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop(){
        if(!running)
            return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Display getDisplay() {
        return display;
    }
}
