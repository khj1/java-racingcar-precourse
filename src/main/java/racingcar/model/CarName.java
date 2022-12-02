package racingcar.model;

public class CarName {

    private static final String INVALID_NAME_LENGTH = "자동차 이름은 5자를 초과할 수 없습니다.";
    private static final int NAME_LENGTH_UPPER_BOUND = 5;

    private final String name;

    public CarName(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (isInvalidLength(name)) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH);
        }
    }

    private boolean isInvalidLength(String name) {
        return name.length() > NAME_LENGTH_UPPER_BOUND;
    }

    public static CarName from(String name) {
        return new CarName(name);
    }
}
