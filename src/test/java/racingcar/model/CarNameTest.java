package racingcar.model;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class CarNameTest {

    @Test
    void 자동차_이름은_5자를_초과할_수_없다() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> CarName.from("khjkhj"));
    }
}
