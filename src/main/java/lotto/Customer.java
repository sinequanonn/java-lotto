package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Customer {

    private Bag bag;
    private Long price;
    private Long lottoCount;

    public Customer(Bag bag) {
        this.bag = bag;
        this.price = 0L;
        this.lottoCount = 0L;
    }

    public void buy(Lotto lotto) {
        bag.hold(lotto);
    }

    public Long choseLottoCount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        try {
            Long priceInput = Long.parseLong(input);
            validate(priceInput);
            this.price = priceInput;
            this.lottoCount = (priceInput / 1000L);
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

    public void checkLotto() {
        bag.viewLotto();
    }

    private void validate(Long countInput) {
        if (countInput % 1000L != 0L) {
            throw new IllegalArgumentException("[ERROR] 구입 금액의 입력은 정수이어야 합니다.");
        }
    }

    public Bag getBag() {
        return bag;
    }

    public Long getPrice() {
        return price;
    }
}
