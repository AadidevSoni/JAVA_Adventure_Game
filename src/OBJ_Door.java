import java.io.IOException;
import javax.imageio.ImageIO;

public class OBJ_Door extends SuperObject{

  public OBJ_Door() {
      this.name = "Door";

      try {
         this.image = ImageIO.read(this.getClass().getResourceAsStream("/door.png"));
      } catch (IOException var2) {
         var2.printStackTrace();
      }

   }
  
}
