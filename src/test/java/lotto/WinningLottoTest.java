package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {

    @DisplayName("당첨 번호 입력 시 당첨 로또 번호 반환")
    @Test
    void getWinningLotto() {
        //given
        WinningLottoMachine winningLottoMachine = new WinningLottoMachine();
        String input = "1,2,3,4,5,6";

        //when
        Lotto lotto = winningLottoMachine.getWinningLotto(input);

        //then
        assertThat(lotto).isInstanceOf(Lotto.class);
    }

    @DisplayName("당첨 번호에 중복 번호 입력 시 예외 발생")
    @Test
    void throwsExceptionWhenWinningNumbersContainDuplicates() {
        //given
        WinningLottoMachine winningLottoMachine = new WinningLottoMachine();
        String input = "1,2,3,4,5,5";

        //when, then
        assertThatThrownBy(() -> winningLottoMachine.getWinningLotto(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 음수가 포함된 경우 예외 발생")
    @Test
    void throwsExceptionWhenWinningNumbersContainNegativeNumber() {
        //given
        WinningLottoMachine winningLottoMachine = new WinningLottoMachine();
        String input = "-1,2,3,4,-5,5";

        //when, then
        assertThatThrownBy(() -> winningLottoMachine.getWinningLotto(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1~45 사이가 아닌 경우 예외 처리 발생")
    @Test
    void throwsExceptionWhenLottoNumberIsOutOfRange() {
        //given
        WinningLottoMachine winningLottoMachine = new WinningLottoMachine();
        String input = "134,2,3,4,5,46";

        //when, then
        assertThatThrownBy(() -> winningLottoMachine.getWinningLotto(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
