package day06;
/**
 * 
 * @author student
 * @since 19.04.30
 * @version 1.0
 */
public class Account {

	private String number;
	private int money;
	
	public Account() 
	{
		this("000", 0);
		// this.setNumber("000");
		// this.setMoney(10);
	}
	
	public Account(String number, int money) {
		this.setNumber(number);
		this.setMoney(money);
	}
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	public void input(int money)
	{
		if(money > 0)
		{
			this.money += money;
		}
	}
	public int output(int money)
	{
		if(this.money >= money)
		{
			this.money -= money;
			return money;
		}
		else
		{
			System.out.printf("계좌 [%s] 잔고 부족 [%d] 원 출금 불가%n", this.number, money);
			return 0;
		}
	}
	/**
	 * 
	 * @param from 출금 계좌
	 * @param to 입금 계좌
	 * @param money 이체 금액
	 */
	public static void transfer(Account from, Account to, int money)
	{
		System.out.printf("계좌 [%s]에서 계좌[%s]로 [%d]원 이체 진행중 ...%n", from.number, to.number, money);
		if (from.money < money)
		{
			System.out.printf("계좌 [%s] 잔고 부족 [%d] 원 이체 불가%n", from.number, money);
		}
		else
		{
			to.input(from.output(money));
			System.out.printf("계좌 [%s]에서 계좌 [%s]로 [%d]원 이체 완료%n", from.number, to.number, money);
		}
	}
	
	public void print()
	{
		System.out.printf("Account[통장번호 : %20s, 잔고 : %d 원]%n", number, money);
	}
	
}
