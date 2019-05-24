package book;

import java.util.Scanner;

public class book {

	public static void main(String[] args) {
	
		Scanner keyboard = new Scanner(System.in);
		System.out.println("[책 제목을 입력하세요...]");
		System.out.println();
		String name = keyboard.nextLine();
		
		System.out.print("[책 가격을 입력하세요...]");
		System.out.println();
		int price = Integer.parseInt(keyboard.nextLine());
		
		Info b1 = new Info();
		b1.setTitle(name);
		b1.getTitle();
		
		b1.setPrice(price);
		b1.getPrice();
		b1.print();
		
		keyboard.close();
		keyboard = null;

	}

}

class Info
{
	private String title;
	private int price;
	
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getTitle()
	{
		return title;
	}

	public void setPrice(int price)
	{
		if (price >= 0)
		{
			this.price = price;
		}
		else 
		{
			this.price = -price;	
		}
	}
	public int getPrice()
	{
		return price;
	}
	
	public void print()
	{
		System.out.printf("[%s의 가격은 %,d 원입니다.]", this.title, this.price);
	}
}
