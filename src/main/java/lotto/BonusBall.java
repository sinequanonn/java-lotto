package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import static lotto.Constant.LOTTO_START_NUMBER;
import static lotto.Constant.LOTTO_END_NUMBER;

public class BonusBall {

    public Integer makeBonusBall(Lotto winningLotto) {
        String input = Console.readLine();
        Integer bonusBall = validate(input);
        if (isDuplicated(winningLotto, bonusBall)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 당첨 번호와 중복입니다.");
        }
        return bonusBall;
    }

    private Integer validate(String input) {
        try {
            Integer bonusBall = Integer.parseInt(input);
            validateRange(bonusBall);
            return bonusBall;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 정수이어야 합니다.");
        }
    }

    private void validateRange(Integer bonusBall) {
        if (bonusBall <= 0 || bonusBall > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 사이여야 합니다.");
        }
    }

    private static boolean isDuplicated(Lotto winningLotto, Integer bonusBall) {
        return winningLotto.getNumbers().contains(bonusBall);
    }
}
