package racing.car.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.car.domain.Car;
import racing.car.model.Cars;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

public class RacingGameControllerTest {
    private RacingGameController game;

    @BeforeEach
    void setUp() {
        game = new RacingGameController();
    }

    @Test
    @DisplayName("initializeCars 메서드는 각 Car 객체를 올바르게 초기화해야 한다.")
    void initializeCars_메서드_테스트() {
        Cars cars = new Cars(new ArrayList<>());
        String[] carNames = {"leo", "seoun"};
        game.initializeCars(carNames, cars);


        assertThat(cars).isEqualTo(new Cars(List.of(new Car("leo", 0), new Car("seoun",0))));
    }

    @Test
    @DisplayName("validateCarCount 메서드는 유효한 자동차 개수 입력 시 해당 값을 반환해야 한다.")
    void validateCarCount_메서드_테스트_성공() {
        int carCount = 2;
        int result = game.validateCarCount(carCount);

        assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("validateCarCount 메서드는 자동차 개수가 2 미만일 경우 예외를 발생시켜야 한다.")
    void validateCarCount_메서드_테스트_실패() {
        int carCount = 0;

        assertThatThrownBy(() -> {
            game.validateCarCount(carCount);
        })
                .isInstanceOf(RuntimeException.class)
                .hasMessageMatching("게임을 진행하려면 자동차가 최소 2대 있어야 합니다.");

    }

    @Test
    @DisplayName("validateTryCount 메서드는 유효한 시도 횟수 입력 시 해당 값을 반환해야 한다.")
    void validateTryCount_메서드_테스트_성공() {
        int tryCount = 1;
        int result = game.validateTryCount(tryCount);

        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("validateTryCount 메서드는 시도 횟수가 1 미만일 경우 예외를 발생시켜야 한다.")
    void validateTryCount_메서드_테스트_실패() {
        int tryCount = 0;

        assertThatThrownBy(() -> {
            game.validateTryCount(tryCount);
        })
                .isInstanceOf(RuntimeException.class)
                .hasMessageMatching("게임을 진행하려면 시도 횟수는 1 이상이어야 합니다.");
    }

    @Test
    @DisplayName("자동차 리스트에서 position 최대 값 구하기")
    void 자동차_max_메서드_테스트() {
        Cars cars = new Cars(List.of(new Car("dong", 3), new Car("duu", 4)));
        int max =game.max(cars);

        assertThat(max).isEqualTo(4);
    }
}