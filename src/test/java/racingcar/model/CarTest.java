package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.Car;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class CarTest {

    Car car;

    @BeforeEach
    void setUp() {
        car = Car.from("khj");
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void _4_이상의_값을_입력_받으면_전진한다(int command) {
        car.move(command);
        Position expectedPosition = Position.from(1);

        assertThat(car.isAt(expectedPosition)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void _4_미만의_값을_입력_받으면_정지한다(int command) {
        car.move(command);
        Position expectedPosition = Position.from(0);

        assertThat(car.isAt(expectedPosition)).isTrue();
    }
}
