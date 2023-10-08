package za.co.advance.fivecard.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Hand {
    private List<Card> cardsInHand;
    private int numberofCardsInHand;
}
