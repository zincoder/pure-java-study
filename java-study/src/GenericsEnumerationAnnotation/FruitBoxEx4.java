package GenericsEnumerationAnnotation;

import java.util.ArrayList;
import java.util.Comparator;

class Fruit4{
	String name;
	int weight;
	
	Fruit4(String name, int weight){
		this.name = name;
		this.weight = weight;
	}
	
	public String toString() {return name+"("+weight+")";}
}

class Apple4 extends Fruit4{
	Apple4(String name, int weight){
		super(name, weight);
	}
}

class Grape4 extends Fruit4{
	Grape4(String name, int weight){
		super(name, weight);
	}
}

class Apple4Comp implements Comparator<Apple4>{
	public int compare(Apple4 t1, Apple4 t2) {
		return t2.weight - t2.weight;
	}
}

class Grape4Comp implements Comparator<Grape4>{
	public int compare(Grape4 t1, Grape4 t2) {
		return t2.weight - t2.weight;
	}
}

class Fruit4Comp implements Comparator<Fruit4>{
	public int compare(Fruit4 t1, Fruit4 t2) {
		return t2.weight - t2.weight;
	}
}

class FruitBox4<T extends Fruit4> extends Box4{}

class Box4<T>{
	ArrayList<T> list = new ArrayList<T>();
	void add(T item) {list.add(item);}
	T get(int i) {return list.get(i);}
	ArrayList<T> getList() {return list;}
	int size() {return list.size();}
	public String toString() {return list.toString();}
}

public class FruitBoxEx4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
