package za.co.advance.cardgame.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import za.co.advance.cardgame.entity.Card;
import za.co.advance.cardgame.entity.Hand;
import za.co.advance.cardgame.enums.HandRankFiveCard;
import za.co.advance.cardgame.enums.HandRankInterface;
import za.co.advance.cardgame.enums.Rank;
import za.co.advance.cardgame.enums.Suit;
import za.co.advance.cardgame.exception.MoreThanTwoOfSameRankException;

@Slf4j
@Getter
public class FiveCardRankAlgorithm implements HandRankAlgorithmInterface{

    private Map<String,Integer> numberOfKindMap = new HashMap<>(); 
    private boolean sameSuit = false; // For instance all hearts
    private boolean inOrder = false;  // For instance Duece, Three, Four, Five, Six
    private boolean fourOfRank = false;
    private boolean threeOfRank = false; //For instance Three of Hearts, Three of Spades and Three of Diamonds
    private boolean twiceTwoOfRank = false; // For instance 2 Three of Hearts and 2 Four of Spades 
    private boolean onceTwoOfRank = false;  // For instance 3 Five of Spades
    private List<Card> cardsInHand = new ArrayList<>();

    @Override
    public HandRankInterface determineHighestPokerRank(Hand hand) {
 
       //Let's sort the cards once
       //Initiliase the private variables for re-use in the logic
        try {
            initialisePrivateVariablesForReuse(hand);
        } catch (MoreThanTwoOfSameRankException e) {
            log.debug("There are more than two pairs!");
            System.out.println("There are more than two pairs, which is impossible");
  
        }       
       //Determine the Highest Poker hand and return
       return determinePokerHand();  
    }

    private HandRankInterface determinePokerHand() {

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
           }else if (sameSuit && !inOrder){    //!inOrder could be removed it will be true at this point, but that will cost readability
                return HandRankFiveCard.FLUSH;
           }else if (inOrder && !sameSuit){    //!sameSuit could also be removed
                return HandRankFiveCard.STRAIGHT;
           }else if (threeOfRank && !onceTwoOfRank){  //!onceTwoOfRank could also be removed
                return HandRankFiveCard.THREE_OF_A_KIND;
           }else if (twiceTwoOfRank){
                return HandRankFiveCard.TWO_PAIR;
           }else if (onceTwoOfRank && !threeOfRank){  //!threeOfRank could also be removed
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
        for (Entry<String, Integer> rank : numberOfKindMap.entrySet()) {
            switch (rank.getValue()) {
                case 4:
                    fourOfRank = true;
                    break;
                case 3:
                    threeOfRank = true;
                    break;
                case 2:
                    numberOfTwoRank++;
                    break;
                default:
                    break;    
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
