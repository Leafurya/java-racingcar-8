package racingcar;

import java.util.ArrayList;

public class Application {
    private static String[] carNames = null;
    private static int raceCount;
    private static Car[] cars;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputManager im = new InputManager();
        carNames = im.getCarNames();
        raceCount = im.getRaceCount();

        RacingManager rm = new RacingManager(carNames, raceCount);

        System.out.println("\n실행 결과");
        rm.startRacing();

        ArrayList<String> winners = rm.determineWinner();
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

//    private static void determineWinner() {
//        int max = 0;
//        ArrayList<String> winners = new ArrayList<>();
//        for (Car car : cars) {
//            int distance = car.getDistance();
//            if (max < distance) {
//                max = distance;
//            }
//        }
//
//        for (Car car : cars) {
//            if (max == car.getDistance()) {
//                winners.add(car.getName());
//            }
//        }
//        System.out.println("최종 우승자 : " + String.join(", ", winners));
//    }
//
//    private static void startRacing() {
//        for (int i = 0; i < raceCount; i++) {
//            for (Car car : cars) {
//                car.race();
//            }
//            System.out.println();
//        }
//    }
//
//    private static void createCars() {
//        cars = new Car[carNames.length];
//        int i = 0;
//        for (String name : carNames) {
//            cars[i++] = new Car(name);
//        }
//    }

//    private static void inspectCarNames() {
//        for (String name : carNames) {
//            if (!name.matches("^[a-zA-Z]{1,5}$")) {
//                throw new IllegalArgumentException("자동차 이름 형식을 맞춰주세요.(5자 이하, 특수문자(공백 포함) 제외)");
//            }
//        }
//    }
//
//    private static void getCarNames() {
//        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
//        String strCarNames = Console.readLine();
//
//        carNames = strCarNames.split(",");
//
//        inspectCarNames();
//    }
//
//    private static void getRaceCount() {
//        System.out.println("시도할 횟수는 몇 회인가요?");
//        String strRaceCount = Console.readLine();
//        try {
//            raceCount = Integer.parseInt(strRaceCount);
//            if (raceCount <= 0) {
//                throw new IllegalArgumentException("시도할 횟수는 0보다 커야합니다.");
//            }
//        } catch (NumberFormatException e) {
//            throw new IllegalArgumentException("시도할 횟수를 정수로 변환할 수 없습니다.");
//        }
//    }
}
