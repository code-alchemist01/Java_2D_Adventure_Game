package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;
import util.Direction;

public class Player extends Entity {

	GamePanel gp;
	KeyHandler keyH;
	
	public Player(GamePanel gp, KeyHandler keyH) {
		this.gp = gp;
		this.keyH = keyH;
		
		setDefaultValues();	
		getPlayerImage();
	}
	
	
	public void setDefaultValues() {
		x = 100;
		y = 100;
		speed = 4;
		direction = Direction.DOWN;
	}
	
	
	public void getPlayerImage() {
			
		try {
			
			up1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_2.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_2.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_2.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_2.png"));
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	

	
	//If we only write it to the gamepanel class, there will be thousands of lines of code, so we make it a segmented organization.
	
	public void update() { 
		
		if(keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true) {
			if(keyH.upPressed == true) {
				direction = Direction.UP;
				y -= speed;
			}
			else if(keyH.downPressed == true) {
				direction = Direction.DOWN;
				y += speed;
			}
			else if(keyH.leftPressed == true) {
				direction = Direction.LEFT;
				x -= speed;
			}
			else if(keyH.rightPressed == true) {
				direction = Direction.RIGHT;
				x += speed;
			}
			spriteCounter++;
			
			if(spriteCounter > 12) {
				if(spriteNum == 1) {
					spriteNum = 2;
				}
				else if(spriteNum == 2) {
					spriteNum = 1;	
				}
				spriteCounter = 0;
			}
		}
		
		

	}
	

	public void draw(Graphics2D g2) {
//		g2.setColor(Color.white);
//		g2.fillRect(x, y, gp.tileSize, gp.tileSize);
		
		
		BufferedImage image = null;
		
		switch(direction) {
			case Direction.UP:
				image = spriteNum == 1 ? up1 : up2;
				break;
			case Direction.DOWN:
				image = spriteNum == 1 ? down1 : down2;
				break;
			case Direction.LEFT:
				image = spriteNum == 1 ? left1 : left2;
				break;
			case Direction.RIGHT:
				image = spriteNum == 1 ? right1 : right2;
				break;
		}
		
		g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
		
		
	}
	
	
}
