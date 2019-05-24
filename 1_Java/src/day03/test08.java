package day03;

public class test08 {

	public static void main(String[] args) {
		
		String msg = "hello java test !!!";
		String msg2 = "";
		StringBuilder sb = new StringBuilder();
		System.out.println(msg);
		for (int i = 0; i < msg.length(); i++ ) {
			if (msg.charAt(i) >= 'a' && msg.charAt(i) <= 'z')
				sb.append((char) (msg.charAt(i)-32));
			else
				sb.append((char) (msg.charAt(i)));
		}
		
		msg2 = sb.toString();
		System.out.println(msg2);
		
		
	}

}
