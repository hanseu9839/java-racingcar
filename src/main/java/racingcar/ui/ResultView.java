package racingcar.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.Vehicle;
import racingcar.domain.Vehicles;

public class ResultView {


    public ResultView() {
        System.out.println("실행 결과");
    }

    public void printResult(Vehicles vehicles) {
        for (Vehicle vehicle : vehicles.getVehicles()) {
            System.out.println(String.format("%s : %s", vehicle.getName(), vehicle.toString()));
        }
        System.out.println();
    }

    public void printWinners(String winners) {

        System.out.println(String.format("%s가 최종 우승했습니다.", winners));
    }




}
