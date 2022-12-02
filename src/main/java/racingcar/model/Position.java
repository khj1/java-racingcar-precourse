package racingcar.model;

import java.util.Objects;

public class Position {

    private static final int STARTING_POSITION = 0;

    private int position;

    public Position(int position) {
        this.position = position;
    }

    public static Position from(int position) {
        return new Position(position);
    }

    public static Position init() {
        return new Position(STARTING_POSITION);
    }

    public void increase() {
        position++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
