import javax.swing.*;
import javax.swing.JComponent;
import java.awt.Point;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.*;
import javax.swing.text.DefaultCaret;

/**
* The SolitaireJFrame creates the frame and adds the panel to the game
*/
public class SolitaireJFrame extends JFrame {

  public boolean selected;
  public static JButton b1;
  public static JButton b2;

  /**
  * The SolitaireJFrame constructor creates the frame and panel
  */
  public SolitaireJFrame() {
    setTitle("Solitaire");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JPanel panel2 = new SolitaireJPanel();
    panel2.setLayout(null);
    panel2.setSize(600, 700);

    Color pink = new Color(251, 206, 177);   //255, 239, 213
    panel2.setBackground(pink);
    panel2.add(Solitaire.deck);
    panel2.add(Solitaire.discard);
    for (int i = 0; i < Solitaire.table.length; i++)
    panel2.add(Solitaire.table[i]);

    JPanel panel1 = new JPanel();
    b1 = new JButton("New Game");
    b2 = new JButton("Instructions");
    b1.setBackground(Color.pink);
    b2.setBackground(Color.pink);
    panel1.add(b1);
    panel1.add(b2);

    selected = false;

    b1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Solitaire.init();
        repaint();
      }
    });
    b2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        JFrame popup = new JFrame();
        popup.setSize(300,300);
        popup.getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));
          
        popup.setVisible(true);
        popup.setTitle("Instructions");
        JTextArea label = new JTextArea("Terms to know\n" + "Table: The seven piles on the bottom\nFoundation: The four piles on top left the player is trying to build from the table starting from Ace to King.\nStock: Also known as the hand pile on the top right, the remaining cards form the pile the player uses to bring additional cards into play\nWaste: Next to the stock pile the discarded cards from the stockpile that are not playable at the moment\n\n" + "PLAY\nYour goal is to create a sequence among the seven piles in descending order (King, Queen, Jack, 10, 9, 8 and so on), alternating colors.\nYou can also move a faceup card onto another faceup card from the table\nIf you’re left with an empty space in one of the piles, you can put a King (and only a King) in its place.\nIf you have aces, move them to the foundation, where you’ll eventually put all four aces.\nHere, you can start building up by suit in ascending order (Ace, 2, 3, 4, 5 and so on)\nThe last faceup card on a sequence pile (or the most recent one put down in that pile) can be moved to the ace foundations.\nUse the stockpile to draw a card one at a time. If you can use it in one of your piles to create a sequence or count up by suit, do so. If you cannot use it, move it to the waste pile and draw again.\nYou can also stack columns by adding one sequence to another if the first faceup card matches the descending pattern. After you've shifted the column over, it will free up a facedown card, which you can turn over.\nIf you have used all of the cards in the stockpile and all the facedown cards are revealed, you should be able to successfully move all the cards to the ace foundations. This is how you win the game.\n\nYAY! Now time to play!");
        label.setLineWrap(true);
        label.setWrapStyleWord(true);
        label.setEditable(false);
        label.setAutoscrolls(true);

        JScrollPane pane = new JScrollPane(label);
        popup.add(pane);
      }
    });

    add(panel1, BorderLayout.PAGE_START);
    add(panel2);

    setSize(600, 700);
    setVisible(true);
  }
}
