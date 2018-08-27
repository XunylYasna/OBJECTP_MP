package ShirwardIsland.entities;

import ShirwardIsland.Handler;

import java.awt.*;

public class Message extends Entity{

    String message;
    private int babaeffect;

    public Message(Handler handler, String message){
        super(handler, 0,0,0,0);
        this.message = message;
    }

    @Override
    public void tick() {
        babaeffect++;
    }

    @Override
    public void render(Graphics g) {
        g.drawString(message, (int) (handler.getWorld().getEntityManager().getPlayer().getX() - handler.getGameCamera().getxOffset()), (int) (handler.getWorld().getEntityManager().getPlayer().getY() - handler.getGameCamera().getyOffset() + 300 + babaeffect)) ;
    }

    public void setMessage(String message){
        babaeffect = 0;
        this.message = message;
    }
}
