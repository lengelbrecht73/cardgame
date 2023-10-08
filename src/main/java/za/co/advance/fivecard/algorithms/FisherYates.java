package za.co.advance.fivecard.algorithms;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import za.co.advance.fivecard.entity.Card;

/** FisherYates shuffle is a knowm algorithm for shuffling cards. Also known as the Knuth shuffle
 How it works:
    1. Start at the last card (n - 1) and work backwards to the first card (n = 0)
    2. For each card visited, replace it with a random card between 0 and n - 1 
*/
//Implementing an interface makes it easier to replace the shuffle algorithm
public class FisherYates implements ShuffleAlgorithm{

    @Override
    public List<Card> shuffle(List<Card> cards) {

        Card[] deckArray = cards.toArray(new Card[0]);
        Random randomNumber = new Random();
        int cardToSwopOut = 0;
        for (int n = cards.size() - 1; n > - 1; n--){
            cardToSwopOut = randomNumber.nextInt(cards.size());
            Card current = deckArray[n];
            deckArray[cardToSwopOut] = current;
            deckArray[n] = current;
        }
        
        return Arrays.asList(deckArray);
    }

}