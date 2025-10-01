package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

class BonusBallTest {

    @DisplayName("보너스 번호가 당첨 번호와 중복 되지 않고 정상 생성")
    @Test
    void makeBonusBallNotDuplicatedWithWinningLotto() {
        // given
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when
        mockStatic(Randoms.class);
        when(Randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(7);

        BonusBall bonusBall = new BonusBall();
        Integer result = bonusBall.makeBonusBall(winningLotto);

        // then
        Assertions.assertThat(result).isEqualTo(result);
    }

    @DisplayName("보너스 번호가 당첨 번호가 중복되면 예외 발생")
    @Test
    void makeBonusBallDuplicatedWithWinningLotto() {
        // given
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        // when
        mockStatic(Randoms.class);
        when(Randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(7);

        BonusBall bonusBall = new BonusBall();

        // then
        Assertions.assertThatThrownBy(() -> bonusBall.makeBonusBall(winningLotto))
                .isInstanceOf(IllegalArgumentException.class);

    }
}
