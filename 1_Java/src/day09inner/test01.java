package day09inner;

class A{
	String name = "홍길동";
	
	void print() {
		new B().print();
	}
	class B{
		void print() {
			System.out.println(name);
		}
	}	
}




public class test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			A a = new A();
			a.print();
			
			A.B b = new A().new B();
			b.print();
	}

}
