package day06;

public class test02 {

	public static void main(String[] args) {
		
		Account a1 = new Account();
		a1.setMoney(1000);
		a1.setNumber("001");
		a1.print();
	
		Account a2 = new Account("002", 100);
		a2.print();
		
		Account a3 = new Account();
		a3.print();
	}

}
