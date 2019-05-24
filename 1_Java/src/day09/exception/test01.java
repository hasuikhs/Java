package day09.exception;

import javax.swing.JOptionPane;

public class test01 {
	public static void main(String[] args) {
		System.out.println("start");
		String num = JOptionPane.showInputDialog("숫자를 입력하세요");
		try {
			System.out.println(1);
			System.out.println(4./Integer.parseInt(num));
			System.out.println(2);
		}catch(ArithmeticException e) {
			System.out.println(e.getMessage());
			System.out.println("0으로 나누면 안됨...");
		}catch (NumberFormatException e) {
			System.out.println(e.getMessage());
			System.out.println("문자는 안되요...");
		}catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			System.out.println(9);
		}	
		System.out.println("end");
	}
}
