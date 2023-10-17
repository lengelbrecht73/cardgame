package za.co.advance.cardgame.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import za.co.advance.cardgame.enums.Rank;
import za.co.advance.cardgame.enums.Suit;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Card{
    private Suit suit;
    private Rank rank;
}