package day11.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class test02 {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		String filename = "c://lib/ben.mp3";
		
		int count = 0;
		int read = 0;
		
		
		try {
			fis  = new FileInputStream(filename);
			fos = new FileOutputStream("c://lib/copy.mp3");
			System.out.println(" *** 파일 복사 시작 *** ");

			byte[] buffer = new byte[fis.available()]; //available 파일의 사이즈의 버퍼를 생성
			
			while( (read = fis.read(buffer)) != -1) {
				fos.write(buffer);
				count++;
			}
			System.out.println("IO 횟수 : " + count);
			System.out.println(" *** 파일 복사 완료 *** ");
			
			
		} catch (FileNotFoundException e) {
			System.out.println("복사할 파일을 준비해주세요");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (fis != null) fis.close();
				if (fos != null) fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
}
