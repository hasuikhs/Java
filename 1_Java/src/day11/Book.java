package day11;

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
	@Override
	public String toString() {
		return "Book [title=" + title + ", price=" + price + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + price;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (price != other.price)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	
}