package ObjectOrientedProgramming2;

interface Parseable{
	//구문분석작업을 수행함
	public abstract void parser(String fileName);
}

class ParserManager{
	//리턴타입이 Parseable인터페이스
	public static Parseable getParser(String type) {
		if(type.equals("XML")) {
			return new XMLParser();
		} else {
			Parseable p = new HTMLParser();
			return p;
			//return new HTMLParser();
		}
	}
}

class XMLParser implements Parseable{
	public void parser(String fileName) {
		/*구문분석작업을 수행하는 코드를 작성*/
		System.out.println(fileName+"- XML parsing completed");
	}
}

class HTMLParser implements Parseable{
	public void parser(String fileName) {
		/*구문 분석작업을 수행하는 코드를 작성*/
		System.out.println(fileName+"- HTML parsing completed");
	}
}

public class ParserTest {

	public static void main(String[] args) {
		Parseable parser = ParserManager.getParser("XML");
		parser.parser("hello.xml");
		parser = ParserManager.getParser("HTML");
		parser.parser("hello.html");
	}

}
