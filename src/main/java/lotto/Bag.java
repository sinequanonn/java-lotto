package lotto;

import java.util.ArrayList;
import java.util.List;

public class Bag {

    List<Lotto> lottos = new ArrayList<>();

    public void hold(Lotto lotto) {
        lottos.add(lotto);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void viewLotto() {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public List<Rank> compareWithAll(Lotto winningLotto, Integer bonusNumber) {
        List<Rank> ranks = new ArrayList<>();
        for (Lotto lotto : lottos) {
            int matchCount = lotto.countMatchNumbers(winningLotto);
            boolean matchBonus = lotto.containsBonus(bonusNumber);
            Rank rank = Rank.checkRank(matchCount, matchBonus);
            ranks.add(rank);
        }
        return ranks;
    }
}
