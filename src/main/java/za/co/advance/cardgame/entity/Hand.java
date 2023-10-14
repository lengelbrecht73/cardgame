package za.co.advance.cardgame.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Hand {
    
    Hand() {
    }
    private List<Card> cardsInHand;
    private int numberofCardsInHand;
}
