package za.co.advance.cardgame.definition;

public enum HandRankFiveCard implements HandRank {

    ROYAL_FLUSH("Royal Flush", "Consists of a 10, Jack, Queen, King, and Ace of the same Suit.", 1),
    FOUR_OF_A_KIND("Four of a Kind", "Consists four cards of the same Rank and another card.", 2),
    FULL_HOUSE("Full House","Contains three cards of one rank and two cards of another rank", 3),
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