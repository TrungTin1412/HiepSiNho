package main;

import Entity.Player;
import object.SuperObject;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;
import java.util.Collections;

public class GamePanel extends JPanel implements Runnable {
    final int originalTileSize = 20;
    final int scale = 3;
    final int tileSize = originalTileSize * scale;
    Player player = new Player();
    TileManager tileM = new TileManager(this);
    public int gameState;
    public final int playState = 1;
    public final int dialogueState = 3;
    public AssetSetter aSetter = new AssetSetter(this);
    public Entity monster[] = new Entity[20];
    public SuperObject obj[] = new SuperObject[10];
    public void paintComponent(Graphics2D g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        tileM.draw(g2);
        g2.dispose();
    }
    public void setupGame() {
        aSetter.setMonster();
    }
    public void update() {
        for(int i = 0; i < monster.length; i++) {
            if(monster[i] != null) {
                monster[i].update();
            }
        }
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        if(gameState == tileState) {
            ui.draw(g2);
        } else {
            tileM.draw(g2);
            entityList.add(player);
            for(int i = 0; i < monster.length; i++) {
                if(monster[i] != null) {
                    entityList.add(monster[i]);
                }
            }

            Collections.sort(entityList, new Comparator<Entity>() {
                public int compare(Entity e1, Entity e2) {
                    int result = Interger.compare(e1.worldY, e2.worldY);
                    return result;
                }
            });
            for(int i = 0; i < entityList.size(); i++) {
                entityList.get(i).draw(g2);
            }
        }
    }
}
