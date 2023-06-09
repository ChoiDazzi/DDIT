package kr.or.ddit.basic.exercise;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class PhoneBookTestWt {
	private HashMap<String, Phone> PhoneBookMap;
	private Scanner scan;
	
	//생성자 
	public PhoneBookTestWt() {
		scan = new Scanner(System.in);
		PhoneBookMap = new HashMap<>();
	}
	
	public static void main(String[] args) {
		new PhoneBookTestWt().phoneBookStart();
	}
	//프로그램을 시작하는 메서드 
	public void phoneBookStart() {
		System.out.println("+++++++++++++++++++++");
		System.out.println("    전 화 번 호 관 리 프 로 그 램");
		System.out.println("+++++++++++++++++++++");
		System.out.println();
		
		while (true) {
			int choice = displayMenu();
			switch (choice) {
			case 1: //등록 
				insert();
				break;
			case 2: //수정 
				update();
				break;
			case 3: //삭제 
				delete();
				break;
			case 4: //검색 
				search();
				break;
			case 5: //전체 출력 
				displayAll();
				break;
			case 0: //종료  
				System.out.println();
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println();
				System.out.println("작업 번호를 잘못 입력했습니다. 다시 선택하세요.");
				break;
			}
		}
	}
	//4. 전화번호 정보를 검색하는 메서드 
	private void search() {
		System.out.println();
		System.out.println("검색할 전화번호 정보를 입력하세요.");
		System.out.print("이름>> ");
		String name = scan.next();
		if (!PhoneBookMap.containsKey(name)) {
			System.out.println();
			System.out.println(name + "씨 전화번호 정보가 없습니다. ");
		} else {
			Phone p = PhoneBookMap.get(name);
			System.out.println(name+"씨 전화번호 정보");
			System.out.println("----------------------------------");
//			System.out.println("이    름: " + name);
			System.out.println("이      름: " + p.getName());
			System.out.println("전 화 번 호: " + p.getTel());
			System.out.println("주      소: " + p.getAdd());
			System.out.println("----------------------------------");
		}
	}

	//3. 전화번호 정보를 삭제하는 메서드
	private void delete() {
		System.out.println();
		System.out.println("삭제할 전화번호 정보를 입력하세요.");
		String name = scan.next();
		if (!PhoneBookMap.containsKey(name)) {
			System.out.println();
			System.out.println(name+ "씨 전화번호 정보가 없습니다.");
		}
		PhoneBookMap.remove(name); //key값(이름)을 이용해서 삭제한다. 
		System.out.println(name + "씨 전화번호 정보 삭제 완료!!");
	}

	//2. 전화번호 정보를 수정하는 메서드 
	private void update() {
		System.out.println();
		System.out.println("수정할 전화번호 정보를 입력하세요.");
		System.out.print("이름>> ");
		String name = scan.next();
		if (!PhoneBookMap.containsKey(name)) {//해당 이름이 없으면 
			System.out.println(name + "씨 전화번호 정보가 없습니다.");
			return;
		}
		
		System.out.print("새로운 전화번호 >>");
		String newTel = scan.next();
		scan.nextLine(); //입력버퍼 비우기 
		System.out.print("새로운 주소 >>");
		String newAdd = scan.nextLine();
		
		//수정작업 => 같은 key 값에 새로운 전화번호 정보를 저장한다. 
		PhoneBookMap.put(name, new Phone(name, newTel, newAdd));
		System.out.println(name+ "씨의 전화번호 정보를 변경완료!!");
	}
	//5.전체 전화번호를 출력하는 메서드 
	private void displayAll() {
		System.out.println();
		Set<String> PhoneKeySet = PhoneBookMap.keySet();
		System.out.println("------------------------------------------------------");
		System.out.println("번호\t이름\t전화번호\t\t주소");
		System.out.println("------------------------------------------------------");
		if (PhoneKeySet.size() == 0) {
			System.out.println("등록된 전화번호 정보가 하나도 없습니다.");
		} else {
			int num = 0; //번호 출력용 변수 선언 
			Iterator<String> keyIt = PhoneKeySet.iterator();
			while (keyIt.hasNext()) {
				num++;
				String name = keyIt.next(); //키값(이름) 가져오기 
				Phone p = PhoneBookMap.get(name);
				System.out.println(""+num+"\t"+p.getName()+"\t"+p.getAdd()+"\t"+p.getTel());
			}
		}
		System.out.println("------------------------------------------------------");
	}
	// Scanner 객체의 next(), nextInt(), nextDouble() ..등 nextLine()이 아닌 메서드
	//=> 사이 띄기, Tap키, Enter키 구분 문자로 분리해서 분리된 자료만 읽어간다. 
	//Scanner 객체의 nextLine() 메서드 
	//=> 한 줄 단위로 입력한다. 즉, 자료를 입력하고 Enter키를 누르면 Enter키까지 읽어가서 Enter 키를 뺀 나머지 데이터를 반환한다. 
	//그래서 nextLine()메서드를 사용하기 전에 nextLine()이외의 메서드로 입력한 이력이 있는 경우에는 
	//nextLine()메서드를 한 번 호출해서 입력 버퍼를 비워주어야 한다. 
	
	
	//1. 새로운 전화번호 정보를 등록하는 메서드 
	private void insert() {
		System.out.println();
		System.out.println("새롭게 등록할 전화번호 정보를 입력하세요.");
		System.out.print("이름>> ");
		String name = scan.next();
		//이미 등록된 사람인지 여부 검사하기  
		if (PhoneBookMap.containsKey(name)) { //이미 있으면 
			System.out.println(name + "씨는 이미 등록된 이름 입니다. ");
			return;
		}
		System.out.print("전화번호>> ");
		String tel = scan.next();
		scan.nextLine(); //입력버퍼 비우기 
		
		System.out.print("주소>> ");
		String add = scan.nextLine();
		
//		Phone p = new Phone(name, tel, add);
//		PhoneBookMap.put(name, p);
		PhoneBookMap.put(name, new Phone(name,tel,add));
		System.out.println(name+" 전화번호 정보 등록 완료!");
	}
	
	//0. 메뉴를 출력하고 작업번호를 입력받아 반환하는 메서드 
	private int displayMenu() {
		System.out.println();
		System.out.println("==== 메    뉴 ====");
		System.out.println("1. 전화번호 등록");
		System.out.println("2. 전화번호 수정");
		System.out.println("3. 전화번호 삭제");
		System.out.println("4. 전화번호 검색");
		System.out.println("5. 전화번호 전체 출력");
		System.out.println("0. 프로그램 종료");
		System.out.println("============");
		System.out.print("번호 입력 >>");
		return scan.nextInt();
	}
}

