package com.metacube.main;
import java.util.Scanner;
import com.metacube.resource.Stack;

public class MainClass {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();

		String userExpression = "";
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter Expression");  // You can use Five Operators [ *,/,+,-,^ ]
		userExpression = scan.nextLine();
		
		stack.infixToPostfixConversion(userExpression);
	}
}
