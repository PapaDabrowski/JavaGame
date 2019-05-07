import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.Properties;
import java.util.Random;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.Image;
import java.awt.image.ImageObserver;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

/**
   To jest klasa gry , głowna klasa zawierająca maina()
*/


public class Game extends Canvas implements Runnable {

   /**
  *Variables of GameStart and GameClo
  */
  private Thread thread;
  private boolean running=true;

  /**
  *Instance of our Handlerer
  */
  private Handler handler;
  private Random r;
  private Menu menu;
  public HUD hud;

  /**
  * Zmienne potrzebne do obsługi wartości podawanych do hud
  */
  private int Game_Max_Ammo;
  private int Game_Ammo;
  public WEAPON choosedWeapon = WEAPON.M4A4;  // domyślna wartość poprostu nie ma to znaczenia co tutaj ustawimy

  /**
  *Zmienne niezbędne do wczytywania danych z pliku
  */
  ReaderFromFile FileReader = new ReaderFromFile();
  ParameterContainer Container = new ParameterContainer();

  /**
  * To jest miejsce gdzie przechowywujemy informacje o stanie naszej gry
  * Dzięki enum łatwiej będzie programiście ,który będzie przeglądał ten kod
  * Zrozumieć go , niż w przypadku kiedy zamiast stanów w formie enum
  * korzystalibyśmy ze stanów w formie int -> 1-Menu , 2-Game ....
  */


  public STATE gameState = STATE.Menu; //domyślna wartość STATE




  /**
  Ta metoda tworzy okno gry , korzysta z klasy WindowGenerator , metoda nie przyjmuje argumentów przy wywołaniu
  */

  public Game() {

    Container = FileReader.load();
    handler = new Handler();
    hud = new HUD();
    menu = new Menu(this,handler,Container);
    this.addKeyListener(new KeyInput(handler));
    this.addMouseListener(menu);
    new WindowGenerator(Container.getWidthOfWindow(),Container.getHeightOfWindow(),Container.getTitleOfTheGame(),this);

  }




  /**
  *Metoda która uruchamia grę
  */
  public synchronized void start() {
    thread = new Thread(this);
    thread.start();
    running = true;
    }

  /**
  *Metoda, która odpowiada za wyłączenie gry
  */
  public synchronized void stop() {
    try
    {
      thread.join();
      running = false;
    }
    catch(Exception StopProblem)
    {
      StopProblem.printStackTrace();
    }
  }

  /**
  *Główna pętla gry , Game Loop from MineCraft , created probably by Notch ... DONE
  */
  public void run() {

    long lastTime = System.nanoTime();
    double amountOfTricks = 60.0;
    double ns = 1000000000 /amountOfTricks;
    double delta = 0;
    long timer = System.currentTimeMillis();
    int frames = 0;
    while(running){
      long now = System.nanoTime();
      delta += (now-lastTime) /ns;
      lastTime = now;
      while(delta >= 1){
        tick();
        delta--;
      }
      if(running)
        render();
      frames++;
      if(System.currentTimeMillis() - timer > 1000){
        timer += 1000;
        System.out.println("FPS: " + frames);
        frames=0;
      }
    }
    stop();
  }

 private void tick() {

handler.tick();

    if(gameState == STATE.Game)
    {
      hud.tick();
    }
    else if(gameState == STATE.Menu || gameState == STATE.WeaponSelect || gameState == STATE.Help)
    {
      menu.tick();
    }
 }


  /**
  * Metoda render(), która korzysta z BufferStrategy ,
  */
  private void render() {
    this.requestFocus();
    BufferStrategy Var_BufferStrategy = this.getBufferStrategy();
    if(Var_BufferStrategy==null){
      this.createBufferStrategy(3); //This is how much buffers are created in Game
      return;
    }
    Graphics g = Var_BufferStrategy.getDrawGraphics();

    Image img = Toolkit.getDefaultToolkit().createImage("background.jpg");
    if(gameState == STATE.Game) {
      g.setColor(Color.black);
      g.fillRect(0,0,Container.getWidthOfWindow(),Container.getHeightOfWindow());
      }
    else if(gameState == STATE.Menu || gameState == STATE.WeaponSelect || gameState == STATE.Help) {
      g.drawImage(img, 0, 0,Container.getWidthOfWindow(),Container.getHeightOfWindow(),null);
    }

    handler.render(g);

    if(gameState == STATE.Game)
    {
      hud.render(g,Container.getHeightOfWindow(),Container.getWidthOfWindow(),menu.getAmmo(),menu.getMaxAmmo());
    }
    else if(gameState == STATE.Menu || gameState == STATE.WeaponSelect || gameState == STATE.Help)
    {
      menu.render(g,Container.getHeightOfWindow(),Container.getWidthOfWindow());
    }
    g.dispose();
    Var_BufferStrategy.show();
  }


  public static void main(String args[]) {
    new Game();
  }

}
