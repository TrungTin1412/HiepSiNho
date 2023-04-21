package main;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class GamePanel extends JPanel implements Runnable{
	//SCREEN SETTING
	final int originalTileSize = 16; //16x16 tile 
	final int scale = 3;
	
	final int tileSize = originalTileSize * scale; //new larger tile: 48x48 
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
	
	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
		
	}

	@Override
	// GAME LOOP//
	public void run() {
		double drawInterval = 1000000000/FPS;//0.166666 seconds
		double nextDrawTime = System.nanoTime() + drawInterval;
		while(gameThread != null) {
			
			//UPDATE: update new information like positions of character.
			update();
			//DRAW: draw the screen with above updated information.  
			repaint();
			
			try {
				double remainingTime = nextDrawTime - System.nanoTime();
				remainingTime = remainingTime / 1000000;//Sleep method just applies time in millisecond
				
				if(remainingTime < 0) {
					remainingTime = 0;
				}
				Thread.sleep((long) remainingTime);
				
				nextDrawTime += drawInterval;
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void update() {
		if(keyH.upPressed == true) {
			characterY -= characterSpeed;
		}
		else if(keyH.downPressed == true) {
			characterY += characterSpeed;
		}
		else if(keyH.leftPressed == true) {
			characterX -= characterSpeed;
		}
		else if(keyH.rightPressed == true) {
			characterX += characterSpeed; 	 	
		}
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.white);
		g2.fillRect(characterX, characterY, tileSize, tileSize);
		g2.dispose();
	}
 
    

}
