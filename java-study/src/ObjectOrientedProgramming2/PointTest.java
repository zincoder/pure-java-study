package ObjectOrientedProgramming2;

public class PointTest {

	public static void main(String[] args) {
		Point3D2 p = new Point3D2(1,2,3);

	}

}

class Point2{
	int x,y;
	
	Point2(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	String getLocation() {
		return "x :"+x+", y :"+y;
	}
}

class Point3D2 extends Point2{
	int z;
	
	Point3D2(int x, int y, int z){
		super(x,y);
		/*this.x = x;
		this.y = y;*/
		this.z = z;
	}
	
	String getLocation() {
		return "x:"+x+", y:"+y+", z:"+z;
	}
}