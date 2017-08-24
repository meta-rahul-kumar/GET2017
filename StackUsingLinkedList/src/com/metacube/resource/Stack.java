package com.metacube.resource;

/**
 * Stack Class have methods push, pop and infix to PostFix Conversion
 * @author User17
 *
 * @param <T>
 */
public class Stack<T> {
	Node<Character> top;
	int size;
	
	/**
	 * Stack Class Constructor
	 */
	public Stack(){
		top = null;
		size = 0;
	}
	
	/**
	 * push an element to Stack
	 * @param data
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void push(char data) {
		Node newNode = new Node(data);
		
		if (top == null) {
			newNode.setNext(null);
			top = newNode;
		} else {
			newNode.setNext(top);
			top = newNode;
		}
		
		size++;
	}
	
	/**
	 * pop an element from stack
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void pop() {
		Node deletedNode = new Node();
		if (size > 0) {
			deletedNode = top;
			top = top.getNext();
			if (deletedNode.getData().toString().charAt(0) != '(' && deletedNode.getData().toString().charAt(0) != ')') {
				System.out.print(deletedNode.getData());
			}
			size--;
		} else {
			System.out.println("Stack UnderFlows !!");
		}
	}
	
	/**
	 * convert infix expression to postfix expression
	 * @param expression
	 */
	public void infixToPostfixConversion(String expression) {
		Stack<Character> postFix = new Stack<>();
		int lengthOfExpression = expression.length();
		int counter = 0;
		
		while (counter != lengthOfExpression ) {
			if (expression.charAt(counter) == '(') {
				postFix.push(expression.charAt(counter));
			} else if (expression.charAt(counter) == ')') {
				while (postFix.peek().getData().toString().charAt(0) != '(') {
					postFix.pop();
				}	
				postFix.pop();
			} else if (!isOperator(expression.charAt(counter))) {
				System.out.print(expression.charAt(counter));
			} else {
				if (postFix.isEmpty()) {
					postFix.push(expression.charAt(counter));
				} else if (getPrecedence(expression.charAt(counter)) > getPrecedence(postFix.peek().getData().toString().charAt(0))) {
					postFix.push(expression.charAt(counter));
				} else {
					while ((getPrecedence(expression.charAt(counter)) <= getPrecedence(postFix.peek().getData().toString().charAt(0)))) {
						postFix.pop();
						if (postFix.isEmpty()) {
							break;
						}
					}
					postFix.push(expression.charAt(counter));
				}
				
			}
			counter++;
		}
		
		while (!postFix.isEmpty()) {
			postFix.pop();
		}
	}

	public boolean isEmpty() {
		boolean isEmpty = false;
		
		if (size == 0) {
			isEmpty = true;
		}
		
		return isEmpty;
	}

	@SuppressWarnings("rawtypes")
	private Node peek() {
		return top;
	}

	public int getPrecedence(char operator) {
		int precedenceLevel;
		switch (operator) {
		case '^':
			precedenceLevel = 3;
			break;
		case '*':
			precedenceLevel = 2;
			break;
		case '/':
			precedenceLevel = 2;
			break;
		case '+':
			precedenceLevel = 1;
			break;
		case '-':
			precedenceLevel = 1;
			break;
		default:
			precedenceLevel = 0;
		}
		
		return  precedenceLevel;
	}
	
	public boolean isOperator(char character) {
		boolean isOperator = false;
		if (character == '+' || character == '-' || character == '/' || character == '*') {
			isOperator = true;
		}
		
		return isOperator;
	}
}
