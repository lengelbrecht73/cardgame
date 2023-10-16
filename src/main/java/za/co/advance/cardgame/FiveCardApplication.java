package za.co.advance.cardgame;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import za.co.advance.cardgame.algorithms.FiveCardRankAlgorithm;
import za.co.advance.cardgame.definition.GameVariant;
import za.co.advance.cardgame.definition.HandRank;
import za.co.advance.cardgame.entity.Card;
import za.co.advance.cardgame.entity.Deck;
import za.co.advance.cardgame.entity.Hand;
import za.co.advance.cardgame.exception.MoreThanTwoOfSameRankException;
import za.co.advance.cardgame.service.DealerService;

@Slf4j
public class FiveCardApplication {

	DealerService dealerService = new DealerService();

	public void fiveCardGame() throws MoreThanTwoOfSameRankException{
		//We don't use joker cards in this specific game
		boolean includeJokerCards = false;
		log.debug("Do we need the joker card?: " + includeJokerCards );
		
		//Get the cards from the pack and shuffle them
		Deck cardsInDeck = dealerService.collectCardsInDeck(includeJokerCards);
		System.out.println("Shuffling ... Shuffling ... Shuffling");
		List<Card> shuffledDeck = dealerService.shuffleDeck(cardsInDeck);
		
		//Deal the hand to the player
		Hand handDealt = dealerService.dealHand(shuffledDeck, GameVariant.FIVECARD.getNumberofCards());
		log.debug("HandDealt: " + handDealt.toString() );
		
		//Determine his highest hand rank
		FiveCardRankAlgorithm rankAlgorithm = new FiveCardRankAlgorithm();
		HandRank highestHandRank = rankAlgorithm.determineHighestPokerRank(handDealt);
		log.debug("Highest hand rank: " + highestHandRank.getHand());
		System.out.println("\n Highest hand rank: " + highestHandRank.getHand() +  " with a rank score of " + highestHandRank.getWinningOrder() + ".");
	}
}

