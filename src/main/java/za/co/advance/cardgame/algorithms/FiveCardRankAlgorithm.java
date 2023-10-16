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
import za.co.advance.cardgame.exception.MoreThanTwoOfSameRankException;

@Slf4j
@Getter
public class FiveCardRankAlgorithm implements HandRankAlgorithm{

    private Map<String,Integer> numberOfKindMap = new HashMap<>(); 
    private boolean sameSuit = false; // For instance all hearts
    private boolean inOrder = false;  // For instance Duece, Three, Four, Five, Six
    private boolean fourOfRank = false;
    private boolean threeOfRank = false; //For instance Three of Hearts, Three of Spades and Three of Diamonds
    private boolean twiceTwoOfRank = false; // For instance 2 Three of Hearts and 2 Four of Spades 
    private boolean onceTwoOfRank = false;  // For instance 3 Five of Spades
    private List<Card> cardsInHand = new ArrayList<>();

    @Override
    public HandRank determineHighestPokerRank(Hand hand) {
 
       //Let's sort the cards once
       //Initiliase the private variables for re-use in the logic
       try {
            initialisePrivateVariablesForReuse(hand);
        } catch (MoreThanTwoOfSameRankException e) {
            e.printStackTrace();
        }       

       //The order of checking is important. A four of a kind
       //could give a two pair as well, but a two pair could not be a four
       //of a kind.
       //A lot of if statements, might refactor at a later stage. 
       if (sameSuit && inOrder){
            return HandRankFiveCard.STRAIGHT_FLUSH;
       }else if (fourOfRank){
            return HandRankFiveCard.FOUR_OF_A_KIND;
       }else if (onceTwoOfRank && threeOfRank){
            return HandRankFiveCard.FULL_HOUSE;
       }else if (sameSuit && !inOrder){
            return HandRankFiveCard.FLUSH;
       }else if (inOrder && !sameSuit){
            return HandRankFiveCard.STRAIGHT;
       }else if (threeOfRank && !onceTwoOfRank){
            return HandRankFiveCard.THREE_OF_A_KIND;
       }else if (twiceTwoOfRank){
            return HandRankFiveCard.TWO_PAIR;
       }else if (onceTwoOfRank && !threeOfRank){
            return HandRankFiveCard.ONE_PAIR;
       }
       else{
            return HandRankFiveCard.HIGH_CARDS;
       }  
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
            int j = i + 1;
            Card nextCard = cardsInHand.get(j);
            
            if (currentCard.getRank().getOrder() != nextCard.getRank().getOrder() - 1) {
                isInOrder = false;
            } else {
                // But what about the ACE which can also be a 1?
                if (currentCard.getRank().getOrder() == Rank.ACE.getOrder()
                        && (nextCard.getRank().getOrder() == Rank.DEUCE.getOrder())) {
                    isInOrder = true;
                }
            }           
        }

        return isInOrder;
    }

    //These values in this methods can be re-used without having to check for them for every hand evaluation.
    private void initialisePrivateVariablesForReuse(Hand hand) throws MoreThanTwoOfSameRankException{

        for (Rank rank: Rank.values()){
            numberOfKindMap.put(rank.getName(), 0);    
        }

        cardsInHand = hand.getCardsInHand();
        Collections.sort(cardsInHand, Comparator.comparingInt(card -> card.getRank().getOrder()));
        for (Rank rank: Rank.values()){
            for (Card card : cardsInHand){
                if (card.getRank().getName().equals(rank.getName())){
                    numberOfKindMap.put(rank.getName(),  numberOfKindMap.get(rank.getName()) + 1);
                }
            }
        }
        sameSuit = isSameSuit(hand);
        inOrder = isInOrder(hand.getCardsInHand()); 

        int numberOfTwoRank = 0;
        for (Entry<String, Integer> rank: numberOfKindMap.entrySet()){
            if (rank.getValue() == 4){
                fourOfRank = true;
            }else if (rank.getValue() == 3){
                 threeOfRank = true;
            }else if (rank.getValue() == 2){
                numberOfTwoRank = numberOfTwoRank + 1;
            }
           
        }

        //Is there one double?
        if (numberOfTwoRank == 1){
            onceTwoOfRank = true;
        }
        //Is there two double?
        else if (numberOfTwoRank == 2){
           twiceTwoOfRank = true;
        }
        // I smell a cheater
        else if (numberOfTwoRank > 2){
            throw new MoreThanTwoOfSameRankException();
        }
    }
}
