package entity;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.GamePanel;

public class Entity {
	
	public GamePanel gp;
	
	public int x, y;
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public String direction;
    public int spriteCounter = 0;
    public int spriteNum = 1;
    public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collision = false;
    public int actionLockCounter;
    public boolean invincible = false;
    public int invincibleCounter = 0;
    public BufferedImage image, image2, image3;
    public boolean collisionOn;
    public int type;
    public boolean alive = true;
    public boolean dying = false;
    int dyingCounter = 0;
    boolean hpBarOn = false;
    int hpBarCounter = 0;
    
    
    //CHARACTER ATTRIBUTES
    public String name;
    public int speed;
    public int life;
    public int maxLife;
    public Projectile projectile;
    
    
    
    
    
    
    
    
    
    
    
    public Entity(GamePanel gp) {
    	this.gp = gp;

	}
    public void setAction(){}
    public void damageReaction() {}
    public void update() {
        setAction();
        collisionOn = false;
        gp.cChecker.checkEntity(this, gp.monster);
    }
    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        int screenX = x - gp.player.x + gp.player.x;
        int screenY = y - gp.player.y + gp.player.y;

        if(x + gp.tileSize > gp.player.x - gp.player.x &&
                x - gp.tileSize < gp.player.x + gp.player.x &&
                y + gp.tileSize > gp.player.y - gp.player.y &&
                y - gp.tileSize < gp.player.y + gp.player.y) {
            if (type == 2 && hpBarOn == true) {
                double oneScale = gp.tileSize / maxLife;
                double hpBarValue = oneScale * life;

                g2.setColor(new Color(35, 35, 35));
                g2.fillRect(screenX - 1, screenY - 16, gp.tileSize + 2, 12);

                g2.setColor(new Color(255, 0, 30));
                g2.fillRect(screenX, screenY - 15, (int) hpBarValue, 10);

                hpBarCounter++;

                if(hpBarCounter > 600) {
                    hpBarCounter = 0;
                    hpBarOn = false;
                }
            }
            if(invincible == true) {
                hpBarOn = true;
                hpBarCounter = 0;
                changeAlpha(g2, 0.4F);
            }
            if(dying == true) {
                dyingAnimation(g2);
            }
            g2.drawImage(image, screenX, screenX, gp.tileSize, gp.tileSize, null);

            changeAlpha(g2, 1F);
        }
    }
    public void dyingAnimation(Graphics2D g2) {
        dyingCounter++;
        int i = 5;
        if(dyingCounter <= i) {changeAlpha(g2, 0f);}
        if(dyingCounter > i && dyingCounter <= i*2) {changeAlpha(g2, 1f);}
        if(dyingCounter > i*2 && dyingCounter <= i*3) {changeAlpha(g2, 0f);}
        if(dyingCounter > i*3 && dyingCounter <= i*4) {changeAlpha(g2, 1f);}
        if(dyingCounter > i*4 && dyingCounter <= i*5) {changeAlpha(g2, 0f);}
        if(dyingCounter > i*5 && dyingCounter <= i*6) {changeAlpha(g2, 1f);}
        if(dyingCounter > i*6 && dyingCounter <= i*7) {changeAlpha(g2, 0f);}
        if(dyingCounter > i*7 && dyingCounter <= i*8) {changeAlpha(g2, 1f);}
        if(dyingCounter > i*8) {
            dying = false;
            alive = false;
        }
    }
    public void changeAlpha(Graphics2D g2, float alphaValue){
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alphaValue));
    }
}
