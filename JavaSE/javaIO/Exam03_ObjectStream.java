package javaIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class Exam03_ObjectStream {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("1", "홍길동");
		map.put("2", "강감찬");
		map.put("3", "신사임당");
		map.put("4", "최길동");
		
		// 일단 객체가 저장될 File에 대한 File객체부터 만들자
		// 해당 파일이 존재하는지 않은지는 상관이 없다
		File file = new File("asset/objectStream.txt");
		
		// 객체가 저장될 File에 outputStream부터 열자
		try {
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(map);
			// 1. 내보내려고 하는 map 객체를 마샹링 작업을 통해서 형태를 변환
			//    마샬링 : 객체를 문자열로 표현하기 위해서하는변환작업
			// 저장하는 코드이다 보니.. close를 제대로 해줘야 함
			oos.close();
			fos.close();
			
			// 객체가 저장된 파일을 open해서 해당 객체를 프로그램으로 읽어들임
			// 파일에서 데이터를 읽기위해 inputstream이 필요
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			Object obj = ois.readObject();
			// 문자열로 표현된 객체를 읽어들여서 원래 객체로 복원
			// 언마샬링
			
			HashMap<String, String> result = null;
			if(obj instanceof Map<?, ?>) {
				result = (HashMap<String, String>)obj;
			}
			System.out.println(result.get("3"));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
