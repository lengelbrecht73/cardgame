package za.co.advance.cardgame.definition;

//Still to be implemented in version 2
public enum HandRankBadugi implements HandRank {

    //None, as it is not yet required to be implemented
    NONE("NONE", "None", 1);

    private final String hand;
    private final String description;
    private final int winningOrder;

    HandRankBadugi(String hand, String description, int winningOrder) {
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