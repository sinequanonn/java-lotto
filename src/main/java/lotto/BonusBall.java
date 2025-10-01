package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import static lotto.Constant.LOTTO_START_NUMBER;
import static lotto.Constant.LOTTO_END_NUMBER;

public class BonusBall {

    public Integer makeBonusBall(Lotto winningLotto) {
        Integer bonusBall;
        bonusBall = Randoms.pickNumberInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER);

        if (isDuplicated(winningLotto, bonusBall)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 당첨 번호와 중복입니다.");
        }
        return bonusBall;
    }

    private static boolean isDuplicated(Lotto winningLotto, Integer bonusBall) {
        return winningLotto.getNumbers().contains(bonusBall);
    }
}
