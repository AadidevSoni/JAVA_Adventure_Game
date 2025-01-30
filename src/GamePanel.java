import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{

  //SCREEN SETTINGS
  public final int originalTileSize = 16;  //16x16 tile
	public final int scale = 3; //16 x 3 = 48   ->  48x48 tile as all characters and blocks are designed in 16x16 which is too small nowadays
	
	public final int tileSize = originalTileSize * scale;  //48x48 tile
	public final int maxScreenCol = 16;  //4:3 window
	public final int maxScreenRow = 12;
	public final int screenWidth = maxScreenCol * tileSize;  //16*48 = 768 pixels
	public final int screenHeight = maxScreenRow * tileSize;  //48x12 = 576 pixels

  KeyHandler keyH = new KeyHandler();
  Thread gameThread; //Concept of time - it keeps the game running and requires you to implement runnable
	//when we start this game thread, it automatically calls the run method as it is from the runnable that we implemented

  //set Player's default variables;
  int playerX = 100;
  int playerY = 100;
  int playerSpeed = 5;
  int FPS = 60;
	
  //set player's default position - deleted
	//constructor
  public GamePanel(){
    this.setPreferredSize(new Dimension(screenWidth, screenHeight));
    this.setBackground(Color.BLACK);
    this.setDoubleBuffered(true);
    this.addKeyListener(keyH);
    this.setFocusable(true);
  }
  
  public void startGameThread() {
      gameThread = new Thread(this);   //instantiate a game thread to the gamePanel class
      gameThread.start();  //calls the run method
    }

  @Override
  public void run() {

    double drawInterval = 1000000000/FPS;
    double nextDrawTime = System.nanoTime() + drawInterval;

    while(gameThread != null){

      //long currentTime = System.nanoTime(); //returns the value of running java VM in highest esoultion in nano seconds
			//System.out.println("Current time = " + currentTime);
			
			
			//1 UPDATE - update information such as character information

      update();

      //2 DRAW - draw the screen with the updated information
      repaint();  //this is how we call the paintComponent method

      try {
        double remainingTime = nextDrawTime - System.nanoTime();  //we want the brush to  sleep till its time for the next time to draw
        remainingTime = remainingTime/1000000; //sleep works in millisecs so converting
      
        //if update and repaint took more time than is left then no time is left and we immediately draw the next frame
        if(remainingTime < 0) {
          remainingTime = 0; 
        }
      
        Thread.sleep((long) remainingTime);
      
        nextDrawTime += drawInterval;  //0.016 sec later
      
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

    }
    
  }

  public void update(){

    if(keyH.upPressed == true){
      playerY -= playerSpeed;
    }else if(keyH.downPressed == true){
      playerY += playerSpeed;
    }else if(keyH.leftPressed == true){
      playerX -= playerSpeed;
    }else if(keyH.rightPressed == true){
      playerX += playerSpeed;
    }

  }

  //paintComponent is a built in method in java to draw on the screen
  public void paintComponent(Graphics g){
    super.paintComponent(g); //this is how we make this method work

    Graphics2D g2 = (Graphics2D)g;  //we convert brush to graphics 2d which has more features for drawing
    g2.setColor(Color.WHITE);
    g2.fillRect(playerX, playerY, tileSize, tileSize);

    g2.dispose(); //releases any system resource it is using
  }
  
}
