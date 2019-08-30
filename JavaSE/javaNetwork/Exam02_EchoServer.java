package javaNetwork;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * Echo program을 작성해 보자
 * 클라이언트 프로그램으로부터 문자열을 네트워크를 통해 전달받아서
 * 다시 클라이언트에게 전달하는 echo 서버 프로그램
 * 현재는 단 1번만 echo가 동작하는데 클라이언트가 접속을 종료할때까지
 * echo작업이 지속적으로 동작하도록 프로그램을 수정!
 * 서버는 클라이언트가 종료되면 같이 종료되도록 수정
 * 
 * 지금 프로그램은 서버가 클라이언트 1명만 서비스 가능
 * 다수의 클라이언트를 서비스하려면 어떻게 해야하나
 * ==> Thread를 이용해서 이 문제를 해결
 */

public class Exam02_EchoServer {
	public static void main(String[] args) {
		ServerSocket server = null;
		Socket socket = null;
		String content;
		
		try {
			server = new ServerSocket(5557);
			System.out.println("서버프로그램 기동 - 5557");
			socket = server.accept();
			// stream 생성
			BufferedReader br = new BufferedReader(
						new InputStreamReader(socket.getInputStream()));

			PrintWriter out = new PrintWriter(socket.getOutputStream());
			// br로부터 데이터를 읽어서 out을 통해 다시 전달
			String msg = br.readLine();
			out.println(msg);
			out.flush();
			
			
			
			
			// 사용된 리소스를 해제
			out.close();
			br.close();
			socket.close();
			server.close();
			System.out.println("서버 프로그램 종료!");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
