package day06;

public class Book {
	
	private String title;
	private int price;
	
	
	public Book(String title, int price) {
		this.title = title;
		this.price = price;
	}
	public Book() {	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		if(title != null && title.length() > 0)
		{
			this.title = title;
		}
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		if (price >= 0)
		{
			this.price = price;
		}
	}
	public void print()
	{
		System.out.printf("BOOK[제목 :  %s 가격 :  %d]%n",title,price);
	}
}