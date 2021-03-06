import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;

/**
* Jest to klasa obiektu -> koła ,która przechowuje informacje na
* temat obiektu generowanego w oparciu o tą klasę
* Dziedziczy ona po klasie GameObject , która udostępnia
* odpowiednie zmienne pomocne przy opisie danego obiektu
*/

public class Circle extends GameObject {

  Random r = new Random();

  /**
  *konstruktor
  */
  public Circle(int X_position, int Y_position,ID ID) {
    super(X_position,Y_position,ID);
    X_Velocity = r.nextInt(5);
    Y_Velocity = r.nextInt(5);
  }

  public void tick() {
    X_position += X_Velocity;
    Y_position += Y_Velocity;
    if(Y_position <= 0 || Y_position >= 537 - 32) Y_Velocity*=-1;
    if(X_position <= 0 || X_position >= 924 - 32) X_Velocity*=-1;
  }

  public void render(Graphics g) {
    g.setColor(Color.white);
    g.fillOval(X_position,Y_position,32,32);
  }
}
