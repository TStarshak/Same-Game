import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import org.junit.*;

/**
 * The SameGameTester class represents tests of the methods involved with the SameGame class, including methods in the GameButton class that are called in the SameGame class
 * @author Trey Starshak
 */
public class SameGameTester extends Application {
  
 /**
  * Needed Tests
  * 
  * SameGame Tests
  * Setter/Getter?
  * openURL - mention in testing doc
  * start - mention in testing doc
  * handle - mention in testing doc
  * isColor - mention in testing doc
  * updateColor - mention in testing doc
  * 
  * GameButton Tests
  * setter/getter?
  */
  
  private GameButton[][] singleBoard;
  private GameButton[][] crossBoard;
  private GameButton[][] starBoard;
  private GameButton[][] nullBoard;
  private GameButton[][] testBoard;
  private GameButton[][] updateBoard; 
  private GameButton[][] testSingleBoard;
  private GameButton[][] testNullBoard;
  private GameButton[][] winBoard;
  private GameButton[][] loseBoard;
  private GameButton[][] noColumnsBoard;
  private GameButton[][] testNoColumnsBoard;
  private GameButton[][] oneColumnBoard;
  private GameButton[][] testOneColumnBoard;
  private GameButton[][] manyColumnsBoard;
  private GameButton[][] testManyColumnsBoard;
  private GameButton[][] leftBoard;
  private GameButton[][] diffBoard;
  
  public GameButton[][] getSingleBoard() {
    return singleBoard;
  }
  
  public GameButton[][] getCrossBoard() {
    return crossBoard;
  }
  
  public GameButton[][] getStarBoard() {
    return starBoard;
  }
  
  public GameButton[][] getNullBoard() {
    return nullBoard;
  }
  
  public GameButton[][] getTestBoard() {
    return testBoard;
  }
  
  public GameButton[][] getUpdateBoard() {
    return updateBoard;
  }
  
  public GameButton[][] getTestSingleBoard() {
    return testSingleBoard;
  }
  
  public GameButton[][] getTestNullBoard() {
    return testNullBoard;
  }
  
  public GameButton[][] getWinBoard() {
    return winBoard;
  }
  
  public GameButton[][] getLoseBoard() {
    return loseBoard;
  }
  
  public GameButton[][] getNoColumnsBoard() {
    return noColumnsBoard;
  }
  
  public GameButton[][] getTestNoColumnsBoard() {
    return testNoColumnsBoard;
  }
  
  public GameButton[][] getOneColumnBoard() {
    return oneColumnBoard;
  }
  
  public GameButton[][] getTestOneColumnBoard() {
    return testOneColumnBoard;
  }
  
  public GameButton[][] getManyColumnsBoard() {
    return manyColumnsBoard;
  }
  
  public GameButton[][] getTestManyColumnsBoard() {
    return testManyColumnsBoard;
  }
  
  public GameButton[][] getLeftBoard() {
    return leftBoard;
  }
  
  public GameButton[][] getDiffBoard() {
    return diffBoard;
  }
  
  public void setSingleBoard(GameButton[][] board) {
    this.singleBoard = board;
  }
  
  public void setCrossBoard(GameButton[][] board) {
    this.crossBoard = board;
  }
  
  public void setNullBoard(GameButton[][] board) {
    this.nullBoard = board;
  }
  
  public void setStarBoard(GameButton[][] board) {
    this.starBoard = board;
  }
 
  public void setTestBoard(GameButton[][] board) {
    this.testBoard = board;
  }
  
  public void setUpdateBoard(GameButton[][] board) {
    this.updateBoard = board;
  }
  
  public void setTestSingleBoard(GameButton[][] board) {
    this.testSingleBoard = board;
  }
  
  public void setTestNullBoard(GameButton[][] board) {
    this.testNullBoard = board;
  }
  
  public void setWinBoard(GameButton[][] board) {
    this.winBoard = board;
  }
  
  public void setLoseBoard(GameButton[][] board) {
    this.loseBoard = board;
  }
  
  public void setNoColumnsBoard(GameButton[][] board) {
    this.noColumnsBoard = board;
  }
  
  public void setTestNoColumnsBoard(GameButton[][] board) {
    this.testNoColumnsBoard = board;
  }
  
