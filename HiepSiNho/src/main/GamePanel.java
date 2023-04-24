package main;

import javax.swing.JPanel;

import java.awt.Color; 
import java.awt.Dimension;
import java.awt.Graphics; 
import java.awt.Graphics2D;
  
public class GamePanel extends JPanel implements Runnable { 
	private static final long serialVersionUID = 1L;
    //SCREEN SETTING

    final int originalTileSize = 16; //16x16 tile 
    final int scale = 3;
   
    final int tileSize = originalTileSize*scale; //new larger tile: 48x48 
    final int maxScreenCol = 24; 
    final int maxScreenRow = 16; 

    final int screenWidth = maxScreenCol * tileSize; 
    final int screenHeight = maxScreenRow * tileSize;

    
    //FPS 
    int FPS = 60;
    
    KeyHandler keyH = new KeyHandler(); 
    Thread gameThread;
    
    //SET CHARACTER'S DEFAULT POSITION 
    int characterX = 100; 
    int characterY = 100; 
    int characterSpeed = 50;
    
    public GamePanel() { 
        this.setPreferredSize(new Dimension(screenWidth, screenHeight)); 
        this.setBackground(Color.black);
        this.setDoubleBuffered(true); 
        this.addKeyListener(keyH);
        this.setFocusable(true); 
    }
    
    public void startGameThread() { gameThread = new Thread(this);
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
        if(keyH.upPressed == true){ 
            characterY -= characterSpeed; 
        } else if(keyH.downPressed == true) {
            characterY += characterSpeed; 
        } else if(keyH.leftPressed == true) {
            characterX -= characterSpeed; 
        } else if(keyH.rightPressed == true) {
            characterX += characterSpeed; 
        } 
    } 
    
    public void paintComponent(Graphics g) {
    super.paintComponent(g);
    
    Graphics2D g2 = (Graphics2D)g; 
    g2.setColor(Color.white);
    g2.fillRect(characterX, characterY, tileSize, tileSize); 
    g2.dispose(); }
}
