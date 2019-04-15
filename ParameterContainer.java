/** To jest nasz kontener, który przetrzymuje wszystkie
 * wszystkie zmienne, kluczowe dla działania naszego programu
 * znajduje się tutaj parę metod - "getter'ów" , które są potrzebne
 * w celu uzyskania wartości ,które pózniej będziemy mogli przekazać
 * do innych obiektów w naszym programie do tego kontenera wczytujemy za pomocą
 * klasy ReaderFromFile w której jest metoda wczytania i zwrócenia obiektu typu ParameterContainer;
 *Wszystkie zmienne są opisane tak ,że nie ma wątpliwości do czego służą
 *,trudno jest zasadniczo opisać niektóre z nich ,ponieważ są samo tłumaczące.
 * Metody również trudno jest opisać ,ponieważ większość z nich są Getterami lub setterami
 * a jak wiadomo , należą do najprostszego typu metod w klasach.
 * @author PapaDabrowski
 * @version 15:20 08.04.2019
 */

class ParameterContainer {

/** Tutaj znajdują się wszystkie zmienne jakie mogą być potrzebne do przechowywania wartości,
* jakie możemy otrzymać z pliku parametrycznego
*/
  private String TitleOfTheGame;
  private  int AmountOfLevels;
  private String NoIdeaWTFREAKitIS;//nazwa bazowa pliku z opisem poziomu serio nie wiem co to jest ????
  private int FirstLevelVar;
  private String NoIdeaWTFREAKitIS2;// nazwa  rozszerzenie pliku z opisem poziomu
  private int LevelsOfDifficulty;
  private int Difficulty;
  private int HeightOfWindow;
  private int WidthOfWindow;
  private double SizeProcentage;
  private String Background;
  private int Background_Colour[];
  private String FileOfBackground;
  private String Graphics_Object;
  private String ShapeOfObject;
  private String FileOfObject;
  private boolean Color;
  private int AmountOfScores;
  private int Hitpoints;
  //19 Zmiennych

  /**
  *Konstruktor domyślny , niezainicjalizowany -> zwraca wartości -1 , dzięki temu będziemy wiedzieć,
  *że nasz obiekt nie został zainicjalizowany
  */
  ParameterContainer() {
    this.TitleOfTheGame = "";
    this.AmountOfLevels = 1;
    this.NoIdeaWTFREAKitIS = "";
    this.FirstLevelVar = -1;
    this.NoIdeaWTFREAKitIS2 = "";
    this.LevelsOfDifficulty = -1;
    this.Difficulty = -1;
    this.HeightOfWindow = -1;
    this.WidthOfWindow = -1;
    this.SizeProcentage = -1;
    this.Background = "";
    this.Graphics_Object = "";
    this.AmountOfScores = -1;
    this.Hitpoints = -1;
  }

  /**
  *Konstruktor Parametryczny , wykorzystywany w sytuacji gdy przyjmujemy
  *jako tło plik , wtedy wykorzystujemy ten typ Konstruktora , przeciążenie konstruktora pozwala
  *zaoszczędzić pamięć
  */
  ParameterContainer(String TitleOfTheGame,int AmountOfLevels, String NoIdeaWTFREAKitIS,int FirstLevelVar,
                        String NoIdeaWTFREAKitIS2,int LevelsOfDifficulty,int Difficulty,int HeightOfWindow,int WidthOfWindow,
                        double SizeProcentage, String Background, String Graphics_Object, int AmountOfScores, int Hitpoints,String FileOfBackground,String ShapeOfObject_OR_FileOfObject) {

                          this.TitleOfTheGame = TitleOfTheGame;
                          this.AmountOfLevels = AmountOfLevels;
                          this.NoIdeaWTFREAKitIS = NoIdeaWTFREAKitIS;
                          this.FirstLevelVar = FirstLevelVar;
                          this.NoIdeaWTFREAKitIS2 = NoIdeaWTFREAKitIS2;
                          this.LevelsOfDifficulty = LevelsOfDifficulty;
                          this.Difficulty = Difficulty;
                          this.HeightOfWindow= HeightOfWindow;
                          this.WidthOfWindow= WidthOfWindow;
                          this.SizeProcentage = SizeProcentage;
                          this.Background = Background;
                          this.Graphics_Object = Graphics_Object;
                          this.AmountOfScores = AmountOfScores;
                          this.Hitpoints = Hitpoints;
                          this.FileOfBackground = FileOfBackground;
                          this.Color=false;

                          if(Graphics_Object.equals("figuraObiektuGry")) {
                            this.ShapeOfObject = ShapeOfObject_OR_FileOfObject;
                          }
                          else this.FileOfObject = ShapeOfObject_OR_FileOfObject;

                        }

