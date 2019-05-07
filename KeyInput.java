
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

  private Handler handler;

  public KeyInput(Handler handler) {
    this.handler = handler;
  }

  public void keyPressed(KeyEvent e) {
    int key = e.getKeyCode();
    for(int i = 0 ; i < handler.object.size(); i++) {
      GameObject tempObject = handler.object.get(i);

      if(tempObject.getID() == ID.Player) {
        if(key == KeyEvent.VK_W) tempObject.setY(tempObject.getY() - 1);
      }
    }

    System.out.println(key);

  }

  public void keyReleased(KeyEvent e) {
    int key = e.getKeyCode();

  }
}
