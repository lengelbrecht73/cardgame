package za.co.advance.cardgame.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import za.co.advance.cardgame.algorithms.FisherYatesShuffle;
import za.co.advance.cardgame.definition.Rank;
import za.co.advance.cardgame.definition.Suit;
import za.co.advance.cardgame.entity.Card;
import za.co.advance.cardgame.entity.Deck;
import za.co.advance.cardgame.entity.Hand;

@Service
@Slf4j
public class DealerService {
    
    public Deck collectCardsInDeck(boolean includeJokerCards){
     
        log.debug("\n\n\n\nThe deck of cards before being shuffled:");

        //The cards is probably not sorted as it is a popular game. ;-) 
        List<Suit> allSuitsInDeck = Arrays.asList(Suit.values());
        List<Rank> allRanksInDeck = Arrays.asList(Rank.values());

        log.debug("The number of suits in a standard deck of cards: " + allSuitsInDeck.size());
        log.debug("The number of ranks in a standard deck of cards: " + allRanksInDeck.size());

        //Get the number of cards in the deck, without taking the joker cards in consideration
        int numberofCardsInDeck = (allSuitsInDeck.size() - 1) * (allRanksInDeck.size());
        log.debug("The number of cards in a deck without the JOKERS: " + numberofCardsInDeck);

         //There are 2 jokers in a standard set and One is already included
        if (includeJokerCards) numberofCardsInDeck = numberofCardsInDeck + 2; 
        log.debug("The number of cards in deck taking into consideration if we need the 2 JOKERS " + numberofCardsInDeck);

        Deck deckOfCards = new Deck();

        //Remember that arrays indexes start at 0, the number of card indexes should be
        //1 less than the number of cards
        Card[] cards = new Card[numberofCardsInDeck];
        int cardNumber = 0;

        for (Suit suit: allSuitsInDeck){
            for (Rank rank: allRanksInDeck){
                //Add cards
                cardNumber = addCardOfSuitAndRank(cards, cardNumber, suit, rank, includeJokerCards);
            }         
        }

        if (includeJokerCards){
            Card jokerCard = new Card(Suit.JOKER, null);
            //jokerCard is assumed to not have a rank - for now anycase

            //There are usually TWO jokerCards
            cards[cardNumber++] = jokerCard;
        }
        
        deckOfCards.setDeckOfCards(Arrays.asList(cards));
        for (Card card: deckOfCards.getDeckOfCards()){
			if (card.getRank() != null){
				log.debug(card.getSuit().getDescription() + " " + card.getRank().name());
			}
		}
        return deckOfCards;
    }

    public List<Card> shuffleDeck(Deck deck){
        FisherYatesShuffle shuffleAlgorithm =  new FisherYatesShuffle();
        log.debug("\n\n\n\nThe deck of cards after being shuffled:");
		List<Card> shuffledDeck = shuffleAlgorithm.shuffle(deck.getDeckOfCards());
		for (Card card : shuffledDeck) {
			log.debug(card.getSuit().getDescription() + " " + card.getRank().name());
		}
        return shuffledDeck;
    }

    public Hand dealHand(List<Card> shuffledDeck, int numberOfCards){
        List<Card> drawCards = shuffledDeck.stream()
                .limit(numberOfCards)
                .collect(Collectors.toList());
        
        System.out.println("\n\n\n\nHand dealt:");
        Hand handDealt = new Hand(drawCards, numberOfCards);

        //Could be printing the values card.getSuit.getSymbol for the specific
        //Poker card symbols, but it could misbehave on certain console outputs.
        //Since there seems to be plans for a web based version, it could be better
        //implemented in HTML in the future.
		for (Card card : handDealt.getCardsInHand()) {
			System.out.println(card.getRank().name() + " of " + card.getSuit().getDescription());
		}	
        return handDealt;
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
