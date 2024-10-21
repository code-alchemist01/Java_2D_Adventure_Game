package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints.Key;

import javax.swing.JPanel;

import entity.Player;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable{
		// Screen Setting
		
	
		private static final int FPS = 60;
		final int originalTileSize = 16; // 16 x 16 tile size
		final int scale = 3; // 16 x  3 = 48
		
		public final int tileSize = originalTileSize * scale; // 48 x 48 tile size 
		public final int maxScreenCol = 16;
		public final int maxScreenRow = 12;
		
		public final int screenWidth = tileSize * maxScreenCol; // 768 pixel 
		public final int screenHeight = tileSize * maxScreenRow; // 576 pixel
		
		
		
		TileManager tileM = new TileManager(this);
		KeyHandler keyH = new KeyHandler();
		Thread gameThread;
		Player player = new Player(this, keyH);
		
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
			player.update();
		}
		
		
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			
			Graphics2D g2 = (Graphics2D)g;
			
			tileM.draw(g2); // first draw tile and second on draw player
			player.draw(g2);
			
			g2.dispose();
			
		}
		
		
		
		
		
	
		
		
		
		
		
		
		
		
		
		

	

}
