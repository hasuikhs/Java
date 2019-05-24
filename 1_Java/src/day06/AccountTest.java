package day06;

import util.Calc;

public class AccountTest {
	public static void main(String[] args) {
		Account a1 = new Account();
		a1.setNumber("001");
		a1.setMoney(100);
		a1.input(9000);
		a1.output(10000);
		a1.print();
		
		Account a2 = new Account();
		a2.setNumber("002");
		a2.setMoney(2000);
		a2.print();
		
		Account.transfer(a1, a2, 100000);
		
		System.out.println("이체 후");
		a1.print();
		a2.print();
		
		int sum = Calc.add(2, 4, 6, 8, 10);
	}
}