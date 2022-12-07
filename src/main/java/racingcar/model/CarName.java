package racingcar.model;

import java.util.Objects;

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

    public String get() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarName carName = (CarName) o;
        return Objects.equals(name, carName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
