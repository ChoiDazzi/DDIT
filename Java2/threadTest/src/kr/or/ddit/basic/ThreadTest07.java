package kr.or.ddit.basic;

import java.util.Random;
import javax.swing.JOptionPane;

/*
 	컴퓨터와 가위 바위 보를 진행하는 프로그램을 작성하시오. 
 	
 	컴퓨터의 가위 바위 보는 난수를 이용해서 구하고 
 	사용자의 입력은 showInputDialog()메서드를 이용해서 입력받는다. 
 	
 	입력시간은 5초로 제한하고 카운트 다운을 진행한다. 
 	5초 안에 입력이 없으면 게임에 진 것으로 처리한다. 
 	
 	5초 안에 입력이 완료되면 승패를 구해서 결과를 출력한다. 
 	
 	결과 예시1 => 5초 안에 입력을 못했을 경우 
 		====    결  과    ====
 		시간초과로 당신이 졌습니다.

 	결과 예시1 => 5초 안에 입력이 완료되었을 경우 
 		====    결  과    ====
 		컴퓨터: 가위
 		사용자: 바위 
 		결과: 당신이 이겼습니다...
 		
 */
public class ThreadTest07 {
	public static void main(String[] args) {
		Thread th1 = new UserInput();
		Thread th2 = new CountFive();
		
		th1.start();
		th2.start();
	}

}

class UserInput extends Thread {
	public static boolean inputCheck = false;

	@Override
	public void run() {
		String user = null;
		do {
		user = JOptionPane.showInputDialog("가위 바위 보 중 하나를 입력하세요...");			
		} while (!"가위".equals(user) && !"바위".equals(user)  && !"보".equals(user) );
		inputCheck = true;
		
		Random rd = new Random();
		String[] coms = {"가위" ,"바위", "보"};
		String com = coms[rd.nextInt(3)];
		
		System.out.println("====    결  과    ====");
		System.out.println(" 컴퓨터: " + com);
		System.out.println(" 사용자: " + user);
		/*
		if (com.equals(user)) {
			System.out.println(" 결과: 비겼습니다...");
		} else if(com.equals("가위") && user.equals("바위") ||
					  com.equals("바위") && user.equals("보") ||
					  com.equals("보") && user.equals("가위") ) {
			System.out.println("결과: 당신이 이겼습니다... ");
		}  else {
			System.out.println("결과: 당신이 졌습니다...");
		}
		*/
		switch(user + com) {
		case "가위가위":
		case "가위바위":
		case "보보": 		System.out.println("비겼습니다..."); break;

		case "가위보":
		case "바위가위":
		case "보바위": 		System.out.println("당신이 이겼습니다."); break;
			
		default: System.out.println("당신이 졌습니다.");
		}
		
	}
}

//카운트 다운을 진행하는 쓰레드 
class CountFive extends Thread {
	@Override
	public void run() {
		for (int i = 15; i >= 1; i--) {
			//입력이 완료되었는지 여부 검사해서 입력이 완료되면 쓰레드를 종료 시킨다. 
			if (UserInput.inputCheck) {
				return;			//run() 메서드가 종료되면 쓰레드도 종료된다.
			}
			
			System.out.println(i);
			try {
				Thread.sleep(1000); // 1초에 한 번씩 출력 (1초동안 잠시 멈춘다..)
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}//for문 끝 
		System.out.println("====    결  과    ====");
		System.out.println("시간초과로 당신이 졌습니다.");				
		System.exit(0);
	}
}
