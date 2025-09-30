package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;


class LottoMachineTest {

    @Test
    void 로또기계가_로또_1개_정상_발행() {
        //given
        LottoMachine lottoMachine = new LottoMachine();

        //when: 로또 한 개 발행
        Lotto lotto = lottoMachine.makeLotto();

        //then
        Assertions.assertThat(lotto).isInstanceOf(Lotto.class);
    }
}
