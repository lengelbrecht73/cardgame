package za.co.advance.cardgame;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import za.co.advance.cardgame.entity.Card;
import za.co.advance.cardgame.entity.Deck;
import za.co.advance.cardgame.entity.Hand;
import za.co.advance.cardgame.service.DealerService;

@Slf4j
public class FiveCardApplication {

	DealerService dealerService = new DealerService();

	public void fiveCardGame(){
		//We don't use joker cards in this specific game
		boolean includeJokerCards = false;
		log.debug("Do we need the joker card?: " + includeJokerCards );
		
		Deck cardsInDeck = dealerService.collectCardsInDeck(includeJokerCards);
		List<Card> shuffledDeck = dealerService.shuffleDeck(cardsInDeck);
		
		Hand handDealt = dealerService.dealHand(shuffledDeck, 5);
		
	}
}

