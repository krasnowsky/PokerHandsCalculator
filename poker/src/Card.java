public class Card {
    //variable for card name ex. Ace, King, 2
    private final String name;

    //variable for card color ex. Diamonds, Spades
    private final String color;

    //constructor setting the name and color of the card
    public Card(String newName, String newColor) {
        this.name = newName;
        this.color = newColor;
    }

    //method for getting the whole info about the card
    public String getName() {
        return name + " of " + color;
    }

    //method for getting only name of the card
    public String getOnlyName() {
        return name;
    }

    //method for getting only color of the card
    public String getColor() {
        return color;
    }
}
