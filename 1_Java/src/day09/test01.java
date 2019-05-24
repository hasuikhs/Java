package day09;

public class test01 {
	public static void main(String[] args) {
		String msg1 = "hello java1";
		String msg2 = "hello java2";
	
		System.out.println(msg1.toString());
		System.out.println(msg2.toString());
		System.out.println("msg1과 msg2 비교 " + msg1.equals(msg2));
		
		Employee emp1 = new Employee("홍길동", "기술부");
		Employee emp2 = new Employee("홍길동", "기술부");
		
		System.out.println(emp1);
		System.out.println(emp2);
		System.out.println("emp1과 emp2 비교 " +emp1.equals(emp2));
		
		Object emp3 = new Employee("김길동", "인사부");
		System.out.println(emp3); // 오브젝트 타입은 toString, equals 
	}
}
