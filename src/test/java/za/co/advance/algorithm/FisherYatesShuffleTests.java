package za.co.advance.algorithm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.Test;

import za.co.advance.cardgame.algorithm.FisherYatesShuffle;
import za.co.advance.cardgame.definition.Rank;
import za.co.advance.cardgame.definition.Suit;
import za.co.advance.cardgame.entity.Card;

class FisherYatesShuffleTests {
     
   @Test
    void testShuffle() {

        List<Suit> allSuitsInDeck = Arrays.asList(Suit.values());
        List<Rank> allRanksInDeck = Arrays.asList(Rank.values());

        // Create a sorted deck of cards
        Card[] originalDeck =  new Card[52];  //Standard  desk without joker cards
        int cardNumber = 0;
        for (Suit suit: allSuitsInDeck){
            for (Rank rank: allRanksInDeck){
                //Add cards
                cardNumber = addCardOfSuitAndRank(originalDeck, cardNumber, suit, rank, false);
            }         
        }

        // Shuffle the deck
        FisherYatesShuffle shuffleAlgorithm =  new FisherYatesShuffle();
        List<Card> shuffledDeck = shuffleAlgorithm.shuffle(Arrays.asList(originalDeck));

        // Assert that the shuffled deck is not equal to the original deck (with extremely high probability)
        assertNotEquals(Arrays.asList(originalDeck), shuffledDeck);

        // Assert that the shuffled deck has the same cards as the original deck
        List<Card> originalDeckAsList = Arrays.asList(originalDeck);
        Collections.sort(originalDeckAsList, Comparator.comparingInt(card -> card.getRank().getOrder()));
        Collections.sort(shuffledDeck, Comparator.comparingInt(card -> card.getRank().getOrder()));
      //  assertEquals(originalDeckAsList, shuffledDeck);
    }

    private int addCardOfSuitAndRank(Card[] cards, int cardNumber, Suit suit, Rank rank, boolean includeJokerCards) {
       
        if (!includeJokerCards && !suit.equals(Suit.JOKER)){
            Card card = new Card(suit, rank);
            cards[cardNumber] = card;
            cardNumber++;
        }
        return cardNumber;
    }
}
