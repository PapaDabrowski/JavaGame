import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileInputStream;
import java.awt.Font;


 /** Jest to klasa HU Display , wyświetla informacje
 * o aktualnym stanie zasobów gracza podczas gry.
 * @version 15:20 08.04.2019
 * @author PapaDabrowski
 */


public class HUD {

  int alpha;
  Color BackgroundOfHud;
  double HeightRatio;
  double WidthRatio;
  Font font,font2;
  public static int Score = 0;


  public void tick() {
    
  }
  public void render(Graphics g, int Height, int Width, int Ammo, int MaxAmmo) {


    /**
    * Tutaj mamy wczytanie customowej czcionki ,której potrzebujemy
    */

    try {
      font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("big_noodle_titling.ttf"))).deriveFont(Font.PLAIN,(int)(Height/22.45833));
      font2 = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("big_noodle_titling.ttf"))).deriveFont(Font.PLAIN,(int)(Height/9.9814));
      }catch (Exception ex)
    {
      ex.printStackTrace();
    }


    /**
    * To jest tło pod hud w prawym dolnym rogu ekranu
    */
    HeightRatio = 4.491666;
    WidthRatio = 5.13333;
    int alpha = 127;
    Color BackgroundOfHud = new Color(50, 50, 50, alpha);
    g.setColor(BackgroundOfHud);
    g.fillRect((14*Width/18),(16*Height/24), (int) (Width/WidthRatio), (int) (Height/HeightRatio));

    /**
    * To jest tło pod hud w lewym górnym rogu ekranu pod tzw "Score"
    */
    HeightRatio = 15.7208131;
    WidthRatio = 6.6733329;
    g.setColor(BackgroundOfHud);
    g.fillRect((3*Width/72),(3*Height/96), (int) (Width/WidthRatio), (int) (Height/HeightRatio));

    /**
    * To jest zasadniczo napis "Score"
    */
    g.setFont(font);
    g.setColor(Color.white);
    g.drawString("Score: " + Score,(1*Width/18),(7*Height/96));

    /**
    * To jest napis ammo w prawym dolnym rogu
    */
    g.setFont(font);
    g.setColor(Color.white);
    g.drawString("Ammo:",(86*Width/108),(70*Height/96));

    /**
    * To jest informacja o stanie amunicji w magazyku!
    */
    g.setFont(font2);
    g.setColor(Color.white);
    g.drawString( Ammo +"/"+ MaxAmmo,(15*Width/18),(20*Height/24));
  }
}
