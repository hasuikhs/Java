package day07;

public class test01_car {
	public static void main(String[] args) {
		Car c1 = new Car();
		Car c2 = new Car("아반떼","black");
		Car c3 = new Car(c2);
		
		c1.print();
		c2.print();
		c3.print();
		
		c1 = null;
		c2 = null;
		c3 = null;
		
		Car c4 = new Car(c3);
		c4.print();
	}
}

class Car
{
	String kind;
	String color;
	
	public Car() {
	}

	public Car(String kind, String color) {
		this.kind = kind;
		this.color = color;
	}
	
	public Car(Car c) {
		if(c != null)
		{
			this.kind = c.kind;
			this.color = c.color;
		}
	}
	
	public void print() 
	{
		System.out.printf("Car[%s : %s]%n", kind, color);
	}
	
}