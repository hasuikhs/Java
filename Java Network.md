## Java Network

- Java는 Socket이라는 개념을 토애서 Network 통신을 함
- Socket은 Network 부분의 끝. 실제 Data가 어떻게 전송되는지 상관하지 않고 읽기/쓰기 Interface를 제공
- Network 계층과 Transfer 계층이 캡슐화 되어 있기에 두개의 계층을 신경 쓰지 않고 Program 제작 가능
- Java는 이식성과 Cross Platform Network Program을 위해서 Socket을 핵심 library로 만듦
- TCP/IP 계층의 TCP를 지원하기 위해 Socket, ServerSocket class를 제공
- Client는 Socket Object를 생성하여 TCP Server와 연결을 시도
- Server는 SocketServer Object를 생성하여 TCP 연결을 받아 Client와 Server가 연결됨
- TCP Socket은 두개의 Network 사이에서 Byte Stream 통신을 제공
- Socket class는 Byte를 읽기 위한 method와 쓰기 위한 method를 제공
- 두 가지 method를 이용하여 Client와 Server간에 통신이 가능



- #### Date 예제

  - Server

    ```java
    public class DateServer{
        pulic static void main(String[] args){
            // 서버쪽 프로그램은 클라이언트의 소켓 접속을 대기
            ServerSocket server = null;
            
            // 클라이언트와 접속된 후 소켓 객체가 있어야 클라이언트와 통신이 가능
            Socket socket = null;
            
            try{
                // port 번호를 가지는 ServerSocktet 객체 생성
                server  new ServerSocket(5554);
                System.out.println("클라이언트 접속 대기");
                
                // 클라이언트 접속을 기다림
                socket = server.accept();
                // 만약 클라리언트가 접속해 오면 Socket객체를 하나 리턴
                PrintWriter out = new PrintWriter(socket.getOutputStream());
                SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");
                
                out.flush();
                out.close();
                socket.close();
                server.close();
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
    ```

  - Client

    ```java
    public class Exam01_DateClient extends Application{
    	
    	TextArea textarea;
    	Button btn;
    	
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
    		root.setPrefSize(700, 500);
    		
    		// Component 생성해서 BorderPane에 부착
    		textarea = new TextArea();
    		root.setCenter(textarea);
    		
    		btn = new Button("Date 서버 접속");
    		btn.setPrefSize(250, 50);
    		btn.setOnAction(t -> {
    			// 버튼에서 Action이 발생(클릭)했을 때 호출!
    			try {
    				// 클라이언트는 버튼을 누르면 서버쪽에 Socket 접속을 시도
    				Socket socket = new Socket("localhost", 5554);
    				
    				// 만약에 접속에 성공하면 socket 객체를 하나 획득
    				InputStreamReader isr = 
                        			new InputStreamReader(socket.getInputStream());
    				BufferedReader br = new BufferedReader(isr);
    				String msg = br.readLine();
    				printMsg(msg);
    				
    				br.close();
    				isr.close();
    				socket.close();
    			}catch(Exception e) {
    				System.out.println(e);
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