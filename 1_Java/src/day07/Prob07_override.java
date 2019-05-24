package day07;

public class Prob07_override {

	public static void main(String[] args) {
		Student s1 = new Student("홍길동",20,200201);
		Teacher s2 = new Teacher("이순신",30,"JAVA");
		Employee s3 = new Employee("유관순",40,"교무과");
		
		s1.print();
		s2.print();
		s3.print();
		
		Person p1 = new Student("홍동",20,200201);
		Person p2 = new Teacher("이신",30,"JAVA");
		Person p3 = new Employee("유순",40,"교무과");
		// 기존 ((Student)p1).print(); 해야하지만 다운캐스팅은
		// instanceof가 필요하기 때문에 오버라이딩을 유도
		p1.print(); 
		p2.print();
		p3.print();
		
		Prob07_override.personPrint(s3);
		personPrint(p3);
		System.out.println("Person 배열");
		Person[] p = {new Employee ("길동",40,"행정실"), 
				new Teacher("고길동",45,"자바"), new Student("최길녀",21,201911),
				new Employee ("길말동",40,"행정실"), 	new Teacher("고길동",45,"C"), 
				new Student("최말녀",21,201912)};
		
		for (int i = 0; i < p.length; i++)
		{
			p[i].print();
			
		}
		System.out.println("Person 배열에서 학생 객체만 뽑는데 학번, 이름 출력");
		
		// 배열의 사람들 중에서 학생 객체만 뽑아서 이름만을 출력하자
		for (Person data:p) // for(int i =0; i <p.length;i++)
		{
			if(data instanceof Student) // if (p[i] instanceof Student)
			{
				System.out.print( ((Student)data).getId() + " "); 
				// id는 student 자식클래스의 멤버변수 이므로 다운캐스팅해서 getid 호출
				System.out.println(data.getName()); // system.out.println(p[i].getName());
			}	
		}	
	}
	/*
	public static void personPrint(Employee e) {
		e.print();
	}
	public static void personPrint(Student s) {
		s.print();
	}
	public static void personPrint(Teacher t) {
		t.print();
	}
	*/
	public static void personPrint(Person p) {
		p.print();
	}

}

class Person{
	private String name ;
	private int age ;
	
	Person(){}
	Person(String name, int age){
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	} 
	
	public void print() { // 오버라이딩
		System.out.printf("[이    름 : %s  나이 : %d",name,age);
	}
}

class Student extends Person{
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Student() { // 기본 생성자
		super();
	}

	public Student(String name, int age, int id) { // 인자 생성자
		super(name, age);
		this.id = id;
	}
	
	public void print() {
		System.out.printf("[이    름 : %s  나이 : %d 학    번 : %d]%n",super.getName(),super.getAge(),this.id );
	}
	
}

class Teacher extends Person{
	private String subject; 
	
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Teacher() {
		super();
	}
	
	public Teacher(String name, int age, String subject) {
		super(name, age);
		this.subject = subject;
	}
	
public void print() {
	System.out.printf("[이    름 : %s  나이 : %d 담당과목 : %6s]%n",super.getName(),super.getAge(),this.subject);
	}
	
}

class Employee extends Person{
	private String dept;
	
	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public Employee() {
		super();
	}

	public Employee(String name, int age, String dept) {
		super(name, age);
		this.dept = dept;
	}
	
public void print() {
	super.print();
	System.out.printf(" 부    서 : %s]%n", dept );
	}
	
}