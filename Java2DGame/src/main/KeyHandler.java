package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{

	
	public boolean upPressed, downPressed, leftPressed, rightPressed;
	
	
	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keycode = e.getKeyCode();
		
		if(keycode == KeyEvent.VK_W || keycode == KeyEvent.VK_UP) { // Press W key
			upPressed = true;
		}
		
		if(keycode == KeyEvent.VK_S || keycode == KeyEvent.VK_DOWN) { // Press S key
			downPressed = true;
		}
		
		if(keycode == KeyEvent.VK_A || keycode == KeyEvent.VK_LEFT) { // Press A key
			leftPressed = true;
		}
		
		if(keycode == KeyEvent.VK_D || keycode == KeyEvent.VK_RIGHT) { // Press D key
			rightPressed = true;
		}
	}

	
	@Override
	public void keyReleased(KeyEvent e) {
		
		int keycode = e.getKeyCode();
		
		if(keycode == KeyEvent.VK_W || keycode == KeyEvent.VK_UP) { // Press W key
			upPressed = false;
		}
		
		if(keycode == KeyEvent.VK_S || keycode == KeyEvent.VK_DOWN) { // Press S key
			downPressed = false;
		}
		
		if(keycode == KeyEvent.VK_A || keycode == KeyEvent.VK_LEFT) { // Press A key
			leftPressed = false;
		}
		
		if(keycode == KeyEvent.VK_D || keycode == KeyEvent.VK_RIGHT) { // Press D key
			rightPressed = false;
		}
	}
}
