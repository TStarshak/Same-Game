import javafx.scene.control.Button;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

/**
 * The GameButton class represents colored Button objects and their adjacent GameButtons.
 * @author Trey Starshak
 */

public class GameButton extends Button {
  
  //The array of colors to choose from when creating a GameButton
  private Color colorWheel[] = new Color[]{Color.LIME, Color.RED, Color.ORANGE, Color.TURQUOISE, Color.GREEN, Color.BROWN, Color.BLUE, Color.OLIVE, Color.TOMATO, Color.HOTPINK};
  
  //The color of the GameButton
  private Color color;
  
  //The circle used to create the GameButton
  private Circle circle;
  
  //The button above this button
  private GameButton topButton;
  
  //The button below this button
  private GameButton bottomButton;
  
  //The button to the right of this button
  private GameButton rightButton;
  
  //The button to the left of this button
  private GameButton leftButton;
  
  //The button above this button
  private GameButton topLeftButton;
  
  //The button below this button
  private GameButton bottomLeftButton;
  
  //The button to the right of this button
  private GameButton bottomRightButton;
  
  //The button to the left of this button
  private GameButton topRightButton;
  
  
  /**
   * Creates a GameButton object with a random color from the colorWheel field
   * @param colors the number of colors to choose from
   */
  public GameButton(int colors) {
    super();
    this.color = colorWheel[(int)(Math.random() * colors)];
    //The number 10 is the radius of the circle which I have found to be aesthetically pleasing
    this.circle = new Circle(10, color);
    this.setGraphic(circle);
  }
  
  
  /**
   * Creates a GameButton object with a specified color
   * @param color the color of the GameButton object
   */
  public GameButton(Color color) {
    super();
    this.color = color;
    this.circle = new Circle(10, color);
    this.setGraphic(circle);
  }
  
  
  /**
   * returns the color of the GameButton
   * @return color the color field
   */
  public Color getColor() {
    return this.color;
  }
  
  
  /**
   * changes the value of the color field
   * @param color the new color of the GameButton
   */
   public void setColor(Color color) {
    this.color = color;
  }
  
   
   /**
    * Returns the circle field of this GameButton
    * @return circle the CIrcle object stored by this GameButton
    */
  public Circle getCircle() {
    return circle;
  }
  
  
  /**
   * Returns the topButton field of this GameButton
   * @return topButton the button above this button
   */
  public GameButton getTopButton() {
    return topButton;
  }
  
  
  /**
   * Updates the value of the topButton field
   * @param button the button above this button
   */
  public void setTopButton(GameButton button) {
    this.topButton = button;
  }
  
  
  /**
   * Returns the bottomButton field of this GameButton
   * @return bottomButton the button below this button
   */
  public GameButton getBottomButton() {
    return bottomButton;
  }
  
  
  /**
   * Updates the value of the bottomButton field
   * @param button the button below this button
   */
  public void setBottomButton(GameButton button) {
    this.bottomButton = button;
  }
  
  
  /**
   * Returns the leftButton field of this GameButton
   * @return leftButton the button left of this button
   */
  public GameButton getLeftButton() {
    return leftButton;
  }

  
  /**
   * Updates the value of the leftButton field
   * @param button the button left this button
   */
  public void setLeftButton(GameButton button) {
    this.leftButton = button;
  }
  
  
  /**
   * Returns the rightButton field of this GameButton
   * @return rightButton the button right of this button
   */
  public GameButton getRightButton() {
    return rightButton;
  }
  
  
  /**
   * Updates the value of the rightButton field
   * @param button the button right of this button
   */
  public void setRightButton(GameButton button) {
    this.rightButton = button;
  }
  
  
  /**
   * Returns the topLeftButton field of this GameButton
   * @return topButton the button above and left of this button
   */
  public GameButton getTopLeftButton() {
    return topLeftButton;
  }
  
  
  /**
   * Updates the value of the topLeftButton field
   * @param button the button above and left of this button
   */
  public void setTopLeftButton(GameButton button) {
    this.topLeftButton = button;
  }
  
  
  /**
   * Returns the bottomRightButton field of this GameButton
   * @return bottomRightButton the button below and right of this button
   */
  public GameButton getBottomRightButton() {
    return bottomRightButton;
  }
  
  
  /**
   * Updates the value of the bottomRightButton field
   * @param button the button below and right of this button
   */
  public void setBottomRightButton(GameButton button) {
    this.bottomRightButton = button;
  }
  
  
  /**
   * Returns the bottomLeftButton field of this GameButton
   * @return bottomLeftButton the button below and left of this button
   */
  public GameButton getBottomLeftButton() {
    return bottomLeftButton;
  }

  
  /**
   * Updates the value of the bottomLeftButton field
   * @param button the button below and left this button
   */
  public void setBottomLeftButton(GameButton button) {
    this.bottomLeftButton = button;
  }
  
  
  /**
   * Returns the topRightButton field of this GameButton
   * @return topRightButton the button right of this button
   */
  public GameButton getTopRightButton() {
    return topRightButton;
  }
  
  
  /**
   * Updates the value of the topRightButton field
   * @param button the button right of this button
   */
  public void setTopRightButton(GameButton button) {
    this.topRightButton = button;
  }
  
 
  /**
   * Returns the topButton field of this GameButton
   * @param color the color to compare against
   * @return the boolean that is whether or not the two colors are the same
   */
  public boolean isColor(Color color) {
    return this.getColor() == color;
  }
  
  
  /**
   * Returns the topButton field of this GameButton
   * @param color the color to set the button to
   */
  public void updateColor(Color color) {
    this.setColor(color);
    this.getCircle().setFill(color);
  }
  
  
  /**
   * Assigns the values of the rightButton, leftButton, topButton, and bottomButton fields
   * @param array the GameButton[][] used to determine the relationship of the buttons
   */
  public static void assignButtons(GameButton[][] array) {
    for(int i = 0; i <= array.length - 1; i++) {
      for(int j = 0; j <= array[i].length - 1; j++) {
        //updates the top button, if one exists
        if(i > 0) {
          array[i][j].setTopButton(array[i - 1][j]);
        }
        //updates the bottom button, if one exists
        if(i < array.length - 1) {
          array[i][j].setBottomButton(array[i + 1][j]);
        }
        //updates the left button, if one exists
        if(j > 0) {
          array[i][j].setLeftButton(array[i][j - 1]);
        }
        //updates the right button, if one exists
        if(j < array[i].length - 1) {
          array[i][j].setRightButton(array[i][j + 1]);
        }
        //updates the top left button, if one exists
        if(i > 0 && j > 0) {
          array[i][j].setTopLeftButton(array[i - 1][j - 1]);
        }
        //updates the bottom right button, if one exists
        if(i < array.length - 1 && j < array[i].length - 1) {
          array[i][j].setBottomRightButton(array[i + 1][j + 1]);
        }
        //updates the bottom left button, if one exists
        if(j > 0 && i < array.length - 1) {
          array[i][j].setBottomLeftButton(array[i + 1][j - 1]);
        }
        //updates the top right button, if one exists
        if(j < array[i].length - 1 && i > 0) {
          array[i][j].setTopRightButton(array[i - 1][j + 1]);
        }
      }
    }
  } 
}
      