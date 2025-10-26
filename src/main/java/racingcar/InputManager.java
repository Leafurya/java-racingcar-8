package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;

public class InputManager {
    public void inspectCarNames(String[] carNames) {
        if (carNames == null || carNames.length == 0) {
            throw new IllegalArgumentException("자동차 이름을 하나 이상 입력하세요.");
        }
        for (String name : carNames) {
            if (name.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름 형식을 맞춰주세요.(1자 이상, 5자 이하, 특수문자(공백 포함) 제외)");
            }
            if (!name.matches("^[a-zA-Z]{1,5}$")) {
                throw new IllegalArgumentException(name + ": 자동차 이름 형식을 맞춰주세요.(1자 이상, 5자 이하, 특수문자(공백 포함) 제외)");
            }
        }
    }

    public String[] parseCarNames(String carNames) {
        if (carNames == null || carNames.isEmpty()) {
            throw new IllegalArgumentException("입력이 없습니다.");
        }
        // 파싱 및 트림
        String[] result = Arrays.stream(carNames.split(",")).map(String::trim).toArray(String[]::new);

        return result;
    }

    public String[] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String strCarNames = Console.readLine();

        String[] carNames = parseCarNames(strCarNames);

        inspectCarNames(carNames);

        return carNames;
    }

    public int inspectRaceCount(String strRaceCount) {
        try {
            int raceCount = Integer.parseInt(strRaceCount);
            if (raceCount <= 0) {
                throw new IllegalArgumentException("시도할 횟수는 0보다 커야합니다.");
            }
            return raceCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 횟수를 정수로 변환할 수 없습니다.");
        }
    }

    public int getRaceCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String strRaceCount = Console.readLine();

        return inspectRaceCount(strRaceCount);
    }
}
