package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.GamePanel;

public class Entity {
	
	GamePanel gp;
	
	public int x, y;
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public String direction;
    public int spriteCounter = 0;
    public int spriteNum = 1;
    public Rectangle solidArea;
    public boolean collision = false;
    public boolean collisionOn;
    
    
    //CHARACTER ATTRIBUTES
    public String name;
    public int speed;
    public int life;
    public int maxLife;
    public Projectile projectile;
    
    
    
    
    
    
    
    
    
    
    
    public Entity(GamePanel gp) {
    	this.gp = gp;

	}
}
