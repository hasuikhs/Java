package javaThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Exam09_ThreadCallable extends Application{
	
	TextArea textarea;
	Button initBtn, startBtn, stopBtn;
	// initBtn : Thread Pool을 생성하는 버튼
	// startBtn : Thread Pool을 이용해서 Thread를 실행시키는 버튼
	// stopBtn : Thread Pool을 종료하는 버튼
	ExecutorService executorService;
	// executorService : Thread Pool
	
	private void printMsg(String msg) {
		Platform.runLater(()->{
			textarea.appendText(msg + "\n");
		});
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// 화면 구성해서 window 띄우는 코드
		// 화면 기본 layout을 설정 => 화면을 동서남북중앙(5개 영역)으로 분리
		BorderPane root = new BorderPane();
		// BorderPane의 크기를 설정 => 화면에 띄우는 window의 크기설정
		root.setPrefSize(750, 500);
		
		// Component 생성해서 BorderPane에 부착
		textarea = new TextArea();
		root.setCenter(textarea);
		
		initBtn = new Button("Thread Pool 생성");
		initBtn.setPrefSize(250, 50);
		initBtn.setOnAction(t -> {
			executorService = Executors.newCachedThreadPool();
			int threadNum = ((ThreadPoolExecutor)executorService).getCorePoolSize();
			printMsg("현재 Pool 안의 Thread 개수 : " + threadNum);
			// 처음에 만들어지는 Thread Pool 안에는 thread 비존재
			// 만약 필요하면 내부적으로 Thread를 생성
			// 만드는 Thread의 수는 제한이 없음
			// 60초 동안 Thread가 사용되지 않으면 자동적으로 삭제

			// executorService = Executors.newFixedThreadPool(5);
			// 처음에 만들어지는 Thread Pool 안에는 thread 비존재
			// 만약 필요하면 내부적으로 Thread를 생성
			// 인자로 들어온 int 수 만큼의 Thread를 초과 불가
			// Thread가 사용되지 않더라도 만들어진 Thread는 계속 유지
		});
		
		stopBtn = new Button("Thread Pool 종료");
		stopBtn.setPrefSize(250, 50);
		stopBtn.setOnAction(t -> {
			executorService.shutdown();
		});
		
		startBtn = new Button("Thrad 실행!");
		startBtn.setPrefSize(250, 50);
		startBtn.setOnAction(t -> {
			// 버튼에서 Action이 발생(클릭)했을 때 호출!
			// Textarea에 글자를 넣자!
			for(int i = 0; i < 10; i++) {
				final int k = i;
				Callable<String> callable = new Callable<String>() {
					@Override
					public String call() throws Exception {
						Thread.currentThread().setName("MyThread-" + k);
						String msg = Thread.currentThread().getName() 
											+ " pool의 개수 " 
											+ ((ThreadPoolExecutor)executorService).getPoolSize();
						printMsg(msg);
						try {
							Thread.sleep(1000);
						}catch(Exception e) {
							e.printStackTrace();
						}
						return Thread.currentThread().getName() + "종료";
					}
				};
				
				Future<String> future = executorService.submit(callable);
				// future : pending 객체
				try {
					String result = future.get();
					// get() method가 blocking method..
					System.out.println(result);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (ExecutionException e) {
					e.printStackTrace();
				}
			}
		}); //"리스너 객체가 들어와야 함!"
		
		FlowPane flowpane = new FlowPane();
		flowpane.setPrefSize(750, 50);
		
		// flowpane에 버튼을 올림
		flowpane.getChildren().add(initBtn);
		flowpane.getChildren().add(startBtn);
		flowpane.getChildren().add(stopBtn);
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
