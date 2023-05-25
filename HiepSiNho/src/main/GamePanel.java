package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JPanel;

import entity.Entity;
import entity.Player;
import tile.TileManager;
  
public class GamePanel extends JPanel implements Runnable { 
	private static final long serialVersionUID = 1L;
    //SCREEN SETTING

    final int originalTileSize = 16; //16x16 tile 
    final int scale = 3;
   
    public final int tileSize = originalTileSize*scale; //new larger tile: 48x48 
    public final int maxScreenCol = 13; 
    public final int maxScreenRow = 16; 

    final int screenWidth = maxScreenCol * tileSize; 
    final int screenHeight = maxScreenRow * tileSize;

    // public final int maxWorldCol = 13;
    // public final int maxWorldRow = 16;
    // public final int worldWidth = tileSize * maxWorldCol;
    // public final int worldHeight = tileSize * maxWorldRow;
    
    //FPS 
    int FPS = 60;
    
    TileManager tileM = new TileManager(this);

    KeyHandler keyH = new KeyHandler(this); 
    public UI ui = new UI(this);
    Thread gameThread;

    public CollisionChecker cChecker = new CollisionChecker(this);
    public Player player = new Player(this,keyH);
    public AssetSetter aSetter = new AssetSetter(this);
    public Entity monster[] = new Entity[20];
    public Entity obj[] = new Entity[10];
    ArrayList<Entity>entityList = new ArrayList<>();
    
    
    
    
    // GAME STATE
    public int gameState;
    public final int titleState = 0;
    public final int playState = 1;
    public final int pauseState = 2;
    
    public GamePanel() { 
        this.setPreferredSize(new Dimension(screenWidth, screenHeight)); 
        this.setBackground(Color.black);
        this.setDoubleBuffered(true); 
        this.addKeyListener(keyH);
        this.setFocusable(true); 
    }
    public void setupGame() {
        aSetter.setMonster();
    	//playMusic(0);
    	gameState = titleState;
    }
    
    public void startGameThread() { 
    	gameThread = new Thread(this);
    	gameThread.start();
    
    }
    
    @Override
    public void run() {
        double drawInterval = 1000000000/FPS; //0.01666 seconds
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while(gameThread != null){
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;
            if (delta >= 1){
                update();
                repaint();
                delta--;
                drawCount++;
            }
            if (timer >= 1000000000){
                //System.out.println("FPS:" + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public void update() {
		
		if(gameState == playState) { 
            //PLAYER
			player.update();

            //MONSTER
            for(int i = 0; i < monster.length; i++){
                if(monster[i] != null){
                    monster[i].update();
                }
            }
		} 
		if(gameState == pauseState) {
		//nothing
		}
		  
    } 
     
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        
        //TITLE SCREEN
        if(gameState == titleState) {
        	ui.draw(g2);
        }
        
        //OTHER
        else {
            //TILE
            tileM.draw(g2);

            //ADD ENTITIES TO THE LIST
            entityList.add(player);
            for(int i = 0; i < monster.length; i++) {
                if(monster[i] != null) {
                    entityList.add(monster[i]);
                }
            }
            for(int i = 0; i < obj.length; i ++){
                if(obj[i] != null){
                    entityList.add(obj[i]);
                }
            }
            //SORT
            Collections.sort(entityList, new Comparator<Entity>() {

                @Override
                public int compare(Entity e1, Entity e2) {
                    int result = Integer.compare(e1.y, e2.y);
                    return 0;
                }
                
            });
            //DRAW ENTITIES
            for(int i = 0; i < entityList.size(); i++){
                entityList.get(i).draw(g2);
            }
            //EMPTY ENTITY LIST 
            for(int i = 0; i < entityList.size(); i++){
                entityList.remove(i);
            }
            //PLAYER
            player.draw(g2);
            //UI
            ui.draw(g2);
        }
        g2.dispose();
    }
}
