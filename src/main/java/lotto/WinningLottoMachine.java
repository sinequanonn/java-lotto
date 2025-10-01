package lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningLottoMachine {

    public Lotto getWinningLotto(String input) {
        return new Lotto(makeWinningLotto(input));
    }

    private List<Integer> makeWinningLotto(String input) {
        List<Integer> numbers = new ArrayList<>();
        String[] split = input.split(",");
        for (String number : split) {
            int validatedNumber = validateNumber(number.strip());
            numbers.add(validatedNumber);
        }
        return numbers;
    }

    private int validateNumber(String number) {
        try {
            int num = Integer.parseInt(number);
            validateLottoNumber(num);
            return num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 정수이어야 합니다.");
        }
    }

    private void validateLottoNumber(int num) {
        if (num <= 0) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 양수이어야 합니다.");
        }

        if (num <= 0 || num > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45 사이여야 합니다.");
        }
    }
}
