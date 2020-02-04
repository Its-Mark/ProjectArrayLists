import java.lang.StringBuffer;

/**
 * CECS 277 Project ArrayLists
 * @author Mark Garcia
 *         mark.garcia01@student.csulb.edu
 * @author Brandon Wiitanen
 *
 */
public class Card {
    private int ranking; // 2-10, Jack (11), Queen (12), King (13), Ace (either 1 or 14 depending on the game being played.)
    private int suit; // 0-3 Clubs Spades Hearts Diamonds

    /**
     * Creates a Card with a suit(0-3) and a rank (2-14)
     * @param s int of suit
     * @param r int of rank
     */
    public Card(int s, int r){
        this.suit = s;
        this.ranking = r;
    }

    /**
     * Gets the rank/number of the card
     * @return cards ranking
     */
    public int getRank(){
        return ranking;
    }

    /**
     * Gets the suit of the card. Since suit is taken as an int there needs to be the if/else statements to
     * return the suit as a word
     * @return String of the suit of the card
     */
    public String getSuit(){
        String suitName = "";
        if(suit == 0){suitName = "Clubs";}
        else if (suit == 1) {suitName = "Spades";}
        else if (suit == 2) {suitName = "Hearts";}
        else if (suit == 3) {suitName = "Diamonds";}
        return suitName;
    }

    /**
     * Creates a string of the card.
     * @return a String in the form "Rank of Suit"
     */
    @Override
    public String toString(){
        StringBuffer card = new StringBuffer();
        if(ranking == 14){ card.append("Ace");}
        else if (ranking == 13){ card.append("King");}
        else if (ranking == 12){card.append("Queen");}
        else if (ranking == 11){card.append("Jack");}
        else {card.append(ranking);}
        card.append(" of ");
        if(suit == 0){card.append("Clubs ");}
        else if (suit == 1) {card.append("Spades");}
        else if (suit == 2) {card.append("Hearts");}
        else if (suit == 3) {card.append("Diamonds");}

        return card.toString();
    }

}
