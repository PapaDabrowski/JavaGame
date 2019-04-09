import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;


public class Window extends Canvas {

  //Constructor
  public Window(int width, int height,String title,Game game) {

    JFrame WindowOfGame = new JFrame(title); //JFrame object creating

    //Default Dimensions for WindowGenerator

    WindowOfGame.setPreferredSize(new Dimension(width,height));
    WindowOfGame.setMaximumSize(new Dimension(width,height));
    WindowOfGame.setMinimumSize(new Dimension(width,height));

    //Basic settings of window

    WindowOfGame.setDefaultCloseOperation(JFrame .EXIT_ON_CLOSE);
    WindowOfGame.setResizable(true);
    WindowOfGame.setLocationRelativeTo(null);
    WindowOfGame.setVisible(true);
    WindowOfGame.setAlwaysOnTop(true);

    WindowOfGame.add(game);
    game.start();
  }
}
