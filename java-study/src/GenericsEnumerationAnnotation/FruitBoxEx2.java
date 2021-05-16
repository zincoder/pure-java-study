package GenericsEnumerationAnnotation;

import java.util.ArrayList;

class Fruit2 implements Eatable2{public String toString() {return "Fruit";}}
class Apple2 extends Fruit2 {public String toString() {return "Apple";}}
class Grape2 extends Fruit2 {public String toString() {return "Grape";}}
class Toy2 {public String toString() {return "Toy";}}

interface Eatable2{}

class FruitBox2<T extends Fruit2 & Eatable2> extends Box2<T>{}

class Box2<T>{
	ArrayList<T> list = new ArrayList<T>();
	void add(T item) {list.add(item);}
	T get(int i) {return list.get(i);}
	int size() {return list.size();}
	public String toString() {return list.toString();}
}

public class FruitBoxEx2 {

	public static void main(String[] args) {
		FruitBox2<Fruit2> fruitBox = new FruitBox2<Fruit2>();
		FruitBox2<Apple2> appleBox = new FruitBox2<Apple2>();
		FruitBox2<Grape2> grapeBox = new FruitBox2<Grape2>();
		//FruitBox2<Toy2> toyBox = new FruitBox2<Toy2>();
		//Box<Grape> grapeBox2 = new Box<Apple>(); //error 타입 불일치
		
		fruitBox.add(new Fruit2());
		fruitBox.add(new Apple2());
		
		appleBox.add(new Apple2());
		appleBox.add(new Apple2());
		//appleBox.add(new Toy()); 
		
		System.out.println(fruitBox);
		System.out.println(appleBox);

	}

}
