import java.util.Collections;
import java.util.Random;

public class WarGame {
  private static int numofPlayer1Cards;
  private static int numofPlayer2Cards;
  private static Deck Player2Deck;
  private static Deck Player1Deck;

  public static Deck makeMasterDeck() {
    Deck cardDeck = new Deck();
    while(cardDeck.getDeckSize() != 52){
      for(int j = 0; j <= 3; j++){
        for(int k = 2; k <= 14; k++){
          cardDeck.addCard(new Card(j,k));
        }//end cardRanking for loop
      } //end suit for loop
    }//end while loop
    return cardDeck;
  }

  /**
   * Creates temp variables for cards in the deck
   * one of the cards corresponds to the position of i in the arraylist and another card corresponds to the position
   * of a random number in the deck. Then the two cards are swapped. it is possible however that the same card is swapped with
   * the same card for 52 times but the chances of that are close to 0.
   * @param d is the deck to be shuffled
   * @return a deck that has been pseudo shuffled 52 times.
   */
  public static Deck shuffle(Deck d){
    Card temp1;
    Card temp2;
    int random;
    for(int i = 0; i < d.getDeckSize(); i++){
      random = new Random().nextInt(53);
      temp1 = d.getCard(i);
      temp2 = d.getCard(random);
      d.swapCards(temp1, temp2, i, random);
    }//end for loop
    return d;
  }

  public static Deck makePlayerHand(Deck d){
    Deck PlayerDeck = new Deck();
    for(int i = 0; i < 26; i++) {
      PlayerDeck.addCard(d.getCard(i));
      d.removeCard(d.getCard(i));
    }
    return PlayerDeck;
  }

  public static void mainCompare(Card c1, Card c2) {
    if (c1.getRank() > c2.getRank()) {
      Player1Deck.addCard(c1);
      Player1Deck.addCard(c2);
      numofPlayer1Cards += 1;
      numofPlayer2Cards -= 1;
    }
    else {
      Player2Deck.addCard(c1);
      Player2Deck.addCard(c2);
      numofPlayer2Cards += 1;
      numofPlayer1Cards -= 1;
    }
  }

  /*public void bigCompare(){

  }*/

  public static void main (String [] args) {
    Deck deck = makeMasterDeck();
    shuffle(deck);
    Player1Deck = makePlayerHand(deck);
    numofPlayer1Cards = 26;
    numofPlayer2Cards = 26;
    Player2Deck = makePlayerHand(deck);
    Card cardInPlay1 = Player1Deck.getCard(0);
    Card cardInPlay2 = Player2Deck.getCard(0);
    System.out.println("Cards have been shuffled. Hands have been made. Begin.");
    while (numofPlayer1Cards > 0 && numofPlayer2Cards > 0) {
      System.out.println("Player 1 plays a " + cardInPlay1);
      System.out.println("Player 2 plays a " + cardInPlay2);
      mainCompare(cardInPlay1, cardInPlay2);
    }
    if (numofPlayer1Cards == 0) {System.out.println("Player 2 Wins!");}
    else {System.out.println("Player 1 Wins!");}
  }
}
