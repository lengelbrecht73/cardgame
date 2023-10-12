package za.co.advance.fivecard.definition;

import lombok.Getter;

@Getter
public enum WinningHandRank {

    ROYAL_FLUSH("Royal Flush", "Consists of a 10, Jack, Queen, King, and Ace of the same Suit.", 1); 
 
    private final String hand;
    private final String description;
    private final int winningOrder;

    WinningHandRank(String hand, String descriptiom, int winningOrder){
        this.hand = hand;
        this.description = descriptiom;
        this.winningOrder = winningOrder;
    }
}