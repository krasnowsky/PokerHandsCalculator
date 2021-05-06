import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PokerLogic implements PokerLogicInterface {
    //initial size of a deck
    private int size = 52;

    //declaration of variables
    private final Deck pokerLogicDeck = new Deck();
    private final List<Card> player = new ArrayList<>();
    private final List<Card> table = new ArrayList<>();
    private final List<Card> together = new ArrayList<>();

    //method for checking if hand is a Royal Flush
    public boolean checkRoyalFlush() {
        join();
        if(checkSuit()) {
            for(Card cardOne : together) {
                if(cardOne.getOnlyName().equals("Ace")) {
                    for(Card cardTwo : together) {
                        if(cardTwo.getOnlyName().equals("King") && cardTwo.getColor().equals(cardOne.getColor())) {
                            for(Card cardThree : together) {
                                if(cardThree.getOnlyName().equals("Queen") && cardThree.getColor().equals(cardOne.getColor())) {
                                    for(Card cardFour : together) {
                                        if(cardFour.getOnlyName().equals("Jack") && cardFour.getColor().equals(cardOne.getColor())) {
                                            for(Card cardFive : together) {
                                                if(cardFive.getOnlyName().equals("10") && cardFive.getColor().equals(cardOne.getColor())) return true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    //method for checking if hand is a Flush
    public boolean checkFlush() {
        join();
        return checkSuit();
    }

    //method for setting up a game
    public void gameSetUp() {
        shuffleCards();
        giveCardToPlayer1(2);
        giveCardToDiffPlayer(6);
        flop();
        turn();
        river();
    }

    //method for checking if hand is suited
    private boolean checkSuit() {
        int counterClubs = 0;
        int counterDiamonds = 0;
        int counterHearts = 0;
        int counterSpades = 0;
        for(Card newCard : together) {
            switch (newCard.getColor()) {
                case "Clubs" -> counterClubs++;
                case "Diamonds" -> counterDiamonds++;
                case "Hearts" -> counterHearts++;
                case "Spades" -> counterSpades++;
            }
        }
        return counterClubs >= 5 || counterDiamonds >= 5 || counterHearts >= 5 || counterSpades >= 5;
    }

    //method for getting info about the matching hands
    public void getInfoAboutHands() {
        System.out.println("HAND: ");
        showDeckPlayer();
        System.out.println("----------------");
        showDeckTable();
        System.out.println("----------------");
    }

    //method for joining player and table list
    private void join() {
        together.addAll(player);
        together.addAll(table);
    }

    //methods for initializing poker game
    private void flop() {
        putCardOnTheTable(3);
    }
    private void turn() {
        putCardOnTheTable(1);
    }
    private void river() {
        putCardOnTheTable(1);
    }

    //method for showing particular deck
    private void showDeckPlayer() {
        for(Card newCard : player)
            System.out.println(newCard.getName());
    }
    private void showDeckTable() {
        for(Card newCard : table)
            System.out.println(newCard.getName());
    }

    //method for shuffling the cards in the deck
    private void shuffleCards() {
        pokerLogicDeck.prepareDeck();
        Collections.shuffle(pokerLogicDeck.deckOfCards);
    }

    //methods for either giving cards to a player or putting them on the table
    private void giveCardToPlayer1(int value) {
        for(int i = 0; i < value; i++) {
            int random = getRandom(size);
            player.add(pokerLogicDeck.deckOfCards.get(random));
            pokerLogicDeck.deckOfCards.remove(random);
            size--;
        }
    }
    private void giveCardToDiffPlayer(int value) {
        for(int i = 0; i < value; i++) {
            int random = getRandom(size);
            pokerLogicDeck.deckOfCards.remove(random);
            size--;
        }
    }
    private void putCardOnTheTable(int value) {
        for(int i = 0; i < value; i++) {
            int random = getRandom(size);
            table.add(pokerLogicDeck.deckOfCards.get(random));
            pokerLogicDeck.deckOfCards.remove(random);
            size--;
        }
    }

    //method for getting random number in given boundaries
    private int getRandom(int bound) {
        Random rand = new Random();
        return rand.nextInt(bound);
    }

}
