package ObjectOrientedProgramming2;

public class FighterTest {

	public static void main(String[] args) {
		/*Fighter f = new Fighter();*/
		Unit f = null;
		Fighter f2 = new Fighter();
		f = f2;
		
		Fighter f3 = null;
		f3 = (Fighter)f;
		
		if(f instanceof Unit) {
			System.out.println("f�� UnitŬ������ �ڼ��Դϴ�.");
		}
		
		if(f instanceof Fightable) {
			System.out.println("f�� FightableŬ������ �ڼ��Դϴ�.");
		}
		
		if(f instanceof Movable) {
			System.out.println("f�� MovableŬ������ �ڼ��Դϴ�.");
		}
		
		if(f instanceof Attackable) {
			System.out.println("f�� AttackableŬ������ �ڼ��Դϴ�.");
		}

		if(f instanceof Object) {
			System.out.println("f�� ObjectŬ������ �ڼ��Դϴ�.");
		}
		

	}

}


class Fighter extends Unit implements Fightable{

	@Override
	public void move(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attack(Unit u) {
		// TODO Auto-generated method stub
		
	}
	
}

class Unit{
	int currentHP; //������ ü��
	int x;		   //������ ��ġ(x��ǥ)
	int y;		   //������ ��ġ(y��ǥ)
}

interface Fightable extends Movable, Attackable{}
interface Movable {void move(int x, int y);}
interface Attackable{void attack(Unit u);}