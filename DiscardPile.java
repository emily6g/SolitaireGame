import java.util.*;

/**
* The DiscardPile class is the pile of the discarded cards from the deck 
*/ 
public class DiscardPile extends CardPile {

  /**
  * The DiscardPile constructor creates the discard pile
  * @param iX the x coordinate of the discard pile
  * @param iY the y param of the discard pile
  */
  public DiscardPile(int iX, int iY) {
    super(iX, iY);
  }

  /**
  * The addCard method adds a card to the discard pile
  * @param inCard the card being added
  */
  public void addCard(DrawCard inCard) {
    if (!inCard.faceUp())
      inCard.flip();
    pile.add(inCard);
  }

  /**
  * The select method decides if the card from discard pile can go into the table or suit pile
  */
  public void select() {
    if (pile.isEmpty())
      return;
    DrawCard top = pile.pop();
    for (int i = 0; i < 4; i++) {
      if (Solitaire.suit[i].canTake(top)) {
        Solitaire.suit[i].addCard(top);
        return;
      }
    }
    for (int i = 0; i < 7; i++) {
      if (Solitaire.table[i].canTake(top)) {
        Solitaire.table[i].addCard(top);
        return;
      }
    }
    addCard(top);
  }
}