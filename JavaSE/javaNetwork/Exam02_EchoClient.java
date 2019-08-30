package javaNetwork;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Exam02_EchoClient extends Application{
	
	TextArea textarea;
	Button btn;
	TextField tf;
	Socket socket;
	BufferedReader br;
	PrintWriter out;
	
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
		
		btn = new Button("Date 서버 접속");
		btn.setPrefSize(250, 50);
		btn.setOnAction(t -> {
			try {
				socket = new Socket("localhost", 5557);
				// Stream을 생성
				InputStreamReader isr = new InputStreamReader(socket.getInputStream());
				br = new BufferedReader(isr);
				
				out = new PrintWriter(socket.getOutputStream());
				
				
	
				
			} catch(Exception e){
				System.out.println(e);
			}
		});
		
		tf = new TextField();
		tf.setPrefSize(200, 40);
		tf.setOnAction(t->{
			// 입력상자(TextField)에서 enter key가 입력되면 호출
			String msg = tf.getText();
			out.println(msg);	// 서버로 문자열 전송!
			out.flush();
			try {
				String result = br.readLine();
				printMsg(result);
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		FlowPane flowpane = new FlowPane();
		flowpane.setPrefSize(700, 50);
		
		flowpane.getChildren().add(btn);
		flowpane.getChildren().add(tf);
		root.setBottom(flowpane);
		
		// Scene 객체가 필요
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Thread 예제입니다!");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch();
	}
}
