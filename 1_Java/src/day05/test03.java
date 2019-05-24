package day05;

public class test03 {

	public static void main(String[] args) {
		
		Time t1 = new Time();
		t1.setHour(10);
		t1.getHour();
		
		t1.setSecond(70);
		t1.getSecond();
		t1.print();

	}

}

class Time
{
	private int hour;
	private int second;
	private boolean am;
	
	public boolean isAm() {
		return hour < 12;
	}
	public void setAm(boolean am) {
		this.am = am;
	}
	
	// 시간
	public void setHour(int hour)
	{
		if (hour >= 0 && hour <= 24)
		{
			if (hour > 12)
			{
				hour = hour - 12;
				this.hour = hour;
			}
			else
			{
				this.hour = hour;
			}
			
		}
	}
	public int getHour()
	{
		return hour;
	}
	
	// 초
	public void setSecond(int s)
	{
		if (s >= 0 && s <= 60)
		{
			this.second = s;					
		}
		else
		{
			this.second = 0;
		}
	}
	public int getSecond()
	{
		return second;
	}
	
	public void print()
	{
		System.out.printf("[%2d시 %2d분] %n", this.hour, this.second);
	}
}