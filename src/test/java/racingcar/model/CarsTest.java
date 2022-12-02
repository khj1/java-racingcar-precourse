package racingcar.model;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class CarsTest {

    @Test
    void 자동차들의_이름은_서로_중복될_수_없다() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Cars.from(List.of("pobi,jun,pobi")));
    }
}
