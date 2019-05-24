package bookapp_v01;

import java.io.Serializable;

class Book extends Object implements Serializable{
	private String title; // 제목 멤버변수
	private int price; // 가격 멤버변수
	
	Book()	{	} // 기본 생성자
	Book(String title, int price)
	{
		this.setTitle(title);
		this.setPrice(price);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
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
		boolean f = false; // 기본적으로 f를 false로 선언하고,
		if (obj != null && obj instanceof Book) { // obj객체가 null이 아니고 obj 객체가 book객체인 경우
			Book temp = (Book) obj; // 임시 북객체에 obj 객체를 넣는다
			if (title.equals(temp.title) && price == temp.price) { // title과 price가 임시 북객체와 같다면
				f = true; // f를 true로 반환
			}
		}
		return f;
	}
}