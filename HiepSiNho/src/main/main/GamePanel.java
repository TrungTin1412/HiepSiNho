package main;


import javax.swing.JPanel;

import entity.Player;

import java.awt.Color; 
import java.awt.Dimension;
import java.awt.Graphics; 
import java.awt.Graphics2D;
  
public class GamePanel extends JPanel implements Runnable { 
	private static final long serialVersionUID = 1L;
    //SCREEN SETTING

    final int originalTileSize = 16; //16x16 tile 
    final int scale = 3;
   
    public final int tileSize = originalTileSize*scale; //new larger tile: 48x48 
    final int maxScreenCol = 24; 
    final int maxScreenRow = 16; 

    final int screenWidth = maxScreenCol * tileSize; 
    final int screenHeight = maxScreenRow * tileSize;

    
    //FPS 
    int FPS = 60;
    
    //SYSTEM
    Sound music = new Sound();
    Sound se = new Sound();
    KeyHandler keyH = new KeyHandler(this); 
    public UI ui = new UI(this);
    Thread gameThread;
    Player player = new Player(this,keyH);
    
    
    //SET CHARACTER'S DEFAULT POSITION 
    int characterX = 100; 
    int characterY = 100; 
    int characterSpeed = 20;
    
    // GAME STATE
    public int gameState;
    public int titleState = 0;
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
    	gameState = playState;
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
                System.out.println("FPS:" + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public void update() { 
    	if(gameState == playState) {
    		player.update();
    	}
        player.update();
        if(gameState == pauseState) {
        	//nothing
        }
    } 
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D)g; 
        player.draw(g2); 
        g2.dispose(); 
    }
    
    public void playMusic(int i) {
    	music.setFile(i);
    	music.play();
    	music.loop();
    }
    
    public void playSE(int i) {
    	se.setFile();
    	se.play();
    }
}
