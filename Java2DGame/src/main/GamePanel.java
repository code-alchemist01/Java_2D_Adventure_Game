package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
		// Screen Setting
		
	
		final int originalTileSize = 16; // 16 x 16 tile size
		final int scale = 3; // 16 x  3 = 48
		
		final int tileSize = originalTileSize * scale; // 48 x 48 tile size 
		final int maxScreenCol = 16;
		final int maxScreenRow = 12;
		
		final int screenWidth = tileSize * maxScreenCol; // 768 pixel 
		final int screenHeight = tileSize * maxScreenRow; // 576 pixel
		
		
		Thread gameThread;
		
		
		
		public GamePanel() {
			
			this.setPreferredSize(new Dimension(screenWidth, screenHeight));
			this.setBackground(Color.black);
			this.setDoubleBuffered(true);
			
		}

		
		
		public void startGameThread() {
			gameThread = new Thread(this);
			gameThread.start();
		}


		@Override
		public void run() {
			
			while(gameThread != null) {
				
				System.out.println("Game Lopp Running...");
				
				// 1 UPDATE : update information such as character positions 
				update();
				
				// 2 DRAW : draw the screen with the update information
				repaint();
				
			}
			
		}
		
		
		public void update() {
			
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			
			Graphics g2 = (Graphics2D)g;
			
			g2.setColor(Color.white);
			
			g2.fillRect(100, 100, tileSize, tileSize);
			
			g2.dispose();
			
		}
		
		
		
		
		
	
		
		
		
		
		
		
		
		
		
		

	

}
