package day08;

// import static 메인문 Math. 생략
import static java.lang.Math.PI;
import static java.lang.Math.random;

public class test01 {
	public static void main(String[] args) {
		System.out.println(PI);
		System.out.println(random());
	
		Animal f = new Fish("쿠피");
		Animal d = new Dog("시베리","해피");
		
		Animal a = f;
		
		exec(d);
	}
	
	public static void exec(Animal f) {
		f.breath();
		f.print();
	}
}