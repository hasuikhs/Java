package day08;

//상속을 전제로 만들어진 Animal 클래스 abstract
public abstract class Animal extends Object{
	String kind = "동물의 종류";

	public Animal() { } // 기본 생성자
	public Animal(String kind) {
		super(); // 자동으로 생성 super
		this.kind = kind;
	}
	
	public abstract void breath();
	public void print() {
		
	}
	
}