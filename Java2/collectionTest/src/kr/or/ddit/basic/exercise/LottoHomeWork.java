package kr.or.ddit.basic.exercise;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class LottoHomeWork {

	public void BuyLotto() {
		System.out.println("Lotto 구입 시작 \n(1000원에 로또번호 하나입니다.) ");
		Scanner sc = new Scanner(System.in);
		System.out.print("금액입력: ");
		int money = sc.nextInt();
		if (money <= 100000 && money >= 1000) {
			int num = money / 1000;
			Random rd = new Random();

			for (int i = 1; i <= num; i++) {
				HashSet<Integer> set = new HashSet<>();
				for (int j = 0; set.size() < 6; j++) {
					int lotto = rd.nextInt(45) + 1;
					set.add(lotto);
				}
				System.out.println("로또번호" + i + ":");
				System.out.println(set);
			}
			System.out.println("받은 금액은 " + money + "원이고 거스름돈은 " + (money - num * 1000) + "원입니다.");
		} else if (money > 100000) {
			System.out.println("입력 금액이 너무 많습니다. 로또 번호 구입 실패!!");
		} else {
			System.out.println("입력 금액이 너무 적습니다. 로또 번호 구입 실패!!");
		}
	}

	public static void main(String[] args) {
		System.out.println("=========================================");

		System.out.println("              Lotto 프로그램");
		System.out.println("-----------------------------------------");
		System.out.println("1. Lotto 구입");
		System.out.println("2. 프로그램 종료");
		System.out.println("-----------------------------------------");
		System.out.println("-----------------------------------------");
		System.out.print("메뉴선택: ");
		Scanner sc = new Scanner(System.in);
		int menu = sc.nextInt();

		switch (menu) {
		case 1:
			LottoHomeWork lt = new LottoHomeWork();
			lt.BuyLotto();
			break;
		case 2:
			System.out.println("감사합니다.");
			break;

		default:
			System.out.println("잘못된 번호를 선택하셨습니다. ");
			break;
		}
	}
}
