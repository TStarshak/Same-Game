import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.event.EventHandler;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import javafx.scene.paint.Color;
import java.awt.Desktop;
import java.net.URI;
import java.io.IOException;
import java.net.URISyntaxException;


/**
 * The class SameGame represents a variant of the Same Game. 
 * @author Trey Starshak
 */
public class SameGame extends Application {
  
  //Represents the gameboard
  private static GameButton[][] board; 
  
  //Stores the url of the video to be played on win.  Video: "Congratulations!!!" published by VerticalMule
  private static String winURL = "https://www.youtube.com/watch?v=1Bix44C1EzY";
  
  //Stores the url of the video to be played on lose.  Vide: "When You Try Your Best But You Don't Succed - Vine/Meme" published by Footbal Match-up
  private static String lossURL = "https://www.youtube.com/watch?v=adYloWQmgBQ";
  
  //Stores the integer value of the gamemode.  0 = cross, 1 = star, 2 = same.
  private static int gameMode;
  
  
  /**
   * Returns the board field
   * @return the board field
   */
  public GameButton[][] getBoard() {
    return board;
  }
  
  
  /**
   * Returns the gameMode field
   * @return gameMode the integer representation of the gamemode.
   */
  public int getGameMode() {
    return this.gameMode;
  }
  
  
  /**
   * Updates the value of the gameMode field
   * @param gameMode the integer value of the gamemode
   */
  public void setGameMode(int gameMode) {
    this.gameMode = gameMode;
  }
  
  
  /**
   * Sets the value of the board field
   * @param board the GameButton[][] used to create the board.
   */
  public void setBoard(GameButton[][] board) {
    this.board = board;
  }
  
  
  /**
   * Returns the the winURL field
   * @return the winURL field
   */
  public String getWinURL() {
    return this.winURL;
  }
  
  
  /**
   * Returns the lossURL field
   * @return the lossURL field
   */
  public String getLossURL() {
    return this.lossURL;
  }
  
  
  /**
   * Checks if the game has been won.
   * The same game is won if the bottom left corner button is grey.  
   * @param array the GameButton[][] to be check for a win
   * @return the boolean that is whether or not the game has been won
   */
  public boolean isWon(GameButton[][] array) {
    return array[array.length - 1][0].isColor(Color.LIGHTGRAY);
  }
  
  
  /**
   * Checks if the game has been lost
   * The SameGame has been lost if no button that's in play has an adjacent button of the same color
   * @param array the GameButton[][] to be checked for a loss
   * @return loss the boolean that is whether or not the game has been lost
   */
  public boolean isLost(GameButton[][] array) {
    boolean loss = !isWon(array);                                                        //Stores if there is non adjacent buttons of the same color
    /**
     * Goal: Check if any buttons in the GameButton[][] have buttons of the same color below or to the right
     */
    for(int i = 0; i < array.length; i++) {
      for(int j = 0; j < array[i].length; j++) {
        //Checks to make sure light gray buttons are not included
        if(!array[i][j].isColor(Color.LIGHTGRAY)) {
          //Checks below the current button, if there is a button below
          if(i != array.length - 1) {
            if(array[i][j].isColor(array[i + 1][j].getColor())) {
              loss = false;
            }
          }
          //Checks for buttons to the right
          if(j != array[i].length - 1) {
            if(array[i][j].isColor(array[i][j + 1].getColor())) {
              loss = false;
            }
          }
        }
      }
    }
    return loss;
  }
    