  /**
  *Konstruktor Parametryczny , wykorzystywany w sytuacji gdy przyjmujemy
  *jako tło jednolity kolor, wtedy wykorzystujemy ten typ Konstruktora , przeciążenie konstruktora pozwala
  *zaoszczędzić pamięć , i inaczej korzystać z kontenera w innych miejscach kodu
  */
  ParameterContainer(String TitleOfTheGame,int AmountOfLevels, String NoIdeaWTFREAKitIS,int FirstLevelVar,
                        String NoIdeaWTFREAKitIS2,int LevelsOfDifficulty,int Difficulty,int HeightOfWindow,int WidthOfWindow,
                        double SizeProcentage, String Background, String Graphics_Object, int AmountOfScores, int Hitpoints,int[] Background_Colour,String ShapeOfObject_OR_FileOfObject) {

                          this.TitleOfTheGame = TitleOfTheGame;
                          this.AmountOfLevels = AmountOfLevels;
                          this.NoIdeaWTFREAKitIS = NoIdeaWTFREAKitIS;
                          this.FirstLevelVar = FirstLevelVar;
                          this.NoIdeaWTFREAKitIS2 = NoIdeaWTFREAKitIS2;
                          this.LevelsOfDifficulty = LevelsOfDifficulty;
                          this.Difficulty = Difficulty;
                          this.HeightOfWindow = HeightOfWindow;
                          this.WidthOfWindow= WidthOfWindow;
                          this.SizeProcentage = SizeProcentage;
                          this.Background = Background;
                          this.Graphics_Object = Graphics_Object;
                          this.AmountOfScores = AmountOfScores;
                          this.Hitpoints = Hitpoints;
                          this.Background_Colour = Background_Colour;
                          this.Color=true;

                          if(Graphics_Object.equals("figuraObiektuGry")) {
                            this.ShapeOfObject = ShapeOfObject_OR_FileOfObject;
                          }
                          else this.FileOfObject = ShapeOfObject_OR_FileOfObject;

                        }

  public void setHeightofWindow(int Height) {
    this.HeightOfWindow= Height;
  }

  public void setWidthofWindow(int Width) {
    this.WidthOfWindow = Width;
  }

  String getTitleOfTheGame() {
    return TitleOfTheGame;
  }

  int getAmountOfLevels() {
    return AmountOfLevels;
  }

  String getNoIdeaWTFREAKitIS() {
    return NoIdeaWTFREAKitIS;
  }

  int getFirstLevelVal() {
    return FirstLevelVar;
  }

  String getNoIdeaWTFREAKitIS2() {
    return NoIdeaWTFREAKitIS2;
  }

  int getLevelsofDifficulty() {
    return LevelsOfDifficulty;
  }

  int getDifficulty() {
    return Difficulty;
  }

  int getHeightOfWindow() {
    return HeightOfWindow;
  }

  int getWidthOfWindow() {
    return WidthOfWindow;
  }

  double getSizeProcentage() {
    return SizeProcentage;
  }

  String getBackground() {
    return Background;
  }

  String getGraphics_Object() {
    return Graphics_Object;
  }

  int  getAmountOfScores() {
    return AmountOfScores;
  }

  int getHitpoints() {
    return Hitpoints;
  }

  int[] getBackground_Colour() {
    return Background_Colour;
  }

  String getFileOfBackground() {
    return FileOfBackground;
  }

  String getShapeOfObject() {
    return ShapeOfObject;
  }

  String getFileOfObject() {
    return FileOfObject;
  }

  boolean getColor(){
    return Color;
  }

}
