package cantest;


import java.io.BufferedInputStream;
import java.io.OutputStream;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Exam01_DataFrameReceiver extends Application{
	TextArea textarea;	// �޽��� â(���� �޽����� �����ִ� ����)
	Button connBtn;		// �����ư(COM��Ʈ �����ư)
	
	// ����� COM ��Ʈ�� �����ϱ� ���ؼ� �ʿ�
	private CommPortIdentifier portIdentifier;	

	// ���� COM ��Ʈ�� ��� �����ϰ� �ش� ��Ʈ�� open�ϸ� COM ��Ʈ ��ü�� ȹ��
	private CommPort commPort;
	
	// COM ��Ʈ�� ������ 2����(Serial, Parallel �ΰ��� ����)
	// CAN ����� Serial ����� ��. ���� COM ��Ʈ�� Ÿ���� �˾Ƴ���
	// type casting�� ��Ŵ
	private SerialPort serialPort;
	// Port ��ü�κ��� Stream�� ���� ����� ����
	private BufferedInputStream bis;
	private OutputStream out;
	
	// inner class�������� eventó�� listener class�� �ۼ�
	class MyPortListener implements SerialPortEventListener{

		@Override
		public void serialEvent(SerialPortEvent event) {
			// Serial Port���� Event�� �߻��ϸ� ȣ��!
			if(event.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
				// port�� ���ؼ� �����Ͱ� ���Դٴ� �ǹ�
				byte[] readBuffer = new byte[128];
				try {
					while(bis.available() > 0) { // bis�� stream�� �����ϴ°�?
						bis.read(readBuffer);
					}
					String result = new String(readBuffer);
					printMsg("���� �޽����� : " + result);
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}
	}
	
	private void printMsg(String msg) {
		Platform.runLater(()->{
			textarea.appendText(msg + "\n");
		});
	}
	public static void main(String[] args) {		
		launch();
	}
	private void connectPort(String portName) {
		// portName�� �̿��� Port�� �����ؼ� ��ü�� ����
		try {
			portIdentifier = CommPortIdentifier.getPortIdentifier(portName);
			printMsg(portName + "�� ������ �õ��մϴ�.");
			
			if(portIdentifier.isCurrentlyOwned()) {
				printMsg(portName + "�� �ٸ� ���α׷��� ���ؼ� ���ǰ� �־��!");
			} else {
				// ��Ʈ�� �����ϰ� ���� ��� ����!
				// ��Ʈ�� ���� ��Ʈ ��ü�� ȹ��
				// ù��° ���ڴ� ��Ʈ�� ���� ���α׷��� �̸�(���ڿ�)
				// �ι�° ���ڴ� ��Ʈ�� ���� ��ٸ� �� �ִ� �ð�(�и�������)
				commPort = portIdentifier.open("MyApp", 5000);
				// ��Ʈ ��ü�� ���� �� �� ��Ʈ��ü�� Serial���� Parallel������
				// Ȯ���� �� �����ϰ� type casting
				if(commPort instanceof SerialPort) {
					// Serial Port ��ü�� �� �� �ִ�!
					serialPort = (SerialPort)commPort;
					// Serial Port�� ���� ������ �ؾ���!
					serialPort.setSerialPortParams(
							38400,	// Serial Port ��� �ӵ�
							SerialPort.DATABITS_8,	// ������ ��Ʈ
							serialPort.STOPBITS_1,	// stop bit ����
							serialPort.PARITY_NONE);	// Paraty bit�� �Ⱦ�

					// Serial Port�� Open�ϰ� �������� ��Ƴ��� ����
					// ������ ������ Data Frame�� �޾Ƶ��� �� �ִ� ����
					// Data Frame�� ���޵Ǵ� ���� �����ϱ� ���ؼ� Eventó�� ����� �̿�
					// �����Ͱ� ������ �� �����ϰ� ó���ϴ� Listener��ü�� �־�� ��
					// �̷� Listener��ü�� ����Port�� �����ʷ� ������ָ� ��!
					// �翬�� Listener��ü�� ����� ���� class�� �־�� ��!
					serialPort.addEventListener(new MyPortListener());
					serialPort.notifyOnDataAvailable(true);
					printMsg(portName + " �� �����ʰ� ��ϵǾ����ϴ�!");
					// ������� �ϱ� ���ؼ� Stream�� ���� �ȴ�!
					bis = new BufferedInputStream(serialPort.getInputStream());
					out = serialPort.getOutputStream();
					// CAN ������ ���� ��� ����
					// �� �۾��� ��� �ؾ� �ϳ�?
					// ���������� �̿��ؼ� ������ ���Ĵ�� ���ڿ��� ����
					// out stream�� ���ؼ� ���
					String msg =":G11A9\r";	// CANPro ��� �������� �޴��� 7p ����
					try {
						byte[] inputData = msg.getBytes();
						out.write(inputData);
						printMsg(portName + "�� ������ �����մϴ�.");
					} catch (Exception e) {
						System.out.println(e);
					}
				}
			}
		} catch (Exception e) {
			// �߻��� Exception�� ó���ϴ� �ڵ尡 ���;� ��
			System.out.println(e);
		}
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		root.setPrefSize(700, 500);

		textarea = new TextArea();
		root.setCenter(textarea);
		
		connBtn = new Button("COM ��Ʈ ����");
		connBtn.setPrefSize(250, 50);
		connBtn.setOnAction(t->{
			// ��ư���� Action�� �߻����� �� ȣ��
			String portName = "COM9";	// ��ġ�����ڿ��� ����� ��Ʈ ��ȣ Ȯ��
			// ��Ʈ ����
			connectPort(portName);
		});
		
		
		FlowPane flowpane = new FlowPane();
		flowpane.setPrefSize(700, 50);
		//flowpane�� ��ư �߰�
		flowpane.getChildren().add(connBtn);
		root.setBottom(flowpane);
		
		//Scene��ü�� �ʿ�
		Scene scene = new Scene(root); 
		primaryStage.setScene(scene);
		primaryStage.setTitle("CAN Data Frame Receiver ����");
		primaryStage.show();
	}
}