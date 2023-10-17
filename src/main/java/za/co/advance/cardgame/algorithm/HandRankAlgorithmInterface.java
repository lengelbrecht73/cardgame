package za.co.advance.cardgame.algorithm;

import za.co.advance.cardgame.entity.Hand;
import za.co.advance.cardgame.enums.HandRankInterface;

//An interface for returning the highest hand rank order
public interface HandRankAlgorithmInterface {
     
    public HandRankInterface determineHighestPokerRank(Hand hand);
}