  /**
   * Parses gamemode from user input
   * @param mode the string submitted by the user via the command line
   * @return int the integer representation of the gamemode
   */
  public int parseGameMode(String mode) {
    //some possible variants are included into the check
    if(mode.equals("Cross") || mode.equals("cross") || mode.equals("CrossGame") || mode.equals("crossGame") || mode.equals("crossgame") || mode.equals("0")) {
      return 0;
    }
    if(mode.equals("Star") || mode.equals("star") || mode.equals("StarGame") || mode.equals("starGame") || mode.equals("stargame") || mode.equals("1")) {
      return 1;
    }
    //If the input is not covered by these checks, a non-existent gametype will be returned. 
    return -1;
  }
    
  
  /**
   * Sets the color of connected buttons of the same color to gray
   * @param button the button that was clicked
   */
  public void crossScan(GameButton button) {
    Color color = button.getColor();
    if(button.getTopButton() != null && button.getTopButton().isColor(color)) {
      GameButton btn = button;                                                  //Stores the current GameButton while iterating.
      /**
       * Goal: Change the connected path of buttons with the same color above the initial button to gray
       */
      while(btn != null && (btn.isColor(color) || btn == button)) {
        btn.updateColor(Color.LIGHTGRAY);
        btn = btn.getTopButton();
      }
    }
    if(button.getBottomButton() != null && button.getBottomButton().isColor(color)) {
      GameButton btn = button;                                                  //Stores the current GameButton while iterating.
      /**
       * Goal: Change the connected path of buttons with the same color below the initial button to gray
       */
      while(btn != null && (btn.isColor(color) || btn == button)) {
        btn.updateColor(Color.LIGHTGRAY);
        btn = btn.getBottomButton();
      }
    }
    if(button.getLeftButton() != null && button.getLeftButton().isColor(color)) {
      GameButton btn = button;                                                  //Stores the current GameButton while iterating.
      /**
       * Goal: Change the connected path of buttons with the same color to the left of the initial button to gray
       */
      while(btn != null && (btn.isColor(color)) || btn == button) {
        btn.updateColor(Color.LIGHTGRAY);
        btn = btn.getLeftButton();
      }
    }
    if(button.getRightButton() != null && button.getRightButton().isColor(color)) {
      GameButton btn = button;                                                  //Stores the current GameButton while iterating.
      /**
       * Goal: Change the connected path of buttons with the same color to the right of the initial button to gray
       */
      while(btn != null && (btn.isColor(color) || btn == button)) {
        btn.updateColor(Color.LIGHTGRAY);
        btn = btn.getRightButton();
      }
    }
  }
  
  
  /**
   * Sets the color of connected buttons of the same color to gray
   * @param button the button that was clicked
   * @param color the color to look for - needed because crossScan is called first and will set button to grey.
   */  
  public void starScan(GameButton button) {
    Color color = button.getColor();
    crossScan(findLeftButton(button));
    if(button != null) {
      if(button.getTopLeftButton() != null && button.getTopLeftButton().isColor(color)) {
        GameButton btn = button;                                                  //Stores the current GameButton while iterating.
        /**
         * Goal: Change the connected path of buttons with the same color above and to the right of the initial button to gray
         * SubGoal: Remove the diagonal spaces being removed
         */
        while(btn != null && (btn.isColor(color) || btn == button)) {
          btn.updateColor(Color.LIGHTGRAY);
          updateBoard(btn);
          btn = btn.getTopLeftButton();
        }
      }
      if(button.getTopRightButton() != null && button.getTopRightButton().isColor(color)) {
        GameButton btn = button;                                                  //Stores the current GameButton while iterating.
        /**
         * Goal: Change the connected path of buttons with the same color above and to the left of the initial button to gray
         */
        while(btn != null && (btn.isColor(color) || btn == button)) {
          btn.updateColor(Color.LIGHTGRAY);
          updateBoard(btn);
          btn = btn.getTopRightButton();
        }
      }
      if(button.getBottomLeftButton() != null && button.getBottomLeftButton().isColor(color)) {
        GameButton btn = button;                                                  //Stores the current GameButton while iterating.
        /**
         * Goal: Change the connected path of buttons with the same color below amd to the left of the initial button to gray
         */
        while(btn != null && (btn.isColor(color) || btn == button)) {
          btn.updateColor(Color.LIGHTGRAY);
          updateBoard(btn);
          btn = btn.getBottomLeftButton();
        }
      }
      if(button.getBottomRightButton() != null && button.getBottomRightButton().isColor(color)) {
        GameButton btn = button;                                                  //Stores the current GameButton while iterating.
        /**
         * Goal: Change the connected path of buttons with the same color below and to the right of the initial button to gray
         */
        while(btn != null && (btn.isColor(color) || btn == button)) {
          btn.updateColor(Color.LIGHTGRAY);
          updateBoard(btn);
          btn = btn.getBottomRightButton();
        }
      }
    }
  }
    
 
  /**
   * Re-assigns all the color of buttons so that there are no non-gray buttons above gray buttons
   * @param button the button to start updating at
   */
  public static void updateBoard(GameButton button) {
    //Because this method can call itself at the end, a check is made to ensure that a nullpointerexception is not thrown
    if(button != null) {
      GameButton holder = button;                                               //Stores the current button
      /**
       * Goal: Find the lowest button to be removed from a column
       */
      while(holder.getBottomButton() != null && holder.getBottomButton().isColor(Color.LIGHTGRAY)) {
        holder = holder.getBottomButton();
      }
      GameButton btn = holder;                                                  //Stores the bottom-most button that is being removed    
      /**
       * Goal: Positions a placeholder at the first button that is not removed from a column
       */
      while(holder != null && holder.isColor(Color.LIGHTGRAY)) {
        holder = holder.getTopButton();
      }
      /**
       * Goal: Re-assign colors of buttons that are being removed
       */
      while(holder != null) {
        btn.updateColor(holder.getColor());
        holder = holder.getTopButton();
        btn = btn.getTopButton();
      }
      /** 
       * Goal: Set all remaining buttons to gray 
       */
      while(btn != null) {
        btn.updateColor(Color.LIGHTGRAY);
        btn = btn.getTopButton();
      }
     /* Because updateBoard starts at the left most button in a row, a call is made to the next button in the row.
      */
     if(button.getRightButton() != null) {
      updateBoard(button.getRightButton());
      }
    }
  }
    
  
  /**
   * Finds the leftmost button to remove from a row
   * @param button the GameButton that was clicked
   * @return btn the GameButton that is the leftmost button to be removed
   */
  public GameButton findLeftButton(GameButton button) {
    GameButton btn = button;                                                    //Stores the current button
    /**
     * Goal: iterate through until btn is the left-most button in the path of buttons of the same color
     */
    while(btn.getLeftButton() != null && btn.getLeftButton().isColor(Color.LIGHTGRAY)) {
      btn = btn.getLeftButton();
    }
    return btn;
  }
  
  
  /** 
   * Checks the bottom row for any grey buttons and shifts columns over
   * @param array the GameButton[][] storing the GameButtons for the game
   */
  public void checkColumns(GameButton[][] array) {
    /**
     * Goal: Evaluate if the bottom row button of a column is grey
     * SubGoal: Ensure that the difference between two columns is not out of the array's bounds.
     */
    for(int i = 0; i < array[array.length - 1].length - 1; i++) {
      if(array[array.length - 1][i].isColor(Color.LIGHTGRAY)) {
        int shift = findDifference(array[array.length - 1][i]);                 //Stores the number of grey spaces between two buttons
        if(shift + i >= array[array.length - 1].length) {
          shift = array[array.length - 1].length - i - 1;
        }
        /**
         * Goal: replace n columns
         */
        for(int j = 0; j < array.length; j ++) {
          array[j][i].updateColor(array[j][i + shift].getColor());
          array[j][i + shift].updateColor(Color.LIGHTGRAY);
        }
      }
    }
  }
  
  
  /**
   * Opens the computer's default browser to the specified URL
   * @param url the String representation of the URL to open
   */
  public void openURL(String url) {
     if(Desktop.isDesktopSupported()) {
      try {
        Desktop.getDesktop().browse(new URI(url));
      } catch (IOException e) {
        
      } catch (URISyntaxException e1) {
        
      }
    }
  }
  
  
  /**
   * Finds the amount of grey space between a starting button and the next button with color
   * @param button the button to start at
   * @return i the number of spaces between the buttons
   */
  public int findDifference(GameButton button) {
    int i = 0;
    while(button != null && button.isColor(Color.LIGHTGRAY)) {
      button = button.getRightButton();
      i++;
    }
    return i;
  }
  
  
  /**
   * Creates the game board and handles event
   * @param primaryStage the stage passed to start via Application.launch
   */
  @Override
  public void start(Stage primaryStage) {
    String[] parameters = new String[4];                                        //Stores the array of args passed to the main method
    getParameters().getRaw().toArray(parameters);
    int rows = 10;                                                              //Stores the number of rows used to create the board.  Defaults to 10.
    int columns = 10;                                                           //Stores the number of columns used to create the board.  Defaults to 10.
    int colors = 3;                                                             //Stores the number of colors used for the GameButtons.  Defaults to 3
    setGameMode(0);                                                             //Sets the default value of the gamemode to 0 - CrossGame
    //Attempts to convert args from the main method into useable ints. 
    try { 
      //Sets values to default if input value is too large or gamemode is non-existant. Prints an error message if this happens
      if(parseGameMode(parameters[0] ) != -1) {
        setGameMode(parseGameMode(parameters[0]));
      } else System.out.println("Gamemode not found. Defaulting to CrossGame");
      if(Integer.parseInt(parameters[1]) < 25) {
        rows = Integer.parseInt(parameters[1]);
      } else System.out.println("Too many rows.  Defaulting to 10.");
      if(Integer.parseInt(parameters[2]) < 25) {
        columns = Integer.parseInt(parameters[2]);
      } else System.out.println("Too many columns.  Defaulting to 10.");
      if(Integer.parseInt(parameters[3]) < 10) {
        colors = Integer.parseInt(parameters[3]);
      } else System.out.println("Too many colors.  Defaulting to 3.");
     
      //For all caught exceptions, the program uses the defualt values and prints an error message
    } catch (ArrayIndexOutOfBoundsException e0) {
      System.out.println("Bad Input: Not enough arguments.  Defaulting to CrossGame on a 10x10 grid with 3 colors");
    } catch (NumberFormatException e1) {
      System.out.println("Bad Input: Expected a numeric representation of an integer.  Defaulting to CrossGame a 10x10 grid with 3 colors.");
    } catch (NullPointerException e2) {
      System.out.println("Bad Input: Not enough arguments.  Defaulting to CrossGame on a 10x10 grid with 3 colors");
    }
    
    GridPane gridPane = new GridPane();                                         //Stores the GridPane that is used as the Parent root ofthe Scene
    setBoard(new GameButton[rows][columns]); 
    /**
     * Goal: Create GameButtons and add them to the gridpane. 
     * Sub-Goal: set buttons to respond to events
     */
    for(int i = 0; i <= columns - 1; i++) {
      for(int j = 0; j <= rows - 1; j++) {
        getBoard()[j][i] = new GameButton(colors);
        //The numbers 30 and 15 are scales that I have found to be aesthetically pleasing
        gridPane.add(getBoard()[j][i], i * 30, j * 30, 15, 15);
        getBoard()[j][i].setOnAction(new EventHandler<ActionEvent>() {
          /**
           * responds to button clicks.
           * @param e the ActionEvent that occured.
           */
          public void handle(ActionEvent e) {
            GameButton b = (GameButton)(e.getSource());                         //Stores the button that was clicked
            if(getGameMode() == 0) {
              crossScan(b);
            }
            else {
              starScan(b);
            }
            updateBoard(findLeftButton(b));
            checkColumns(getBoard());
            if(isWon(getBoard())) {
              openURL(getWinURL());
            } else if(isLost(getBoard())) {
                openURL(getLossURL());
              }
          }
        });
      }
    }
    GameButton.assignButtons(board);
    Scene scene = new Scene(gridPane);                                          //Stores the scene being shown in the current stage
    primaryStage.setScene(scene);
    primaryStage.show();    
  }
  
  
  /**
   * Executable method that calls the launch method.
   * @param args the String[] from the command line
   */
  public static void main(String args[]) {
    Application.launch(args);
  }
}