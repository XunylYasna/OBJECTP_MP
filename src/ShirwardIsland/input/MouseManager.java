package ShirwardIsland.input;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseManager extends MouseAdapter {

    private static final int nb = 6;
    private static final boolean[] buttons = new boolean[nb];
    private static final boolean[] lastbuttons = new boolean[nb];
    public static int x = -1, y = 1;

    @Override
    public void mousePressed(MouseEvent e){
        buttons[e.getButton()] = true;
        x = e.getX();
        y = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e){
        buttons[e.getButton()] = false;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        super.mouseDragged(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        super.mouseMoved(e);
    }

    public static void tick(){
        if(buttons[MouseEvent.BUTTON1] == true)
            buttons[MouseEvent.BUTTON1] = false;
    }


    public static boolean wasKeyPressed(int button){
        return buttons[button];
    }

    public static int getX() {
        return x;
    }

    public static int getY() {
        return y;
    }


}
