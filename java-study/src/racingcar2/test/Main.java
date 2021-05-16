/*
 * 
 * 
 •주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
•각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다. 
•자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
•사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
•전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이
하의 값이면 멈춘다.
•자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
 *
 * */


/*
 * 1. 자동차 이름을 입력하도록 요청
 * 2. 사용자가 자동차 이름 입력
 * 3. 사용자가 시도할 횟수 입력
 * 4. 사용자는 0~9 사이의 랜덤값을 구
 * */

/* TODO. 자동차이름 5자 내로 제한*/
package racingcar2.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Car[] carArr = null;
		boolean isCarRacingStart = true;
		
		while(true) {
			String carName = ""; //입력받은 자동차 이름
			String[] carNameArr = null;//입력받은 자동차이름을 요소별로 저장할 배열
			
			int reqRacingGameCnt = 0; //사용자가 요청한 레이싱게임 횟
			
			//사용자가 자동차 이름을 입력
			System.out.println("경주할 자동차 이름을 입력하세요.");
			Scanner sc1 = new Scanner(System.in);
			carName = sc1.next();
			System.out.println(carName);
			
			//입력받은 자동차이름 자르기
			carNameArr = carName.split(",");
			for(int i=0; i<carNameArr.length; i++) {
				carArr = new Car[carNameArr.length];
			}
			
			for(int i=0; i<carArr.length; i++) {
				carArr[i] = new RacingCar();
				try {
					carArr[i].setCarName(carNameArr[i]);
					isCarRacingStart  = true;
				} catch (OverNameMaxLengthException e) {
					//e.printStackTrace();
					System.out.println("자동차 이름이 최대길이를 초과하였습니다. 게임을 재시작합니다.");
					isCarRacingStart = false;
					break;
				}
			}
			
			//자동차게임을 시작
			if(isCarRacingStart) {
				System.out.println("자동차 레이싱을 시작합니다. 시도할 회수는 몇회인가요?");
				Scanner sc2 = new Scanner(System.in);
				reqRacingGameCnt = sc2.nextInt();
				System.out.println(reqRacingGameCnt);
				
				for(int i=0; i<reqRacingGameCnt; i++) {
					RacingGame racingGame = new RacingGame();
					racingGame.startRacingGame(carArr);
				}
			}
			
		
		}
		
		
	}
}
