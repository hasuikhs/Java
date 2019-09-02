package javaNetwork;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Exam01_DateServer {
	public static void main(String[] args) {
		// 서버쪽 프로그램은 클라이언트의 소켓 접속을 기다려야 함
		// ServerSocket class를 이용해서 기능을 구현
		ServerSocket server = null;
		
		// 클라이언트와 접속된 후 Socket 객체가 있어야지 클라이언트와
		// 데이터 통신이 가능
		Socket socket = null;
		
		try {
			// port 번호를 가지고 ServerSocket 객체를 생성
			// port 번호는 0~65535 사용 가능. 0~1023까지는 예약이므로 비권장
			server = new ServerSocket(5554);
			System.out.println("클라이언트 접속 대기");
			socket = server.accept();	// 클라이언트 접속을 기다림!(block)
			// 만약 클라이언트가 접속해 오면 Socket객체를 하나 리턴
			// 이클립스에서 구동시 서버쪽 코드를 먼저 실행시킨 후
			// 클라이언트 코드를 실행시킨다
			// 서버쪽의 서버시작을 누르고 클라이언트의 서버접속을 한 후 텍스트를 전송!
			
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd"); 
			out.println(format.format(new Date()));
			
			// 일반적으로 Reader와 Writer는 내부 buffer를 가지고 있음
			out.flush();	// 명시적으로 내부 buffer를 비우고 데이터를 전달 명령
			out.close();
			socket.close();
			server.close();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
