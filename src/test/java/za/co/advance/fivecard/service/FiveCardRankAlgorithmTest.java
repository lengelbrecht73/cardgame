package za.co.advance.fivecard.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import za.co.advance.cardgame.algorithms.FiveCardRankAlgorithm;
import za.co.advance.cardgame.definition.HandRank;
import za.co.advance.cardgame.definition.HandRankFiveCard;
import za.co.advance.cardgame.definition.Rank;
import za.co.advance.cardgame.definition.Suit;
import za.co.advance.cardgame.entity.Card;
import za.co.advance.cardgame.entity.Hand;
import za.co.advance.cardgame.service.DealerService;

class FiveCardRankAlgorithmTest {

    @Autowired
    DealerService dealerService;
    
    @Test
    void testStraightFlush(){
        List<Card> cards = new ArrayList<>();
        Card card1 = new Card(Suit.SPADES, Rank.FIVE);
        Card card2 = new Card(Suit.SPADES, Rank.FOUR);
        Card card3 = new Card(Suit.SPADES, Rank.DEUCE);
        Card card4 = new Card(Suit.SPADES, Rank.THREE);
        Card card5 = new Card(Suit.SPADES, Rank.SIX);

        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);

        Hand hand = new Hand(cards,5);
        FiveCardRankAlgorithm algorithm =  new FiveCardRankAlgorithm();
        HandRankFiveCard rank = (HandRankFiveCard) algorithm.determineHighestPokerRank(hand);

