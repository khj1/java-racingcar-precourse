package racingcar.cotroller;

import racingcar.RandomRacingNumberGenerator;
import racingcar.model.AttemptCount;
import racingcar.model.CarName;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.function.Supplier;

public class RacingCarController {

    private final InputView inputView;
    private final OutputView outputView;
    private final Cars cars;

    public RacingCarController() {
        inputView = new InputView();
        outputView = new OutputView();
        cars = checkError(this::getCars);
    }

    public void run() {
        progressGame();
        printWinners();
    }

    private void progressGame() {
        AttemptCount attemptCount = checkError(inputView::readAttemptCount);
        outputView.printRaceIntro();

        while (!attemptCount.isOver()) {
            attempt();
            attemptCount.decrease();
        }
    }

    private void printWinners() {
        List<CarName> winners = cars.findWinners();
        outputView.printWinners(winners);
    }

    private void attempt() {
        RandomRacingNumberGenerator numberGenerator = new RandomRacingNumberGenerator();
        cars.race(numberGenerator);
        outputView.printResult(cars);
    }

    private Cars getCars() {
        List<String> names = inputView.readNames();
        return Cars.from(names);
    }

    private <T> T checkError(Supplier<T> reader) {
        try {
            return reader.get();
        } catch (IllegalArgumentException error) {
            outputView.printError(error);
            return checkError(reader);
        }
    }
}
