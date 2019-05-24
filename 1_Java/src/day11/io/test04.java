package day11.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class test04 {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		String filename = "c://lib/ben.mp3";
		
		int count = 0;
		int read = 0;
		
		
		try {
			fis  = new FileInputStream(filename);
			fos = new FileOutputStream("c://lib/copy.mp3",false); // true : 덧씌우기, false : 덮어쓰기
			
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			
			System.out.println(" *** 파일 복사 시작 *** ");
			
			while( (read = bis.read()) != -1) {
				bos.write(read);
				count++;
			}
			bos.flush(); // 버퍼 비우기
			System.out.println("IO 횟수 : " + count);
			System.out.println(" *** 파일 복사 완료 *** ");
			
			
		} catch (FileNotFoundException e) {
			System.out.println("복사할 파일을 준비해주세요");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (bis != null) bis.close();
				if (bos != null) bos.close();
				
				if (fis != null) fis.close();
				if (fos != null) fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
}
