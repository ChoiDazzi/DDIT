package kr.or.ddit.basic.exercise;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

//문제) 이름, 주소, 전화번호를 멤버로 갖는 Phone클래스를 만들고
//Map을 이용하여 '전화번호 정보'를 관리하는 프로그램을 작성하시오.
//(이 때 Map의 구조는 key값으로 '이름'데이터를 사용하고, 
//value값으로는 'Phone클래스의 인스턴스'로 한다.)

public class PhoneBookTest {
	Scanner sc = new Scanner(System.in);
	HashMap<String, Phone> telMap = new HashMap<>();

	public static void main(String[] args) {
		PhoneBookTest pbt = new PhoneBookTest();
		pbt.start();
	}

	public void start() {
		while (true) {
			int num = menu();
			sc.nextLine();
			switch (num) {
			case 1:
				register();
				break;
			case 2:
				modify();
				break;
			case 3:
				delete();
				break;
			case 4:
				search();
				break;
			case 5:
				print();
				break;
			case 0:
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("번호를 잘못 입력하셨습니다. 다시 입력해주세요.");
				break;
			}
		}
	}

	// 메인 메뉴
	public int menu() {
		System.out.println("------------------------------------");
		System.out.println("               메  뉴");
		System.out.println("------------------------------------");
		System.out.println("1. 전화번호 등록");
		System.out.println("2. 전화번호 수정");
		System.out.println("3. 전화번호 삭제");
		System.out.println("4. 전화번호 검색");
		System.out.println("5. 전화번호 전체 출력");
		System.out.println("0. 프로그램 종료");
		System.out.println("------------------------------------");
		System.out.print("번호 입력 >> ");
		return sc.nextInt();
	}

	// 1. 전화번호 등록
	public void register() {
		System.out.println("새롭게 등록할 전화번호 정보를 입력하세요.");
		System.out.print("이름 >>");
		String name = sc.nextLine();
		if (telMap.get(name) != null) {
			System.out.println("'" + name + "' 은 이미 등록된 사람입니다.");
			register();
		}
		System.out.print("전화번호 >>");
		String tel = sc.nextLine();
		System.out.print("주소 >>");
		String add = sc.nextLine();
		telMap.put(name, new Phone(name, add, tel));
		System.out.println("'" + telMap.get(name).getName() + "' 전화번호 등록 완료!!");
	}

	// 2. 전화번호 수정
	public void modify() {
		System.out.println("전화번호를 수정하실 분의 이름을 입력하세요.");
		System.out.print("이름을 입력하세요: ");
		String name = sc.nextLine();
		if (telMap.get(name) == null) {
			System.out.println("수정할 정보가 존재하지 않습니다.");
			modify();
		}
		System.out.print("수정할 전화번호를 입력하세요: ");
		String tel = sc.nextLine();
		System.out.print("수정할 주소를 입력하세요: ");
		String add = sc.nextLine();
		telMap.put(name, new Phone(name, add, tel));
		System.out.println("수정이 완료되었습니다!");
	}

	// 3. 전화번호 삭제
	public void delete() {
		System.out.println("전화번호를 삭제하실 분의 이름을 입력하세요.");
		System.out.print("이름을 입력하세요: ");
		String name = sc.nextLine();
		if (telMap.get(name) == null) {
			System.out.println("삭제할 정보가 존재하지 않습니다.");
			delete();
		}
		telMap.remove(name);
		System.out.println("삭제가 완료되었습니다!");
	}

	// 4. 전화번호 검색
	public void search() {
		System.out.println("검색하시는 전화번호 정보를 입력하세요.");
		System.out.print("이름을 입력하세요: ");
		String name = sc.nextLine();
		if (telMap.get(name) == null) {
			System.out.println("찾으시는 정보가 존재하지 않습니다.");
			search();
		}
		System.out.println("------------------------------------");
		System.out.println("              " + telMap.get(name).getName() + "님의 정보         ");
		System.out.println("------------------------------------");
		System.out.println("\t이름\t전화번호\t\t주소");
		System.out.println(telMap.get(name));
	}

	// 5. 전화번호 전체 출력
	public void print() {
		Set<String> mapSet = telMap.keySet();
		Iterator<String> it = mapSet.iterator();
		System.out.println("------------------------------------");
		System.out.println("          전화번호 전체 출력");
		System.out.println("------------------------------------");
		System.out.println("번호\t이름\t전화번호\t\t주소");
		for (int i = 1; i <= mapSet.size(); i++) {
			String name = it.next();
			Phone value = telMap.get(name);
			System.out.println(" " + i + value);
		}
	}
}
//Phone class 
class Phone {
	private String name;
	private String add;
	private String tel;

	public Phone(String name, String add, String tel) {
		this.name = name;
		this.add = add;
		this.tel = tel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdd() {
		return add;
	}

	public void setAdd(String add) {
		this.add = add;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return String.format("\t%s\t%s\t%s", name, tel, add);
	}

}