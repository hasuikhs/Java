package day09;

import java.util.Calendar;

import javax.swing.JOptionPane;

public class test02_Command {
	public static void main(String[] args) {
		Command cmd = null;
		String msg = JOptionPane.showInputDialog("수행할 명령을 입력하세요.create,list,delete,update");
	
		switch(msg.trim().toLowerCase()) {
			case "delete" :
				cmd = new DeleteCommand();
				break;
			case "list" :
				cmd = new ListCommand();
				break;
			case "update" :
				cmd = new UpdateCommand();
				break;
			case "create" :
				cmd = new CreateCommand();
				break;
			default :
				System.out.println("다시 입력하세요.");
		}
		if (cmd != null) {
			cmd.exec();
			cmd.process();
		}
		
		Calendar c = Calendar.getInstance();
		
	}
}
