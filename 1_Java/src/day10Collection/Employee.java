package day10Collection;

//public class Employee<T extends Number> { // <T> 제너릭 number의 타입은 추후 제공
public class Employee<P, T>{
	private P name;
	private T number;
		 
	 public Employee() {
		super();
	}

	public Employee(P name, T number) {
		super();
		this.name = name;
		this.number = number;
	}

	public P getName() {
		return name;
	}

	public void setName(P name) {
		this.name = name;
	}

	public T getNumber() {
		return number;
	}

	public void setNumber(T number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", number=" + number + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		return true;
	}
	
	
	
	 
}
