package za.co.advance.cardgame.algorithm;

import java.util.Collections;
import java.util.List;
import za.co.advance.cardgame.entity.Card;

/** 
 * Using Collections.shuffle() could be an alternative
*/
//Implementing an interface makes it easier to replace the shuffle algorithm
//Not used currently, but to showcase that the algorithm can be replaced
public class CollectionShuffle implements ShuffleAlgorithmInterface{

    @Override
    public List<Card> shuffle(List<Card> items) {
        Collections.shuffle(items);
        return items;
    }

}
