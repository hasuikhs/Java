package book;

public class acc1 
{
	public static void main(String[] args) 
	{
		Account ac1 = new Account("ac1", 50000);
		Account ac2 = new Account("ac2", 100000);
		ac1.print();
		ac2.print();
		ac1.AccountIn(50000);
		ac2.AccountIn(10000000);
		ac1.print();
		ac2.print();
		ac1.AccountOut(10000000);
		ac1.Move(ac2, 100000);
		ac1.print();
		ac2.print();
	} 
}

class Account
{
	
	private String Account; 
	private int Balance; 
	
	Account(String Account1, int Balance1)
	{
		this.Account = Account1;
		this.Balance = Balance1;
	}
	
	public int AccountIn(int a) 
	{
		System.out.println(this.Account + " 계좌 " + a +" 입금");
		this.Balance += a;
		return this.Balance; 
		
	}
	
	public int AccountOut(int a)
	{
		if (this.Balance < a)
		{
			System.out.println(this.Account + " 잔고 부족 " + a + " 출금 불가");
			return this.Balance;
		}
		else
		{
			System.out.println(this.Account + " 계좌 " + a +" 출금");
			this.Balance -= a;
			return this.Balance;
		}
		
	}
	
	public int Move(Account a, int b) 
	{
		if (this.Balance < b)
		{
			System.out.println("잔고 부족");
		}
		else
		{
			AccountOut(b); 
			a.AccountIn(b);
		}
		return this.Balance;
	}
	
	public void print()
	{
		System.out.println();
		System.out.println("=========== Account Information ===========");
		System.out.printf("========= Account = %13s =========%n", this.Account);
		System.out.printf("========= Balance = %13d =========%n", this.Balance);
		System.out.println("===========================================");
		System.out.println();
	}
}