        assertEquals(HandRankFiveCard.STRAIGHT_FLUSH, rank);
    }

    @Test
    void testFourOfAKind(){
        List<Card> cards = new ArrayList<>();
        Card card1 = new Card(Suit.SPADES, Rank.FIVE);
        Card card2 = new Card(Suit.SPADES, Rank.SEVEN);
        Card card3 = new Card(Suit.HEARTS, Rank.FIVE);
        Card card4 = new Card(Suit.CLUBS, Rank.FIVE);
        Card card5 = new Card(Suit.DIAMONDS, Rank.FIVE);

        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);

        Hand hand = new Hand(cards,5);
        FiveCardRankAlgorithm algorithm =  new FiveCardRankAlgorithm();
        HandRankFiveCard rank = (HandRankFiveCard) algorithm.determineHighestPokerRank(hand);

        assertEquals(HandRankFiveCard.FOUR_OF_A_KIND, rank);
    }

    @Test
    void testFullHouse(){
        List<Card> cards = new ArrayList<>();
        Card card1 = new Card(Suit.SPADES, Rank.FIVE);
        Card card2 = new Card(Suit.SPADES, Rank.SEVEN);
        Card card3 = new Card(Suit.HEARTS, Rank.FIVE);
        Card card4 = new Card(Suit.CLUBS, Rank.SEVEN);
        Card card5 = new Card(Suit.DIAMONDS, Rank.SEVEN);

        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);

        Hand hand = new Hand(cards,5);
        FiveCardRankAlgorithm algorithm =  new FiveCardRankAlgorithm();
        HandRankFiveCard rank = (HandRankFiveCard) algorithm.determineHighestPokerRank(hand);

        assertEquals(HandRankFiveCard.FULL_HOUSE, rank);
    }

    @Test
    void testFlush(){
        List<Card> cards = new ArrayList<>();
        Card card1 = new Card(Suit.SPADES, Rank.FIVE);
        Card card2 = new Card(Suit.SPADES, Rank.NINE);
        Card card3 = new Card(Suit.SPADES, Rank.THREE);
        Card card4 = new Card(Suit.SPADES, Rank.KING);
        Card card5 = new Card(Suit.SPADES, Rank.TEN);

        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);

        Hand hand = new Hand(cards,5);
        FiveCardRankAlgorithm algorithm =  new FiveCardRankAlgorithm();
        HandRankFiveCard rank = (HandRankFiveCard) algorithm.determineHighestPokerRank(hand);

        assertEquals(HandRankFiveCard.FLUSH, rank);
    }

    @Test
    void testStraight(){
        List<Card> cards = new ArrayList<>();
        Card card1 = new Card(Suit.SPADES, Rank.NINE);
        Card card2 = new Card(Suit.DIAMONDS, Rank.QUEEN);
        Card card3 = new Card(Suit.DIAMONDS, Rank.TEN);
        Card card4 = new Card(Suit.CLUBS, Rank.JACK);
        Card card5 = new Card(Suit.DIAMONDS, Rank.EIGHT);

        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);

        Hand hand = new Hand(cards,5);
        FiveCardRankAlgorithm algorithm =  new FiveCardRankAlgorithm();
        HandRankFiveCard rank = (HandRankFiveCard) algorithm.determineHighestPokerRank(hand);

        assertEquals(HandRankFiveCard.STRAIGHT, rank);
    }

    @Test
    void testThreeOfAKin(){
        List<Card> cards = new ArrayList<>();
        Card card1 = new Card(Suit.SPADES, Rank.NINE);
        Card card2 = new Card(Suit.DIAMONDS, Rank.QUEEN);
        Card card3 = new Card(Suit.DIAMONDS, Rank.NINE);
        Card card4 = new Card(Suit.CLUBS, Rank.ACE);
        Card card5 = new Card(Suit.DIAMONDS, Rank.NINE);

        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);

        Hand hand = new Hand(cards,5);
        FiveCardRankAlgorithm algorithm =  new FiveCardRankAlgorithm();
        HandRankFiveCard rank = (HandRankFiveCard) algorithm.determineHighestPokerRank(hand);

        assertEquals(HandRankFiveCard.THREE_OF_A_KIND, rank);
    }


    @Test
    void testTwoPairs(){
        List<Card> cards = new ArrayList<>();
        Card card1 = new Card(Suit.SPADES, Rank.ACE);
        Card card2 = new Card(Suit.DIAMONDS, Rank.TEN);
        Card card3 = new Card(Suit.HEARTS, Rank.TEN);
        Card card4 = new Card(Suit.HEARTS, Rank.KING);
        Card card5 = new Card(Suit.CLUBS, Rank.ACE);

        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);

        Hand hand = new Hand(cards,5);
        FiveCardRankAlgorithm algorithm =  new FiveCardRankAlgorithm();
        HandRankFiveCard rank = (HandRankFiveCard) algorithm.determineHighestPokerRank(hand);

        assertEquals(HandRankFiveCard.TWO_PAIR, rank);
    }

    @Test
    void testOnePair(){
        List<Card> cards = new ArrayList<>();
        Card card1 = new Card(Suit.SPADES, Rank.ACE);
        Card card2 = new Card(Suit.DIAMONDS, Rank.TEN);
        Card card3 = new Card(Suit.HEARTS, Rank.TEN);
        Card card4 = new Card(Suit.HEARTS, Rank.KING);
        Card card5 = new Card(Suit.CLUBS, Rank.SIX);

        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);

        Hand hand = new Hand(cards,5);
        FiveCardRankAlgorithm algorithm =  new FiveCardRankAlgorithm();
        HandRankFiveCard rank = (HandRankFiveCard) algorithm.determineHighestPokerRank(hand);

        assertEquals(HandRankFiveCard.ONE_PAIR, rank);
    }

    @Test
    void testHighCard(){
        List<Card> cards = new ArrayList<>();
        Card card1 = new Card(Suit.SPADES, Rank.ACE);
        Card card2 = new Card(Suit.DIAMONDS, Rank.SEVEN);
        Card card3 = new Card(Suit.HEARTS, Rank.TEN);
        Card card4 = new Card(Suit.HEARTS, Rank.KING);
        Card card5 = new Card(Suit.CLUBS, Rank.SIX);

        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);

        Hand hand = new Hand(cards,5);
        FiveCardRankAlgorithm algorithm =  new FiveCardRankAlgorithm();
        HandRankFiveCard rank = (HandRankFiveCard) algorithm.determineHighestPokerRank(hand);

        assertEquals(HandRankFiveCard.HIGH_CARDS, rank);
    }
}
