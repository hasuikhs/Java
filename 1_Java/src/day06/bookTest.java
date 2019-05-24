package day06;

import javax.swing.JOptionPane;

public class bookTest {

	public static void main(String[] args) {
		
		bookmgr_ArrResizing mgr = new bookmgr_ArrResizing();
		String data = JOptionPane.showInputDialog("이름을 입력해 주세요 !");
		
		mgr.addBook(new Book("java1", 600));
		mgr.addBook(new Book("java2", 600));
		mgr.addBook(new Book("java3", 600));
		mgr.addBook(new Book("java4", 600));
		mgr.addBook(new Book("java5", 600));
		
		mgr.printBookList();
		mgr.printTotalPrice();
	}
}
