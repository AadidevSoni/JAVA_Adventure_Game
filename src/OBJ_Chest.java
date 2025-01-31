import java.io.IOException;
import javax.imageio.ImageIO;

public class OBJ_Chest extends SuperObject{

  public OBJ_Chest() {
      this.name = "Chest";

      try {
         this.image = ImageIO.read(this.getClass().getResourceAsStream("/chest.png"));
      } catch (IOException var2) {
         var2.printStackTrace();
      }

   }
  
}
