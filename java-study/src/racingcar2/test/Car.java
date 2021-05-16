package racingcar2.test;

public abstract class Car {
	//레이싱기능
	public abstract String startRacingStatus();
	
	public abstract String getRacingStatus();
	
	public abstract String getCarName();
	
	public abstract void setCarName(String carName)  throws OverNameMaxLengthException ;
	
}