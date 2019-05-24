package day05;

import javax.swing.JOptionPane;
public class test01 {

	public static void main(String[] args) {
		
		String data = JOptionPane.showInputDialog("이름을 입력해 주세요 !");
		
		System.out.println(data);
		
		String jumsu = 
				JOptionPane.showInputDialog
				("국/영/수 점수를 입력해 주세요(90/90/90) !");
		
		System.out.println(jumsu);

		int sum = 0;
		for(int i = 0; i < jumsu.split("/").length; i++)
		{
			sum += Integer.parseInt(jumsu.split("/")[i]);
		}
		System.out.println("평균 = " + sum/jumsu.split("/").length);

	}

}
