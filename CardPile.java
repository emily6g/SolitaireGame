import java.awt.*;
import java.util.Stack;
import java.util.EmptyStackException;
import javax.swing.JComponent;

/**
* The CardPile class constructs all the piles
*/
public class CardPile extends JComponent {
  protected Stack<DrawCard> pile;
  public int x;
  public int y;

  /**
  * The CardPile constructor creates a pile in the given area
  * @param inX the x coordinate of the pile
  * @param inY the y coordinate of the pile
  */
  public CardPile(int inX, int inY) {
    x = inX;
    y = inY;
    pile = new Stack<DrawCard>();
  }

  /**
  * The getPileSize method returns the size of the pile made
  * @return the size of the pile
  */
  public int getPileSize() {
    return pile.size();
  }

  /**
  * The peek method only looks at the top card of the pile
  * @return the top card of the pile
  */
  public DrawCard peek() {
    if (pile.size() == 0)
      throw new EmptyStackException();
    return pile.get(pile.size() - 1);
  }

  /**
  * The isEmpty method checks to see if the pile is empty or not
  * @return true if pile is empty, false if pile is not empty
  */
  public boolean isEmpty() {
    if (pile.size() == 0)
      return true;
    return false;
  }

  /**
  * The pop method takes off the top card on the pile
  * @return the top card removed from the pile
  */
  public DrawCard pop() {
    if (pile.size() == 0)
      throw new EmptyStackException();
    return pile.remove(pile.size() - 1);
  }

  /**
  * The push method adds a card to the pile
  * @param c the card being added
  */
  public void push(DrawCard c) {
    pile.add(c);
  }

  /**
  * The paintComponent method draws the pile on to the frame
  * @param g the graphics of the pile
  */
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    draw(g);
  }

  /**
  * The draw method draws on the pile, and if it is empty draws a square
  * @param g the graphics of the pile 
  */
  public void draw(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;
    if (pile.size() > 0)
      pile.peek().draw(x, y, g);
    else {
      g2.setColor(Color.gray);
      g2.drawRect(x, y, 50, 80);
    }

  }

}