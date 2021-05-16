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


/*
 * 자동차
 * 
 * 레이싱행위
 * 
 * */

/* TODO. 자동차이름 5자 내로 제한*/
package racingcar.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		while(true) {
			String carName = ""; //입력받은 자동차 이름
			String[] carNameArr = null;//입력받은 자동차이름을 요소별로 저장할 배열
			//List<String> carNameArr = new ArrayList<String>();//입력받은 자동차이름을 요소별로 저장할 배열
			//String[] carNameArr = new String[5]; //입력받은 자동차이름을 요소별로 저장할 배열
			
			int reqRacingGameCnt = 0; //사용자가 요청한 레이싱게임 횟
			
			//사용자가 자동차 이름을 입력
			System.out.println("경주할 자동차 이름을 입력하세요.");
			Scanner sc1 = new Scanner(System.in);
			carName = sc1.next();
			System.out.println(carName);
			
			//입력받은 자동차이름 자르기
			carNameArr = carName.split(",");
			for(String a : carNameArr) {
				System.out.println(a);
			}
			
			//입력된 자동차 각 자동차 이름 5자 내로 체크
			if(chkCarLength(carNameArr)) {
				//사용자가 시도할 횟수 입력  -> 레이싱 반복횟수가 됨
				System.out.println("시도할 회수는 몇회인가요?");
				Scanner sc2 = new Scanner(System.in);
				reqRacingGameCnt = sc2.nextInt();
				System.out.println(reqRacingGameCnt);
				
				
				//사용자가 입력한 레이싱횟수 만큼 레이싱시작
				for(int i=0; i<reqRacingGameCnt; i++) {
					startRacingGame(carNameArr);
					System.out.println();
				}
			} else {
				System.out.println("자동차이름은 5자 이내로 입력가능합니다.");
			}
			
		
		}
		
		
	}
	
	//입력된 자동차 이름 5자를 넘지 않도록 체
	public static boolean chkCarLength(String[] carNameArr) {
		boolean isFiveLength = true;
		final int maxLength = 5;
		
		for(int i=0; i< carNameArr.length; i++) {
			if(carNameArr[i].length() > maxLength) {
				isFiveLength = false;
				System.out.println("carNameArr[i].length() :" +carNameArr[i].length());
				return isFiveLength;
			}
			
		}
		
		return isFiveLength;
	}
	
	//실제 레이싱게임 진행메서드
	public static String startRacingGame(String[] carNameArr) {
		String racingStatus = ""; //현재레이싱카의 진행상태를 표현해줄 값
		final String statusBar = "-"; //현재레이싱카 진행태 표시할 작대기기호
		int randomNumber = 0; //Math.random()으로  나온 숫자를 담을 변수... 변수명 변경해야 듯..
		int racingCarCnt = carNameArr.length; //레이싱에 참여할 레이싱 카 개수 
		String nowRacingCarName = "";
		
		for(int i=0; i<racingCarCnt; i++) { //매개변수로 넘어온 횟수만큼 레이싱을 반복
			nowRacingCarName = carNameArr[i];
			randomNumber = (int)(Math.random()* 9);  //0부터 9까지 랜덤한 수를 뽑음
			
			//TODO. 괄호가 또 들어가네 수정해야함...
			if(chkAdvanceStatus(randomNumber)) {
				racingStatus += statusBar;
			}
			
			System.out.println(nowRacingCarName +""+ racingStatus);
			
		}
		
		return racingStatus;
	}

	
	//전진을 위한 제약조건을 체크할 메서드
	public static boolean chkAdvanceStatus(int standardNumber) {
		boolean isAdvance = false; //현재 전진상태를 체크할 변수
		final int advanceMinNumber = 4; //전진하기 위한 최소값(4이상일 경우만 전진)
		
		if(standardNumber >= advanceMinNumber) { //전진
			isAdvance = true;
		}
		return isAdvance;
	}
}
