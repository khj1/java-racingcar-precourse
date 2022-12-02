package racingcar.view;

import racingcar.Car;
import racingcar.model.CarName;
import racingcar.model.Cars;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {

    private static final String NEW_LINE = "\n";
    private static final String SCORE_UNIT = "-";
    private static final String SCORE_BOARD = "%s : %s";
    private static final String WINNER_SEPARATOR = ", ";
    private static final String WINNERS_ARE = "최종 우승자 : ";
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String RESULT_INTRO = "실행 결과";

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

    public void printWinners(List<CarName> winners) {
        System.out.print(WINNERS_ARE);
        System.out.println(getWinnerNames(winners));
    }

    private String getWinnerNames(List<CarName> winners) {
        return winners.stream()
                .map(CarName::get)
                .collect(Collectors.joining(WINNER_SEPARATOR));
    }

    public void printError(IllegalArgumentException error) {
        System.out.print(ERROR_PREFIX);
        System.out.println(error.getMessage());
    }

    public void printRaceIntro() {
        System.out.println(RESULT_INTRO);
    }
}
