package chapter07;

public class InterfaceTest3 {
	public static void main(String[] args) {
		X x = new X();
		x.methodX();
	}
}

class X{
	void methodX() {
		Y y = InstanceManager.getInstance(); //제 3의 클래스의 메서드를 통해 인터페이스 Y를 구현한 클래스의 인스터스를 얻어온다.
		y.methodZ();
		System.out.println(y.toString());
	}
}

interface Y{
	public abstract void methodZ();
}

class Z implements Y{
	@Override
	public void methodZ() {
		System.out.println("methodB in Z class");
	}
	
	public String toString() {
		return "class Z";
	}
}

class InstanceManager{
	public static Y getInstance() {
		return new Z();
	}
}