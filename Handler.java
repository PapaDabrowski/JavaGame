/**
 *Ta klasa będzie generowała i rysowała wszystkie nasze obiekty na naszym ekranie
 *Porusza się po wszystkich obiektach które znajdują się w naszej grze i bedzie je
 *updateować dzięki czemu będziemy mogli obserwować zmiany
 *@author PapaDabrowski
 *@version 22:00 08.04.2019
 */

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {

  /**
  * To jest lista naszych wszystkich obiektów znajdujących się w naszym programie
  */
  LinkedList<GameObject> object = new LinkedList<GameObject>();

  public void tick() {
    for(int i = 0;i < object.size(); i++) {
        GameObject tempObject = object.get(i);

        tempObject.tick();
    }
  }

  public void render(Graphics g) {
    for(int i = 0; i < object.size();i++) {
      GameObject tempObject = object.get(i);

      tempObject.render(g);
    }
  }

  public void addObject(GameObject object) {
    this.object.add(object);
  }

  public void removeObject(GameObject object) {
    this.object.remove(object);
  }

}
