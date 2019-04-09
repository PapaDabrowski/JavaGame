/*import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMenu extends GuiPanel {

  private Font titleFont = Game.main.deriveFont(100f);
  private Font creatorFont = Game.main.deriveFont(24f);
  private String title = "WTFreak";
  private int buttonWidth = 220;
  private int spacing = 90;
  private int buttonHeight = 60;

  public MainMenu() {
    super();
    GuiButton playButton = new GuiButton(Game.WidthOfWindow /2 - buttonWidth/2,
                                         220,buttonWidth,buttonHeight);
    GuiButton leaderboardButton = new GuiButton(Game.WidthOfWindow /2 - buttonWidth/2,
                                        playButton.getY()+spacing,buttonWidth,buttonHeight);
    GuiButton quitButton = new GuiButton(Game.WidthOfWindow /2 - buttonWidth/2,
                                        leaderboardButton.getY()+spacing,buttonWidth,buttonHeight);

    playButton.setText("Play");
    leaderboardButton.setText("Leaderboards");
    quitButton.setText("Quit");

    playButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0){}
    });
  }


}
*/
