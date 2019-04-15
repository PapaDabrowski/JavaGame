import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ComponentEvent;
import javax.swing.JFrame;


 /** Jest to klasa WindowGenerator , owa klasa odpowiada za odpowiedni wygląd okna naszej gry ,
 * wykorzystuje ona metody klasy standardowej javy -> JFrame oraz dziedziczy po klasie
 * Canvas.
 * @version 20:20 03.04.2019
 */

public class WindowGenerator extends Canvas {

  //Constructor
  public WindowGenerator(int width, int height,String title,Game game) {

    JFrame WindowOfGame = new JFrame(title); //JFrame object creating

    /**
    *Generacja okna z użyciem odpowiednich wymiarów podanych przy wywołaniu
    *konstruktora w klasie Game
    */

    WindowOfGame.setPreferredSize(new Dimension(width,height));
    WindowOfGame.setMaximumSize(new Dimension(width,height));
    WindowOfGame.setMinimumSize(new Dimension(width,height));


    /**
    * Ustawianie odpowiednich parametrów naszego okna
    * są to metody standardowe udostępnione przez klasę JFrame
    */
    WindowOfGame.setDefaultCloseOperation(JFrame .EXIT_ON_CLOSE);
    WindowOfGame.setResizable(true);
    WindowOfGame.setLocationRelativeTo(null);
    WindowOfGame.setVisible(true);
    WindowOfGame.setAlwaysOnTop(false);

    WindowOfGame.add(game);
    game.start();
  }
}