  public void setOneColumnBoard(GameButton[][] board) {
    this.oneColumnBoard = board;
  }
  
  public void setTestOneColumnBoard(GameButton[][] board) {
    this.testOneColumnBoard = board;
  }
  
  public void setManyColumnsBoard(GameButton[][] board) {
    this.manyColumnsBoard = board;
  }
  
  public void setTestManyColumnsBoard(GameButton[][] board) {
    this.testManyColumnsBoard = board;
  }
  
  public void setLeftBoard(GameButton[][] board) {
    this.leftBoard = board;
  }
  
  public void setDiffBoard(GameButton[][] board) {
    this.diffBoard = board;
  }
  
  /**
   * Tests the starScan and crossScan methods.
   */
  @Test
  public void testScan() {
    SameGame game = new SameGame();
    //Test crossScan when there are multiple buttons to change in each direction
    setBoards();
    game.crossScan(getTestBoard()[2][2]);
    for(int i = 0; i < 5; i++) {
      for(int j = 0; j < 5; j++) {
        if(!getTestBoard()[i][j].isColor(getCrossBoard()[i][j].getColor())) {
          Assert.fail("Different Colors @: " + i + "x" + j);
        }
      }
    }
    //Test crossScan when there is only one button in a direction
    setBoards();
    game.crossScan(getTestSingleBoard()[2][2]);
      for(int i = 0; i < 5; i++) {
        for(int j = 0; j < 5; j++) {
          if(!getTestSingleBoard()[i][j].isColor(getSingleBoard()[i][j].getColor())) {
            Assert.fail("Different Colors @: " + i + "x" + j);
          }
        }
      } 
    //Test crossScan when there is no button being changed
    setBoards();
    game.crossScan(getTestNullBoard()[2][2]);
    for(int i = 0; i < 5; i++) {
      for(int j = 0; j < 5; j++) {
        if(!getTestNullBoard()[i][j].isColor(getNullBoard()[i][j].getColor())) {
          Assert.fail("Different Colors @: " + i + "x" + j);
        }
      }
    }
    //Test starScan when a single oject is changed
    setBoards();
    game.starScan(getTestSingleBoard()[2][2]);
      for(int i = 0; i < 5; i++) {
        for(int j = 0; j < 5; j++) {
          if(!getTestSingleBoard()[i][j].isColor(getSingleBoard()[i][j].getColor())) {
            Assert.fail("Different Colors @: " + i + "x" + j);
          }
        }
      } 
    //Test starScan when there is no button being changed
    setBoards();
    game.starScan(testNullBoard[2][2]);
    for(int i = 0; i < 5; i++) {
      for(int j = 0; j < 5; j++) {
        if(!testNullBoard[i][j].isColor(nullBoard[i][j].getColor())) {
          Assert.fail("Different Colors @: " + i + "x" + j);
        }
      }
    }
    //Test starScan when there are multiple objects in each direction
    setBoards();
    game.starScan(getTestBoard()[2][2]);
    for(int i = 0; i < 5; i++) {
      for(int j = 0; j < 5; j++) {
        if(!getTestBoard()[i][j].isColor(getStarBoard()[i][j].getColor())) {
          Assert.fail("Different Colors @: " + i + "x" + j);
        }
      }
    }
  }
  
  /**
   * Tests the updateBoard method of SameGame
   */
  @Test
  public void testUpdateBoard() {
    SameGame game = new SameGame();
    game.crossScan(getTestBoard()[2][2]);
    //updates with the left most button, which is tested and shown to work.
    game.updateBoard(getTestBoard()[2][1]);
    for(int i = 0; i < 5; i++) {
      for(int j = 0; j < 5; j++) {
        if(!getTestBoard()[i][j].isColor(getUpdateBoard()[i][j].getColor())) {
          Assert.fail("Different Color @: " + i + "x" + j);
        }
      }
    }
  }
  
