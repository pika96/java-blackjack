package blackjacktest.domaintest;

import blackjack.domain.Denomination;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DenominationTest {

    @Test
    @DisplayName("카드 숫자 생성")
    void createDenomination() {
        Denomination denomination = Denomination.valueOf("ACE");
        assertThat(denomination).isEqualTo(Denomination.ACE);
    }
}
