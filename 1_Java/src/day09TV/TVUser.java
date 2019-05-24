package day09TV;

public class TVUser {
	public static void main(String[] args) {
		TV user1 = new STV();
		user1.PowerOn();
		
		user1 = new LTV();
		user1.PowerOn();
		
		System.out.println("--------------");
		
		TV user2 = new STV();
		tv(user1);
		tv(user2);
	}
	
	public static void tv(TV tv) {
		tv.PowerOn();
	}
}
