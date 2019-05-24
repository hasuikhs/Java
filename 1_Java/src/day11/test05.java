package day11;

import java.util.ArrayList;
import java.util.List;

public class test05 {
	public static void main(String[] args) {
		List<Book> books = new ArrayList<Book>();
		
		books.add(new Book("java", 500));
		books.add(new Book("sql", 5200));
		books.add(new Book("servlet&jsp", 2500));
		books.add(new Book("html5", 1500));
		books.add(new Book("java", 500));
		books.add(new Book("java", 500));
		
		books.forEach(i -> System.out.println(i.getTitle().charAt(0) + "**"));
		System.out.println("===========================");
		books.forEach(i -> System.out.println(i));
		System.out.println("===========================");
		books.stream().distinct().forEach(i -> System.out.println(i)); //distinct 중복제거
		
		long count = books.stream().filter(i -> i.getPrice() >=5000).count();
		System.out.println(count);
		
		long sum = books.stream().mapToInt(i -> i.getPrice()).sum();
		System.out.println(sum);
	} 
}
