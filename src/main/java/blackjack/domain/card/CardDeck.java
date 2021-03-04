package blackjack.domain.card;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CardDeck {
    private Cards deck;

    public CardDeck() {
        deck = new Cards(Arrays
                .stream(Denomination.values())
                .flatMap(denomination -> Arrays
                        .stream(Shape.values())
                        .map(shape -> new Card(shape, denomination)))
                .collect(Collectors.toList()));
    }

    public Card drawCard() {
        Card drawCard = deck.peekCard();
        this.deck = deck.removeCard();
        return drawCard;
    }

    public void shuffleCard() {
        deck.shuffle();
    }
}
