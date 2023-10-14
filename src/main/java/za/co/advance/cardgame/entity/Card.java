package za.co.advance.cardgame.entity;

import lombok.Getter;
import lombok.Setter;
import za.co.advance.cardgame.definition.Rank;
import za.co.advance.cardgame.definition.Suit;

@Getter
@Setter
public class Card{
    private Suit suit;
    private Rank rank;
}