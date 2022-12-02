package racingcar.model;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import racingcar.RacingNumberGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.util.Lists.newArrayList;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class CarsTest {

    @Test
    void 자동차들의_이름은_서로_중복될_수_없다() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Cars.from(List.of("pobi,jun,pobi")));
    }

    @Test
    void 가장_멀리_이동한_사림이_우승한다() {
        Cars cars = Cars.from(List.of("pobi", "jun", "khj"));
        TestRacingNumberGenerator numberGenerator = new TestRacingNumberGenerator();

        cars.race(numberGenerator);
        cars.race(numberGenerator);

        assertThat(cars.findWinners())
                .contains(CarName.from("pobi"), CarName.from("khj"));
    }

    static class TestRacingNumberGenerator implements RacingNumberGenerator {

        private final List<Integer> numbers = newArrayList(4, 1, 4, 4, 1, 4);

        @Override
        public int generate() {
            return numbers.remove(0);
        }
    }
}
