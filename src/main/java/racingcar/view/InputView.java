package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.AttemptCount;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private static final String SPLIT_REGEX = ",";
    private static final String NON_NUMERIC_INPUT_MESSAGE = "숫자만 입력할 수 있습니다.";
    private static final String REQUEST_ATTEMPT_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

    public List<String> readNames() {
        String names = Console.readLine();

        return Arrays.stream(names.split(SPLIT_REGEX))
                .collect(Collectors.toList());
    }

    public AttemptCount readAttemptCount() {
        System.out.println(REQUEST_ATTEMPT_COUNT_MESSAGE);
        String attemptCount = Console.readLine();

        return AttemptCount.from(parseInt(attemptCount));
    }

    private int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException error) {
            throw new IllegalArgumentException(NON_NUMERIC_INPUT_MESSAGE);
        }
    }
}
