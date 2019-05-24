package day10Collection;

import java.util.Arrays;

public class Prob10{
	public static void main(String[] args) {
		MyStack stack = new MyStack(10);
		if(stack.isEmpty()){
			System.out.println("스택이 비어있습니다.");
		}
		
		for (int i = 1; i <= 10; i++) {
			stack.push(i);
		}
		
		if(stack.isFull()){
			System.out.println("스택이 가득 찼습니다.");
		}
		
		System.out.println("최상위 숫자 : " + stack.top());
		System.out.println("최상위에서 꺼낸 숫자 : " + stack.pop());
		System.out.println("최상위에서 꺼낸 숫자 : " + stack.pop());
		System.out.println("");
		System.out.println("== 스택 리스트 ==");
		for (int i = 1; i <= 10; i++) {
			int num = stack.pop();
			if(num != -1)
				System.out.println(num);
		}
	}
}
/*
class MyStack{
	int[] st;
	int count = 0;
	
	public MyStack() {
		st = new int[10];
	}
	public MyStack(int size) {
		st = new int[size > 0 ? size : 10];
	}
	
	public boolean isFull() {
		return count == st.length ? true : false;
	}
	public boolean isEmpty() {
		return count == 0 ? true : false;
	}
	
	public void push(int i) {
		if(!isFull()) {
			st[count++]=i;
		}
	}
	public int pop() {
		int data = -1;
		if (count != 0) {
			data = st[count-1];
			st[count-1] = 0;
			count--;
		}
		return data;
	}

	public int top() {
		return count == 0 ? -1:st[count-1];
	}
}
*/

class MyStack{
	// 구현하시오.
	private int[] arr;
	private int count;
	private int size;
	
	public MyStack() {
		super();
		this.arr = new int[10];
	}

	public MyStack(int size) {
		super();
		this.size = size;
		if (size > 0 ) {
			this.arr = new int[size];
		}
		else {
			this.arr = new int[10];
		}
	}
	
	public void push(int size) {
		this.arr[count++] = size;
	}
	
	public boolean isEmpty() {
		return !this.arr.equals(0);
	}
	
	public boolean isFull() {
		return !this.arr.equals(arr.length);
	}
	
	public int top() {
		int temp = 0;
		if(this.arr[arr.length-1] != 0) {
			temp = this.arr[arr.length-1];
		}
		return temp;
	}
	
	public int pop() {
		int temp = -1;
		
		if (count != 0) {
			int[] t = new int[count--];
			temp = arr[count];
			try {
				for (int i =0; i < count; i++) {
					if (count > 0) {
							t[i] = arr[i];
					}
					else {
						break;
					}
				}
			} catch(ArrayIndexOutOfBoundsException e) {
				System.out.println(e);
			}
		}
		return temp; 
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + count;
		result = prime * result + Arrays.hashCode(arr);
		result = prime * result + size;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyStack other = (MyStack) obj;
		if (count != other.count)
			return false;
		if (!Arrays.equals(arr, other.arr))
			return false;
		if (size != other.size)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MyStack [num=" + Arrays.toString(arr) + ", count=" + count + ", size=" + size + "]";
	}
	
}
