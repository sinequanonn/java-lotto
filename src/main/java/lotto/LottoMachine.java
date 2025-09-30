package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static lotto.Constant.*;

public class LottoMachine {

    public void sellLottoTo(Customer customer) {
        Long count = customer.choseLottoCount();
        for (int i = 0; i <count; i++) {
            customer.buy(makeLotto());
        }
        customer.checkLotto();
    }

    public Lotto makeLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_COUNT);
        return new Lotto(numbers);
    }

}
