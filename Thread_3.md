## Thread_3

1. #### Thread Interrupt

   ```java
   public class Exam06_ThreadInterrupt extends Application{
   	
   	TextArea textarea;
   	Button startBtn, stopBtn;
   	Thread counterThread;
   	
   	private void printMsg(String msg) {
   		// textarea에 문자열 출력하는 method
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
   		root.setPrefSize(700, 500);
   		
   		// Component 생성해서 BorderPane에 부착
   		textarea = new TextArea();
   		root.setCenter(textarea);
   		
   		startBtn = new Button("Thread 시작");
   		startBtn.setPrefSize(250, 50);
   		startBtn.setOnAction(t -> {
   			// 버튼에서 Action이 발생(클릭)했을 때 호출!
   			counterThread = new Thread(()-> {
   				try {
   					for(int i = 0; i < 10; i++) {
   						Thread.sleep(1000);
   						printMsg(i + "-" + Thread.currentThread().getName());
   						
   					}
   				} catch (Exception e) {
   					// 만약 interrupt()가 걸려있는 상태에서 block상태로 진입하면
   					// Exception을 내면서 catch문으로 이동
   					printMsg("Thread가 종료!");
   					
   				}
   			});
   			counterThread.start();
   		});
   		
   		stopBtn = new Button("Thread 중지");
   		stopBtn.setPrefSize(250, 50);
   		stopBtn.setOnAction(t -> {
   			// 버튼에서 Action이 발생(클릭)했을 때 호출!
   			counterThread.interrupt(); 	// method가 실행된다고 바로
   										// Thread가 종료되지 않는다
   			// interrupt() method가 호출된 Thread는 sleep()과 같이
   			// block 상태에 들어가야지 interrupt가 가능
   		});
   		
   		FlowPane flowpane = new FlowPane();
   		flowpane.setPrefSize(700, 50);
   		
   		// flowpane에 버튼을 올림
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
   ```

2. #### Thread Daemon

   ```java
   public class Exam07_ThreadDaemon extends Application{
   	
   	TextArea textarea;
   	Button btn;
   	
   	@Override
   	public void start(Stage primaryStage) throws Exception {
   		// 화면 구성해서 window 띄우는 코드
   		// 화면 기본 layout을 설정 => 화면을 동서남북중앙(5개 영역)으로 분리
   		BorderPane root = new BorderPane();
   		// BorderPane의 크기를 설정 => 화면에 띄우는 window의 크기설정
   		root.setPrefSize(700, 500);
   		
   		// Component 생성해서 BorderPane에 부착
   		textarea = new TextArea();
   		root.setCenter(textarea);
   		
   		btn = new Button("버튼 클릭!");
   		btn.setPrefSize(250, 50);
   		btn.setOnAction(t -> {
   			// 버튼에서 Action이 발생(클릭)했을 때 호출!
   			// Thread를 생성(for loop를 1초 sleep하면서 10번 반복)
   			// 이 Thread는 dead 상태로 가기 위해서는 10초가 걸림
   			Thread thread = new Thread(()-> {
   				try {
   					for(int i = 0; i < 10; i++) {
   						Thread.sleep(1000);
   					}
   				} catch (Exception e) {
   					System.out.println(e);
   				}
   			});
   			thread.setDaemon(true); // 해당 Thread를 daemon thread로 설정
   			// 자식 thread가 된다고 생각하면 된다
   			// 부모 thread가 중지되면 자동적으로 자식 thread도 중지
   			thread.start();
   		});
   		
   		FlowPane flowpane = new FlowPane();
   		flowpane.setPrefSize(700, 50);
   		
   		// flowpane에 버튼을 올림
   		flowpane.getChildren().add(btn);
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
   ```

3. #### Thread Pool Basic

   ```java
   public class Exam08_ThreadPoolBasic extends Application{
   	
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
   				Runnable runnable = () ->{
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
   				};
   				executorService.execute(runnable);
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
   ```

4. #### Thread Callable

   ```java
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
   ```

5. #### Thread Complete Service

   ```java
   /*
    * 1부터 100까지 숫자의 합을 구해보자
    * 1~10까지 1개의 Thread가 합을 계산해서 결과를 return
    * 11~20까지 1개의 Thread가 합을 계산해서 결과를 return
    * ...
    * 91~100까지 1개의 Thread가 합을 계산해서 결과를 return
    * ==> Thread Pool을 이용해야 하고 Callable을 이용해서 리턴값을 받아야함
    * ==> 10개의 Thread로부터 각각 데이터를 받아들이는 Thread를 하나 만들어야 함
    */
   public class Exam10_ThreadCompleteService extends Application{
   	
   	TextArea textarea;
   	Button initBtn, startBtn, stopBtn;
   	// initBtn : Thread Pool을 생성하는 버튼
   	// startBtn : Thread Pool을 이용해서 Thread를 실행시키는 버튼
   	// stopBtn : Thread Pool을 종료하는 버튼
   	
   	ExecutorService executorService;
   	// executorService : Thread Pool
   	
   	ExecutorCompletionService<Integer> executorCompletionService;
   	private int total = 0;
   	
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
   			executorCompletionService = 
   					new ExecutorCompletionService<Integer>(executorService);
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
   			for(int i = 1; i < 101; i+=10) {
   				final int k = i;
   				Callable<Integer> callable = new Callable<Integer>() {
   					@Override
   					public Integer call() throws Exception {
   						IntStream intStream = IntStream.rangeClosed(k, k+9);
   						int sum = intStream.sum();
   						return sum;
   					}
   				};
   				executorCompletionService.submit(callable);
   			}
   			Runnable runnable = new Runnable() {
   				@Override
   				public void run() {
   					for(int i = 0; i < 10; i++) {
   						try {
   							Future<Integer> future = executorCompletionService.take();
   							total += future.get();
   						} catch (Exception e) {
   							e.printStackTrace();
   						}
   					}
   					printMsg("최종 결과값은 : " + total);
   				}
   			};
   			executorService.execute(runnable);
   		});
   		
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
   ```

