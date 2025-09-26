package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoMachine {


    public void sellLottoTo(Customer customer) {
        Long count = customer.choseLottoCount();
        for (int i = 0; i <count; i++) {
            customer.buy(makeLotto());
        }
        customer.checkLotto();
    }

    private Lotto makeLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }

}
