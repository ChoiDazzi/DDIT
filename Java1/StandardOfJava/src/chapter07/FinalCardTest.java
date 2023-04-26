package chapter07;

class Card1{
	final int NUMBER; //상수지만 선언과 함께 초기화 하지 않고 
	final String KIND; //생성자에서 단 한번만 초기화가능 
	static int width = 100;
	static int height = 250;
	
	public Card1(int number, String kind) {
		
		NUMBER = number;
		KIND = kind;
	}
	
	Card1(){
		this(1, "HEART");
	}

	@Override
	public String toString() {
		return KIND + " " + NUMBER;
	}
}

public class FinalCardTest {
	public static void main(String[] args) {
		Card1 c = new Card1(10, "HEART");
//		c.NUMBER = 5; 에러. 상수(final) 변경 불가 
		System.out.println(c.KIND);
		System.out.println(c.NUMBER);
		System.out.println(c);
	}
}
