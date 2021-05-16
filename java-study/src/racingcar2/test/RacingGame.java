package racingcar2.test;

public class RacingGame {
	
	
	
	//실제 레이싱게임 진행메서드
	public String startRacingGame(Car[] carArr) {
		String racingStatus = ""; //현재레이싱카의 진행상태를 표현해줄 값
		int randomNumber = 0; //Math.random()으로  나온 숫자를 담을 변수... 변수명 변경해야 듯..
		int racingCarCnt = carArr.length; //레이싱에 참여할 레이싱 카 개수 
		String nowRacingCarName = "";
		
		for(int i=0; i<racingCarCnt; i++) { //매개변수로 넘어온 횟수만큼 레이싱을 반복
			nowRacingCarName = carArr[i].getCarName();
			randomNumber = (int)(Math.random()* 9);  //0부터 9까지 랜덤한 수를 뽑음
			
			//TODO. 괄호가 또 들어가네 수정해야함...
			if(chkAdvanceStatus(randomNumber)) {
				//racingStatus += statusBar;
				carArr[i].startRacingStatus();
			}
			
			System.out.println(carArr[i].getCarName() + " : " +carArr[i].getRacingStatus());
			
		}
		
		System.out.println();
		
		return racingStatus;
	}

	
	//전진을 위한 제약조건을 체크할 메서드
	public boolean chkAdvanceStatus(int standardNumber) {
		boolean isAdvance = false; //현재 전진상태를 체크할 변수
		final int advanceMinNumber = 4; //전진하기 위한 최소값(4이상일 경우만 전진)
		
		if(standardNumber >= advanceMinNumber) { //전진
			isAdvance = true;
		}
		return isAdvance;
	}

}
