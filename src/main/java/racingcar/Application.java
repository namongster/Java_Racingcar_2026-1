package racingcar;

import camp.nextstep.edu.missionutils.*;
import java.util.Arrays;
public class Application {

    public void forward(String[] cars){
        for (int i =0;i < cars.length; i++){

        }
    }

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

        //경주 게임 출력

        String[] race = new String[cars.length];
        Arrays.fill(race,"");
        int[] count = new int[cars.length];
        for(int i =0;i<game;i++){
            for (int j = 0; j < cars.length; j++) {
                int num = Randoms.pickNumberInRange(0, 9);
                System.out.print(cars[j] + " : ");
                if (num >= 4) {race[j] += "-";System.out.println(race[j]);count[j]++;}
                else System.out.println(race[j]);

            }
            System.out.println();
        }

        //우승자 출력
        System.out.print("최종 우승자 : ");
        int s = cars.length;
        for (int i = 0 ; i < s ; i++){

            for (int j = 0; j < s; j++){
                if (j == i)continue;
                if ( count[j] > count[i]){
                    System.out.print(cars[j]);
                    break;
                }
                else if(count[j] == count[i]){
                    System.out.print(cars[j]+","+cars[i]);
                    break;
                }


            }
        }




    }
}
