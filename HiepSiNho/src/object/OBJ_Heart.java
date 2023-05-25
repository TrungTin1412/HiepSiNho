package object;

import entity.Entity;
import main.GamePanel;


public class OBJ_Heart extends Entity {
    public OBJ_Heart(GamePanel gp){
        super(gp);
        name = "Heart";
        image = setup("/res/heart blank");
        image2 = setup("/res/heart full");
        image3 = setup("/res/heart half");
    }
    
}
