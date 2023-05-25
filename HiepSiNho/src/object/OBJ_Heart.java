package object;

import java.awt.image.BufferedImage;

import entity.Entity;
import main.GamePanel;

public class OBJ_Heart extends Entity {

    public OBJ_Heart( GamePanel gp) {
        super(gp);
        this.gp = gp;
        name = "Heart";
        final BufferedImage setup(String imageName) {
            UtilityTool uTool = new UtilityTool();
            BufferedImage image = null;
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
            return image;
        }
    }
}