  @Test
  public void testCheckColumns() {
    SameGame game = new SameGame();
    //Test no columns
    game.checkColumns(getTestNoColumnsBoard());
    for(int i = 0; i < 4; i++) {
      if(!getTestNoColumnsBoard()[0][i].isColor(getNoColumnsBoard()[0][i].getColor())) {
        Assert.fail("Different Colors @: 0" + "x" + i);
      }
    }
    //Test one column
    game.checkColumns(getTestOneColumnBoard());
    for(int i = 0; i < 4; i++) {
      if(!getTestOneColumnBoard()[0][i].isColor(getOneColumnBoard()[0][i].getColor())) {
        Assert.fail("Different Colors @: 0" + "x" + i);
      }
    }
    //Test many columns
    game.checkColumns(getTestManyColumnsBoard());
    for(int i = 0; i < 4; i++) {
      if(!getTestManyColumnsBoard()[0][i].isColor(getManyColumnsBoard()[0][i].getColor())) {
        Assert.fail("Different Colors @: 0" + "x" + i);
      }
    }
  }
  
  /**
   * Tests the findLeftButton method of SameGame
   */
  @Test
  public void testFindLeftButton() {
    SameGame game = new SameGame();
    //Test the left button is the button
    Assert.assertEquals(game.findLeftButton(getLeftBoard()[0][3]), getLeftBoard()[0][3]);
    //Test the left button is one away
    Assert.assertEquals(game.findLeftButton(getLeftBoard()[0][4]), getLeftBoard()[0][3]);
    //Test the button is many away
    Assert.assertEquals(game.findLeftButton(getLeftBoard()[0][6]), getLeftBoard()[0][3]);
    //Test the button occurs at the end of the row
    Assert.assertEquals(game.findLeftButton(getLeftBoard()[0][1]), getLeftBoard()[0][0]);
  }
  
  /** 
   * Tests the findDifference method of SameGame
   */
  @Test
  public void testFindDifference() {
    SameGame game = new SameGame();
    //Test no space
    Assert.assertEquals(1, game.findDifference(getDiffBoard()[0][1]), .01);
    //Test one space
    Assert.assertEquals(2, game.findDifference(getDiffBoard()[0][0]), .01);
    //Test many spaces
    Assert.assertEquals(4, game.findDifference(getDiffBoard()[0][4]), .01);
    //Test spaces until end of columns
    Assert.assertEquals(5, game.findDifference(getDiffBoard()[0][3]), .01);
  }

  
  /**
   * Tests the isWon and isLost methods of SameGame
   */
  @Test
  public void testWinLoss() {
    SameGame game = new SameGame();
    setBoards();
    if(!game.isWon(getWinBoard())) {
      Assert.fail("winBoard has not won");
    }
    if(game.isWon(getLoseBoard())) {
      Assert.fail("loseBoard shouldn't have won");
    }
    if(!game.isLost(getLoseBoard())) {
      Assert.fail("loseBoard has not lost");
    }
    if(game.isLost(getWinBoard())) {
      Assert.fail("winBoard shouldn't have lost");
    }
  }
  
  /**
   * Tests the parseGameMode method with actual gameModes and non-existent gameModes 
   */
  @Test
  public void testParseGameMode() {
    SameGame game = new SameGame();
    //Test real gamemode entries for CrossGame and the getGameMode method to prove it is stored correctly
    game.setGameMode(game.parseGameMode("cross"));
    if(game.parseGameMode("cross") != 0) Assert.fail("cross not found as crossGame");
    if(game.parseGameMode("crossgame") != 0) Assert.fail("crossgame not found as crossGame");
    if(game.parseGameMode("Cross") != 0) Assert.fail("Cross not found as crossGame");
    if(game.parseGameMode("CrossGame") != 0) Assert.fail("CrossGame not found as crossGame");
    if(game.parseGameMode("crossGame") != 0) Assert.fail("crossGame not found as crossGame");
    if(game.parseGameMode("0") != 0) Assert.fail("0 not found as crossGame");
    if(game.getGameMode() != 0) Assert.fail("gameMode not properly stored");
    //Test real gamemode entries for StarGame and the getGameMode method to prove it is stored correctly
    game.setGameMode(game.parseGameMode("star"));
    if(game.parseGameMode("star") != 1) Assert.fail("star not found as starGame");
    if(game.parseGameMode("stargame") != 1) Assert.fail("stargame not found as starGame");
    if(game.parseGameMode("Star") != 1) Assert.fail("Star not found as starGame");
    if(game.parseGameMode("StarGame") != 1) Assert.fail("StarGame not found as starGame");
    if(game.parseGameMode("starGame") != 1) Assert.fail("starGame not found as starGame");
    if(game.parseGameMode("1") != 1) Assert.fail("1 not found as starGame");
    if(game.getGameMode() != 1) Assert.fail("gameMode not properly stored");
    //Test non-existent gamemode entries
    if(game.parseGameMode("yeet") != -1) Assert.fail("Found non-existent gamemode");
    if(game.parseGameMode("stor") != -1) Assert.fail("Found non-existent gamemode");
    if(game.parseGameMode("criss") != -1) Assert.fail("Found non-existent gamemode");
    if(game.parseGameMode("2") != -1) Assert.fail("Found non-existent gamemode");
    if(game.parseGameMode("java") != -1) Assert.fail("Found non-existent gamemode");
  }
 
