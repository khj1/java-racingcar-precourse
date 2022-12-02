package racingcar;

import racingcar.model.CarName;
import racingcar.model.Position;

public class Car {
    private static final int MOVABLE_LOWER_BOUND = 4;

    private final CarName name;
    private Position position = Position.init();

    private Car(String name) {
        this.name = CarName.from(name);
    }

    public static Car from(String name) {
        return new Car(name);
    }

    public void move(int command) {
        if (isMovable(command)) {
            position.increase();
        }
    }

    private static boolean isMovable(int command) {
        return command >= MOVABLE_LOWER_BOUND;
    }

    public boolean isAt(Position expectedPosition) {
        return position.equals(expectedPosition);
    }
}
