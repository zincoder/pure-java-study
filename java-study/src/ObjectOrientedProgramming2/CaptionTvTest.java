package ObjectOrientedProgramming2;
class Tv2{
	boolean power; //��������
	int channel; //ä��
	
	void power() {power = !power; }
	void channelUp() {++channel;}
	void channelDown() {--channel;}
	   
}

class CaptionTv extends Tv2{ 
	boolean caption;	//ĸ�� ����(on/off)
	void displayCaption(String text) {
		if(caption) {	//ĸ�� ���»� on(true)�� ���� text�� ���� ��
			System.out.println(text);
		}
	}
}
public class CaptionTvTest {

	public static void main(String[] args) {
		CaptionTv ctv = new CaptionTv();
		ctv.channel = 10;
		ctv.channelUp();
		System.out.println(ctv.channel);
		ctv.displayCaption("Hello, World");
		ctv.caption = true;	//ĸ��(�ڸ�) ����� ��
		ctv.displayCaption("Hello, World");
	}

}