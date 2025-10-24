package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int distance;

    public Car(String name){
        this.name=name;
        distance=0;
    }
    public void race(){
        int rand=Randoms.pickNumberInRange(0,9);
        if(rand>=4){
            distance++;
        }
        System.out.print(name+" : ");
        for(int i=0;i<distance;i++){
            System.out.print("-");
        }
        System.out.println();
    }
    public int getDistance(){
        return distance;
    }
    public String getName(){
        return name;
    }
}
