import java.util.HashMap;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

/** Jest to klasa przechowująca informacje i metody
* na temat obsługi menu w naszej grze
 * @version 15:20 08.04.2019
 */

public class Menu extends MouseAdapter {

  public void mousePressed(MouseEvent e){}

  public void mouseRelesed(MouseEvent e){}

  public void tick(){}

  public void render(Graphics g,int Height,int Width){

    Font fnt = new Font("arial",6,50);
    Font fnt2 = new Font("arial",6,30);

    g.setFont(fnt);
    g.setColor(Color.white);
    g.drawString("Menu",2*(Width/12),1*(Height/6));

    g.setFont(fnt2);
    g.setColor(Color.white);
    g.drawString("Start! ",2*(Width/11),3*(Height/10));

    g.setFont(fnt2);
    g.setColor(Color.white);
    g.drawString("Wczytaj Grę! ",2*(Width/11),5*(Height)/10);

    g.setFont(fnt2);
    g.setColor(Color.white);
    g.drawString("Wyjście",2*(Width/11),7*(Height/10));

    g.setFont(fnt2);
    g.setColor(Color.white);
    g.drawString("Wyniki",8*(Width/12),1*(Height/4));


    //last
    g.setColor(Color.white);
    g.drawRect(13*(Width/22),3*(Height/10),(312*Width)/1000,(456*Height)/1000);

  }
}
