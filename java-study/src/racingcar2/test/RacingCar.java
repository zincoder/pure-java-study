package racingcar2.test;

public class RacingCar extends Car{
	
	private String carName = "";
	private String racingStatus = "";
	private final int NAME_MAX_LENGTH = 5;

	@Override
	public String startRacingStatus() {
		racingStatus += "-";
		return racingStatus;
	}
	
	@Override
	public String getRacingStatus() {
		return this.racingStatus;
	}	
	
	public String getCarName() {
		return carName;   //자동차의 이름이 5자를 넘을 경우 예외처리 필요
	}
	
	
	public void setCarName(String carName) throws OverNameMaxLengthException {
		if(!chkCarNameLength(carName)) {
			throw new OverNameMaxLengthException("자동차이름 최대길이 초과");
		} 
		this.carName = carName;
	}
	
	//입력된 자동차 이름 5자를 넘지 않도록 체크
	public boolean chkCarNameLength(String carName) {
		boolean isFiveLength = true;
		//final int maxLength = 5;
		
		if(carName.length() > NAME_MAX_LENGTH) {
			isFiveLength = false;
			System.out.println("carNameArr[i].length() :" +carName.length());
			return isFiveLength;
		}
		return isFiveLength;
	}


}
