import java.lang.StringBuffer;

public class Card {
    private int ranking; // 2-10, Jack (11), Queen (12), King (13), Ace (either 1 or 14 depending on the game being played.)
    private int suit; // 0-3 Clubs Spades Hearts Diamonds


    public Card(int s, int r){
        this.suit = s;
        this.ranking = r;
    }

    public int getRank(){
        return ranking;
    }

    public String getSuit(){
        String suitName = "";
        if(suit == 0){suitName = "Clubs";}
        else if (suit == 1) {suitName = "Spades";}
        else if (suit == 2) {suitName = "Hearts";}
        else if (suit == 3) {suitName = "Diamonds";}
        return suitName;
    }

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
