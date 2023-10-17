package za.co.advance.cardgame.enums;

import lombok.Getter;

@Getter
public enum Rank {
    DEUCE(2, "2", 2),
    THREE(3, "3", 3),
    FOUR(4, "4", 4),
    FIVE(5, "5", 5),
    SIX(6, "6", 6),
    SEVEN(7, "7", 7),
    EIGHT(8, "8", 8),
    NINE(9, "9", 9),
    TEN(10, "10", 10),
    JACK(10, "JACK", 11),
    QUEEN(10, "QUEEN", 12),
    KING(10, "KING", 13),
    ACE(11, "ACE", 14);

    private final int rankPoints;
    private final String name;
    private final int order;

    //The points a card count, its name and its order in the pack
    //Please note that the ACE can count in some variants as 1 or 14 in the order - this must be addressed
    //in the specific order algorithm where applicable as it is a special condition
    Rank(int points, String name, int order) {
        this.rankPoints = points;
        this.name = name;
        this.order = order;
    }
}
