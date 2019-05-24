package bookapp_v01;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class bookapp_01 {

	public static void main(String[] args) {
		List<Book> booklist = new ArrayList<Book>();
				
		Scanner keyboard = new Scanner(System.in);
		
		while(true) 
		{
			System.out.println("************************************");
			System.out.println("********* Book Application *********");
			System.out.println("************************************");
		
			System.out.println("원하는 메뉴 번호를 입력하세요... ");
			System.out.println("1. 입    력");
			System.out.println("2. 수    정");
			System.out.println("3. 삭    제");
			System.out.println("4. 검    색");
			System.out.println("5. 목록보기");
			System.out.println("6. 종    료");
		
			System.out.println("*************************************");
		
			String input = keyboard.nextLine();

			if(input == null || input.length() == 0)
			{
				input = "99";
			}
		
			System.out.println();
			
			switch (input.charAt(0)) 
			{
				case '1':
					System.out.println("입력 서비스");
					System.out.println("책 제목과 가격을 입력하세요.");
					System.out.println("입력 예) java/20000");
					
					String data = keyboard.nextLine();
					String[] bookdata = data.split("/");
					booklist.add(new Book(bookdata[0], Integer.parseInt(bookdata[1])));
					continue;
				
				case '2':
					System.out.println("수정 서비스");
					
					System.out.println("수정이 필요한 책 제목을 입력하세요.");
					String needfix = keyboard.nextLine();
					for (int i = 0; i < booklist.size(); i++) {
						if (booklist.get(i).getTitle().equalsIgnoreCase(needfix)) {
							System.out.println("해당 책의 제목과 가격을 입력하세요.");
							System.out.println("입력 예) java/20000");
							String fix = keyboard.nextLine();
							String[] temp = fix.split("/");
							booklist.get(i).setTitle(temp[0]);
							booklist.get(i).setPrice(Integer.parseInt(temp[1]));
							System.out.println("수정 되었습니다.");
						}
					}
					break;
			
				case '3':
					System.out.println("삭제 서비스");
					System.out.println("삭제 필요한 책 제목을 입력하세요.");
					String needremove = keyboard.nextLine();
					for (int i = 0; i < booklist.size(); i++) {
						if (booklist.get(i).getTitle().equalsIgnoreCase(needremove)) {
							booklist.remove(i);
							System.out.println("삭제 되었습니다.");
						}
					}
					
					break;
			
				case '4':
					System.out.println("검색 서비스");
					System.out.println("검색이 필요한 책 제목을 입력하세요.");
					String needsearch = keyboard.nextLine();
					for (int i = 0; i < booklist.size(); i++) {
						if (booklist.get(i).getTitle().equalsIgnoreCase(needsearch)) {
							System.out.println(booklist.get(i));
							System.out.println("검색 되었습니다.");
						}
					}
					break;
			
				case '5':
					System.out.println("목록보기 서비스");
					
					if (booklist.isEmpty()) {
						System.out.println("목록 존재 하지 않음");
						break;
					}else {
						System.out.println("====== 현재 책 목록 =====");
						booklist.forEach(i -> System.out.println(i));
					}
					break;
			
				case '6':
					System.out.println("Application을 종료합니다");
					System.exit(0);
				
				default:
					System.out.println("잘못입력하셨습니다");
					System.out.println("1 ~ 6 번호를 입력하세요");
					break;
			}
			
		}
	}
}
