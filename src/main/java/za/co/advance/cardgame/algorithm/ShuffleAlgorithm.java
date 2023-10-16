package za.co.advance.cardgame.algorithm;

import java.util.List;

import za.co.advance.cardgame.entity.Card;

//Defining an interface makes it easier to replace the shuffle algorithm
public interface ShuffleAlgorithm {
    public List<Card> shuffle(List<Card> items);
}
