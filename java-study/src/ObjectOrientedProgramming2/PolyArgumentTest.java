package ObjectOrientedProgramming2;

class Product{
	int price;
	int bonus;
	
	Product(){
		this(0,0);
	}

	Product(int price){
		this(price,1);
	}
	
	Product(int price, int bonus){
		this.price = price;
		this.bonus = bonus;
	}
}

class TvProduct extends Product{
	TvProduct(){
		super(20);
		System.out.println("TvProduct�� ������ "+price +"�Դϴ�");
	}
}

class ComputerProduct extends Product{

	ComputerProduct(){
		super(10);
		System.out.println("ComputerProduct�� ������ "+price +"�Դϴ�");
	}
	
	public String toString(){
		return "ComputerProduct";
	}
}

class AudioProduct extends Product{
	AudioProduct(){
		super(5);
		System.out.println("TvProduct�� ������ "+price +"�Դϴ�");
	}
	public String toString(){
		return "AudioProduct";
	}
}

class Buyer{
	int money;
	int bonus;
	Product[] productArr = new Product[100];
	int itemIdx;
	
	Buyer(){
		this(1000,10);
	}
	
	Buyer(int money, int bonus){
		this.money = money;
		this.bonus = bonus;
	}
	
	void buyProduct(Product p) {
		
		if(money >= p.price) {
			money -= p.price;			
			bonus += p.bonus;
			productArr[itemIdx] = p;
			System.out.println("������ �����Ͽ����ϴ�. ��ǰ �ݾ�(price)�� "+p.price);
			System.out.println("������ �����Ͽ����ϴ�. ���� �ܾ�(money)�� "+money);
			System.out.println("������ �����Ͽ����ϴ�. ������ ��ǰ�� "+ productArr[itemIdx]);
		    itemIdx++;
		} else {
			System.out.println("������ �ִ� ���� ���ڶ� ������ �� �����ϴ�.");
		}
	}
}

public class PolyArgumentTest {
	public static void main(String[] args) {
		Buyer buyer = new Buyer();
		Product computerProduct = new ComputerProduct();
		Product audioProduct = new AudioProduct();
		buyer.buyProduct(computerProduct);
		buyer.buyProduct(audioProduct);
		
		for(int i=0; i<buyer.productArr.length; i++) {
			System.out.println(buyer.productArr[i]);
		}
	}
}
