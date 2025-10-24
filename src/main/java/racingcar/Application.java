package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static String[] carNames=null;
    private static int raceCount;
    private static Car[] cars;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        getCarNames();
        getRaceCount();

        createCars();
        System.out.println("샐행 결과");
        startRacing();
    }
    private static void startRacing(){
        for(int i=0;i<raceCount;i++){
            for(Car car:cars){
                car.race();
            }
        }
        System.out.println();
    }
    private static void createCars(){
        cars=new Car[carNames.length];
        int i=0;
        for(String name:carNames){
            cars[i++]=new Car(name);
        }
    }
    private static void inspectCarNames(){
        for(String name:carNames){
            if(!name.matches("^[a-zA-Z]{1,5}$")){
                throw new IllegalArgumentException();
            }
        }
    }
    private static void getCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String strCarNames=Console.readLine();

        carNames=strCarNames.split(",");;
        inspectCarNames();
    }
    private static void getRaceCount(){
        System.out.println("시도할 횟수는 몇 회인가요?");
        String strRaceCount=Console.readLine();
        try{
            raceCount=Integer.parseInt(strRaceCount);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }
}
