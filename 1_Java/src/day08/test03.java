package day08;

public class test03 {
	public static void main(String[] args) {
		Object[] obj = {new Fish("쿠피"), new Dog("시베리","캐리"), new Fish("dd"),"Hello Java"};
	}
	
	public static void exec(Object obj) {
		if(obj instanceof Animal) // 오브잭트는 최상위 그래서 다운캐스팅
			((Animal)obj).print();
	}
}


