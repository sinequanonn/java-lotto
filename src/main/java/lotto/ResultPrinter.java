package lotto;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultPrinter {

    DecimalFormat formatter = new DecimalFormat("#,###");

    public void printResult(List<Rank> ranks, BigDecimal totalPrice) {
        System.out.println("\n당첨 통계");
        System.out.println("---");

        printStatistics(ranks);
        printTotalProfit(ranks, totalPrice);
    }

    private void printTotalProfit(List<Rank> ranks, BigDecimal totalPrice) {

        BigDecimal totalPrize = new BigDecimal(0);
        for (Rank rank : ranks) {
            totalPrize = totalPrize.add(rank.getPrizeMoney());
        }
        BigDecimal result = totalPrize
                .divide(totalPrice, 1, BigDecimal.ROUND_HALF_UP) // 소수점 2자리, 반올림
                .multiply(new BigDecimal("100"));
        System.out.println("총 수익률은 "+ formatter.format(result) + "%입니다.") ;
    }

    private void printStatistics(List<Rank> ranks) {
        Map<Rank, Integer> stats = new EnumMap<>(Rank.class);

        for (Rank rank : Rank.values()) {
            stats.put(rank, 0);
        }

        for (Rank rank : ranks) {
            stats.put(rank, stats.get(rank) + 1);
        }

        for (Rank rank : Rank.values()) {
            if (rank == Rank.NONE) continue;

            int count = stats.get(rank);
            System.out.printf("%s (%s원) - %d개%n",
                    rank.getDescription(),
                    formatter.format(rank.getPrizeMoney()),
                    count);
        }
    }
}
