package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        //플레이어 자동차 이름 입력받기
        System.out.print("경주할 자동차 이름을 입력하세요 (,로 구분하고 5자 이하) : ");
        String carsinput = Console.readLine();
        String[] cars = carsinput.split(",");

        //이름 예외처리

        for(int i =0;i < cars.length;i++){   //5자 이하로
            if (cars[i].length() > 5){
                throw new IllegalArgumentException();
            }

            if(cars[i].isBlank()){ //빈칸
                throw new IllegalArgumentException();
            }
        }
        //게임 횟수 입력
        System.out.print("게임 횟수를 입력하세요 : ");
        int game = Integer.parseInt(Console.readLine());
        //횟수 예외처리
        if (game <1){
            throw new IllegalArgumentException();
        }







    }
}
