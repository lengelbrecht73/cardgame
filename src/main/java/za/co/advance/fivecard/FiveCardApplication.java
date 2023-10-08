package za.co.advance.fivecard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import za.co.advance.fivecard.entity.Card;
import za.co.advance.fivecard.entity.Hand;
import za.co.advance.fivecard.service.DealerService;

@SpringBootApplication
public class FiveCardApplication {

	@Autowired
	static DealerService dealerService = new DealerService();

	public static void main(String[] args) {
	
		SpringApplication.run(FiveCardApplication.class, args);

		for (Card card: dealerService.collectCardsInDeck(true).getDeckOfCards()){
			System.out.println(card.getSuit().getDescription());

			if (card.getRank() != null){
				System.out.println(card.getRank().name());
			}
		}

		List<Card> shuffledDeck = dealerService.shuffleDeck(dealerService.collectCardsInDeck(false));
		for (Card card : shuffledDeck) {
			System.out.println(card.getSuit() + " " + card.getRank());
		}

		Hand handDealt = dealerService.dealHand(shuffledDeck, 5);
		System.out.println("Hand");
		for (Card card : handDealt.getCardsInHand()) {
			System.out.println(card.getSuit() + " " + card.getRank());
		}

	}

}

