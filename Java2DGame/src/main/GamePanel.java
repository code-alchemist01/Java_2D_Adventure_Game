package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints.Key;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
		// Screen Setting
		
	
		private static final int FPS = 60;
		final int originalTileSize = 16; // 16 x 16 tile size
		final int scale = 3; // 16 x  3 = 48
		
		final int tileSize = originalTileSize * scale; // 48 x 48 tile size 
		final int maxScreenCol = 16;
		final int maxScreenRow = 12;
		
		final int screenWidth = tileSize * maxScreenCol; // 768 pixel 
		final int screenHeight = tileSize * maxScreenRow; // 576 pixel
		
		
		KeyHandler keyH = new KeyHandler();
		
		
		Thread gameThread;
		
		// Set player default position
		
		int playerX = 100;
		int playerY = 100;
		int playerSpeed = 4;
		
		
		
		public GamePanel() {
			
			this.setPreferredSize(new Dimension(screenWidth, screenHeight));
			this.setBackground(Color.black);
			this.setDoubleBuffered(true);	
			this.addKeyListener(keyH); // add keyhandler
			this.setFocusable(true); // In Java, the setFocusable(true) method makes a user interface element selectable and interactable with the keyboard or mouse.
			
		}
		
		
		public void startGameThread() {
			gameThread = new Thread(this);
			gameThread.start();
		}

		
		@Override
		public void run() {
			
			double drawInterval = 1000000000/FPS; // 0.0166666 seconds
			double nextDrawTime = System.nanoTime() + drawInterval;	
			
			while(gameThread != null) {
				
				update();
				
				repaint();		
				
				
				try {
					double remainingTime = nextDrawTime - System.nanoTime();
					remainingTime = remainingTime/1000000;
					
					if(remainingTime < 0) {
						remainingTime = 0;
					}
					
					Thread.sleep((long) remainingTime);
					
					nextDrawTime += drawInterval;
					
				} catch (InterruptedException e) {
					e.printStackTrace();
			
				}
			}		
		}
		
		
		
		public void update() {
			if(keyH.upPressed == true) {
				playerY -= playerSpeed;
			}
			else if(keyH.downPressed == true) {
				playerY += playerSpeed;
			}
			else if(keyH.leftPressed == true) {
				playerX -= playerSpeed;
			}
			else if(keyH.rightPressed == true) {
				playerX += playerSpeed;
			}
		}
		
		
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			
			Graphics g2 = (Graphics2D)g;
			
			g2.setColor(Color.white);
			
			g2.fillRect(playerX, playerY, tileSize, tileSize);
			
			g2.dispose();
			
		}
		
		
		
		
		
	
		
		
		
		
		
		
		
		
		
		

	

}
