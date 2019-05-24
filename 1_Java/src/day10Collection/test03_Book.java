package day10Collection;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class test03_Book {
	public static void main(String[] args) {
		// List<Book> list = new ArrayList<Book>();
		List<Book> list = new Vector<Book>(); // ArrayList = Vector
		
		list.add(new Book("java",900));
		list.add(new Book("sql",1900));
		list.add(new Book("db",1500));
		list.add(new Book("spring",2100));
		/* 
		System.out.println(list);
		list.remove(new Book("sql",1900));
		Collections.sort(list);
		
		System.out.println(list);
		System.out.println();
		
		for (int i=0;i<list.size();i++) {
			System.out.println(list.get(i).getName().charAt(0));
			*/
		Iterator<Book> it = list.iterator();
		while (it.hasNext()) {
			Book book = (Book) it.next();
			// System.out.println(book);
			if (book.getName().equalsIgnoreCase("SQL")) {
				it.remove();
			}
		}
		System.out.println(list);
	}
}

class Book extends Object implements Serializable, Comparable<Book>{
	String name;
	int price;
	public Book() {
		super();
	}
	public Book(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + price;
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
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price != other.price)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Book [name=" + name + ", price=" + price + "]";
	}
	@Override
	public int compareTo(Book o) {
		 return price-o.price; // 책의 가격으로 소트
		//return name.compareTo(o.name); // 책 제목으로소트
	}
	
	
}
