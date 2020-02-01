import java.util.Collections;
import java.util.ArrayList;

public class Deck {
  private ArrayList<Card> deck;

  /**
   * Constructor of a deck object which as ArrayList of Card objects.
   */
  public Deck() {
    deck = new ArrayList<>();
  }

  /**
   * Adds a card to the deck
   * @param c card to be added to the end of the deck
   */
  public void addCard(Card c){
    deck.add(c);
  }

  /**
   * Remove card from deck at index i
   * @param i index of card to be removed.
   */
  public void removeCard(int i){
    deck.remove(i);
  }

  /**
   * Gets the card at index i
   * @param i index of card in array list
   * @return the card at index i
   * @throws IndexOutOfBoundsException
   */
  public Card getCard(int i) throws IndexOutOfBoundsException{
    return deck.get(i);
  }

  /**
   * Takes 4 parameters, 2 are cards and 2 are those cards index.
   * swaps the two cards at their appropriate index.
   * @param c1 card to be moved
   * @param c2 card to be moved
   * @param num1 position to move card 2
   * @param num2 position to move card 1
   */
  public void swapCards(Card c1, Card c2, int num1, int num2){
    deck.set(num1, c2);
    deck.set(num2, c1);
  }

  /**
   * Gets the size of the deck.
   * @return deck size as an integer
   */
  public int getDeckSize(){
    return deck.size();
  }

  /**
   * Overrides the default toString() method and creates a string with all the cards in the current deck.
   * @return String of all cards the deck has
   */
  @Override
  public String toString(){
    String s = "This deck has: ";
    for(Card c : deck){
      s += c.toString() + ",";
    }//end for loop
    return s;
  }//end toString
}
