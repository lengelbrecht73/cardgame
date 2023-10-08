package za.co.advance.fivecard.algorithms;

import java.util.List;

import za.co.advance.fivecard.entity.Card;

//Defining an interface makes it easier to replace the shuffle algorithm
public interface ShuffleAlgorithm {
    public List<Card> shuffle(List<Card> items);
}
