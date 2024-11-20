import java.util.*;
import java.util.LinkedList;

/**
* The SuitPile class is the class for the suit pile
*/
public class SuitPile extends CardPile
  {
    private static LinkedList<String> names; 
    private int suit;

    /**
    * The SuitPile constructor creates the suit cards
    * @x the x coordinate of the card
    * @y the y coordinate of the card
    * @s the suit of the card
    */
    public SuitPile(int x, int y, int s)
    {
      super(x, y);
      suit = s;
      names = new LinkedList<String>();
      names.add("A");
      names.add("2");
      names.add("3");
      names.add("4");
      names.add("5");
      names.add("6");
      names.add("7");
      names.add("8");
      names.add("9");
      names.add("10");
      names.add("J");
      names.add("Q");
      names.add("K");
    }

    /**
    * The canTake method determines if the suit can take that card
    * @param aCard the card being tested
    * @return whether the card can be taken in the pile
    */
    public boolean canTake(DrawCard aCard)
    {
      if(pile.isEmpty())
        return aCard.isAce();
      DrawCard top = pile.peek(); 
      return (aCard.suit() == top.suit()) && (aCard.rank() == 1 + top.rank());

    }

    /**
    * The addCard method adds the card if it is faceup
    * @param inCard the card being tested
    */
    public void addCard(DrawCard inCard)
    {
      if(inCard.faceUp())
      {
        pile.add(inCard);
      }
   }
  }
