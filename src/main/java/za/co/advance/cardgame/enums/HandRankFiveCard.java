package za.co.advance.cardgame.enums;

public enum HandRankFiveCard implements HandRankInterface {

    STRAIGHT_FLUSH("Straight Flush", "Consists of five cards in order of the same Suit.", 1),
    FOUR_OF_A_KIND("Four of a Kind", "Consists four cards of the same Rank and another card.", 2),
    FULL_HOUSE("Full House","Contains three cards of one Rank and two cards of another Rank.", 3),
    FLUSH("Flush","Contains five cards, all of the same Suit but not in order.", 4),
    STRAIGHT("Straight","Contains five cards in order, but not of the same Suit.", 5),
    THREE_OF_A_KIND("Three of a Kind","Contains three cards of one Rank.", 6),
    TWO_PAIR("Two pair","Contains two cards of one Rank, two cards of another Rank and one card of a third Rank.", 7),   
    ONE_PAIR("One pair","Contains two cards of one Rank and three cards of three other Ranks.", 8), 
    HIGH_CARDS("High Cards", "Consists of nothing winnable.", 20);

    private final String hand;
    private final String description;
    private final int winningOrder;

    HandRankFiveCard(String hand, String description, int winningOrder) {
        this.hand = hand;
        this.description = description;
        this.winningOrder = winningOrder;
    }

    @Override
    public String getHand() {
        return hand;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public int getWinningOrder() {
        return winningOrder;
    }
}