import java.util.HashMap;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.Graphics2D;


/*
public class GuiScreen {

  private static GuiScreen screen;
  private HashMap <String,GuiPanel> panels;
  private String currentPanel = "";

  private GuiScreen() {
    panels = new HashMap<String,GuiPanel>();
  }

  public static GuiScreen getInstance() {
    if(screen == null) screen = new GuiScreen();

    return screen;
  }

  public void update() {
    if(panels.get(currentPanel) != null){
      panels.get(currentPanel).update();
    }
  }

  public void render(Graphics2D g) {
    if(panels.get(currentPanel) != null){
      panels.get(currentPanel).render(g);
    }
  }

  public void add(String panelName,GuiPanel panel){
    panels.put(panelName,panel);
   }

   public void setCurrentPanel(String panelName) {
     currentPanel = panelName;
   }

   public void mousePressed(MouseEvent e) {
     if(panels.get(currentPanel) != null)
        panels.get(currentPanel).mousePressed(e);
   }

   public void mouseRelesed(MouseEvent e) {
     if(panels.get(currentPanel) != null)
        panels.get(currentPanel).mouseRelesed(e);
   }

   public void mouseDragged(MouseEvent e) {
     if(panels.get(currentPanel) != null)
        panels.get(currentPanel).mouseDragged(e);
   }

   public void mouseMoved(MouseEvent e) {
     if(panels.get(currentPanel) != null)
        panels.get(currentPanel).mouseMoved(e);
   }






 }
*/