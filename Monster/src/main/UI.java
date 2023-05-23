package main;

import object.OBJ_Heart;
import object.SuperObject;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UI {
    GamePanel gp;
    Graphics2D g2;
    BufferedImage heart_blank, heart_full, heart_half;
    public UI(GamePanel gp) {
        SuperObject heart = new OBJ_Heart(gp);
        heart_blank = heart.image;
        heart_full = heart.image2;
        heart_half = heart.image3;
    }
    public void draw(Graphics2D g2) {
        this.g2 = g2;
        if(gp.gameState == gp.playState) {
            drawPlayerLife();
        }
        if(gp.gameState == gp.dialogueState) {
            drawPlayerLife();
        }
    }
    public void drawPlayerLife() {
        int x = gp.tileSize/2;
        int y = gp.tileSize/2;
        int i = 0;
        while (i < gp.player.maxLife/2) {
            g2.drawImage(heart_blank, x, y, null);
            i++;
            x += gp.tileSize;
        }
        x = gp.tileSize/2;
        y = gp.tileSize/2;
        i = 0;
        while (i < gp.player.life) {
            g2.drawImage(heart_half, x, y, null);
            i++;
            if(i < gp.player.life) {
                g2.drawImage(heart_full, x, y, null);
            }
            i++;
            x += gp.tileSize;
        }
    }
}
