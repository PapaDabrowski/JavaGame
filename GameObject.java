import java.awt.Graphics;

public abstract class GameObject {

  protected int X_position,Y_position;
  protected int X_Velocity,Y_Velocity;
  protected int ID;

  public GameObject(int X_position,int Y_position,int ID) {
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

  public void setID(int ID) {
    this.ID=ID;
  }

  public int getID() {
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
