package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class WinningLottoInput {

    public static Lotto getWinningLotto() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        String[] split = input.split(",");
        List<Integer> winningNumber = new ArrayList<>();
        for (String num : split) {
            winningNumber.add(Integer.parseInt(num));
        }
        return new Lotto(winningNumber);
    }
}
