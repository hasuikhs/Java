package day09;

public class Employee extends Object {
	// 변수 선언
	private String name;
	private String dept;
	// 생성자
	public Employee() {
		super();
	}
	public Employee(String name, String dept) {
		super();
		this.name = name;
		this.dept = dept;
	}
	// 변수 세팅
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", dept=" + dept + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dept == null) ? 0 : dept.hashCode());
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
		Employee other = (Employee) obj;
		if (dept == null) {
			if (other.dept != null)
				return false;
		} else if (!dept.equals(other.dept))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	/*
	@Override
	public boolean equals(Object obj) {
		boolean flag = false;
		if (obj != null && obj instanceof Employee) {
			Employee temp = (Employee) obj;
			if (name.equals(temp.name) && dept.equals(temp.dept)) {
				flag = true;
			}
		}
		return flag;
	}
	*/
}
