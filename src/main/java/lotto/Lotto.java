package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        if (hasDuplication(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean hasDuplication(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>();

        return numbers.stream()
                .anyMatch(num -> !set.add(num));
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public int compareTo(Lotto lotto) {
        int matchCount = 0;

        for (Integer number : this.numbers) {
            if (lotto.numbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }
}
