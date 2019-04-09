import java.util.HashMap;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;


public class Menu extends MouseAdapter {

  public void mousePressed(MouseEvent e){

  }

  public void mouseRelesed(MouseEvent e){

  }

  public void tick(){}

  public void render(Graphics g){

    Font fnt = new Font("arial",6,50);
    g.setFont(fnt);
    g.setColor(Color.white);
    g.drawString("Menu",250,50);

    Font fnt2 = new Font("arial",6,30);
    g.setColor(Color.white);
    g.drawRect(130,100,300,100);

    g.setFont(fnt2);
    g.setColor(Color.white);
    g.drawString("Start! ",250,170);

    g.setFont(fnt2);
    g.setColor(Color.white);
    g.drawString("Wczytaj Grę! ",250,370);

    g.setColor(Color.white);
    g.drawRect(130,300,300,100);

    g.setFont(fnt2);
    g.setColor(Color.white);
    g.drawString("Wyjście",250,570);

    g.setColor(Color.white);
    g.drawRect(130,500,300,100);

    //last
    g.setColor(Color.white);
    g.drawRect(700,100,400,400);

    g.setFont(fnt2);
    g.setColor(Color.white);
    g.drawString("Wyniki",900,300);
  }
}
