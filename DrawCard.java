import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.security.cert.X509CRL;

import javax.swing.JComponent;
import java.awt.Color;

/**
* The DrawCard class creates the card being drawn on the frame 
*/
public class DrawCard extends JComponent {
  protected int x;
  protected int y;
  private int s;
  private int r;
  public final static int width = 50;
  public final static int height = 80;
  public static int heart = 0;
  public static int spade = 1;
  public static int diamond = 2;
  public static int club = 3;
  private boolean faceup = false;

  /**
  * The DrawCard method get the suit and rank of the card being made
  * @param cs the suit of the card
  * @param cr the rank of the card
  */
  public DrawCard(int cs, int cr) {
    s = cs;
    r = cr;
  }

  /**
  * The suit pile gets the suit of the card being made
  * @return the suit of the card
  */
  public int suit() {
    return s;
  }

  /**
  * The rank pile gets the rank of the card being made
  * @return the rank of the card
  */
  public int rank() {
    return r;
  }

  /**
  * The isAce methods determines if the cards rank is ace
  * @return true if the card is ace false if not
  */
  public boolean isAce() {
    return r == 0;
  }

  /**
  * The isKing methods determines if the cards rank is King
  * @return true if the card is King false if not
  */
  public boolean isKing() {
    return r == 12;
  }

  /**
  * The isRed methods determines if the cards suit is even
  * @return true if the card is even false if not
  */
  public boolean isRed() {
    return s % 2 == 0;
  }

  /**
  * the faceUp method determines if the card is facing up or not
  * @return true if the card is facing up false if not
  */
  public boolean faceUp() {
    return faceup;
  }

  /**
  * the flip method turns the card over to the opposite side
  */
  public void flip() {
    faceup = !faceup;
  }

  /**
  * The draw method draws out the created card
  * @param x the x coordinate of the card
  * @param y the y coordinate of the card
  * @param g the graphics of the card
  */
  public void draw(int x, int y, Graphics g) {
    String names[] = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
    Graphics2D g2 = (Graphics2D) g;
    if (!faceUp()) {
      g2.setColor(Color.pink);
      g2.fillRect(x, y, 50, 80);
      g2.setColor(Color.gray);
      g2.drawRect(x, y, 50, 80);
    }
    if (faceUp()) {
      Color tan = new Color(255, 245, 238);
      g2.setColor(tan);
      g2.fillRect(x, y, 50, 80);
      g2.setColor(Color.gray);
      g2.drawRect(x, y, 50, 80);

      if (isRed())
        g2.setColor(Color.red);
      else
        g2.setColor(Color.black);

      g2.drawString(names[rank()], x + 3, y + 15);

      if (suit() == heart) {
        g2.drawLine(x + 25, y + 30, x + 35, y + 20);
        g2.drawLine(x + 35, y + 20, x + 45, y + 30);
        g2.drawLine(x + 45, y + 30, x + 25, y + 60);
        g2.drawLine(x + 25, y + 60, x + 5, y + 30);
        g2.drawLine(x + 5, y + 30, x + 15, y + 20);
        g2.drawLine(x + 15, y + 20, x + 25, y + 30);
      } else if (suit() == spade) {
        g2.drawLine(x + 25, y + 20, x + 40, y + 50);
        g2.drawLine(x + 40, y + 50, x + 10, y + 50);
        g2.drawLine(x + 10, y + 50, x + 25, y + 20);
        g2.drawLine(x + 23, y + 50, x + 20, y + 60);
        g2.drawLine(x + 20, y + 60, x + 30, y + 60);
        g2.drawLine(x + 30, y + 60, x + 27, y + 50);
      } else if (suit() == diamond) {
        g2.drawLine(x + 25, y + 20, x + 40, y + 40);
        g2.drawLine(x + 40, y + 40, x + 25, y + 60);
        g2.drawLine(x + 25, y + 60, x + 10, y + 40);
        g2.drawLine(x + 10, y + 40, x + 25, y + 20);
      } else {
        g2.drawOval(x + 20, y + 25, 10, 10);
        g2.drawOval(x + 25, y + 35, 10, 10);
        g2.drawOval(x + 15, y + 35, 10, 10);
        g2.drawLine(x + 23, y + 45, x + 20, y + 55);
        g2.drawLine(x + 20, y + 55, x + 30, y + 55);
        g2.drawLine(x + 30, y + 55, x + 27, y + 45);
      }

    } else {
      g2.drawOval(x + 15, y + 30, 20, 20);
      g2.drawLine(x + 5, y + 7, x + 45, y + 7);
      g2.drawLine(x + 5, y + 7, x + 5, y + 73);
      g2.drawLine(x + 5, y + 73, x + 45, y + 73);
      g2.drawLine(x + 45, y + 7, x + 45, y + 73);
    }

  }


}
