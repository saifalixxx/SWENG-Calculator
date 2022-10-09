package org.example;

import java.util.Scanner;
import java.util.Stack;

public class Calculator {
	public static int calculate(char[] expressionArray) {
		Stack<Integer> numStack = new Stack<Integer>();
		Stack<Character> operStack = new Stack<Character>();
		for (int i = 0; i < expressionArray.length; i++) {
			if (expressionArray[i] == ' ') {
				continue;
			} else if (expressionArray[i] >= '0' && expressionArray[i] <= '9') {
				StringBuffer buff_s = new StringBuffer();
				while (i < expressionArray.length && expressionArray[i] >= '0' && expressionArray[i] <= '9')
					buff_s.append(expressionArray[i++]);
				numStack.push(Integer.parseInt(buff_s.toString()));
			} else if (expressionArray[i] == '(') {
				operStack.push(expressionArray[i]);
			} else if (expressionArray[i] == ')') {
				while (operStack.peek() != '(')
					numStack.push(applyOperation(operStack.pop(), numStack.pop(), numStack.pop()));
				operStack.pop();
			} else if (expressionArray[i] == '+' || expressionArray[i] == '-' || expressionArray[i] == '*'
					|| expressionArray[i] == '/') {
				while (!operStack.empty() && hasPrecedence(expressionArray[i], operStack.peek()))
					numStack.push(applyOperation(operStack.pop(), numStack.pop(), numStack.pop()));
				operStack.push(expressionArray[i]);
			} else {
				while (i < expressionArray.length && expressionArray[i] != '0' && expressionArray[i] != '9'
						&& (expressionArray[i] != '+' || expressionArray[i] != '-' || expressionArray[i] != '*'
								|| expressionArray[i] != '/'))
					continue;
			}
		}

		while (!operStack.empty())
			numStack.push(applyOperation(operStack.pop(), numStack.pop(), numStack.pop()));
		return numStack.pop();
	}

	public static boolean hasPrecedence(char oper_1, char oper_2) {
		if (oper_2 == '(' || oper_2 == ')')
			return false;
		if (oper_1 == '*' && (oper_2 == '+' || oper_2 == '-'))
			return false;
		else
			return true;
	}

	public static int applyOperation(char oper, int var2, int var1) {
		switch (oper) {
		case '+':
			return var1 + var2;
		case '-':
			return var1 - var2;
		case '*':
			return var1 * var2;
		}
		return 0;
	}

	public static boolean checkInvalid(String num) {
		boolean invalid = false;
		invalid = num.matches(".*[a-zA-Z].*");
		char[] expressionArray = num.toCharArray();
		for (int i = 0; i < expressionArray.length; i++) {
			if (expressionArray[i] == '+' || expressionArray[i] == '-' || expressionArray[i] == '*') {
				if (expressionArray[i + 1] == '+' || expressionArray[i + 1] == '-' || expressionArray[i + 1] == '*') {
					invalid = true;
				} else
					continue;
			}
		}
		return invalid;
	}

	public static void main(String[] args) {
		System.out.print("Please enter a valid expression to calculate : ");
		Scanner input = new Scanner(System.in);
		String num = input.nextLine();
		if (num == null) {
			System.out.print("Please enter a valid expression to calculate : ");
			input = new Scanner(System.in);
		}
		if (checkInvalid(num)) {
			System.out.println("Invalid");
			System.exit(1);
		}
		char[] expressionArray = num.toCharArray();
		System.out.println(calculate(expressionArray));
	}
}