package racingcar.model;

public class AttemptCount {

    private final int count;

    public AttemptCount(int count) {
        this.count = count;
    }

    public static AttemptCount from(int count) {
        return new AttemptCount(count);
    }
}
