package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        Customer customer = new Customer(new Bag());
        LottoMachine lottoMachine = new LottoMachine();
        LottoStore lottoStore = new LottoStore(lottoMachine);

        lottoStore.enter(customer);

        Lotto lotto = WinningLottoInput.getWinningLotto();
        WinningLotto winningLotto = new WinningLotto(lotto);
//        System.out.println("result = " + result.getWinningLotto());

        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusInput = Console.readLine();
        Integer bonus = Integer.valueOf(bonusInput);
//        System.out.println("bonus = " + bonus);

        LottoResult lottoResult = new LottoResult(winningLotto.getWinningLotto(), customer.getBag().getLottos(), bonus);

        lottoResult.printLottoResult();
        lottoResult.printRateReturn(customer.getPrice());


    }
}
