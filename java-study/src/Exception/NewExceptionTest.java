package Exception;

public class NewExceptionTest {
	public static void main(String[] args) {
		try {
			startInstall(); //프로그램 설치에 필요한 준비를 함.
			copyFiles();
		} catch(SpaceException e) {
			System.out.println("에러 메시지 : " +e.getMessage());
			e.printStackTrace();
			System.out.println("공간을 확보한 후에 다시 설치하시기 바합니다.");
		} catch(MemoryException e) {
			System.out.println("에러 메시지 : " +e.getMessage());
			e.printStackTrace();
			System.gc();  //GarbageCollection을 수행하여 메모리를 늘려줌.
			System.out.println("다시 설치를 시도하세요.");
		}
	}

	static void startInstall() throws SpaceException, MemoryException{
		if(!enoughSpace()) {
			throw new SpaceException("설치할 공간이 부족합니다.");
		}
		if(!enoughMemory()) {
			throw new MemoryException("메모리가 부족합니다.");
		}
	}
	
	static void copyFiles() {/*파일들을 복사하는코드를 적음*/}
	static void deleteTempFiles() {/*임시파일들을 삭제하는 코드를 적음*/}
	static boolean enoughSpace() {
		return false;
	}
	static boolean enoughMemory() {
		return false;
	}
}

class SpaceException extends Exception{
	SpaceException(String msg){super(msg);}
}

class MemoryException extends Exception{
	MemoryException(String msg){super(msg);}
}