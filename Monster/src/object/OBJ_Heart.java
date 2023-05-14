package object;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class OBJ_Heart extends SuperObject {
    GamePanel gp;
    public OBJ_Heart() {
        this.gp = gp;
        name = "Heart";
        public BufferedImage setup(String imageName) {
            UtilityTool uTool = new UtilityTool();
            BufferedImage image = null;
            try {
                image = ImageIO.read(getClass().getResourceAsStream("/heart/heart blank.png"));
                image2 = ImageIO.read(getClass().getResourceAsStream("/heart/heart full.png"));
                image3 = ImageIO.read(getClass().getResourceAsStream("/heart/heart half.png"));
                image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);
                image2 = uTool.scaleImage(image2, gp.tileSize, gp.tileSize);
                image3 = uTool.scaleImage(image3, gp.tileSize, gp.tileSize);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
