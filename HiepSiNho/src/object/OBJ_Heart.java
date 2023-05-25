package object;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;
import main.UtilityTool;

public class OBJ_Heart extends Entity {
    GamePanel gp;
    UtilityTool uTool = new UtilityTool();
    public OBJ_Heart( GamePanel gp) {
        super(gp);
        this.gp = gp;
        name = "Heart";
            try {
                image = ImageIO.read(getClass().getResourceAsStream("/res/heart blank.png"));
                image2 = ImageIO.read(getClass().getResourceAsStream("/res/heart full.png"));
                image3 = ImageIO.read(getClass().getResourceAsStream("/res/heart half.png"));
                image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);
                image2 = uTool.scaleImage(image2, gp.tileSize, gp.tileSize);
                image3 = uTool.scaleImage(image3, gp.tileSize, gp.tileSize);
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}