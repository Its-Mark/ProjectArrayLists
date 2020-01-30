import java.util.Collections;
import java.util.ArrayList;

public class Deck {
  private int deckSize;
  private ArrayList<Card> deck;

  public Deck() {
    deck = new ArrayList<>();
  }
  public void addCard(Card c){
    deck.add(c);
  }
  public void removeCard(Card c){
    deck.remove(c);
  }
  public Card getCard(int i){
    return deck.get(i);
  }

  public int getDeckSize(){
    return deck.size();
  }

  @Override
  public String toString(){
    String s = "This player has:";
    for(Card c : deck){
      s += c.toString();
    }//end for loop
    return s;
  }//end toString
}
