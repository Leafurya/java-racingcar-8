package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        distance = 0;
    }

    public void race() {
        int rand = Randoms.pickNumberInRange(0, 9);
        move(rand);
        System.out.println(getMoveResult());
    }

    public void move(int rand) {
        if (rand >= 4) {
            distance++;
        }
    }

    public String getMoveResult() {
        return name + " : " + "-".repeat(distance);
    }


    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }
}
