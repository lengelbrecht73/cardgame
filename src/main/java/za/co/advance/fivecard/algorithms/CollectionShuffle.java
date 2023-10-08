package za.co.advance.fivecard.algorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import za.co.advance.fivecard.entity.Card;

/** 
 * Using Collections.shuffle() could be an alternative
*/
//Implementing an interface makes it easier to replace the shuffle algorithm
public class CollectionShuffle implements ShuffleAlgorithm{

    @Override
    public List<Card> shuffle(List<Card> items) {
        Collections.shuffle(items);
        return items;
    }

}
