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


/**
   To jest klasa gry , głowna klasa zawierająca maina()
*/
public class Game extends Canvas implements Runnable {

  /**
  Default Size of a Window of a Window
  */
  public static final int WidthOfWindow = 1280, HeightOfWindow = 720;

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

  /**
  * To jest miejsce gdzie przechowywujemy informacje o stanie naszej gry
  * Dzięki enum łatwiej będzie programiście ,który będzie przeglądał ten kod
  * Zrozumieć go , niż w przypadku kiedy zamiast stanów w formie enum
  * korzystalibyśmy ze stanów w formie int -> 1-Menu , 2-Game ....
  */
  public enum STATE {
    Menu,
    Game
  };

  public STATE gameState = STATE.Menu;

  /**
  Ta metoda tworzy okno gry , korzysta z klasy Window , metoda nie przyjmuje argumentów przy wywołaniu
  */
  public Game() {

    handler = new Handler();

    new Window(WidthOfWindow,HeightOfWindow,"Tutaj wstawić zmienną TitleOfTheGame",this);
    menu = new Menu();
    if(gameState == STATE.Game)
    {
      r = new Random();
      for(int i=0; i<50;i++) {
        handler.addObject(new Square(0,0,i)) ;
      }
    }
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
    try {
      thread.join();
      running = false;
      }catch(Exception StopProblem) {
        StopProblem.printStackTrace();
      }
  }

  /**
  *Główna pętla gry , Game Loop from MineCraft , created probably by Notch ... DONE
  */
  public void run(){
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

  /**
  * W tym ifie pojawią się pewne metody, lecz w momencie oddawania Etapu 2
  * owych funkcjonalności jeszcze nie ma ale pozostawiam ifa aby pamiętać ,że należy tutaj do niego wrócić ...
  */
  private void tick() {
    handler.tick();

    if(gameState == STATE.Game){}
      else if(gameState == STATE.Menu) {
        menu.tick();
      }
  }


  private void render() {
    BufferStrategy Var_BufferStrategy = this.getBufferStrategy();
    if(Var_BufferStrategy==null){
      this.createBufferStrategy(3); //This is how much buffers are created in Game
      return;
    }
    Graphics g = Var_BufferStrategy.getDrawGraphics();
    g.setColor(Color.green);
    g.fillRect(0,0,WidthOfWindow,HeightOfWindow);

    handler.render(g);


    if(gameState == STATE.Game){}
      else if(gameState == STATE.Menu) {
        menu.render(g);
      }
    g.dispose();
    Var_BufferStrategy.show();
  }

  public static void main(String args[]) {
    new Game();
  }

}
