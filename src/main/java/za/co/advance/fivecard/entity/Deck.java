package za.co.advance.fivecard.entity;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Deck{
    private List<Card> deckOfCards = new ArrayList<>();
}