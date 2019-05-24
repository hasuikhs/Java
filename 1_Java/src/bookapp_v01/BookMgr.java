package bookapp_v01;

class BookMgr{
	private Book[] booklist; // 여러권의 책 정보를 기억할 배열을 선언, 크기 고려 X
	private int size; // 배열의 크기
	private int count; // 배열에 저장된 데이터의 수
	
	public BookMgr() {// 기본 생성자
		this.size = 0;
		this.count = 0;
		this.booklist = new Book[10];
	} 
	public BookMgr(int size) // 인자에 따른 생성자 메소드
	{
		this.size = size;
		this.count = 0;
		this.booklist = new Book[size];
	}
	public Book[] getBookList()
	{
		return booklist;
	}
	
	public void addBook(Book book) // Book객체를 list에 추가
	{ 
		
		for (int j = 0; j < booklist.length; j++) { 
			if(booklist[j] == null){ // j번재 booklist가 비어있다면
				booklist[j] = book; // j번째에 현재 book을 넣는다
				break;
			}else if (booklist[j].equals(book)) { // booklist의 j번째 book이 현재 book과 같다면 멈춘다
				break;
			}
		}
	}
		
	
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public void printBookList() // list를 화면에 출력
	{
		System.out.println("================ 책 목록 ================");
		for(int i = 0; i < this.booklist.length; i++)
		{
			if(booklist[i] != null)
				System.out.printf("제목 : %20s 가격 : %6d%n",booklist[i].getTitle(),booklist[i].getPrice());
		}
	}
	public void printTotalPrice() // 모든 책 가격의 합을 출력
	{
		int sum = 0;
		System.out.println("============== 책 가격의 합 ==============");
		for(int i =0; i < this.booklist.length; i++)
		{
			if(booklist[i] != null)
				sum += booklist[i].getPrice();
		}
		System.out.printf("%41d%n",sum);
	}
}