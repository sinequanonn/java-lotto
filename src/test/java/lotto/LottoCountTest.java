package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoCountTest {

    @DisplayName("정상 금액 입력 후 구매할 로또 개수를 반환합니다.")
    @Test
    void getLottoCount() {
        //given
        LottoCount lottoCount = new LottoCount();
        String input = "1000";

        //when
        int result = lottoCount.getHowManyLotto(input);

        //then
        Assertions.assertThat(result).isEqualTo(1);
    }

    @DisplayName("입력이 1,000원 단위 아닐 시 예외 처리 발생")
    @Test
    void inputNotThousandThrowException() {
        // given
        LottoCount lottoCount = new LottoCount();
        String input = "1500";

        // when then
        Assertions.assertThatThrownBy(() -> lottoCount.getHowManyLotto(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 입력 금액은 1,000원 단위어야 합니다.");
    }

    @DisplayName("입력이 정수가 아닐 시 예외 처리 발생")
    @Test
    void inputNotIntegerThrowException() {
        // given
        LottoCount lottoCount = new LottoCount();
        String input = "idf100";

        // when then
        Assertions.assertThatThrownBy(() -> lottoCount.getHowManyLotto(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 입력 금액은 정수이어야 합니다.");
    }

    @DisplayName("입력이 음수인 경우 예외 처리 발생")
    @Test
    void inputNegativeIntegerThrowException() {
        // given
        LottoCount lottoCount = new LottoCount();
        String input = "-1000";

        // when then
        Assertions.assertThatThrownBy(() -> lottoCount.getHowManyLotto(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 입력 금액은 양수이어야 합니다.");
    }


}
