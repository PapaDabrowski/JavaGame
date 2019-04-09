import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;

public class Square extends GameObject {

  Random r = new Random();

  public Square(int X_position, int Y_position,int ID) {
    super(X_position,Y_position,ID);
    X_Velocity = r.nextInt(5);
    Y_Velocity = r.nextInt(5);
  }

  public void tick() {
    X_position += X_Velocity;
    Y_position += Y_Velocity;
  }

  public void render(Graphics g) {
    g.setColor(Color.white);
    g.fillRect(X_position,Y_position,32,32);
  }
}
