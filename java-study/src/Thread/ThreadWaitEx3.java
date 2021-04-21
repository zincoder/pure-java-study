package Thread;

import java.util.ArrayList;

public class ThreadWaitEx3 {

	public static void main(String[] args) throws Exception{
		Table3 table = new Table3();
		
		new Thread(new Cook3(table), "COOK1").start();
		new Thread(new Customer3(table, "donut"), "CUST1").start();
		new Thread(new Customer3(table, "burger"), "CUST2").start();

		Thread.sleep(2000);
		System.exit(0);
	}

}

class Customer3 implements Runnable{
	private Table3 table;
	private String food;
	
	Customer3(Table3 table, String food){
		this.table = table;
		this.food = food;
	}
	
	public void run() {
		while(true) {
			try {Thread.sleep(100);}catch(InterruptedException e) {}
			String name = Thread.currentThread().getName();
			
			table.remove(food);
			System.out.println(name + " ate a "+ food);
		}
	}
	
}

class Cook3 implements Runnable{
	private Table3 table;
	
	Cook3(Table3 table){this.table = table;}
	
	public void run() {
		while(true) {
			int idx = (int)(Math.random() * table.dishNum());
			table.add(table.dishNames[idx]);
			try {Thread.sleep(10);}catch(InterruptedException e) {}
		}
	}
}

class Table3{
	String[] dishNames = {"donut", "donut", "burger"}; //donut�� Ȯ���� ����
	final int MAX_FOOD = 6;
	private ArrayList<String> dishes = new ArrayList<>();
	
	public synchronized void add(String dish) {
		while(dishes.size() >= MAX_FOOD) {
			String name = Thread.currentThread().getName();
			System.out.println(name+" is waiting.");
			try {
				wait();
				Thread.sleep(500);
			} catch(InterruptedException e) {}
		}
		dishes.add(dish);
		notify(); //��ٸ��� �ִ� CUST�� ����� ����.
		System.out.println("Dishes:"+dishes.toString());
	}
	
	public void remove(String dishName) {
		synchronized(this) {
			String name = Thread.currentThread().getName();
			
			while(dishes.size() == 0) {
				System.out.println(name+" is waiting.");
				try {
					wait(); //CUST�����带 ��ٸ��� ��
					Thread.sleep(500);
				}catch(InterruptedException e) {}
			}
			while(true) {
				for(int i=0; i<dishes.size(); i++) {
					if(dishName.equals(dishes.get(i))) {
						dishes.remove(i);
						notify(); //���ڰ� �ִ� COOK�� ����� ����.
						return;
					}
				}
				
				try {
					System.out.println(name+ " is waiting.");
					wait(); //���ϴ� ������ ���� CUST�����带 ��ٸ��� ��.
					Thread.sleep(500);
				} catch(InterruptedException e) {}
			}
		}
	}
	public int dishNum() {return dishNames.length;}
}

