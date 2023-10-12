package za.co.advance.fivecard.definition;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum Suit {

    CLUBS("C", "Clubs", '\u2663'),
    DIAMONDS("D", "Diamonds", '\u1234'),
    HEARTS("H", "Hearts", '\u2660'),
    SPADES("S", "Spades", '\u2660'),
    //If we later want to use the enum/software for a different card game, 
    // requiring a joker card 
    JOKER("J", "JOKER", '\u2660');  
 
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