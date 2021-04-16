package ObjectOrientedProgramming2;

interface Parseable{
	//�����м��۾��� ������
	public abstract void parser(String fileName);
}

class ParserManager{
	//����Ÿ���� Parseable�������̽�
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
		/*�����м��۾��� �����ϴ� �ڵ带 �ۼ�*/
		System.out.println(fileName+"- XML parsing completed");
	}
}

class HTMLParser implements Parseable{
	public void parser(String fileName) {
		/*���� �м��۾��� �����ϴ� �ڵ带 �ۼ�*/
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
