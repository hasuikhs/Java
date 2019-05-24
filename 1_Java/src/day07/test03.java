package day07;

public class test03 {

	public static void main(String[] args) {
		Dog d = new Dog("시베리안 허스키","캐리");
		Fish f = new Fish("쿠피");
		f.print();
		f.breath();
		
		Animal b = f;
		b.breath();
		b.print();
		
		d.print();
		d.breath();
		System.out.println(((Animal)d).kind);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
		
		Object a = new Dog("시베리안 허스키","캐리");
		 // 캐스팅 전 instanceof 처리
		if ( a instanceof Animal)
			System.out.println( ( (Animal) a).kind);
		
		if ( a instanceof Dog)
			System.out.println( ( (Dog) a).kind);
		
		if (a instanceof String)
			System.out.println( ( (String) a).toString());
	}

}
