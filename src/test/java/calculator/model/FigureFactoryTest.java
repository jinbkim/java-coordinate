package calculator.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class FigureFactoryTest {

    @Test
    void 입력값에_따라_올바른_객체_생성하기() {
        Figure line = FigureFactory.create("(1,1)-(2,2)");
        Figure triangle = FigureFactory.create("(1,1)-(2,2)-(2,1");
        Figure rectangle = FigureFactory.create("(1,1)-(1,2)-(2,1)-(2,2)");

        Assertions.assertThat(line instanceof Line)
            .isTrue();
        Assertions.assertThat(triangle instanceof Triangle)
            .isTrue();
        Assertions.assertThat(rectangle instanceof Rectangle)
            .isTrue();
    }

    @Test
    void 좌표_정보_파싱하기() {
        Figure line = FigureFactory.create("(1,1)-(2,2)");
        Figure triangle = FigureFactory.create("(1,1)-(2,2)-(2,1");
        Figure rectangle = FigureFactory.create("(1,1)-(1,2)-(2,1)-(2,2)");

        Assertions.assertThat(line.hasPoint(1, 1))
            .isEqualTo(true);
        Assertions.assertThat(line.hasPoint(2, 2))
            .isEqualTo(true);

        Assertions.assertThat(triangle.hasPoint(1, 1))
            .isEqualTo(true);
        Assertions.assertThat(triangle.hasPoint(2, 2))
            .isEqualTo(true);
        Assertions.assertThat(triangle.hasPoint(2, 1))
            .isEqualTo(true);

        Assertions.assertThat(rectangle.hasPoint(1, 1))
            .isEqualTo(true);
        Assertions.assertThat(rectangle.hasPoint(1, 2))
            .isEqualTo(true);
        Assertions.assertThat(rectangle.hasPoint(2, 1))
            .isEqualTo(true);
        Assertions.assertThat(rectangle.hasPoint(2, 2))
            .isEqualTo(true);
    }
}