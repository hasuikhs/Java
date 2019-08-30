package javaNetwork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

class EchoRunnable implements Runnable{
	// 가지고 있어야 하는 field
	Socket socket;	// 클라이언트와 연결된 소켓
	BufferedReader br;	// 입력을 위한 스트림
	PrintWriter out;	// 출력을 위한 스트림
	
	public EchoRunnable(Socket socket) {
		super();
		this.socket = socket;
		try {
			this.br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			this.out = new PrintWriter(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// 클라이언트와 Echo 처리 구현
		// 클라이언트가 문자열을 보내면 해당 문자열을 받아서다시 클라이언트에게 전달
		// 한번하고 종료하는게 아니라 클라이언트가 "/EXIT"라는 문자열을 보낼때까지
		String line = "";
		try {
			while((line = br.readLine()) != null) {
				if(line.equals("/EXIT/")) {
					break; // 가장 근접한 loop를 탈출
				} else {
					out.println(line);
					out.flush();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

public class Exam03_EchoServerMultiClient extends Application{
	
	TextArea textarea;		   // 메시지창
	Button startBtn, stopBtn; // 서버시작, 서버중지 버튼
	
	// ThreadPool을 생성
	ExecutorService executorservice = Executors.newCachedThreadPool();
	
	// 클라이언트의 접속을 받아들이는 서버소켓
	ServerSocket server;
	
	private void printMsg(String msg) {
		Platform.runLater(()->{
			textarea.appendText(msg + "\n");
		});
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
	
		BorderPane root = new BorderPane();
		
		root.setPrefSize(700, 500);
		
		textarea = new TextArea();
		root.setCenter(textarea);
		
		startBtn = new Button("Echo 서버 시작");
		startBtn.setPrefSize(250, 50);
		startBtn.setOnAction(t -> {
			// 서버 프로그램을 시작
			// 클라이언트의 접속을 기다림 -> 접속이 되면 Thread를 하나 생성
			// -> Thread를 시작해서 클라이언트와 Thread가 통신하도록 만듦
			// -> 서버는 다시 다른 클라이언트의 접속을 기다림
			Runnable runnable = () -> {
				try {
					server = new ServerSocket(7777);
					printMsg("Echo 서버 기동!!");
					while(true) {
						printMsg("클라이언트 접속 대기");
						Socket s = server.accept();
						printMsg("클라이언트 접속 성공");
						// 클라이언트가 접속했의 Thread 만들고 시작해야 함
						EchoRunnable r = new EchoRunnable(s);
						executorservice.execute(r);	// Thread 실행
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			};
			executorservice.execute(runnable);
		});
		
		stopBtn = new Button("Echo 서버 종료");
		stopBtn.setPrefSize(250, 50);
		stopBtn.setOnAction(t -> {
			
		});
				
		FlowPane flowpane = new FlowPane();
		flowpane.setPrefSize(700, 50);
		
		flowpane.getChildren().add(startBtn);
		flowpane.getChildren().add(stopBtn);
		root.setBottom(flowpane);
		
		// Scene 객체가 필요
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("다중 클라이언트 Echo Server");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch();
	}
}
