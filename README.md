# 🃏 Solitaire Game (Java Swing)

A desktop Solitaire game built with Java Swing, featuring fully interactive gameplay, card animations, and classic rules. Built as a personal project to improve GUI programming and OOP design skills.

---

## 🎮 How to Play

- The goal is to move all cards to the suit piles (Ace to King, by suit).
- Only face-up cards can be moved.
- Cards can be moved between table piles in descending order, alternating colors (e.g. red 6 on black 7).
- Empty table piles can only accept Kings.
- Click the draw pile to flip cards into the discard pile.
- You win once all suits are complete.

---

## 🚀 How to Run

### 🔗 [Download the game here](https://github.com/emily6g/SolitaireGame/raw/main/SolitaireGame.jar)

1. Ensure you have Java installed  
   *(Java 8 or higher recommended)*  
2. Run the game using:

``bash
java -jar SolitaireGame.jar

---

## 🛠️ How It Works

### Main Files

| File                                  | Purpose                                                       |
|---------------------------------------|---------------------------------------------------------------|
| `Solitaire.java`                      | Initializes game logic and card setup                         |
| `SolitaireJFrame.java`                | Main game window (Swing `JFrame`)                             |
| `SolitaireJPanel.java`                | Handles drawing the cards and mouse events                    |
| `CardPile.java`                       | Abstract class for pile behavior                              |
| `DeckPile`, `DiscardPile`, `DrawCard`,<br>`SuitPile`, `TablePile` | Each manages card behavior for different pile types            |

### Key Design

- **OOP**: Each pile is a class that extends `CardPile` and implements specific rules.
- **Mouse Interaction**: Clicking cards is handled via mouse listeners in `SolitaireJPanel`.
- **Redrawing**: `repaint()` is used to constantly update the card visuals after moves.
- **Game State**: Internal logic manages valid moves, win conditions, and redraws dynamically.

---

## 🎓 What I Learned

- Building Java GUIs using Swing (`JFrame`, `JPanel`, `Graphics`)
- Event-driven programming with mouse listeners
- Object-oriented design for game elements
- State management and dynamic UI updates
