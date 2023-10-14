package za.co.advance.cardgame.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import za.co.advance.cardgame.definition.HandRank;
import za.co.advance.cardgame.definition.HandRankFiveCard;
import za.co.advance.cardgame.definition.Rank;
import za.co.advance.cardgame.definition.Suit;
import za.co.advance.cardgame.entity.Card;
import za.co.advance.cardgame.entity.Hand;

@Slf4j
@Getter
public class FiveCardRankAlgorithm implements HandRankAlgorithm{

    private Map<String,Integer> numberOfKindMap = new HashMap<>(); 
    private boolean sameSuit;
    private boolean inOrder;
    private List<Card> cardsInHand = new ArrayList<>();
    /*private int numberOfAcesInHand = 0;
    private int numberOfDueceInHand = 0; 
    private int numberOfThreeInHand = 0; 
    private int numberOfFourInHand = 0; 
    private int numberOfFiveInHand = 0; 
    private int numberOfSixInHand = 0; 
    private int numberOfSevenInHand = 0; 
    private int numberOfEightInHand = 0; 
    private int numberOfNineInHand = 0; 
    private int numberOfTenInHand = 0; 
    private int numberOfJackInHand = 0;
    private int numberOfQueenInHand = 0;
    private int numberOfKingInHand = 0;
    */

    @Override
    public HandRank determineHighestPokerRank(Hand hand) {
 
       //Lets sort the cards once
       //Initiliase the private variables for re-use in the logic
       initialisePrivateVariablesForReuse(hand);       
       //Check for ROYAL_FLUSH
       if (isRoyalFlush(cardsInHand)){
            return HandRankFiveCard.FULL_HOUSE;
       }else if (isFourOfAKind()){
            return HandRankFiveCard.FOUR_OF_A_KIND;
       }else{
            return HandRankFiveCard.HIGH_CARDS;
       }  
    }

    private boolean isRoyalFlush(List<Card> cardsInHand){
        if (sameSuit && inOrder){
           Card firstCard = cardsInHand.get(0);
           Card lastCard = cardsInHand.get(cardsInHand.size() - 1);

           if(firstCard.getRank().getOrder() == 10 && lastCard.getRank().getOrder() == 14) {
                return true;
           }
       } 
       return false;
    }

    private boolean isFourOfAKind(){
        for (Entry<String, Integer> rank: numberOfKindMap.entrySet()){
            System.out.println(rank.getKey() + rank.getValue());
                if (rank.getValue() == 4){
                    return true;
                }  
          }
       return false;
    }

    private boolean isSameSuit(Hand hand){

        //The first suit in the hand
        Suit suitOfCard = hand.getCardsInHand().get(0).getSuit();
        
        for (Card card: hand.getCardsInHand()){

            if (!card.getSuit().equals(suitOfCard)){
                log.debug("The cards are not of the same suit.");
                return false;
            }
        }
        
        //The suit of the card will be the same if we get to this point.
        return true;
    }

    private boolean isInOrder(List<Card> cardsInHand) {
       
        boolean isInOrder = true; // True until proven false. :-)

        // There is probably a more elegant way of checking the order
        // Will refactor at a later stage
        for (int i = 0; i < cardsInHand.size() - 1; i++) {
            Card currentCard = cardsInHand.get(i);
            Card nextCard = cardsInHand.get(i + 1);

            if (currentCard.getRank().getOrder() != nextCard.getRank().getOrder() - 1) {
                isInOrder = false;
            } else {
                // But what about the ACE which can also be a 1?
                if (currentCard.getRank().getOrder() == Rank.ACE.getOrder()
                        && (nextCard.getRank().getOrder() == Rank.DEUCE.getOrder())) {
                    isInOrder = true;
                }
            }
            String currentRankName = currentCard.getRank().getName();
            numberOfKindMap.put(currentRankName, numberOfKindMap.get(currentRankName) + 1);
        }

        return isInOrder;
    }

    //These values in this methods can be re-used without having to check for them for every hand evaluation.
    private void initialisePrivateVariablesForReuse(Hand hand){

        cardsInHand = hand.getCardsInHand();
        Collections.sort(cardsInHand, Comparator.comparingInt(card -> card.getRank().getOrder()));
        for (Rank rank: Rank.values()){
            numberOfKindMap.put(rank.getName(), 0);
        }

        sameSuit = isSameSuit(hand);
        inOrder = isInOrder(hand.getCardsInHand()); 
    }
}
