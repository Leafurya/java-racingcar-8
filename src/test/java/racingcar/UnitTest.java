package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class UnitTest {

    @Test
    void 자동차_입력_파싱_테스트() {
        InputManager im = new InputManager();

        // 공백 포함된 구분자 입력 테스트
        String[] names = im.parseCarNames("pobi, hello");
        assertThat(names).containsExactlyInAnyOrder("pobi", "hello");

        // 빈 자동차 이름 입력 테스트
        names = im.parseCarNames("pobi,,hello");
        assertThat(names).containsExactlyInAnyOrder("pobi", "", "hello");

        // 빈 입력 테스트
        assertThatThrownBy(() -> im.parseCarNames("")).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력이 없습니다.");
    }

    @Test
    void 자동차_입력_예외처리_테스트() {
        InputManager im = new InputManager();

        // 5글자 이상 자동차 이름 예외처리 테스트
        assertThatThrownBy(() -> im.inspectCarNames(im.parseCarNames("pobi,hellow"))).isInstanceOf(
                IllegalArgumentException.class);

        // 빈 자동차 이름 예외처리 테스트
        assertThatThrownBy(() -> im.inspectCarNames(im.parseCarNames("pobi,,hello"))).isInstanceOf(
                IllegalArgumentException.class);

        // 빈 입력 예외처리 테스트
        assertThatThrownBy(() -> im.inspectCarNames(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 횟수_입력_예외처리_테스트() {
        InputManager im = new InputManager();

        // 음수 입력 예외처리 테스트
        assertThatThrownBy(() -> im.inspectRaceCount("-1")).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0보다 커야합니다");
        // 숫자 외의 문자 포함 예외처리 테스트
        assertThatThrownBy(() -> im.inspectRaceCount("1a3")).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("변환할 수 없습니다");
    }

    @Test
    void 움직임_테스트() {
        Car car = new Car("test_car");

        car.move(3);
        assertThat(car.getMoveResult()).isEqualTo("test_car : ");

        car.move(4);
        assertThat(car.getMoveResult()).isEqualTo("test_car : -");

        car.move(5);
        assertThat(car.getMoveResult()).isEqualTo("test_car : --");
    }

    @Test
    void 승자_결정_테스트() {
        Car[] cars = {
                new Car("pobi"),
                new Car("woni"),
                new Car("hello")
        };
        RacingManager rm = new RacingManager();

        // 단일 승자 결정 테스트
        cars[0].move(4);
        assertThat(rm.determineWinner(cars)).containsExactlyInAnyOrder("pobi");

        // 다중 승자 결정 테스트
        cars[1].move(4);
        assertThat(rm.determineWinner(cars)).containsExactlyInAnyOrder("pobi", "woni");
    }
}
