package racingcar.view;

import racingcar.Car;
import racingcar.model.Cars;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {

    private static final String NEW_LINE = "\n";
    private static final String SCORE_UNIT = "-";
    private static final String SCORE_BOARD = "%s : %s";

    public void printResult(Cars cars) {
        System.out.println(getScore(cars));
    }

    private String getScore(Cars cars) {
        return cars.get().stream()
                .map(this::toScoreBoard)
                .collect(Collectors.joining(NEW_LINE));
    }

    private String toScoreBoard(Car car) {
        return String.format(SCORE_BOARD, car.getName(), convertToScore(car.getPosition()));
    }

    private String convertToScore(int position) {
        StringBuilder score = new StringBuilder();
        IntStream.rangeClosed(1, position)
                .forEach(currentPosition -> score.append(SCORE_UNIT));

        return score.toString();
    }
}
