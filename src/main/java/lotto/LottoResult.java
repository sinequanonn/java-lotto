package lotto;

import java.util.List;

public class LottoResult {
    private Long firstWin;
    private Long secondWin;
    private Long thirdWin;
    private Long fourthWin;
    private Long fifthWin;

    private Lotto winningLotto;
    private List<Lotto> lottos;
    private Integer bonus;

    public LottoResult(Lotto winningLotto, List<Lotto> lottos, Integer bonus) {
        this.winningLotto = winningLotto;
        this.lottos = lottos;
        this.bonus = bonus;
        this.firstWin = 0L;
        this.secondWin = 0L;
        this.thirdWin = 0L;
        this.fourthWin = 0L;
        this.fifthWin = 0L;
    }
    public void printLottoResult() {
        System.out.println("당첨 통계\n---");
        checkResult();
        System.out.println("3개 일치 (5,000원) - " + fifthWin + "개");
        System.out.println("4개 일치 (50,000원) - " + fourthWin + "개");
        System.out.println("5개 일치 (1,500,000원) - " + thirdWin + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + secondWin + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + firstWin + "개");
    }

    public void printRateReturn(Long price) {
        Long earn = (2000000000L * firstWin) + (30000000 * secondWin) + (1500000 * thirdWin) + (50000 * fourthWin) + (5000 * fifthWin);

        System.out.printf("총 수익률은 %.2f%%", (double)earn/price * 100);
    }

    private void checkResult() {
        for (Lotto lotto : lottos) {
            int num = winningLotto.compareTo(lotto);
            boolean matchBonus = lottos.contains(bonus);

            if (num == 6) {
                firstWin++;
            } else if (matchBonus && num == 5) {
                secondWin++;
            } else if (num == 5) {
                thirdWin++;
            } else if (num == 4) {
                fourthWin++;
            } else if (num == 3) {
                fifthWin++;
            }
        }
    }


}
