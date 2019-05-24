package day08;

public class Fish extends Animal{
	String name;
	Fish(){
		super("물고기");
	}
	Fish(String name){
		super("물고기");
		this.name = name;
	}
	@Override
	public void breath() {
		System.out.println("아가미로 숨쉬기");
	}
	public void print() {
		System.out.printf("동물[%s, %s, %s]%n", super.kind, this.kind, name);
	}
}