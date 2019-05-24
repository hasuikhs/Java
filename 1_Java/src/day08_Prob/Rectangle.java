package day08_Prob;

public class Rectangle extends Shape{
	private double width;
	private double hight;
	
	public Rectangle() {
		super();
	}
	
	public Rectangle(String name, double width, double hight) {
		super(name);
		this.width = width;
		this.hight = hight;
	}

	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getHight() {
		return hight;
	}
	public void setHight(double hight) {
		this.hight = hight;
	}
	
	public void calculationArea() {
		 width = this.getWidth();
		 hight = this.getHight();
		 this.area = width * hight;	
	}
	
	public void print() {
		super.print();
		System.out.printf("%.1f%n", this.area);
	}
}
