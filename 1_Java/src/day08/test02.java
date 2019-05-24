package day08;

public class test02 {
	public static void main(String[] args) {
		
		// 애러 Animal a = new Animal(); // <- 객체생성 불가
		// Animal[] animals = new Animal[3]; // <- 타입생성은 가능
		Animal[] animals = {new Fish("쿠피"), new Dog("시베리","캐리")};
		
		for( Animal a: animals) {
			exec(a);
		}
	}
	
	public static void exec(Animal f) {
		f.breath();
		f.print();
	}
	
}
