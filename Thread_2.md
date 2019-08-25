## Thread_2

1. #### Thread Race

   ```java
   class UserPanel extends FlowPane{
   	private TextField nameField = new TextField();
   	private ProgressBar progressBar = new ProgressBar(0.0);
   	private ProgressIndicator progressIndicator =
   			new ProgressIndicator(0.0);
   	public UserPanel() {}
   	
   	public UserPanel(String name) {
   		// 전체 사이즈
   		this.setPrefSize(700, 50);
   		// 각 구성의 사이즈
   		nameField.setText(name);
   		nameField.setPrefSize(100, 50);
   		progressBar.setPrefSize(500, 50);
   		progressIndicator.setPrefSize(50, 50);
   		
   		getChildren().add(nameField);
   		getChildren().add(progressBar);
   		getChildren().add(progressIndicator);
   	}
   
   	// getter & setter
       ...
   }
   ```

   ```java
   class ProgressRunnable implements Runnable{
   	private TextField name;
   	private ProgressBar progressBar;
   	private ProgressIndicator progressIndicator;
   	private TextArea textarea;
   	
   	public ProgressRunnable(TextField textField, ProgressBar progressBar, ProgressIndicator progressIndicator,
   			TextArea textarea) {
   		super();
   		this.name = textField;
   		this.progressBar = progressBar;
   		this.progressIndicator = progressIndicator;
   		this.textarea = textarea;
   	}
   
   	@Override
   	public void run() {
   		// Thread가 동작해서 progressBar를 제어하면 될 것
   		Random random = new Random();
   		double k = 0;
   		
   		while(progressBar.getProgress() < 1.0) {
   			try {
   				Thread.sleep(100); // 1초 동안 현재 Thread를 sleep
   				k += (random.nextDouble() * 0.1);
   				final double tt = k;
   				// k값이 지속적으로 증가
   				Platform.runLater(()->{
   					progressBar.setProgress(tt);
   					progressIndicator.setProgress(tt);
   				});
   				if ( k > 1.0 ) break;
   			}catch(Exception e) {
   				System.out.println(e);
   			}
   		}
   	}
   }
   ```

   ```java
   public class Exam02_ThreadRace extends Application{
   	
   	private List<String> names = Arrays.asList("홍길동", "이순신", "강감찬");
   	
   	// progressBar를 제어할 Thread가 FlowPane 1개당 1개씩 존재해야함
   	private List<ProgressRunnable> uRunnable = new ArrayList<ProgressRunnable>();
   	
   	TextArea textarea;
   	Button btn;
   	
   	@Override
   	public void start(Stage primaryStage) throws Exception {
   		// 화면 구성해서 window 띄우는 코드
   		// 화면 기본 layout을 설정 => 화면을 동서남북중앙(5개 영역)으로 분리
   		BorderPane root = new BorderPane();
   		// BorderPane의 크기를 설정 => 화면에 띄우는 window의 크기설정
   		root.setPrefSize(700, 500);
   		
   		// center 부분을 차지할 TilePane을 생성
   		TilePane center = new TilePane();
   		center.setPrefColumns(1); // 1열만 존재하는 TilePane
   		center.setPrefRows(4); // 4행이 존재하는 TilePane
   		
   		// 메시지가 출력될 TextArea 생성 및 크기 결정
   		textarea = new TextArea();
   		textarea.setPrefSize(600, 100);
   		
   		// 이제 만들어진 TilePane에 3개의 FlowPane과 TextArea를 부착
   		for(String name : names) {
   			UserPanel panel = new UserPanel(name);
   			center.getChildren().add(panel);
   			uRunnable.add(
   					new ProgressRunnable(panel.getNameField(),
   										 panel.getProgressBar(),
   										 panel.getProgressIndicator(),
   										 textarea));
   		}
   		center.getChildren().add(textarea);
   		root.setCenter(center);
   		
   		btn = new Button("버튼 클릭!");
   		btn.setPrefSize(250, 50);
   		btn.setOnAction(t -> {
   			// 버튼에서 Action이 발생(클릭)했을 때 호출!
   			// uRunnable(ArrayList)를 돌면서 Thread를 생성하고
   			// start() 호출
   			for(ProgressRunnable runnable : uRunnable) {
   				new Thread(runnable).start();
   			}
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

2. #### Thread Sleep

   ```java
   public class Exam03_ThreadSleep extends Application{
   	
   	TextArea textarea;
   	Button btn;
   	
   	private void printMsg(String msg) {
   		Platform.runLater(() -> {
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
   		
   		btn = new Button("버튼 클릭!");
   		btn.setPrefSize(250, 50);
   		btn.setOnAction(t -> {
   			// 버튼에서 Action이 발생(클릭)했을 때 호출!
   			// 1부터 5까지 5번 반복 => for문 이용
   			IntStream intStream = IntStream.rangeClosed(1, 5);
   			intStream.forEach(value -> {
   				// 1부터 5까지 5번 반복하면서 Thread 생성
   				Thread thread = new Thread(() -> {
   					for(int i = 0; i < 5; i++) {
   						try {
   							Thread.sleep(3000);
   							printMsg(i + " : " + Thread.currentThread().getName());
   						} catch (Exception e) {
   							System.out.println(e);
   						}
   					}
   				});
   				thread.setName("ThreadNumber" + value);
   				thread.start(); // runnable 상태로 대기
   			});
   		}); //"리스너 객체가 들어와야 함!"
   		
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

3. #### Thread Sync

   - 2개의 Thread를 파생시켜서 공용객체를 이용하도록 만들어 보자!

      Thread가 공용객체를 동기화해서 사용하는 경우와 그렇지 않은 경우를 비교해서 이해보자!

   ```java
   class SharedObject{
   	private int number; // 공용객체가 가지는 field
   
   	// getter & setter (Thread에 의해서 사용)
   	public int getNumber() {
   		return number;
   	}
   
   	public void setNumber(int number) {
   		this.number = number;
   	}
   	
   	// Thread에 의해서 사용이 되는 business method
   	// synchronized keyword로 동기화를 할 수 있음
   	// method 동기화는 효율이 좋지 않음
   	// 동기화 block을 이용해서 처리하는 것이 일반적
   	public void assignNumber(int number) {
   		// 동기화 block
   		// 첫 thread가 실행되다가 잠이 들면 다음 thread가 오지만
   		// 다음 thread가 봤을때 같은 이름의 객체? 가 있어 대기한다
   		// 첫 thread가 잠에서 깨고 코드를 수행하고
   		// 대기 중인 thread가 코드를 수행한다 
   		synchronized (this) {
   			this.number = number;
   			try {
   				Thread.sleep(3000);
   				System.out.println("현재 공용객체의 number : " + this.number);
   			} catch (InterruptedException e) {
   				e.printStackTrace();
   			}
   		}
   	}
   }
   ```

   ```java
   // Runnable interface를 구현한 class(Thread 생성자의 인자로 이용하기 위해)
   class MyRunnable implements Runnable{
   	
   	SharedObject shared;
   	int input;
   	
   	public MyRunnable(SharedObject shared, int input) {
   		this.shared = shared;
   		this.input = input;
   	}
   	
   	@Override
   	public void run() {
   		shared.assignNumber(input);
   	}
   }
   public class Exam04_ThreadSync {
   	public static void main(String[] args) {
   		// 공용객체를 하나 생성
   		SharedObject shared = new SharedObject();
   		
   		// Thread를 생성(2개) - 공용객체를 가지는 Thread를 생성
   		Thread t1 = new Thread(new MyRunnable(shared, 100));
   		Thread t2 = new Thread(new MyRunnable(shared, 200));
   		
   		// Thread 실행(runnable 상태로 전환)
   		t1.start();
   		t2.start();
   	}
   }
   ```

4. #### Thread Notify

   ```java
    class MyShared{
   	 
   	 // method 호출할 때 Thread가 번갈아 가면서 호출하도록 만들어 보자!
   	public synchronized void printNum() {
   		for(int i = 0; i < 10; i++) {
   			try {
   				Thread.sleep(1000);
   				System.out.println(Thread.currentThread().getName() + " : " +  i);
   				notify(); // 현재 wait() 상태에 있는 Thread를깨워서
   						  // runnable 상태로 전환
   				wait();	  // 자기가 가지고 있는 monitor객체를 놓고
   						  // 스스로 wait block에 들어감
   			} catch (InterruptedException e) {
   				e.printStackTrace();
   			}
   		}
   	}
   }
   
   class Exam05_Runnable implements Runnable{
   	
   	MyShared obj;
   		
   	public Exam05_Runnable(MyShared obj) {
   		this.obj = obj;
   	}
   
   	@Override
   	public void run() {
   		obj.printNum();
   	}
   }
   
   public class Exam05_ThreadNotify {
   	public static void main(String[] args) {
   		
   		// 공용 객체 생성
   		MyShared shared = new MyShared();
   		
   		// Thread를 생성하면서 공용객체를 넣음
   		Thread t1 = new Thread(new Exam05_Runnable(shared));
   		Thread t2 = new Thread(new Exam05_Runnable(shared));
   		
   		t1.start();
   		t2.start();
   	}
   }
   ```

   