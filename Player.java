import java.awt.Graphics;
import java.awt.Color;

public class Player extends GameObject {

  public Player(int X_Position, int Y_Position , ID ID) {
    super(X_Position,Y_Position,ID);
  }

  public void tick() {

  }

  public void render(Graphics g) {
    g.setColor(Color.red);
    g.fillRect(X_position,Y_position,32,32);
  }
}
