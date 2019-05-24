package day10Collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class test04 {
	public static void main(String[] args) { // set 중복제거
		/*
		Set<Book> set = new HashSet<Book>();
		set.add(new Book("java",900));
		set.add(new Book("sql",1900));
		set.add(new Book("db",1500));
		set.add(new Book("spring",2100));
		set.add(new Book("java",900));
		set.add(new Book("sql",1900));
		set.add(new Book("db",1500));
		set.add(new Book("spring",2100));
		
		System.out.println(set.size());  // 4 중복제거
		*/
		
		Set<String> set = new HashSet<String>(); // 중복제거
		set.add("hello1");
		set.add("hello2");
		set.add("hello3");
		set.add("hello4");
		set.add("hello1");
		set.add("hello2");
		set.add("hello3");
		set.add("hello4");
		System.out.println(set);
		System.out.println(set.size());
		System.out.println();
		
		Set<String> set1 = new TreeSet<String>(); // 중복제거 & 소트
		set1.add("hello1");
		set1.add("hello2");
		set1.add("hello3");
		set1.add("hello4");
		set1.add("hello1");
		set1.add("hello2");
		set1.add("hello3");
		set1.add("hello4");
		System.out.println(set1);
		System.out.println(set1.size());
		System.out.println();
		
		Set<Book> set2 = new TreeSet<Book>();
		set2.add(new Book("java",900));
		set2.add(new Book("sql",1900));
		set2.add(new Book("db",1500));
		set2.add(new Book("spring",2100));
		set2.add(new Book("java",900));
		set2.add(new Book("sql",1900));
		set2.add(new Book("db",1500));
		set2.add(new Book("spring",2100));
		
		System.out.println(set2);
		System.out.println(set2.size());
		System.out.println();
		for (Book data:set2) {
			System.out.println(data);
		}
		
		System.out.println();
		Iterator<Book> it = set2.iterator();
		while (it.hasNext()) {
			Book book = (Book) it.next();
			// System.out.println(book);
			if (book.getName().equalsIgnoreCase("SQL")) {
				it.remove();
			}
		}
		System.out.println(set2);
	}
}
