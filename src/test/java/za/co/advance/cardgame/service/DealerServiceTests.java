package za.co.advance.cardgame.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import za.co.advance.cardgame.definition.Suit;
import za.co.advance.cardgame.entity.Card;
import za.co.advance.cardgame.entity.Deck;
import za.co.advance.cardgame.entity.Hand;


@SpringBootTest(classes = DealerService.class)
public class DealerServiceTests {

    @Autowired
    DealerService dealerService = new DealerService();
    
    @Test
    public void testCollectCardsInDeckWithoutJokers() {
        // Create a new deck of cards.
        Deck deck = dealerService.collectCardsInDeck(false);

        // Check that the deck contains the correct number of cards.
        assertEquals(52, deck.getDeckOfCards().size());

        // Check that the deck contains the correct cards.
        for (Card card : deck.getDeckOfCards()) {
            assertNotNull(card);
            assertNotNull(card.getSuit());
            assertNotNull(card.getRank());
        }
    }

    @Test
    public void testCollectCardsInDeckJokers() {
        // Create a new deck of cards.
        Deck deck = dealerService.collectCardsInDeck(true);

        // Check that the deck contains the correct number of cards.
        assertEquals(54, deck.getDeckOfCards().size());

        // Check that the deck contains the correct cards.
        for (Card card : deck.getDeckOfCards()) {
            assertNotNull(card);
            assertNotNull(card.getSuit());
        }
    }

    @Test
    public void testShuffleDeck() {
        // Create a new deck of cards.
        Deck deck = dealerService.collectCardsInDeck(false);

        // Shuffle the deck.
        List<Card> shuffledDeck = dealerService.shuffleDeck(deck);

        // Check that the deck is shuffled.
        assertFalse(shuffledDeck.equals(deck.getDeckOfCards()));
    }

    @Test
    public void testDealHand() {
        // Create a new deck of cards.
        Deck deck = dealerService.collectCardsInDeck(false);

        // Shuffle the deck.
        List<Card> shuffledDeck = dealerService.shuffleDeck(deck);

        // Deal a hand of cards.
        Hand hand = dealerService.dealHand(shuffledDeck, 5);

        // Check that the hand contains the correct number of cards.
        assertEquals(5, hand.getCardsInHand().size());

        // Check that the hand contains the correct cards.
        for (Card card : hand.getCardsInHand()) {
            assertNotNull(card);
            assertNotNull(card.getSuit());
            assertNotNull(card.getRank());
        }
    }
}