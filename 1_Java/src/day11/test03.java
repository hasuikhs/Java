package day11;

import java.util.ArrayList;
import java.util.List;

public class test03 {
	public static void main(String[] args) {	
	
		List<Integer> list = new ArrayList<Integer>();
		
		list.add(77);
		list.add(90);
		list.add(75);
		list.add(80);
		list.add(49);
		
		for(Integer data:list) {
			System.out.println(data);
		}
		/*
		System.out.println("=======================");
		
		list.forEach(new Consumer<Integer>() {
			@Override
			public void accept(Integer t) {
				System.out.print(t+" ");
			}
		});
		System.out.println();
		System.out.println("=======================");
		*/
		
		// 위식에서 람다식으로
		//list.forEach((Integer t) -> System.out.print(t+" "));
		//System.out.println();
		//System.out.println("==================");
		
		// 더 간결하게
		list.forEach(t -> System.out.print(t+" "));
		
		list.removeIf(i -> i % 2 == 0);
		System.out.println();
		list.forEach(t -> System.out.print(t+" "));
		
		System.out.println();
		
		list.replaceAll(i -> i*10);
		
		list.forEach(t -> System.out.print(t+" "));
	}
}
