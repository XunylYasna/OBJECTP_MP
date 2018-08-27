package ShirwardIsland.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

	private boolean[] keys;
	public boolean up, down, left, right, action, iteme, itemq, harvest;


	public KeyManager(){
		keys = new boolean[256];
	}

	public void tick(){

		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
		action = keys[KeyEvent.VK_F];
		iteme = keys[KeyEvent.VK_E];
		itemq = keys[KeyEvent.VK_Q];
		harvest = keys[KeyEvent.VK_C];

		if(keys[KeyEvent.VK_E]){
			keys[KeyEvent.VK_E] = false;
		}

		if(keys[KeyEvent.VK_Q])
			keys[KeyEvent.VK_Q] = false;

		if(keys[KeyEvent.VK_F]){
			keys[KeyEvent.VK_F] = false;
		}

		if(keys[KeyEvent.VK_C]){
			keys[KeyEvent.VK_C] = false;
		}
	}

	public void restart(){
		for(int i = 0; i < keys.length; i++){
			keys[i] = false;
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {

		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}


}
