package lotto;

import java.math.BigDecimal;

public enum Rank {

    NONE(new BigDecimal(0), "0개 일치"),
    FIFTH(new BigDecimal(5_000), "3개 일치"),
    FOURTH(new BigDecimal(50_000), "4개 일치"),
    THIRD(new BigDecimal(1_500_000), "5개 일치"),
    SECOND(new BigDecimal(30_000_000), "5개 일치, 보너스 볼 일치"),
    FIRST(new BigDecimal(2_000_000_000), "6개 일치");

    private final BigDecimal prizeMoney;
    private final String description;

    Rank(BigDecimal prizeMoney, String description) {
        this.prizeMoney = prizeMoney;
        this.description = description;
    }

    public static Rank checkRank(int matchCount, boolean matchBonus) {
        if (matchCount == 6) return FIRST;
        if (matchCount == 5 && matchBonus) return SECOND;
        if (matchCount == 5) return THIRD;
        if (matchCount == 4 && matchBonus) return THIRD;
        if (matchCount == 4) return FOURTH;
        if (matchCount == 3 && matchBonus) return FOURTH;
        if (matchCount == 3) return FIFTH;
        return NONE;
    }

    public boolean isWinning() {
        return this != NONE;
    }

    public BigDecimal getPrizeMoney() {
        return prizeMoney;
    }

    public String getDescription() {
        return description;
    }
}
