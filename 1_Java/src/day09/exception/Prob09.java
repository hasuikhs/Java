package day09.exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Scanner;


// book tostring(), equals(~)
// bookmgr
// Scanner를 이용 "C://lib//bookdata.txt" 위치의 파일을 스캔
// booklist에 등록(중복체크)

public class Prob09 {

	public static void main(String[] args) {
		System.out.println("========== bookdata scan start ==========");
		
		BookMgr bmgr = new BookMgr();
		
		try(Scanner sc = new Scanner(new File("C://lib/bookdata.txt"));) {
			while (sc.hasNextLine()) {
				String data = sc.nextLine();
				String[] bookdata = data.split("/");
				
				Book book = new Book(bookdata[0], Integer.parseInt(bookdata[1]));
				bmgr.addBook(book);
			}
		} catch (FileNotFoundException e) {
			// e.printStackTrace();
			System.out.println("bookdata.txt 파일을 준비해주세요.");
		} catch (Exception e) {
			System.out.println("bookdata Parsing error");
			System.out.println(e.getMessage());
		}
		bmgr.printBookList();
		bmgr.printTotalPrice();
		System.out.println("=========== bookdata scan end ===========");
	}
}

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

class BookMgr{
	private Book[] booklist; // 여러권의 책 정보를 기억할 배열을 선언, 크기 고려 X
	private int size; // 배열의 크기
	private int count; // 배열에 저장된 데이터의 수
	
	public BookMgr() {// 기본 생성자
		this.size = 0;
		this.count = 0;
		this.booklist = new Book[10];
	} 
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
		
		for (int j = 0; j < booklist.length; j++) { 
			if(booklist[j] == null){ // j번재 booklist가 비어있다면
				booklist[j] = book; // j번째에 현재 book을 넣는다
				break;
			}else if (booklist[j].equals(book)) { // booklist의 j번째 book이 현재 book과 같다면 멈춘다
				break;
			}
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
		System.out.println("================ 책 목록 ================");
		for(int i = 0; i < this.booklist.length; i++)
		{
			if(booklist[i] != null)
				System.out.printf("제목 : %20s 가격 : %6d%n",booklist[i].getTitle(),booklist[i].getPrice());
		}
	}
	public void printTotalPrice() // 모든 책 가격의 합을 출력
	{
		int sum = 0;
		System.out.println("============== 책 가격의 합 ==============");
		for(int i =0; i < this.booklist.length; i++)
		{
			if(booklist[i] != null)
				sum += booklist[i].getPrice();
		}
		System.out.printf("%41d%n",sum);
	}
}