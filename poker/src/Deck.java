import java.util.*;

public class Deck {

    //variable holding whole deck of cards
    public List<Card> deckOfCards = new ArrayList<>();

    //method for preparing deck, putting actual cards in it
    public void prepareDeck() {
        String[] colors = {"Clubs", "Diamonds", "Hearts", "Spades"};
        String[] figures = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

        for (String figure : figures) {
            for (String color : colors) {
                Card new_card = new Card(figure, color);
                deckOfCards.add(new_card);
            }
        }
    }

    //method for printing whole deck
    public void showDeck() {
        for(Card newCard : deckOfCards)
        System.out.println(newCard.getName());
    }
}
