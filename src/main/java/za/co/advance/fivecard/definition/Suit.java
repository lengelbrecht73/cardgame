package za.co.advance.fivecard.definition;

public enum Suit {

    CLUBS("C", "Clubs", "♣"),
    DIAMONDS("D", "Diamonds", "♦"),
    HEARTS("H", "Hearts", "♥"),
    SPADES("S", "Spades", "♠"),
    //If we later want to use the enum/software for a different card game, 
    // requiring a joker card 
    JOKER("J", "JOKER", "☺");  
 
    private final String letter;
    private final String description;
    private final String symbol;

    Suit(String letter, String description, String symbol) {
        this.letter = letter;
        this.description = description;
        this.symbol = symbol;
    }

    public String getLetter() {
        return letter;
    }

    public String getDescription() {
        return description;
    }

    public String getSymbol() {
        return symbol;
    }
}