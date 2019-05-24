package day08_Prob;

import static java.lang.Math.PI;
public class Circle extends Shape{

	private double radius;

	public Circle() {
		super();
	}
	public Circle(String name, double radius) {
		super(name);
		this.radius = radius;
	}
	
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	@Override
	public void calculationArea() {
		radius = this.getRadius();
		area = radius * radius * PI;
	}

	public void print() {
		super.print();
		System.out.printf("%.13f%n", this.area);
	}
}
