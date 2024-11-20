import java.util.Random;
import java.util.*;
import java.util.Stack;

/**
* The DeckPile class is the class for the deck cards 
*/
public class DeckPile extends CardPile {

  /**
  * The DeckPile constructor creates each card in the deck
  * @param iX the x coordinate of the deck
  * @param iY the y coordinate of the deck
  */
  public DeckPile(int iX, int iY) {
    super(iX, iY);
    ArrayList<DrawCard> temp = new ArrayList<DrawCard>(52);

    int count = 0;
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j <= 12; j++) {
        temp.add(new DrawCard(i, j));
        count++;
      }
    }

    Random rand = new Random();
    for (int i = 0; count > 0; count--) {
      int j = Math.abs(rand.nextInt() % 52);

      DrawCard t = temp.get(i);
      temp.set(i, temp.get(j));
      temp.set(j, t);
    }
    pile.addAll(temp);
  }

  /**
  * The select method selects if the top card of the deck goes to the discard pile, or it restarts
  */
  public void select() {
    if (pile.size() > 0) {
      Solitaire.discard.addCard(pile.pop());
    } else {
      while (Solitaire.discard.getPileSize() > 0) {
        DrawCard top = Solitaire.discard.pop();
        if (top.faceUp())
          top.flip();
        pile.add(top);
      }
    }
  }

}