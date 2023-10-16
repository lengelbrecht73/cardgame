package za.co.advance.cardgame.definition;

import lombok.Getter;

@Getter
public enum Suit {

    CLUBS("C", "Clubs", '\u2663'),
    DIAMONDS("D", "Diamonds", '\u2666'),
    HEARTS("H", "Hearts", '\u2665'),
    SPADES("S", "Spades", '\u2660'),
    //If we later want to use the enum/software for a different card game, 
    // requiring a joker card 
    JOKER("J", "JOKER", '\u263A');  
 
    private final String letter;
    private final String description;
    private final char symbol;

    Suit(String letter, String description, char symbol) {
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

    public char getSymbol() {
        return symbol;
    }
}