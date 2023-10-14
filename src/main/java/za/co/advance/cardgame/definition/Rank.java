package za.co.advance.cardgame.definition;

import lombok.Getter;

@Getter
public enum Rank {
    DEUCE(2, "2"),
    THREE(3, "3"),
    FOUR(4, "4"),
    FIVE(5, "5"),
    SIX(6, "6"),
    SEVEN(7, "7"),
    EIGHT(8, "8"),
    NINE(9, "9"),
    TEN(10, "10"),
    JACK(10, "JACK"),
    QUEEN(10, "QUEEN"),
    KING(10, "KING"),
    ACE(11, "ACE");

    private final int rankPoints;
    private final String name;

    Rank(int points,String name) {
        this.rankPoints = points;
        this.name = name;
    }
}
