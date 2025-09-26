package lotto;

import java.util.ArrayList;
import java.util.List;

public class Bag {

    List<Lotto> lottos = new ArrayList<>();

    public void hold(Lotto lotto) {
        lottos.add(lotto);
    }

    public void viewLotto() {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }


    public List<Lotto> getLottos() {
        return lottos;
    }
}
