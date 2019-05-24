package day05;

public class TV {
	// 데이터(속성) + 기능(메소드)
	
	 String color;
	 int size;
	 boolean power;
	 int channel;
	 // 맴버 베리어블
	 
	 public void channelUp()
	 {
		 this.channel++;
	 }
	 public void channelDown()
	 {
		 this.channel--;
	 }
	 public void power()
	 {
		 this.power = !this.power;
	 }
	 public void print()
	 {
		 System.out.printf("TV[전원상태 %b, 현재채널 %d, 색상정보 %s] %n",
				 this.power, this.channel, this.color);
	 }
	
}
