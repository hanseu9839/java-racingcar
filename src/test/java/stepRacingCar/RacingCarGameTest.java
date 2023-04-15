package stepRacingCar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingCar.RacingCarGame;
import racingCar.car.move.RacingCarMoveDirectionStrategy;
import racingCar.car.move.RacingCarMoveForward;
import racingCar.view.RacingCarGameResultView;
import util.RandomUtils;

import java.util.List;

public class RacingCarGameTest {
  List<RacingCarMoveDirectionStrategy> allowedMoveStrategies;

  @BeforeEach
  void setup() {
    allowedMoveStrategies = List.of(new RacingCarMoveForward());
  }

  @DisplayName("[RacingCarGame.class] 레이싱카 게임은 사용자가 입력한 숫자만큼 레이싱카가 설정된다.")
  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3})
  public void 사용자_입력만큼_레이싱카_세팅(int racingCarCnt) {

    // when
    RacingCarGame racingCarGame = new RacingCarGame(racingCarCnt, new RacingCarGameResultView(), allowedMoveStrategies);

    // then
    Assertions.assertThat(racingCarGame)
        .extracting("racingCars")
        .asList()
        .hasSize(racingCarCnt);
  }

  @DisplayName("[RacingCarGame.class] 레이싱카 게임은 게임 턴마다 자동차 움직임을 기록한다.")
  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3, 4})
  public void 레이싱카_게임은_매_이동마다_기록을_가지고_있음(int moveTryCnt) {
    // given
    final int 레이싱카_수 = 10;
    RacingCarGame racingCarGame = new RacingCarGame(레이싱카_수, new RacingCarGameResultView(), allowedMoveStrategies);

    // when
    racingCarGame.play(moveTryCnt);

    // then
    Assertions.assertThat(racingCarGame)
        .extracting("resultView.snapShots")
        .asList()
        .hasSize(moveTryCnt);
  }
}