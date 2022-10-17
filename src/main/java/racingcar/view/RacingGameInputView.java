package racingcar.view;

import java.util.Scanner;

public class RacingGameInputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static String inputCarNumber() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.next();
    }

    public static int inputMoveNumber() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        return scanner.nextInt();
    }
}