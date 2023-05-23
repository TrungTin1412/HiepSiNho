package Entity;

import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
    GamePanel gp;
    public int speed;
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public String direction;
    public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn = false;
    public int actionLockCounter;
    public boolean invincible = false;
    public int invincibleCounter = 0;
    public BufferedImage image, image2, image3;
    public String name;
    public boolean collision = false;
    public int type;

    public int maxLife;
    public int life;
    public Entity(GamePanel gp) {
        this.gp = gp;
    }
    public void update() {
        setAction();
        collisionOn = false;
        gp.cChecker.checkEntity(this, gp.monster);
    }
    public void draw(Graphics2D g2) {
        BufferedImage image = null;

        if(type == 2) {
            double oneScale = (double).gp.tileSize/maxLife;
            double hpBarValue = oneScale * life;

            g2.setColor(new Color(35, 35, 35));
            g2.fillRect(screenX - 1, screenY - 16, gp.tileSize + 2 , 12);

            g2.setColor(new Color(250, 0, 30));
            g2.fillRect(screenX, screenY - 15, (int) hpBarValue, 10);
        }
    }
}
