package ObjectOrientedProgramming2;

import java.util.Vector;

class Product3 {
	int price ; //��ǰ�� ����
	int bonusPoint; //��ǰ���� �� �����ϴ� ���ʽ� ����
	
	Product3(int price){
		this.price = price;
		bonusPoint = (int)(price/10.0);
	}
	
	Product3(){}//�⺻������
}

class TvProduct3 extends Product3{
	TvProduct3() { super(100); }
	public String toString() {return "TvProduct3";}
}

class ComputerProduct3 extends Product3{
	ComputerProduct3() { super(200); }
	public String toString() {return "ComputerProduct3";}
}


class AudioProduct3 extends Product3{
	AudioProduct3() { super(50); }
	public String toString() {return "AudioProduct3";}
}

class Buyer3{
	int money = 1000;
	int bonusPoint = 0; 
	//Product3[] item = new Product3[10]; //������ ��ǰ�� �����ϱ� ���� �迭
	Vector item = new Vector();//������ ��ǰ�� �����ϱ� ���� Vector��ü
	int i=0;
	
	void buyProduct(Product3 p) {
		if(money < p.price) {
			System.out.println("�ܾ��� �����Ͽ� ������ �� �� �����ϴ�.");
			return;
		}
		
		money -= p.price;
		bonusPoint += p.bonusPoint;
		item.add(p);
		System.out.println(p+"�� �����ϼ̽��ϴ�.");
	}
	
	void refund(Product3 p) {
		boolean findItem = false;
		for(int idx=0; idx<item.size(); idx++) {
			if(item.get(idx) == p) {
				item.remove(idx);
				findItem=true;
				break;
			}
		}
		if(findItem) {
			money += p.price;
			bonusPoint -= p.bonusPoint;			
			System.out.println("ȯ�ҵǾ����ϴ�. ���� �ܾ��� "+money+"�Դϴ�.");
		}else {
			System.out.println("�����Ͻ� ���� ���� ��ǰ�Դϴ�.");
		}
	}
	
	void summary() {
		int sum = 0;
		String result = "";
		
		for(int idx=0; idx<item.size(); idx++) {
			if(item.get(i) == null) {
				break;
			}
			sum++;
			//result+=item[idx] +", ";
			result+= (idx==0)?""+item.get(idx):", "+item.get(idx);
		}
		
		System.out.println("������� ������ �������� ������ "+sum+"�Դϴ�.");
		System.out.println("������� ������ �������� "+result+"�Դϴ�.");
	}
}

public class PolyArgumentTest3 {

	public static void main(String[] args) {
		Buyer3 buyer = new Buyer3();
		Product3 tvProduct = new TvProduct3();
		Product3 computerProduct = new ComputerProduct3();
		Product3 audioProduct = new AudioProduct3();
		buyer.buyProduct(computerProduct);
		buyer.buyProduct(audioProduct);
		
		buyer.refund(tvProduct);
		buyer.summary();
	}
}

