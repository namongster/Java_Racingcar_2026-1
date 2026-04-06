package racingcar;

import camp.nextstep.edu.missionutils.*;

import java.util.*;

public class Application {
    static String[] cars;
    static int[] count;
    static class player{//자동차 이름 및 경주 순위 클래스
        String name;
        int counting;

        player(String name, int counting){
        this.name = name;
        this.counting = counting;
        }
    }
    static player[] playerarr;
    public static void name(){//자동차 이름 입력
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
    public static int playtime(){//게임 횟수 입력
        System.out.print("게임 횟수를 입력하세요 : ");
        int game = Integer.parseInt(Console.readLine());
        //횟수 예외처리
        if (game <1){
            throw new IllegalArgumentException();
        }
        return game;
    }
    public static void play(int game){//경주게임 출력
        String[] race = new String[cars.length];
        Arrays.fill(race,"");
        count = new int[cars.length];
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
    }
    static void winner(){//우승자 출력
        System.out.print("최종 우승자 : ");
        System.out.print(playerarr[0].name);
        for (int i = 1;i < playerarr.length;i++){
            if (playerarr[0].counting == playerarr[i].counting){
                System.out.print(","+playerarr[i].name);
            }
        }
    }
    public static void Sorting(){
        playerarr = new player[cars.length];
        for (int i = 0 ;i < cars.length;i++){
            playerarr[i] = new player(cars[i], count[i]);
        }
        Arrays.sort(playerarr, Comparator.comparingInt((player p) -> p.counting).reversed());



    }

    public static void main(String[] args) {
        //이름 입력
        name();
        //게임 횟수 입력
        int game = playtime();
        //경주 게임 출력
        play(game);
        //순위 별로 정렬
        Sorting();
        //우승자 출력
        winner();
    }
}
