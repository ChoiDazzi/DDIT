package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListSortTest02 {
	public static void main(String[] args) {
		ArrayList<Member> memList = new ArrayList<>();

		memList.add(new Member(1, "신짱구", "010-1234-5678"));
		memList.add(new Member(5, "봉미선", "010-1234-5678"));
		memList.add(new Member(9, "신형만", "010-1234-5678"));
		memList.add(new Member(3, "김철수", "010-1234-5678"));
		memList.add(new Member(6, "이훈이", "010-1234-5678"));
		memList.add(new Member(2, "박맹구", "010-1234-5678"));

		System.out.println("정렬 전: ");
		for (Member mem : memList) {
			System.out.println(mem);
		}
		System.out.println("============================================");

		Collections.sort(memList);
		System.out.println("정렬 후: ");
		for (Member mem : memList) {
			System.out.println(mem);
		}
		System.out.println("============================================");
		
		//데이터 섞기 
		Collections.shuffle(memList);
		System.out.println("섞기 후: ");
		for (Member mem : memList) {
			System.out.println(mem);
		}
		System.out.println("============================================");
		Collections.sort(memList, new SortNumDesc());
		System.out.println("회원번호를 기준으로 내림차순 정렬 후: ");
		for (Member mem : memList) {
			System.out.println(mem);
		}
		System.out.println("============================================");
		
		
	}
}

//Member 의 회원번호 (num)값의 내림차순으로 정렬하는 외부 정렬 기준 클래스를 작성하여 정렬하시오. 
//=> Comparator 인터페이스를 구현한다. (클래스명: SortNumDesc) 
class SortNumDesc implements Comparator<Member>{

	@Override
	public int compare(Member mem1, Member mem2) {
//		if (mem1.getNum() > mem2.getNum()) {
//			return -1;
//		} else if(mem1.getNum() < mem2.getNum()) {
//		return 1;
//		} else return 0;
		
		//Wrapper 클래스를 이용하는 방법 1
		//return new Integer(mem1.getNum()).compareTo(mem2.getNum()) * (-1);
		
		//Wrapper 클래스를 이용하는 방법 2
		return Integer.compare(mem1.getNum(), mem2.getNum()) * (-1);
	}
}

//Member 클래스의 회원이름을 기준으로 오름차순 정렬이 되도록 내부 정렬 기준 추가하기 
class Member implements Comparable<Member> {
	private int num;
	private String name;
	private String tel;

	// Constructor
	public Member(int num, String name, String tel) {
		this.num = num;
		this.name = name;
		this.tel = tel;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "Member [num=" + num + ", name=" + name + ", tel=" + tel + "]";
	}

	// 회원 이름의 오름차순 정렬 지정하기
	// compare()메스드의 반환값의 의미
	// 반환값이 0이면 두 값이 같다. & 양수이면 두 값의 순서를 바꾼다. & 음수이면 두 값의 순서를 바꾸지 않는다.
	@Override
	public int compareTo(Member mem) {
//		if (this.getName().compareTo(mem.getName()) > 0) return 1;
//		else if (this.getName().compareTo(mem.getName()) < 0) return -1;
//		else return 0;
		
		return this.getName().compareTo(mem.getName());
	}
}

