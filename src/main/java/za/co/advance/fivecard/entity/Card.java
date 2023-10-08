package za.co.advance.fivecard.entity;

import lombok.Getter;
import lombok.Setter;
import za.co.advance.fivecard.definition.Rank;
import za.co.advance.fivecard.definition.Suit;

@Getter
@Setter
public class Card{
    private Suit suit;
    private Rank rank;
}