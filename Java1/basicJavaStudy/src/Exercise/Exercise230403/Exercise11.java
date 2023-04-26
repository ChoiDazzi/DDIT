package Exercise.Exercise230403;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise11 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			try {
				System.out.println("어떤 수를 나누시겠습니까? >> ");
				int num1 = sc.nextInt();

				System.out.println("어떤 수로 나누시겠습니까? >> ");
				int num2 = sc.nextInt();
				int result = num1 / num2;
				System.out.println(num1 + "/" + num2 + "=" + result);
				sc.close();
				break;
			} catch (ArithmeticException e) {
				System.out.println("0으로 나눌 수 없습니다.");
				sc.nextLine();
			} catch (InputMismatchException e) {
				System.out.println("잘못된 입력입니다.");
				sc.nextLine();
			}
		}
	}
}
