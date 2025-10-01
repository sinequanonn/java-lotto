package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Customer {
    private Bag bag;

    public Customer(Bag bag) {
        this.bag = bag;
    }

    public void buy(Lotto lotto) {
        bag.hold(lotto);
    }

    public void checkBag() {
        bag.viewLotto();
    }
}
