package za.co.advance.cardgame.enums;

import lombok.Getter;

@Getter
public enum GameVariant {
    
    FIVECARD("fivecard", "A poker game of five cards in a hand.",5),
    //Not yet implemented - future dev
    BADUGI("badugi", "A variant of the five card game, but with 4 cards in a hand.",4);

    private final String name;
    private final String description;
    private final int numberofCards;
    
    private GameVariant(String name, String description, int numberOfCards) {
        this.name = name;
        this.description = description;
        this.numberofCards = numberOfCards;
    }


}
