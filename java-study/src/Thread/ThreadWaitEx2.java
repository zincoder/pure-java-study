package Thread;

import java.util.ArrayList;

public class ThreadWaitEx2 {

	public static void main(String[] args) throws Exception {
		Table table = new Table(); //여러 쓰레드가 공유하는 객체
		
		new Thread(new Cook(table), "COOK1").start();
		new Thread(new Customer(table, "donut"), "CUST1").start();
		new Thread(new Customer(table, "buger"), "CUST2").start();
		
		Thread.sleep(5000);
		System.exit(0);

	}

}

class Customer2 implements Runnable{
	private Table2 table2;
	private String food;
	
	Customer2(Table2 table2, String food){
		this.table2 = table2;
		this.food = food;
	}
	
	public void run() {
		while(true) {
			try {Thread.sleep(10);} catch(InterruptedException e) {}
			String name = Thread.currentThread().getName();
			
			if(eatFood()) {
				System.out.println(name + " ate a " +food);
			} else {
				System.out.println(name + " failed to eat. :(");
			}
		}
	}
	
	boolean eatFood() { return table2.remove(food);}
}

class Cook2 implements Runnable{
	private Table2 table2;
	
	Cook2(Table2 table2){this.table2 = table2;}
	
	public void run() {
		while(true) {
			int idx = (int)(Math.random()*table2.dishNum());
			table2.add(table2.dishNames[idx]);
			try {Thread.sleep(100);}catch(InterruptedException e){}
		}
	}
}


class Table2{
	String[] dishNames = {"donut", "donut", "burger"};
	final int MAX_FOOD = 6;
	private ArrayList<String> dishes = new ArrayList<>();
	
	public synchronized void add(String dish) { //synchronized를 추가
		if(dishes.size() >= MAX_FOOD) {
			return;
		}
		dishes.add(dish);
		System.out.println("Dishes:"+dishes.toString());
	}
	
	public boolean remove(String dishName) {
		synchronized(this) {
			while(dishes.size() == 0) {
				String name = Thread.currentThread().getName();
				System.out.println(name+" is waiting.");
				try {Thread.sleep(500);}catch(InterruptedException e) {}
			}
			
			for(int i=0; i<dishes.size(); i++) {
				if(dishName.equals(dishes.get(i))) {
					dishes.remove(i);
					return true;
				}
			}
		}
		return false;
	}
	
	public int dishNum() {return dishNames.length;}
}