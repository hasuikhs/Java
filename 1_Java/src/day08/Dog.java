package day08;

public class Dog extends Animal{
	String kind;
	String name;
	
	public Dog() {
		super("개");
		//super.kind = "강아지";
	}
	public Dog(String kind, String name) {
		super("개");
		this.kind = kind;
		this.name = name;
	}
	@Override
	public void breath() {
		System.out.println("폐로 숨쉬기");
	}
	
	public void print() {
		System.out.printf("동물[%s(%s), %s]%n", super.kind, this.kind, name);
	}
	@Override
	public String toString() {
		return "Dog [kind=" + kind + ", name=" + name + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((kind == null) ? 0 : kind.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Dog other = (Dog) obj;
		if (kind == null) {
			if (other.kind != null)
				return false;
		} else if (!kind.equals(other.kind))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}