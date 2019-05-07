
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.awt.Image;
import java.awt.image.ImageObserver;
import javax.swing.ImageIcon;
import java.awt.Toolkit;import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


/** Jest to klasa menu w naszej grze , tak naprawdę cała obsługa gry jest
 * wykonywana przez tą klasę ,więc trzeba zwrócić na nią szczególną uwagę
 * @version 15:20 08.04.2019
 * @author PapaDabrowski
 * W tym pliku dodać obsługe tego drugiego menmu i usuwanie , w sumie to powinienem porpawić mouse
 * relesed bo bez tego to się wszystk opierdoli  mimo ze powinno banglać kurwa jak ta lala mimo innych
 * z dwóch różnych Klass to pewnie kurwa się ogarnie jak napiszę ten mouse relesed
 */

public class Menu extends MouseAdapter {

  Font font,font2,font3;
  double HeightRatio;
  double WidthRatio;
  private Game game;
  private Handler handler;
  int Height,Width;
  AudioPlayer audioPlayer;
  int Ammo,Max_Ammo;


  public Menu(Game game,Handler handler,ParameterContainer Container) {
    this.game = game;
    this.handler = handler;
    Height = Container.getHeightOfWindow();
    Width = Container.getWidthOfWindow();
    audioPlayer = new AudioPlayer();

    if(game.choosedWeapon == WEAPON.AK47) {
      Max_Ammo = 30;
      Ammo = 30;
    }
    else if (game.choosedWeapon == WEAPON.M4A4) {
      Max_Ammo = 25;
      Ammo = 25;
    }
    else {
      Max_Ammo = 10;
      Ammo = 10;
    }
  }

  public void mousePressed(MouseEvent e) {
    int mx = e.getX();
    int my = e.getY();

   /**
   *play button
   */
   if(game.gameState == STATE.Menu)
   {
    if(mouseOver(mx,my,0,2*(Height/10),(int)(Width/3.08),(int)(Height/7.7))) {
       game.gameState = STATE.WeaponSelect;
     }

   //help -> out of order yet
   if(mouseOver(mx,my,0,4*(Height/10),(int)(Width/3.08),(int)(Height/7.7))) {
     game.gameState = STATE.Help;
   }

   /**
   *Quit button
   */
   if(mouseOver(mx,my,0,6*(Height/10),(int)(Width/3.08),(int)(Height/7.7))) {
      System.exit(1);
    }

   }else if(game.gameState == STATE.WeaponSelect)
   {
     if(mouseOver(mx,my,108*(Width/924),140*(Height/537),(200*Width)/924,(456*Height)/1000)) {
       game.choosedWeapon = WEAPON.AK47;
       game.gameState = STATE.Game;
       audioPlayer.setFile("AKReload.wav");
       audioPlayer.play();

       }
     if(mouseOver(mx,my,362*(Width/924),140*(Height/537),(200*Width)/924,(456*Height)/1000)) {
       game.gameState = STATE.Game;
       game.choosedWeapon = WEAPON.M4A4;
       }
     if(mouseOver(mx,my,616*(Width/924),140*(Height/537),(200*Width)/924,(456*Height)/1000)) {
       game.gameState = STATE.Game;
       game.choosedWeapon = WEAPON.AWP;
     }
     handler.addObject(new Square(70, 140,ID.Enemy));
     handler.addObject(new Square(90, 140,ID.Enemy));
     handler.addObject(new Square(170, 140,ID.Enemy));
     handler.addObject(new Square(70, 140,ID.Enemy));
     handler.addObject(new Circle(90, 140,ID.Enemy));
     handler.addObject(new Square(170, 140,ID.Enemy));
     handler.addObject(new Square(70, 140,ID.Enemy));
     handler.addObject(new Square(90, 140,ID.Enemy));
     handler.addObject(new Triangle(170, 140,ID.Enemy));
   }
   else if(game.gameState == STATE.Help) {
     game.gameState = STATE.Menu;
   }
   else {
     if(mouseOver(mx,my,0,0,Width,Height)) {
       if(Ammo>0) Ammo -= 1;
       else Ammo = 0;
       game.hud.Score+=100;
       }
    }


   if(game.gameState == STATE.Game) {

   }
 }






  /**
  * Jest to metoda ,która zwraca wartość logiczną położenia myszy w zadanym do metody
  * obszarze , dzięki temu bedziemy mogli stwierdzić czy uruchomic zadaną metodę czy też nie
  */
  private boolean mouseOver(int mx ,int my , int x , int y , int width, int height) {
    if(mx > x && mx < x + width)
    {
      if(my > y && my < y + height) {
      return true; }
      else return false;
    }
    else return false;
  }



  public int getAmmo() { return Ammo ;}
  public int getMaxAmmo() { return Max_Ammo;}
  public void mouseReleased(MouseEvent e){}
  public void tick() {}

