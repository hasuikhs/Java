package day08;

public interface Movable {
	public void move(); // abstract가 생략되어있다
}

interface Drawable{
	void draw();  // public abstract 생략되어 있다
}

interface MovableAndDrawable extends Movable, Drawable{ // 통합 인터페이스 설계
	
}

class Circle extends Object implements MovableAndDrawable{// interface 상속은 implements 일반 class 상속은 extends
	// implements 보다extends를 우선 추가
	@Override
	public void move() {
		System.out.println("Circle Move");	
	}

	@Override
	public void draw() {
		System.out.println("Circle Draw");
	} 
}

class Rectangle implements MovableAndDrawable{

	@Override
	public void move() {
		System.out.println("Rectangle Move");	
	}
	
	@Override
	public void draw() {
		System.out.println("Rectangle Draw");	
	}
}