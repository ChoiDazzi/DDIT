package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class HotelTest {
	Scanner scan = new Scanner(System.in);
	HashMap<Integer, Room> hotelMap = new HashMap<>();

	public static void main(String[] args) {
		HotelTest ht = new HotelTest();
		ht.process();
	}

	//선택시 과정 
	public void process() {
		insert();
		while (true) {
			int choice = menu();
			scan.nextLine();
			switch (choice) {
			case 1:
				checkIn();
				break;
			case 2:
				checkOut();
				break;
			case 3:
				roomCondition();
				break;
			case 4:
				System.out.println("*********************************************");
				System.out.println("       호텔문을 닫았습니다.");
				System.out.println("*********************************************");
				return;

			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				break;
			}
		}
	}
	//1. 체크인 
	private void checkIn() {
		System.out.println("----------------------------------------------");
		System.out.println("   체크인 작업");
		System.out.println("----------------------------------------------");
		System.out.println(" * 201~209 : 싱글룸");
		System.out.println(" * 301~309 : 더블룸");
		System.out.println(" * 401~409 : 스위트룸");
		System.out.println("----------------------------------------------");
		System.out.print("방 번호 입력>> ");
		int num = scan.nextInt();
		scan.nextLine();
		if (hotelMap.get(num) == null) {
			System.out.println(num + "호 객실은 존재하지 않습니다.");
			return;
		} else if(hotelMap.get(num).name != "-") {
			System.out.println(num + "호 객실은 이미 손님이 있습니다. ");;
			return;
		}else {
			System.out.println("누구를 체크인 하시겠습니다?");
			System.out.print("이름 입력>> ");
			
			String name = scan.nextLine();
			hotelMap.put(num, new Room(num,hotelMap.get(num).type,name));
			System.out.println("체크인이 완료되었습니다.");
		}
	}
	//2. 체크아웃 
	private void checkOut() {
		System.out.println("----------------------------------------------");
		System.out.println("   체크아웃 작업");
		System.out.println("----------------------------------------------");
		System.out.println("체크아웃 할 방 번호를 입력하세요.");
		System.out.print("방 번호 입력>> ");
		int num = scan.nextInt();
		scan.nextLine();
		if(hotelMap.get(num) == null) {
			System.out.println(num + "호 객실은 존재하지 않습니다.");
			return;
		} else if (hotelMap.get(num).name == "-") {
			System.out.println(num + "호 객실에는 체크인 한 사람이 없습니다.");
			return;
		} else {
		System.out.println(num + "객실의 " + hotelMap.get(num).name + "님 체크아웃을 완료하였습니다.");
		hotelMap.put(num, new Room(num,hotelMap.get(num).type,"-"));
		}
	}
	//3. 객실상태 
	private void roomCondition() {
		System.out.println("----------------------------------------------");
		System.out.println("		현재 객실 상태");
		System.out.println("----------------------------------------------");
		System.out.println("방 번호\t방 종류\t\t투숙객 이름");
		System.out.println("----------------------------------------------");
		List<Integer> mapSet = new ArrayList<>(hotelMap.keySet());
		Collections.sort(mapSet);
		
		for (Integer roomNum : mapSet) {
			System.out.println(hotelMap.get(roomNum));
		}
	}

	//메뉴
	public int menu() {
		System.out.println();
		System.out.println("*********************************************");
		System.out.println("       호텔문을 열었습니다. 어서오십시요.");
		System.out.println("*********************************************");
		System.out.println();
		System.out.println();
		System.out.println("-----------------------------------------------------------");
		System.out.println("어떤 업무를 하시겠습니까?");
		System.out.println("1. 체크인    2. 체크아웃    3. 객실상태    4. 업무종료");
		System.out.println("-----------------------------------------------------------");
		System.out.print("선택>> ");
		return scan.nextInt();
	}
	
	//방정보 저장 
	public void insert() {
		for (int i = 1; i <= 9; i++) {
			int num2 = 200+i;
			int num3 = 300+i;
			int num4 = 400+i;
			hotelMap.put(num2, new Room(num2,"싱글룸","-"));
			hotelMap.put(num3, new Room(num3,"더블룸","-"));
			hotelMap.put(num4, new Room(num4,"스위트룸","-"));	
		}
	}
}

class Room{
	int num;
	String type;
	String name;
	
	public Room(int num, String type, String name) {
		this.num = num;
		this.type = type;
		this.name = name;
	}

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return String.format("%s\t%s\t\t%s", num, type, name);
	}
	
}