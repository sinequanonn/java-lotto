package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.math.BigDecimal;
import java.util.List;

import static lotto.Constant.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoMachine lottoMachine = new LottoMachine();
        LottoStore lottoStore = new LottoStore(lottoMachine);

        Bag bag = new Bag();
        Customer customer = new Customer(bag);

        ResultPrinter resultPrinter = new ResultPrinter();

        int lottoCount = getLottoCount();
        System.out.println(lottoCount + "개를 구매하셨습니다.");

        lottoStore.sellLottoTo(customer, lottoCount);
        customer.checkBag();

        Lotto winningLotto = getWinningLotto();

        Integer bonusNumber = getBonusNumber(winningLotto);

        BigDecimal totalPrice = new BigDecimal(LOTTO_PRICE).multiply(new BigDecimal(lottoCount));
        resultPrinter.printResult(bag.compareWithAll(winningLotto, bonusNumber), totalPrice);
    }

    private static Integer getBonusNumber(Lotto winningLotto) {
        System.out.println("보너스 번호를 입력해 주세요.");
        BonusBall bonusBall = new BonusBall();
        while (true) {
            try {
                return bonusBall.makeBonusBall(winningLotto);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static Lotto getWinningLotto() {
        WinningLottoMachine winningLottoMachine = new WinningLottoMachine();
        System.out.println("당첨 번호를 입력해 주세요.");
        while (true) {
            String input = Console.readLine();
            try {
                return winningLottoMachine.getWinningLotto(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int getLottoCount() {
        LottoCount lottoCount = new LottoCount();

        System.out.println("구입 금액을 입력해 주세요.");
        while (true) {
            String input = Console.readLine();
            try {
                return lottoCount.getHowManyLotto(input);
            } catch (IllegalArgumentException e) {;
                System.out.println(e.getMessage());
            }
        }
    }
}
