
import java.util.*;
import java.util.Enumeration;
import javax.swing.JComponent;
import java.awt.Graphics;

/**
* The TablePile class is the class for the table piles
*/
public class TablePile extends CardPile {
  private int cardCount;
  private int CardYOffsets = 17;

  /**
  * The TablePile constructor creates the cards in the table piles
  * @param iX the x coordinate of the pile
  * @param iY the y coordinate of the pile
  * @param c the amount of cards in the pile
  */
  public TablePile(int iX, int iY, int c) {
    super(iX, iY);
    cardCount = c;
    for (int i = 0; i < c; i++) {
      pile.add(Solitaire.deck.pop());
    }
    pile.peek().flip();
  }

  /**
  * The addCard method adds a card to the pike if it is faceup
  * @param inCard the card being tested
  */
  public void addCard(DrawCard inCard) {
    if (inCard.faceUp())
      pile.add(inCard);
  }

  /**
  * The canTake method checks to see if the table pile can take the card
  * @param aCard the card being tested
  * @return whether the card can be taken in   the pile
  */
  public boolean canTake(DrawCard aCard) {
    if (pile.isEmpty())
      return aCard.isKing();
    DrawCard top = pile.peek();
    return (aCard.isRed() != top.isRed()) && (aCard.rank() + 1 == top.rank());
  }

  /**
  * The select method decides if the suit pile or another table pile can take the card from the table pile
  * @param clickedY the y coordinate of the card clicked
  */
  public void select(int clickedY) {
    if (pile.isEmpty())
      return;
    
    int selectedCard = (clickedY - y)/CardYOffsets;
    if (selectedCard >= getPileSize())
      selectedCard = getPileSize() - 1;

    int j = 0;
    Enumeration e = pile.elements();
    while(e.hasMoreElements()) {
      DrawCard card = (DrawCard) e.nextElement();
      if (j == selectedCard && j == getPileSize() - 1) {
        for (int i = 0; i < 4; i++) {
          if (Solitaire.suit[i].canTake(card)) {
            Solitaire.suit[i].addCard(card);
            pile.pop();
            if (pile.isEmpty() != true && pile.peek().faceUp() == false) {
              DrawCard top = pile.peek();
              top.flip();
            }
            return;
          }
        } 
      }
      if (j == selectedCard) {
        // Check other table piles
        for (int i = 0; i < 7; i++) {
          if (Solitaire.table[i].canTake(card)) {
            Solitaire.table[i].addCard(card);
            while (e.hasMoreElements()) {
              card = (DrawCard) e.nextElement();
              Solitaire.table[i].addCard(card);
            }
            int deleteCount = getPileSize() - selectedCard;
            for (int d = 0; d < deleteCount; d++){
              pile.pop();
            }
            
            if (pile.isEmpty() != true && pile.peek().faceUp() == false) {
              DrawCard top = pile.peek();
              top.flip();
            }
            return;
          }
        }
      }
      j++;
    }
  }

  /**
  * The draw method draws each card of the table pile
  * @param g the graphics of the card
  */
  public void draw(Graphics g) {
    int yOffset = 0;
    Enumeration e = pile.elements();

    while (e.hasMoreElements()) {
      DrawCard card = (DrawCard) e.nextElement();
      card.draw(x, y + yOffset, g);
      yOffset += CardYOffsets;
    }
  }

  /**
  * The method faceUpCount counts the amount of faceup cards in the table pile
  * @return the amount of faceup cards
  */
  public int faceUpCount() {
    int count = 0;
    
    Enumeration e = pile.elements();
    while (e.hasMoreElements()) {
      DrawCard card = (DrawCard) e.nextElement();
      if (card.faceUp())  
        count++;
    }
    return count;
  }

  /**
  * The method getMinClickableY gets the smallest y coordinate of a card that can be clicked
  * @return the smallest y coordinate of a card that can be clicked
  */
  public int getMinClickableY() {
    return y + (getPileSize() - faceUpCount()) * CardYOffsets;
  }

  /**
  * The method getMaxClickableY gets the largest y coordinate of a card that can be clicked
  * @return the largest y coordinate of a card that can be clicked
  */
  public int getMaxClickableY() {
    return y + DrawCard.height + (getPileSize() - 1) * CardYOffsets;
  }
}
