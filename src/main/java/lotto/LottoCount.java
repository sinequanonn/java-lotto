package lotto;

import camp.nextstep.edu.missionutils.Console;

import static lotto.Constant.LOTTO_PRICE;

public class LottoCount {

    // 로또 금액 입력하고 개수 반환
    public int getHowManyLotto(String input) {
        try {
            int money = parseAndValidateMoney(input);
            return calculateLottoCount(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력 금액은 정수이어야 합니다.");
        }
    }


    private int parseAndValidateMoney(String input) {
        try {
            int money = Integer.parseInt(input);
            validatePositive(money);
            return money;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력 금액은 정수이어야 합니다.");
        }
    }

    private void validatePositive(int money) {
        if (money <= 0) {
            throw new IllegalArgumentException("[ERROR] 입력 금액은 양수이어야 합니다.");
        }
    }

    private int calculateLottoCount(int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 입력 금액은 1,000원 단위어야 합니다.");
        }
        return money / LOTTO_PRICE;
    }
}
