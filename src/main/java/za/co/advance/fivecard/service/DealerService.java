package za.co.advance.fivecard.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import za.co.advance.fivecard.algorithms.FisherYates;
import za.co.advance.fivecard.definition.Rank;
import za.co.advance.fivecard.definition.Suit;
import za.co.advance.fivecard.entity.Card;
import za.co.advance.fivecard.entity.Deck;
import za.co.advance.fivecard.entity.Hand;

@Service
@Slf4j
public class DealerService {
    
    public Deck collectCardsInDeck(boolean includeJokerCards){
        
        //The cards is probably not sorted as it is a popular game. ;-) 
        List<Suit> allSuitsInDeck = Arrays.asList(Suit.values());
        List<Rank> allRanksInDeck = Arrays.asList(Rank.values());

        log.info("The number of suits in a deck of cards: " + allSuitsInDeck.size());
        log.info("The number of ranks in a deck of cards: " + allRanksInDeck.size());

        //Get the number of cards in the deck, without taking the joker cards in consideration
        int numberofCardsInDeck = (allSuitsInDeck.size() - 1) * (allRanksInDeck.size());
        log.info("The number of cards in a deck without the JOKERS: " + numberofCardsInDeck);

         //There are 2 jokers in a standard set and One is already included
        if (includeJokerCards) numberofCardsInDeck = numberofCardsInDeck + 2; 
        log.info("The number of cards in deck taking into consideration if we need the 2 JOKERS " + numberofCardsInDeck);

        Deck deckOfCards = new Deck();

        //Remember that arrays indexes start at 0, the number of card indexes should be
        //1 less than the number of cards
        Card[] cards = new Card[numberofCardsInDeck];
        int cardNumber = 0;

        for (Suit suit: allSuitsInDeck){
            for (Rank rank: allRanksInDeck){
                //Don't add the JOKER cards to the deck just yet
                cardNumber = addCardOfSuitAndRankExludingJokers(cards, cardNumber, suit, rank);
            }         
        }

        if (includeJokerCards){
            Card jokerCard = new Card();
            jokerCard.setSuit(Suit.JOKER);
            //jokerCard is assumed to not have a rank - for now anycase

            //There are usually TWO jokerCards
            cards[cardNumber++] = jokerCard;
            cards[cardNumber++] = jokerCard;
        }
        
        deckOfCards.setDeckOfCards(Arrays.asList(cards));

        return deckOfCards;
    }

    public List<Card> shuffleDeck(Deck deck){
        FisherYates shuffleAlgorithm =  new FisherYates();
        return shuffleAlgorithm.shuffle(deck.getDeckOfCards());
    }

    public Hand dealHand(List<Card> shuffledDeck, int numberOfCards){
        List<Card> firstFive = shuffledDeck.stream()
                .limit(numberOfCards)
                .collect(Collectors.toList());
        return new Hand(firstFive, 5);
    }
    
    private int addCardOfSuitAndRankExludingJokers(Card[] cards, int cardNumber, Suit suit, Rank rank) {
       
        if (!suit.equals(Suit.JOKER)){
            Card card = new Card();
            card.setSuit(suit);
            card.setRank(rank);
            cards[cardNumber] = card;
            cardNumber++;
        }
        return cardNumber;
    }
}
