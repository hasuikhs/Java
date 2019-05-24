package util;

import java.util.Scanner;

public class Prob06 {

	public static void main(String[] args) {
			
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("책의 권수를 입력하세요.");
		System.out.println();
		int cnt = Integer.parseInt(keyboard.nextLine());
		
		BookMgr bmgr = new BookMgr(cnt); // cnt개의 책이 들어가는 배열
		
		for (int i = 0; i < cnt; i++)
		{
			System.out.println((i + 1) + " 번째 책");
			System.out.print("제목을 입력하세요.");
			System.out.println();
			String title = keyboard.nextLine();
			System.out.print("가격을 입력하세요.");
			System.out.println();
			int price = Integer.parseInt(keyboard.nextLine());
			
			Book book = new Book(title, price);
			bmgr.addBook(book);
		}
		
		keyboard.close();
		bmgr.printBookList();
		bmgr.printTotalPrice();	
	}

}

class Book
{
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
}

class BookMgr // 책 
{
	private Book[] booklist; // 여러권의 책 정보를 기억할 배열을 선언, 크기 고려 X
	private int size; // 배열의 크기
	private int count; // 배열에 저장된 데이터의 수
	public BookMgr() {
		this.size = 0;
		this.count = 0;
	} // 기본 생성자
	public BookMgr(int size) // 인자에 따른 생성자 메소드
	{
		this.size = size;
		this.count = 0;
		this.booklist = new Book[size];
	}
	public Book[] getBookList()
	{
		return booklist;
	}
	
	public void addBook(Book book) // Book객체를 list에 추가
	{
		if (count < size)
		{
			this.booklist[count++] = book;
		}
	}
	
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public void printBookList() // list를 화면에 출력
	{
		System.out.println("=== 책 목록 ===");
		for(int i = 0; i < this.booklist.length; i++)
		{
			System.out.println("제목 : " + booklist[i].getTitle() + " 가격 : " + booklist[i].getPrice());
		}
	}
	public void printTotalPrice() // 모든 책 가격의 합을 출력
	{
		int sum = 0;
		System.out.println("=== 책 가격의 합 ===");
		for(int i =0; i < this.booklist.length; i++)
		{
			sum += booklist[i].getPrice();
		}
		System.out.println(sum);
	}
}