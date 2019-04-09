import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

/** To jest klasa ,która użycza metody wczytywania pliku i odpowiedniego dopasowywnia
 * wczytanych parametrów do odpowiednich miejsc w konstruktorze naszego kontenera.
 * Klasa korzysta z instancji klasy pin , aby korzystać z jej metody wypisywania komunikatów i
 * zakończenia . Klasa wykorzystuje BufferedReader , Reader , FileReader i Properties.
 * Odpowiednio wybiera odpowiedni przeciążony konstruktor klasy ParameterContainer i metoda load()
 * zwraca obiekt typu ParameterContainer . Klasa ReaderFromFile zawiera tylko jedną stałą typu PIN.
 * @author PapaDabrowski
 * @version 16:20 08.04.2019
 */

public class ReaderFromFile {

  private final PIN pin = PIN.PIN;

   public ParameterContainer load() {
     Properties pr = new Properties();
     try (Reader r = new BufferedReader(new FileReader("par.txt"))){
       pr.load(r);
     }
     catch (FileNotFoundException NotFound)
     {
       pin.wypiszKomunikatyIZakończ("Nie udało się odnaleźć pliku","par.txt",NotFound);
     }
     catch (IOException IOE)
     {
       pin.wypiszKomunikatyIZakończ("Nie udało się odczytać pliku","par.txt",IOE);
     }

    int Background_Colour[]= new int[3];
    String FileOfBackground = "";
    String Graphics_Object = "";
    String ShapeOfObject = "";
    String FileOfObject = "";
    boolean Color = true;
    ParameterContainer temp;

    String TitleOfTheGame = pr.getProperty("nazwaGry");
    int AmountOfLevels = Integer.parseInt(pr.getProperty("liczbaPoziomów"));
    String NoIdeaWTFREAKitIS = pr.getProperty("nazwaBazowaPlikuZOpisemPoziomu");
    int FirstLevelVar = Integer.parseInt(pr.getProperty("numeracjaPoziomówZaczynaSięOd"));
    String NoIdeaWTFREAKitIS2 = pr.getProperty("rozszerzeniePlikuZOpisemPoziomu");
    int LevelsOfDifficulty = Integer.parseInt(pr.getProperty("liczbaStopniTrudności"));
    int Difficulty = Integer.parseInt(pr.getProperty("zmianaStopniaTrudności"));
    int File_WidthOfWindow= Integer.parseInt(pr.getProperty("początkowaSzerokośćPlanszy"));
    int File_HeightOfWindow= Integer.parseInt(pr.getProperty("początkowaWysokośćPlanszy"));
    double SizeProcentage = Double.parseDouble(pr.getProperty("początkowaSzerokośćObiektuGryJakoProcentPoczątkowejSzerokościPlanszy"));
    String Background = pr.getProperty("tło");

    if(Background.equals("plikGraficzny"))
             FileOfBackground= pr.getProperty("plikTła");

    if(Background.equals("jednolite")) {
			Color=true;
			String[] Var_BackgroundColor = (pr.getProperty("kolorTła")).split(" ");
			int AmountOfColor = Var_BackgroundColor.length;
			Background_Colour= new int[AmountOfColor];
			for(int i=0; i<AmountOfColor;i++)
          Background_Colour[i]=Integer.parseInt(Var_BackgroundColor[i]);
    }
		Graphics_Object = pr.getProperty("obiektyGry");

    if(Graphics_Object.equals("figuryGeometryczne"))
          ShapeOfObject = pr.getProperty("figuraObiektuGry");

    if(Graphics_Object.equals("plikGraficzny"))
          FileOfObject = pr.getProperty("plikObiektu");

    int Hitpoints = Integer.parseInt(pr.getProperty("HitPoints"));
    int AmountOfScores = Integer.parseInt(pr.getProperty("LiczbaWynikow"));

    if(Background.equals("jednolite") && Graphics_Object.equals("figuraObiektuGry")) {
      temp = new ParameterContainer(TitleOfTheGame,AmountOfLevels,NoIdeaWTFREAKitIS,FirstLevelVar,NoIdeaWTFREAKitIS2,
                                                       LevelsOfDifficulty,Difficulty,File_HeightOfWindow,File_WidthOfWindow,SizeProcentage,
                                                       Background,Graphics_Object,AmountOfScores,Hitpoints,Background_Colour,ShapeOfObject);
    }
    else if(Background.equals("jednolite") && Graphics_Object.equals("plikGraficzny")) {
      temp = new ParameterContainer(TitleOfTheGame,AmountOfLevels,NoIdeaWTFREAKitIS,FirstLevelVar,NoIdeaWTFREAKitIS2,
                                                       LevelsOfDifficulty,Difficulty,File_HeightOfWindow,File_WidthOfWindow,SizeProcentage,
                                                       Background,Graphics_Object,AmountOfScores,Hitpoints,Background_Colour,FileOfObject);
    }
    else if(Background.equals("plikGraficzny") && Graphics_Object.equals("figuraObiektuGry")) {
      temp = new ParameterContainer(TitleOfTheGame,AmountOfLevels,NoIdeaWTFREAKitIS,FirstLevelVar,NoIdeaWTFREAKitIS2,
                                                       LevelsOfDifficulty,Difficulty,File_HeightOfWindow,File_WidthOfWindow,SizeProcentage,
                                                       Background,Graphics_Object,AmountOfScores,Hitpoints,FileOfBackground,ShapeOfObject);
    }
    else{
      temp = new ParameterContainer(TitleOfTheGame,AmountOfLevels,NoIdeaWTFREAKitIS,FirstLevelVar,NoIdeaWTFREAKitIS2,
                                                       LevelsOfDifficulty,Difficulty,File_HeightOfWindow,File_WidthOfWindow,SizeProcentage,
                                                       Background,Graphics_Object,AmountOfScores,Hitpoints,FileOfBackground,FileOfObject);
    }

    return temp;
  }


  public static void main(String[] args) {
     ReaderFromFile ReaderInstance = new ReaderFromFile();
     ParameterContainer Container = new ParameterContainer();
     Container = ReaderInstance.load();
     System.out.println(Container.getDifficulty());
  }
}
