import java.awt.Graphics;

 /** Jest to klasa która po której tak naprawdę
 * będą dziedziczyć inne obiekty , natomiast sama w sobie
 * klasa nie będzie wykorzystywana jako Obiekt.
 * @author PapaDabrowski
 * @version 15:20 08.04.2019
 */

public abstract class GameObject {

  int X_position,Y_position;
  int X_Velocity,Y_Velocity;
  ID ID;

  public GameObject(int X_position,int Y_position,ID ID) {
    this.X_position=X_position;
    this.Y_position=Y_position;
    this.ID=ID;
  }

  public abstract void tick();
  public abstract void render(Graphics g);

  public void setX(int X_position) {
    this.X_position=X_position;
  }

  public void setY(int Y_position) {
    this.Y_position=Y_position;
  }

  public int getX() {
    return X_position;
  }

  public int getY() {
    return Y_position;
  }

  public void setID(ID ID) {
    this.ID=ID;
  }

  public ID getID() {
    return ID;
  }

  public void setVeloX(int X_Velocity) {
    this.X_Velocity=X_Velocity;
  }

  public void setVeloY(int Y_Velocity) {
    this.Y_Velocity=Y_Velocity;
  }

  public int getVeloX() {
    return X_Velocity;
  }

  public int getVeloY() {
    return Y_Velocity;
  }



}
