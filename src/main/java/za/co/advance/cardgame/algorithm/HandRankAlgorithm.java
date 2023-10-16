package za.co.advance.cardgame.algorithm;

import za.co.advance.cardgame.definition.HandRank;
import za.co.advance.cardgame.entity.Hand;

//An interface for returning the highest hand rank order
public interface HandRankAlgorithm {
     
    public HandRank determineHighestPokerRank(Hand hand);
}
