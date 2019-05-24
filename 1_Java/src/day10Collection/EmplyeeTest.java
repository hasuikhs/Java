package day10Collection;

public class EmplyeeTest {

	public static void main(String[] args) {
		/*
		Employee<String> emp1 = new Employee<String>("홍길동", "2019001");
		System.out.println(emp1.number.substring(0, 4));
		
		Employee<Integer> emp2 = new Employee<Integer>("고길동", 123);
		System.out.println(emp2);
		
		Employee emp3 = new Employee("김길동",2019002);
		System.out.println(emp3.number);
		*/
		
		Employee<String, String> emp1 = new Employee<>("홍길동", "2019001");
		System.out.println(emp1);
		
		Employee emp2 = new Employee("김길동",2019002); 
		System.out.println(emp2);
		}
}
