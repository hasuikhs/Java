package day10Collection;

import java.util.Stack;

public class test01_Stack {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		stack.push("aaaa");
		stack.push("bbbb");
		stack.push("cccc");
		
		System.out.println(stack.empty());
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.empty());
		System.out.println(stack.pop());
		System.out.println(stack.empty());

		}
		
}

