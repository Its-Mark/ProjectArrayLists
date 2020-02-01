import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class WarGame {
  private static Deck player2Deck;
  private static Deck player1Deck;

  /**
   * This method creates a Deck object which is an ArrayList of Card objects.
   * Standard deck has 52 cards therefore only 52 cards are created.
   * @return a deck of 52 cards
   */
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
      random = new Random().nextInt(d.getDeckSize()-1);
      temp1 = d.getCard(i);
      temp2 = d.getCard(random);
      d.swapCards(temp1, temp2, i, random);
    }//end for loop
    return d;
  }

  /**
   * This method makes player 1's deck by taking in the masterDeck and then getting half of their cards.
   * Player 2's deck is just going to be the remainder of masterDeck
   * @param d is the master deck
   * @return player 1 deck
   */
  public static Deck makePlayerHand(Deck d){
    Deck PlayerDeck = new Deck();
    while (PlayerDeck.getDeckSize() != 26) {
      for (int i = 0; i < d.getDeckSize()-1 ; i++) {
        PlayerDeck.addCard(d.getCard(i));
        d.removeCard(i);
      }
    }
    return PlayerDeck;
  }

  public static void main (String [] args) {
    Deck masterDeck = makeMasterDeck();
    shuffle(masterDeck);
    player1Deck = makePlayerHand(masterDeck);
    player2Deck = masterDeck;
    while(player1Deck.getDeckSize() != 0 && player2Deck.getDeckSize() != 0){
      for (int i = 0; i < player1Deck.getDeckSize(); i++){
        if (player1Deck.getDeckSize() == 0){
          System.out.println("Player 2 wins the game!");
          System.exit(0);
        } else if (player2Deck.getDeckSize() == 0){
          System.out.println("Player 1 wins the game!");
          System.exit(0);
        } else { // both players have enough cards to play
          System.out.println("Player 1 plays a " + player1Deck.getCard(i).toString().stripTrailing());
          System.out.println("Player 2 plays a " + player2Deck.getCard(i).toString().stripTrailing());
          if (player1Deck.getCard(i).getRank() > player2Deck.getCard(i).getRank()) { // player 1 wins
            player1Deck.addCard(player2Deck.getCard(i));
            player2Deck.removeCard(i);
            System.out.println("Player 1 wins the round!");
          } else if (player1Deck.getCard(i).getRank() < player2Deck.getCard(i).getRank()) { //player 2 wins
            player2Deck.addCard(player1Deck.getCard(i));
            player1Deck.removeCard(i);
            System.out.println("Player 2 wins the round!");
          } else { //war
            System.out.println("war");

          }
        }
      }//end for loop
    }//end while loop
  }

}
