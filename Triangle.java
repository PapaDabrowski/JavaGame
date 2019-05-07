import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;

/** Jest to klasa obiektu -> kwadratu ,która przechowuje informacje na
* temat obiektu generowanego w oparciu o tą classę
*/

public class Triangle extends GameObject {

  Random r = new Random();
  int [] X_Points;
  int [] Y_Points;


  /**
  *konstruktor
  */
  public Triangle(int X_position, int Y_position,ID ID) {
    super(X_position,Y_position,ID);
    X_Points = new int[]{X_position,X_position+20,X_position+40};
    Y_Points = new int[]{Y_position+35,Y_position,Y_position+35};
    X_Velocity = r.nextInt(5);
    Y_Velocity = r.nextInt(5);

  }

  public void tick() {

  for(int i = 0; i < 3; i++) {
    X_Points[i] += X_Velocity;
    Y_Points[i] += Y_Velocity;
    if(Y_Points[1] <= 0 || Y_Points[1] >= 537 - 32) Y_Velocity*=-1;
    if(X_Points[1] <= 0 || X_Points[1] >= 924 - 32) X_Velocity*=-1;
  }


  }

  public void render(Graphics g) {
    g.setColor(Color.blue);
    g.fillPolygon(X_Points,Y_Points,3);
  }
}
