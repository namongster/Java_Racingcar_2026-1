package racingcar;

import camp.nextstep.edu.missionutils.*;
import org.assertj.core.util.VisibleForTesting;

import java.util.Arrays;

public class Application {
    static String[] cars;
    public static void name(){
        System.out.print("경주할 자동차 이름을 입력하세요 (,로 구분하고 5자 이하) : ");
        String carsinput = Console.readLine();
        cars = carsinput.split(",");

        //이름 예외처리

        for (String car : cars) {   //5자 이하로
            if (car.length() > 5) {
                throw new IllegalArgumentException();
            }

            if (car.isBlank()) { //빈칸
                throw new IllegalArgumentException();
            }
        }

    }
    public static void main(String[] args) {

        name();

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
                if (num >= 4) {
                    race[j] += "-";
                    System.out.println(race[j]);
                    count[j]++;
                }
                else System.out.println(race[j]);

            }
            System.out.println();
        }

        //우승자 출력
        System.out.print("최종 우승자 : ");
        int s = cars.length;
        for (int i = 0 ; i < s ; i++){

            for (int j = 0; j < s; j++){
                if (j == i) continue;
                else if ( count[j] > count[i]){
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
