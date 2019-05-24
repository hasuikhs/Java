package day10Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class test02 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("hello1");
		list.add("java");
		list.add("sql");
		list.add("spring");
		
		String[] s = new String[list.size()];
		s = list.toArray(s);
		
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);

		System.out.println("배열");
		System.out.println(Arrays.toString(s));
		Arrays.sort(s);
		System.out.println(Arrays.toString(s));
		
	}
}
