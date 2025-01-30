import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{

  public final int originalTileSize = 16;
	public final int scale = 3;
	
	public final int tileSize = originalTileSize * scale;
	public final int maxScreenCol = 16;
	public final int maxScreenRow = 12;
	public final int screenWidth = maxScreenCol * tileSize;
	public final int screenHeight = maxScreenRow * tileSize;

  Thread gameThread;
	
  public GamePanel(){
    this.setPreferredSize(new Dimension(screenWidth, screenHeight));
    this.setBackground(Color.BLACK);
    this.setDoubleBuffered(true);
  }

  public void startGameThread() {
      gameThread = new Thread(this);
      gameThread.start();
    }

  @Override
  public void run() {
    
  }
  
}
