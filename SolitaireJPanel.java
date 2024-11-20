import javax.swing.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;
import java.awt.Point;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.*;

/**
* The SolitaireJPanel class creates the panel of the game
*/
public class SolitaireJPanel extends JPanel {

  /**
  * The SolitaireJPanel creates a panel 
  */
  public SolitaireJPanel() {
    super();
    addMouseListener(new MousePressListener());
  }

  /**
  * The paintComponent method draws to the panel
  * @param the graphics of the cards
  */
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    g2.setColor(Color.black);
    g2.drawString("Deck Size: " + Solitaire.deck.getPileSize(), Solitaire.deck.x - 15, Solitaire.deck.y - 15);
    g2.drawString("Reload", Solitaire.deck.x+3, Solitaire.deck.y+30);
    g2.drawString("Here", Solitaire.deck.x+8, Solitaire.deck.y+45);  
    if(Solitaire.gameEnded() == true)
    {
     g2.drawString("Congratulations! You have won this game.", 170, 300);
    }
    Solitaire.deck.draw(g);
    Solitaire.discard.draw(g);
    for (int i = 0; i < Solitaire.suit.length; i++) {
      Solitaire.suit[i].draw(g);
    }
    for (int i = 0; i < Solitaire.table.length; i++) {
      Solitaire.table[i].draw(g);
    }
  }

  /**
  * The MousePressListener adds a moust listener to the cards
  */
  class MousePressListener implements MouseListener {
    public void mousePressed(MouseEvent event) {
    }

    public void mouseReleased(MouseEvent event) {
    }

    /**
    * The mouseClicked method determines if the click was on one of the piles
    * @param event
    */
    public void mouseClicked(MouseEvent event) {
      final Point pos = event.getPoint();
      final int x = pos.x;
      final int y = pos.y;
      // This click is on the deck pile
      if (x > Solitaire.deck.x && x < Solitaire.deck.x + DrawCard.width
          && y > Solitaire.deck.y && y < Solitaire.deck.y + DrawCard.height) {
        Solitaire.deck.select();
        Solitaire.frame.repaint();
      }
      // This click is on the discard pile
      if (x > Solitaire.discard.x && x < Solitaire.discard.x + DrawCard.width
          && y > Solitaire.discard.y && y < Solitaire.discard.y + DrawCard.height) {
        Solitaire.discard.select();
        Solitaire.frame.repaint();
      }

      // This click is on one of the table piles
      for (int i = 0; i < Solitaire.table.length; i++) {
        if (x > Solitaire.table[i].x && x < Solitaire.table[i].x + DrawCard.width
            && y > Solitaire.table[i].getMinClickableY() && y < Solitaire.table[i].getMaxClickableY()) {
          Solitaire.table[i].select(y);
          Solitaire.frame.repaint();

        }
      }

    }

    public void mouseEntered(MouseEvent event) {
    }

    public void mouseExited(MouseEvent event) {
    }
  }
}
