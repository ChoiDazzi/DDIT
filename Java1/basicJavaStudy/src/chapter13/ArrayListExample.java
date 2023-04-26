package chapter13;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {
	public static void main(String[] args) {
		String[] subjects= {"Java","Database","JSP/Servlet","JDBC","iBatis"}; // 추가나 삭제 안 됨 
		List<String> list = new ArrayList<>();
		list.add("Java");
		list.add("Database");
		list.add("JSP/Servlet");
		//index 2랑 3 바꾸기 
		list.add(2, "JDBC");
		list.add("iBatis");
		
		System.out.println("순서바꾸기\n");
		for (String string : list) {
			System.out.println(string);
		}
		System.out.println();
		System.out.println("갯수: " + list.size());
		System.out.println("list.get(): " + list.get(2));
		System.out.println();
		list.remove(2);
		list.remove(2);
		list.remove("iBatis");
		for (String string : list) {
			System.out.println(string);
		}
	}
}