  /**
   * Tests the assignButtons method of the GameButton class. 
   */
  @Test
  public void testAssignButtons() {
    setBoards();
    GameButton.assignButtons(testBoard);
    for(int i = 0; i < 5; i++) {
      for(int j = 0; j < 5; j++) {
        //Test assigning topButtons
        if(i == 0) {
          if(testBoard[i][j].getTopButton() != null) {
            Assert.fail("testBoard[i][j] should not have a topButton when i is 0");
          }
        }
        else if(testBoard[i][j].getTopButton() != testBoard[i - 1][j]) {
          Assert.fail("Incorrect assignmet for testBoard[i][j]: topButton");
        }
        //Test assigning bottomButtons
        if(i == 4) {
          if(testBoard[i][j].getBottomButton() != null) {
            Assert.fail("testBoard[i][j] should not have a bottomButton when i is 4");
          }
        }
        else if(testBoard[i][j].getBottomButton() != testBoard[i + 1][j]) {
          Assert.fail("Incorrect assignmet for testBoard[i][j]: bottomButton");
        }
        //Test assigning leftButtons
        if(j == 0) {
          if(testBoard[i][j].getLeftButton() != null) {
            Assert.fail("testBoard[i][j] should not have a leftButton when j is 0");
          }
        }
        else if(testBoard[i][j].getLeftButton() != testBoard[i][j - 1]) {
          Assert.fail("Incorrect assignmet for testBoard[i][j]: leftButton");
        }
        //Test assigning rightButtons
        if(j == 4) {
          if(testBoard[i][j].getRightButton() != null) {
            Assert.fail("testBoard[i][j] should not have a rightButton when j is 4");
          }
        }
        else if(testBoard[i][j].getRightButton() != testBoard[i][j + 1]) {
          Assert.fail("Incorrect assignmet for testBoard[i][j]: rightButton");
        }
        //Test assigning topLefttButtons
        if(i == 0 || j == 0) {
          if(testBoard[i][j].getTopLeftButton() != null) {
            Assert.fail("testBoard[i][j] should not have a topLeftButton when i and j are 0");
          }
        }
        else if(testBoard[i][j].getTopLeftButton() != testBoard[i - 1][j - 1]) {
          Assert.fail("Incorrect assignmet for testBoard[i][j]: topLeftButton");
        }
        //Test assigning bottomRightButtons
        if(i == 4 || j == 4) {
          if(testBoard[i][j].getBottomRightButton() != null) {
            Assert.fail("testBoard[i][j] should not have a bottomRightButton when i and j are 4");
          }
        }
        else if(testBoard[i][j].getBottomRightButton() != testBoard[i + 1][j + 1]) {
          Assert.fail("Incorrect assignmet for testBoard[i][j]: bottomRightButton");
        }
        //Test assigning topLeftButtons
        if(i == 4 || j == 0) {
          if(testBoard[i][j].getBottomLeftButton() != null) {
            Assert.fail("testBoard[i][j] should not have a bottomLeftButton when i is 4 and j is 0");
          }
        }
        else if(testBoard[i][j].getBottomLeftButton() != testBoard[i + 1][j - 1]) {
          Assert.fail("Incorrect assignmet for testBoard[i][j]: bottomLeftButton");
        }
        //Test assigning topRightButtons
        if(i == 0 || j == 4) {
          if(testBoard[i][j].getTopRightButton() != null) {
            Assert.fail("testBoard[i][j] should not have a rightButton when i is 0 and j is 4");
          }
        }
        else if(testBoard[i][j].getTopRightButton() != testBoard[i - 1][j + 1]) {
          Assert.fail("Incorrect assignmet for testBoard[i][j]: topRightButton");
        }
      }
    }
  }  
  
  
  /**
   * Initializes predetermined boards for testing
   * called before in order to reset the values of the boards
   */
  @Before
   public void setBoards() {
    Color bl = Color.BLUE;
    Color lg = Color.LIGHTGRAY;
    Color yl = Color.YELLOW;
    GameButton[][] singleBoard = new GameButton[5][5];
    /* testSingleBoard should look like:
     * {bl, bl, bl, bl, bl}
     * {bl, bl, bl, bl, bl}
     * {bl, lg, lg, bl, bl}
     * {bl, bl, bl, bl, bl}
     * {bl, bl, bl, bl, bl}
     */
    GameButton[][] crossBoard = new GameButton[5][5];
    /* testCrossBoard should look like:
     * {yl, bl, bl, bl, yl}
     * {bl, yl, lg, yl, bl}
     * {bl, lg, lg, lg, bl}
     * {bl, yl, lg, yl, bl}
     * {yl, bl, bl, bl, byl}
     */
    GameButton[][] starBoard = new GameButton[5][5];
    /* testStarBoard should look like:
     * {lg, lg, lg, lg, lg}
     * {lg, lg, lg, lg, lg}
     * {bl, lg, lg, lg, bl}
     * {bl, bl, bl, bl, bl}
     * {bl, bl, bl, bl, bl}
     */
    GameButton[][] nullBoard = new GameButton[5][5];
    /* testingNullBoard should look like:
     * {bl, bl, bl, bl, bl}
     * {bl, bl, bl, bl, bl}
     * {bl, bl, yl, bl, bl}
     * {bl, bl, bl, bl, bl}
     * {bl, bl, bl, bl, bl}
     */
    GameButton[][] testBoard = new GameButton[5][5];
    /* testingBoard should look like:
     * {yl, bl, bl, bl, yl}
     * {bl, yl, yl, yl, bl}
     * {bl, yl, yl, yl, bl}
     * {bl, yl, yl, yl, bl}
     * {yl, bl, bl, bl, yl}
     */
    GameButton[][] updateBoard = new GameButton[5][5];
    /* updateBoard should look like:
     * {yl, lg, lg, lg, yl}
     * {bl, bl, lg, bl, bl}
     * {bl, yl, lg, bl, bl}
     * {bl, yl, bl, yl, bl}
     * {yl, bl, bl, bl, yl}
     */
    GameButton[][] testSingleBoard = new GameButton[5][5];
    /* testSingleBoard should look like:
     * {bl, bl, bl, bl, bl}
     * {bl, bl, bl, bl, bl}
     * {bl, yl, yl, bl, bl}
     * {bl, bl, bl, bl, bl}
     * {bl, bl, bl, bl, bl}
     */
    GameButton[][] testNullBoard = new GameButton[5][5];
    /* testingNullBoard should look like:
     * {bl, bl, bl, bl, bl}
     * {bl, bl, bl, bl, bl}
     * {bl, bl, yl, bl, bl}
     * {bl, bl, bl, bl, bl}
     * {bl, bl, bl, bl, bl}
     */
    GameButton[][] winBoard = new GameButton[2][2];
    /* winBoard should look like: 
     * {lg, lg}
     * {lg, lg}
     */
    GameButton[][] loseBoard = new GameButton[3][3];
    /* loseBoard should look like:
     * {lg, lg, lg}
     * {yl, lg, lg}
     * {bl, lg, lg}
     */
    GameButton[][] noColumnsBoard = new GameButton[1][4];
    /* noColumnsBoard should look like:
     * {bl, bl, bl, bl}
     */
    GameButton[][] oneColumnBoard = new GameButton[1][4];
    /* oneColumnBoard should look like:
     * {bl, bl, lg, bl}
     */
    GameButton[][] manyColumnsBoard = new GameButton[1][4];
      /* manyColumnBoard should look like:
       * {bl, lg, lg, bl}
       */
    GameButton[][] testNoColumnsBoard = new GameButton[1][4];
    /*testNoColumnsBoard should look like:
     * {bl, bl, bl, bl}
     */
    GameButton[][] testOneColumnBoard = new GameButton[1][4];
    /*testOneColumnBoard should look like:
     * {bl, bl, bl, lg}
     */
    GameButton[][] testManyColumnsBoard = new GameButton[1][4];
    /*testManyColumnsBoard should look like:
     * {bl, bl, lg, lg}
     */
    GameButton[][] leftBoard = new GameButton[1][8];
    /* leftBoard should look like: 
     * {lg, lg, bl, lg, lg, lg, bl, lg)
     */
    GameButton[][] diffBoard = new GameButton[1][8];
    /* diffBoard should look like: 
     * {lg, lg, bl, lg, lg, lg, bl, lg)
     */
    
    //Sets these boards to be only blue buttons.
    for(int i = 0; i < 5; i++) {
      for(int j = 0; j < 5; j++) {
        singleBoard[i][j] = new GameButton(bl);
        crossBoard[i][j] = new GameButton(bl);
        starBoard[i][j] = new GameButton(bl);
        nullBoard[i][j] = new GameButton(bl);
        testBoard[i][j] = new GameButton(bl);
        updateBoard[i][j] = new GameButton(bl);
        testSingleBoard[i][j] = new GameButton(bl);
        testNullBoard[i][j] = new GameButton(bl);
        if(i < 3 && j < 3) {
          loseBoard[i][j] = new GameButton(lg);
        }
      }
    }
    //creates a cross on the cross game, and 4 spots on starBoard and testBoard
    for(int i = 1; i < 4; i++) {
      for(int j = 1; j < 4; j++) {
        crossBoard[i][2].updateColor(lg);
        crossBoard[2][j].updateColor(lg);
      }
    }
    //Initializes the diffBoard and leftBoard
    for(int i = 0; i < 8; i++) {
      leftBoard[0][i] = new GameButton(lg);
      diffBoard[0][i] = new GameButton(lg);
    }
    //Initializes the boards associated with the checkColumns test
    for(int i = 0; i < 4; i++) {
      noColumnsBoard[0][i] = new GameButton(bl);
      oneColumnBoard[0][i] = new GameButton(bl);
      manyColumnsBoard[0][i] = new GameButton(bl);
      testNoColumnsBoard[0][i] = new GameButton(bl);
      testOneColumnBoard[0][i] = new GameButton(bl);
      testManyColumnsBoard[0][i] = new GameButton(bl);
    }
    //all these fill in the remaining spots on the boards as they should be filled
    //crossBoard
    crossBoard[1][1].updateColor(yl);
    crossBoard[1][3].updateColor(yl);
    crossBoard[3][1].updateColor(yl);
    crossBoard[3][3].updateColor(yl);
    crossBoard[0][0].updateColor(yl);
    crossBoard[0][4].updateColor(yl);
    crossBoard[4][0].updateColor(yl);
    crossBoard[4][4].updateColor(yl);
    //singleBoard & testSingleBoard
    singleBoard[2][2].updateColor(lg);
    singleBoard[1][2].updateColor(lg);
    testSingleBoard[2][2].updateColor(yl);
    testSingleBoard[1][2].updateColor(yl);
    //nullBoard & testNullBoard
    nullBoard[2][2].updateColor(yl);
    testNullBoard[2][2].updateColor(yl);
    //starBoard
    for(int i = 0; i < 5; i++) {
      starBoard[0][i].updateColor(lg);
      starBoard[1][i].updateColor(lg);
    }
    starBoard[2][1].updateColor(lg);
    starBoard[2][2].updateColor(lg);
    starBoard[2][3].updateColor(lg);
    //testBoard
    testBoard[0][0].updateColor(yl);
    testBoard[0][4].updateColor(yl);
    testBoard[1][1].updateColor(yl);
    testBoard[1][2].updateColor(yl);
    testBoard[1][3].updateColor(yl);
    testBoard[2][1].updateColor(yl);
    testBoard[2][2].updateColor(yl);
    testBoard[2][3].updateColor(yl);
    testBoard[3][1].updateColor(yl);
    testBoard[3][2].updateColor(yl);
    testBoard[3][3].updateColor(yl);
    testBoard[4][0].updateColor(yl);
    testBoard[4][4].updateColor(yl);
    //updateBoard
    updateBoard[0][0].updateColor(yl);
    updateBoard[0][4].updateColor(yl);
    updateBoard[4][0].updateColor(yl);
    updateBoard[4][4].updateColor(yl);
    updateBoard[2][1].updateColor(yl);
    updateBoard[2][3].updateColor(yl);
    updateBoard[3][1].updateColor(yl);
    updateBoard[3][3].updateColor(yl);
    updateBoard[0][1].updateColor(lg);
    updateBoard[0][2].updateColor(lg);
    updateBoard[0][3].updateColor(lg);
    updateBoard[1][2].updateColor(lg);
    updateBoard[2][2].updateColor(lg);
    
    //winBoard + loseBoard
    winBoard[0][0] = new GameButton(lg);
    winBoard[1][0] = new GameButton(lg);
    winBoard[0][1] = new GameButton(lg);
    winBoard[1][1] = new GameButton(lg);
    loseBoard[1][0].updateColor(yl);
    loseBoard[2][0].updateColor(bl);
    //diffBoard and leftBoard
    leftBoard[0][2].updateColor(bl);
    diffBoard[0][2].updateColor(bl);
    //boards associated with checkColumns
    oneColumnBoard[0][3].updateColor(lg);
    testOneColumnBoard[0][2].updateColor(lg);
    testManyColumnsBoard[0][1].updateColor(lg);
    testManyColumnsBoard[0][2].updateColor(lg);
    manyColumnsBoard[0][2].updateColor(lg);
    manyColumnsBoard[0][3].updateColor(lg);
    
    
    //Sets fields and assigns buttons
    setSingleBoard(singleBoard);
    GameButton.assignButtons(getSingleBoard());
    
    setNullBoard(nullBoard);
    GameButton.assignButtons(getNullBoard());
    
    setCrossBoard(crossBoard);
    GameButton.assignButtons(getCrossBoard());
    
    setStarBoard(starBoard);
    GameButton.assignButtons(getStarBoard());
    
    setTestBoard(testBoard);
    GameButton.assignButtons(getTestBoard());
    
    setTestNullBoard(testNullBoard);
    GameButton.assignButtons(getTestNullBoard());
    
    setTestSingleBoard(testSingleBoard);
    GameButton.assignButtons(getTestSingleBoard());
    
    setOneColumnBoard(oneColumnBoard);
    GameButton.assignButtons(getOneColumnBoard());
    
    setTestOneColumnBoard(testOneColumnBoard);
    GameButton.assignButtons(getTestOneColumnBoard());
    
    setNoColumnsBoard(noColumnsBoard);
    GameButton.assignButtons(getNoColumnsBoard());
    
    setTestNoColumnsBoard(testNoColumnsBoard);
    GameButton.assignButtons(getTestNoColumnsBoard());
    
    setManyColumnsBoard(manyColumnsBoard);
    GameButton.assignButtons(getManyColumnsBoard());
    
    setTestManyColumnsBoard(testManyColumnsBoard);
    GameButton.assignButtons(getTestManyColumnsBoard());
    
    setLeftBoard(leftBoard);
    GameButton.assignButtons(getLeftBoard());
    
    setDiffBoard(diffBoard);
    GameButton.assignButtons(getDiffBoard());
    
    setWinBoard(winBoard);
    setLoseBoard(loseBoard);
    
    setUpdateBoard(updateBoard);
    GameButton.assignButtons(getUpdateBoard());
  } 
  
  
  @Override
  public void start(Stage primaryStage) {
  }
  
  @BeforeClass
  public static void testingLaunch() {
    Thread testThread = new Thread() {      
      public void run() {         
        backgroundLaunch(new String[0]);     
      }   
    };   
    testThread.start();
  }
  
  public static void backgroundLaunch(String[] args) {
    Application.launch(args);
  }
}