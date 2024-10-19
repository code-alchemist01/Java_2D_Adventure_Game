package main;

import java.awt.Color;
import java.awt.Dimension;

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
			// TODO Auto-generated method stub
			
		}
		
		
		
		
		
		
	
		
		
		
		
		
		
		
		
		
		

	

}
