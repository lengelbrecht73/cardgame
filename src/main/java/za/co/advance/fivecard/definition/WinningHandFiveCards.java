package za.co.advance.fivecard.definition;

public enum WinningHandFiveCards implements WinningHand {

    ROYAL_FLUSH("Royal Flush", "Consists of a 10, Jack, Queen, King, and Ace of the same Suit.", 1);

    private final String hand;
    private final String description;
    private final int winningOrder;

    WinningHandFiveCards(String hand, String description, int winningOrder) {
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