  public void render(Graphics g,int Height,int Width){


    try {
      font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("big_noodle_titling.ttf"))).deriveFont(Font.PLAIN,(int)(Height/12));
      font2 = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("big_noodle_titling.ttf"))).deriveFont(Font.PLAIN,Height/6);
      font3 = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("big_noodle_titling.ttf"))).deriveFont(Font.PLAIN,Height/20);

    }catch (Exception ex)
    {
      ex.printStackTrace();
    }

    // Menu główne
    if(game.gameState == STATE.Menu)
    {
    int alpha = 127;
    Color BackgroundOfHud = new Color(50, 50, 50, alpha);
    g.setColor(BackgroundOfHud);
    g.setFont(font2);
    g.drawString("Main Menu",1*(Width/12),1*(Height/6));

    g.setFont(font);
    g.setColor(BackgroundOfHud);
    g.drawString("Play!" ,2*(Width/11),3*(Height/10));

    g.setFont(font);
    g.setColor(BackgroundOfHud);
    g.drawString("Help! ",2*(Width/11),5*(Height)/10);

    g.setFont(font);
    g.setColor(BackgroundOfHud);
    g.drawString("Exit",2*(Width/11),7*(Height/10));

    alpha = 0; // zmień na 0 aby był efekcik xdd
    BackgroundOfHud = new Color (50,50,50,alpha);
    g.setColor(BackgroundOfHud);
    g.drawRect(0,2*(Height/10),(int)(Width/3.08),(int)(Height/7.7));

    g.setColor(BackgroundOfHud);
    g.drawRect(0,4*(Height/10),(int)(Width/3.08),(int)(Height/7.7));

    g.setColor(BackgroundOfHud);
    g.drawRect(0,6*(Height/10),(int)(Width/3.08),(int)(Height/7.7));



    alpha = 20; // zmień na 0 aby był efekcik xdd
    BackgroundOfHud = new Color (30,30,30,alpha);

    g.setFont(font);
    g.setColor(BackgroundOfHud);
    g.drawString("LeaderBoards",8*(Width/12),1*(Height/4));

    g.setColor(BackgroundOfHud);
    g.fillRect(14*(Width/22),3*(Height/10),(260*Width)/1000,(456*Height)/1000);
  }


  // Menu wyboru broni
  else if (game.gameState == STATE.WeaponSelect)
    {
      int alpha = 127;
      Color BackgroundOfHud = new Color(50, 50, 50, alpha);
      //Image imgWeaponSelect = Toolkit.getDefaultToolkit().createImage("WeaponSelect.jpg");
      //g.drawImage(imgWeaponSelect, 0, 0,Width,Height,null);



      //Background elements required to use a menu
      g.setColor(Color.white);
      g.setFont(font2);
      g.drawString("Choose your weapon!",165*(Width/924),105*(Height/537));

      /**
      * Kodowanie części menu odpowiedzialnej za wyświetlanie ak47
      */
      g.setColor(BackgroundOfHud);
      g.fillRect(108*(Width/924),140*(Height/537),(200*Width)/924,(456*Height)/1000);
      g.setColor(Color.white);
      g.setFont(font);
      g.drawString("AK47",180*(Width/923),180*(Height/537));
      g.setFont(font3);
      g.drawString("Accuracy",116*(Width/923),320*(Height/537));
      g.drawString("Damage",116*(Width/923),360*(Height/537));
      g.drawString("Rate Of Fire",116*(Width/923),280*(Height/537));
      g.drawString("Mag Size:  30",116*(Width/923),240*(Height/537));
      g.fillRect(116*(Width/923),328*(Height/537),170*(Width/923),8*(Height/537));
      g.fillRect(116*(Width/923),368*(Height/537),160*(Width/923),8*(Height/537));
      g.fillRect(116*(Width/923),288*(Height/537),120*(Width/923),8*(Height/537));

      /**
      * Kodowanie części menu odpowiedzialnej za wyświetlanie m4a4
      */
      g.setColor(BackgroundOfHud);
      g.fillRect(362*(Width/924),140*(Height/537),(200*Width)/924,(456*Height)/1000);
      g.setColor(Color.white);
      g.setFont(font);
      g.drawString("M4A4",428*(Width/923),180*(Height/537));
      g.setFont(font3);
      g.drawString("Accuracy",370*(Width/923),320*(Height/537));
      g.drawString("Damage",370*(Width/923),360*(Height/537));
      g.drawString("Rate Of Fire",370*(Width/923),280*(Height/537));
      g.drawString("Mag Size:  20",370*(Width/923),240*(Height/537));
      g.fillRect(370*(Width/923),328*(Height/537),150*(Width/923),8*(Height/537));
      g.fillRect(370*(Width/923),368*(Height/537),120*(Width/923),8*(Height/537));
      g.fillRect(370*(Width/923),288*(Height/537),184*(Width/923),8*(Height/537));

      /**
      * Kodowanie części menu odpowiedzialnej za wyświetlanie AWP
      */
      g.setColor(BackgroundOfHud);
      g.fillRect(616*(Width/924),140*(Height/537),(200*Width)/924,(456*Height)/1000);
      g.setColor(Color.white);
      g.setFont(font);
      g.drawString("AWP",688*(Width/923),180*(Height/537));
      g.setFont(font3);
      g.drawString("Accuracy",624*(Width/923),320*(Height/537));
      g.drawString("Damage",624*(Width/923),360*(Height/537));
      g.drawString("Rate Of Fire",624*(Width/923),280*(Height/537));
      g.drawString("Mag Size:  10",624*(Width/923),240*(Height/537));
      g.fillRect(624*(Width/923),328*(Height/537),184*(Width/923),8*(Height/537));
      g.fillRect(624*(Width/923),368*(Height/537),184*(Width/923),8*(Height/537));
      g.fillRect(624*(Width/923),288*(Height/537),20*(Width/923),8*(Height/537));

    }
    else if (game.gameState == STATE.Help)
      {   g.drawString("Destroy all targets with weapon u retardoo!!",100*(Width/923),80*(Height/537));
          g.fillRect(624*(Width/923),328*(Height/537),184*(Width/923),8*(Height/537));
    }

  }
}
