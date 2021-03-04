package blackjack.domain;

public enum MatchResult {
    WIN("승") {
        @Override
        boolean match(int playerScore, int dealerScore) {
            return (playerScore <= 21 && dealerScore > 21) || ((playerScore > dealerScore) && playerScore <= 21);
        }
    },
    LOSE("패") {
        @Override
        boolean match(int playerScore, int dealerScore) {
            return (playerScore > 21 && dealerScore <= 21) || ((playerScore < dealerScore) && dealerScore <= 21);
        }
    },
    DRAW("무") {
        @Override
        boolean match(int playerScore, int dealerScore) {
            return (playerScore > 21 && dealerScore > 21) || (playerScore == dealerScore);
        }
    };

    private final String result;

    MatchResult(String result) {
        this.result = result;
    }

    abstract boolean match(int playerScore, int dealerScore);

    public static MatchResult getPlayerMatchResult(int playerScore, int dealerScore) {
        for (MatchResult matchResult : values()) {
            if (matchResult.match(playerScore, dealerScore)) {
                return matchResult;
            }
        }
        throw new IllegalArgumentException();
    }

    public static MatchResult getDealerMatchResultByPlayer(MatchResult matchResult) {
        if(matchResult.equals(MatchResult.WIN)){
            return MatchResult.LOSE;
        }
        if(matchResult.equals(MatchResult.LOSE)){
            return MatchResult.WIN;
        }
        return MatchResult.DRAW;
    }

    public String getResult() {
        return result;
    }
}
