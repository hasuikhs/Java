package day08;

public class test04_Circle {
	public static void main(String[] args) {
		Circle c = new Circle();
		Rectangle r = new Rectangle();
		
		Drawable d = c ;
		d.draw();
		
		Movable m = c;
		m.move();
		
		MovableAndDrawable[] md = {c, r};
		md[0].draw();
		md[1].move();
	}
}
