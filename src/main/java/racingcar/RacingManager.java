package racingcar;

import java.util.ArrayList;

public class RacingManager {
    private Car[] cars;
    private int raceCount = 0;

    public RacingManager(String[] carNames, int raceCount) {
        this.raceCount = raceCount;
        createCars(carNames);
    }

    public RacingManager() {

    }

    public ArrayList<String> determineWinner() {
        return determineWinner(cars);
    }

    //테스트를 위한 오버로드
    public ArrayList<String> determineWinner(Car[] cars) {
        int max = 0;
        ArrayList<String> winners = new ArrayList<>();
        for (Car car : cars) {
            int distance = car.getDistance();
            if (max < distance) {
                max = distance;
            }
        }

        for (Car car : cars) {
            if (max == car.getDistance()) {
                winners.add(car.getName());
            }
        }

        return winners;
    }

    public void startRacing() {
        for (int i = 0; i < raceCount; i++) {
            for (Car car : cars) {
                car.race();
            }
            System.out.println();
        }
    }

    private void createCars(String[] carNames) {
        cars = new Car[carNames.length];
        int i = 0;
        for (String name : carNames) {
            cars[i++] = new Car(name);
        }
    }
}
