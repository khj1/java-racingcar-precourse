package racingcar;

import racingcar.model.CarName;

public class Car {
    private final CarName name;
    private int position = 0;

    private Car(String name) {
        this.name = CarName.from(name);
    }

    public static Car from(String name) {
        return new Car(name);
    }

    // 추가 기능 구현
}
