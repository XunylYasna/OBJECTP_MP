package ShirwardIsland.entities;

import ShirwardIsland.Handler;
import ShirwardIsland.entities.player.Player;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

public class EntityManager
{
    private Handler handler;
    private ArrayList<Entity> entities;
    private Player player;
    private Message message;

    private Comparator<Entity> renderSorter = new Comparator<Entity>() {
        @Override
        public int compare(Entity a, Entity b) {
            if(a.getY() + a.getHeight() < b.getY() + b.getHeight())
                return -1;
            return 1;
        }
    };

    public EntityManager(Handler handler){
        this.handler = handler;
        entities = new ArrayList<Entity>();
        this.message = new Message(handler, "");
        player = new Player(handler);
        addEntity(player);
    }

    public void tick(){
        for(int i = 0;i < entities.size();i++){
            Entity e = entities.get(i);
            e.tick();
        }

        entities.sort(renderSorter);
    }

    public void render(Graphics g){
        for(Entity e : entities){
            e.render(g);
        }
        message.render(g);
    }

    public void addEntity(Entity e){
        entities.add(e);
    }

    public void removeEntity(Entity e)
    {
        entities.remove(e);
    }


    //GETTERS SETTERS

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }


    public void setDMessage(String message){
        this.message.setMessage(message);
    }

    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }


}
