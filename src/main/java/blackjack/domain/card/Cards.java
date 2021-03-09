package blackjack.domain.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cards {
    private final List<Card> cards;

    public Cards() {
        this(Collections.emptyList());
    }

    public Cards(Card card) {
        this(Collections.singletonList(card));
    }

    public Cards(List<Card> cards) {
        this.cards = new ArrayList<>(cards);
    }

    public Cards addCard(Card card) {
        List<Card> newCards = new ArrayList<>(cards);
        newCards.add(card);
        return new Cards(newCards);
    }

    public Card peekCard() {
        return cards.get(0);
    }

    public Card drawCard() {
        if (cards.size() == 0) {
            throw new IndexOutOfBoundsException("남은 카드가 없습니다.");
        }
        return cards.remove(0);
    }

    public List<Card> getCards() {
        return Collections.unmodifiableList(cards);
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public int calculateScore() {
        int score = 0;
        score += noneAceCardScore();
        score += aceCardScore();

        return score;
    }

    private int noneAceCardScore() {
        return cards.stream()
                .filter(card -> !Denomination.isAce(card.getDenomination()))
                .mapToInt(card -> Denomination.score(card.getDenomination()))
                .sum();
    }

    private int aceCardScore() {
        int score = 0;
        int aceCount = (int) cards
                .stream()
                .filter(card -> Denomination.isAce(card.getDenomination()))
                .count();
        for (int i = 0; i < aceCount; i++) {
            score += Denomination.selectAceScore(score);
        }

        return score;
    }
}
