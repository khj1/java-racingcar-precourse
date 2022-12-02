package racingcar.model;

public class Car {
    private static final int MOVABLE_LOWER_BOUND = 4;

    private final CarName name;
    private final Position position = Position.init();

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

    public int getPosition() {
        return position.getPosition();
    }

    public CarName getName() {
        return name;
    }
}
