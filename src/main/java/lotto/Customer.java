package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Customer {

    private Bag bag;
    private int lottoCount;

    public Customer(Bag bag) {
        this.bag = bag;
        this.lottoCount = 0;
    }

    public void buy(Lotto lotto) {
        bag.hold(lotto);
    }

    public int choseLottoCount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        try {
            int priceInput = Integer.parseInt(input);
            validate(priceInput);
            this.lottoCount = (priceInput / 1000);
            System.out.println("lottoCount = " + lottoCount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            choseLottoCount();
        } catch (IllegalStateException e) {
            System.out.println("[ERROR] 구입 금액의 입력은 1,000원 단위이어야 합니다.");
            choseLottoCount();
        }
        return this.lottoCount;
    }

    public boolean wantToBuyMoreLotto() {
        return this.lottoCount == 0;
    }

    public void checkLotto() {
        bag.viewLotto();
    }

    private void validate(int countInput) {
        if (countInput % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액의 입력은 정수이어야 합니다.");
        }
    }

    public Bag getBag() {
        return bag;
    }
}
