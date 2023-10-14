package za.co.advance.fivecard.definition;

import lombok.Getter;

@Getter
public enum GameVariant {
    
    FIVECARD("fivecard", "A poker game of five cards in a hand."),
    BADUGI("badugi", "A variant of the five card game, but with 4 cards in a hand.");

    private final String name;
    private final String description;
    
    private GameVariant(String name, String description) {
        this.name = name;
        this.description = description;
    }


}
