package javaThread;

/*
 * 2개의 Thread를 파생시켜서 공용객체를 이용하도록 만들어 보자!
 * Thread가 공용객체를 동기화해서 사용하는 경우와 그렇지 않은 경우를
 * 비교해서 이해보자!
 * 
 * 공용객체를 만들기 위한 class를 정의해 보자
 * 
 */

class SharedObject{
	private int number; // 공용객체가 가지는 field

	// getter & setter (Thread에 의해서 사용)
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	// Thread에 의해서 사용이 되는 business method
	// synchronized keyword로 동기화를 할 수 있음
	// method 동기화는 효율이 좋지 않음
	// 동기화 block을 이용해서 처리하는 것이 일반적
	public void assignNumber(int number) {
		// 동기화 block
		// 첫 thread가 실행되다가 잠이 들면 다음 thread가 오지만
		// 다음 thread가 봤을때 같은 이름의 객체? 가 있어 대기한다
		// 첫 thread가 잠에서 깨고 코드를 수행하고
		// 대기 중인 thread가 코드를 수행한다 
		synchronized (this) {
			this.number = number;
			try {
				Thread.sleep(3000);
				System.out.println("현재 공용객체의 number : " + this.number);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
// Runnable interface를 구현한 class(Thread 생성자의 인자로 이용하기 위해)
class MyRunnable implements Runnable{
	
	SharedObject shared;
	int input;
	
	public MyRunnable(SharedObject shared, int input) {
		this.shared = shared;
		this.input = input;
	}
	
	@Override
	public void run() {
		shared.assignNumber(input);
	}
}
public class Exam04_ThreadSync {
	public static void main(String[] args) {
		// 공용객체를 하나 생성
		SharedObject shared = new SharedObject();
		
		// Thread를 생성(2개) - 공용객체를 가지는 Thread를 생성
		Thread t1 = new Thread(new MyRunnable(shared, 100));
		Thread t2 = new Thread(new MyRunnable(shared, 200));
		
		// Thread 실행(runnable 상태로 전환)
		t1.start();
		t2.start();
	}
}
