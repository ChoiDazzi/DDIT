package kr.or.ddit.basic;

public class ThreadTest02 {
	
	public static void main(String[] args) {
		//멀티 쓰레드 프로그램 작성하기 
		/*
			방법 1) Thread 클래스를 상속하는 방법 
				=> Thread를 상속하는 클래스를 작성하고, 
				이 클래스의 인스턴스를 생성한 후, 
				생성된 인스턴스의 start() 메서드를 호출해서 실행한다. 
		*/
		MyThread1 th1 = new MyThread1(); //인스턴스 생성 (객체 생성)
		th1.start();									 //쓰레드 실행 
		
		
		/*
		방법 2) Runnable 인터페이스를 구현하는 방법 
			=> Runnable 인터페이스를 구현한 클래스를 작성하고, 
			이 클래스의 인스턴스를 생성한 후, 
			Thread 클래스의 인스턴스를 생성할 때 
			Runnable 인터페이스를 구현한 클래스의 인스턴스를 
			인수값으로 넣어서 생성한다. 
			생성된 Thread 클래스의 인스턴스의 start()메서드를 호출해서 실행한다. 
		 */
		MyTread2 r1 = new MyTread2(); //Runnable 을 구현한 클래스의 인스턴스 생성 
		Thread th2 = new Thread(r1);		
		th2.start();
		
		// 방법 3) Runnable 인터페이스를 익명 구현체로 구현해서 실행하는 방법 
		Runnable r2 = new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i <= 200; i++) {
					System.out.print("#");
					try {
						// Thread.sleep(시간)	=> 주어진 '시간'동안 작업을 잠시 멈춘다.
						//										'시간' 은 밀리세컨드(1/1000초) 단위를 사용한다. 
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO: handle exception
					}
				}
			}
		};
		
		Thread th3 = new Thread(r2);
		th3.start();
		
		System.out.println("메인 메서드 끝...");
	}
}
// 방법 1) Thread를 상속하는 클래스 작성 
class MyThread1 extends Thread{
	@Override
	public void run() {
		//이 run() 메서드 안에는 쓰레드가 처리할 내용을 작성하면 된다. 
		for (int i = 1; i <= 200; i++) {
			System.out.print("*");
			try {
				// Thread.sleep(시간)	=> 주어진 '시간'동안 작업을 잠시 멈춘다.
				//										'시간' 은 밀리세컨드(1/1000초) 단위를 사용한다. 
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	}
}

// 방법 2) Runnable 인터페이스를 구현한 클래스 작성 
class MyTread2 implements Runnable{

	@Override
	public void run() {
		//이 run() 메서드 안에는 쓰레드가 처리할 내용을 작성하면 된다. 
		for (int i = 0; i <= 200; i++) {
			System.out.print("$");
			try {
				// Thread.sleep(시간)	=> 주어진 '시간'동안 작업을 잠시 멈춘다.
				//										'시간' 은 밀리세컨드(1/1000초) 단위를 사용한다. 
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		
	}
//동시에 실행되는 것처럼 보임 	
}