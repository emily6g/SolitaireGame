import javax.swing.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;
import java.awt.Point;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.*;

import javax.swing.Popup;

/**
* This is the main class where all the piles are constructed
*/
public class Solitaire {
  public static SolitaireJFrame frame;

  public static DeckPile deck;
  public static DiscardPile discard;
  public static SuitPile suit[];
  public static TablePile table[];
  public static CardPile allPiles[];

  /**
  * The main method creates the solitaire world
  */
  public static void main(String[] args) {
    Solitaire world = new Solitaire();
  }

  /**
  * The Solitaire constructor creates new piles and a new frame
  */
  public Solitaire() {
    init();
    frame = new SolitaireJFrame();
  }

  /**
  * The init method creates new suit, table, deck, and discard piles
  */
  public static void init() {
    allPiles = new CardPile[13];
    suit = new SuitPile[4];
    table = new TablePile[7];
    deck = new DeckPile(500, 50); 
    discard = new DiscardPile(430, 50); 
    for (int i = 0; i < suit.length; i++) {
      suit[i] = new SuitPile(50 + i * 70, 50, i);
    }
    for (int i = 0; i < table.length; i++) {
      table[i] = new TablePile(50 + i * 75, 150, i+1);
    }
  }

  /**
  * The gameEnded method determines if all the piles are empty then you have won the game
  * @return true if all piles are empty, false if any piles still have cards
  */
  public static boolean gameEnded()
  {
    if (!Solitaire.deck.isEmpty())
      return false;

    if (!Solitaire.discard.isEmpty())
      return false;

    for (int i = 0; i < Solitaire.table.length; i++)
      {
      if (!Solitaire.table[i].isEmpty())
	       return false;
      }
    return true;
  }

}
