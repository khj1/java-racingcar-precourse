package racingcar.model;

import racingcar.RacingNumberGenerator;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {

    private static final String DUPLICATED_CAR_NAMES = "자동차들의 이름은 서로 중복될 수 없습니다.";

    private final List<Car> cars;

    private Cars(List<String> names) {
        validate(names);
        cars = toCars(names);
    }

    private List<Car> toCars(List<String> names) {
        return names.stream()
                .map(Car::from)
                .collect(Collectors.toList());
    }

    private void validate(List<String> names) {
        if (isDuplicated(names)) {
            throw new IllegalArgumentException(DUPLICATED_CAR_NAMES);
        }
    }

    private boolean isDuplicated(List<String> names) {
        Set<String> uniqueNames = new HashSet<>(names);

        return uniqueNames.size() != names.size();
    }

    public static Cars from(List<String> names) {
        return new Cars(names);
    }

    public void race(RacingNumberGenerator numberGenerator) {
        cars.forEach(car -> car.move(numberGenerator.generate()));
    }

    public List<CarName> findWinners() {
        Car maxPositionCar = getCarWithMaxPosition();
        return cars.stream()
                .filter(maxPositionCar::isSamePosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private Car getCarWithMaxPosition() {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("차량 리스트가 비어있습니다."));
    }

    public List<Car> get() {
        return Collections.unmodifiableList(cars);
    }
}
