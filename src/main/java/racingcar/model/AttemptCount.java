package racingcar.model;

public class AttemptCount {

    private static final int IS_OVER = 0;

    private int count;

    public AttemptCount(int count) {
        this.count = count;
    }

    public static AttemptCount from(int count) {
        return new AttemptCount(count);
    }

    public boolean isPlayable() {
        return count > IS_OVER;
    }

    public void decrease() {
        count--;
    }
}
