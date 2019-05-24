package day06;

public class bookmgr_ArrResizing {
	private Book[] bookList;
	int count  = 0;
	
	public bookmgr_ArrResizing() {
		bookList = new Book[3];
	}

	public void addBook(Book book) {
		if(count == bookList.length) // 리사이징
		{
			Book[] temp = new Book[bookList.length*2];
			System.arraycopy(bookList, 0, temp, 0, bookList.length);
			bookList = temp;
		}
		bookList[count] = book;
		count++;
	}
	
	public void printBookList() {
		System.out.println("===== 책 목록 =====");
		for(int i = 0; i < count; i++) {
			System.out.println(bookList[i].getTitle());
		}
	}
	
	public void printTotalPrice() {
		int sum = 0;
		System.out.println("=== 모든 책 가격의 합계 ===");
		for(int i = 0; i < count; i++) {
			sum += bookList[i].getPrice();
		}
		System.out.println(sum);
	}
	
}
