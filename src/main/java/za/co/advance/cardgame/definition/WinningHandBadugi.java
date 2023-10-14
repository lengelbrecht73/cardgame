package za.co.advance.cardgame.definition;

//Still to be implemented in version 2
public enum WinningHandBadugi implements WinningHand {

    //None, as it is not yet required to be implemented
    NONE("NONE", "None", 1);

    private final String hand;
    private final String description;
    private final int winningOrder;

    WinningHandBadugi(String hand, String description, int winningOrder) {
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