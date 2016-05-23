package sb.interview;

import java.util.ArrayDeque;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation. Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 *  For example:
 *    ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 *    ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6 
 * 
 * See detail at http://www.programcreek.com/2012/12/leetcode-evaluate-reverse-polish-notation/
 * @author alan
 *
 */
public class ReversePolishNotation {

	public static void main(String[] args) {
		String[] expr = new String[] { "2", "1", "+", "3", "*" };
		System.out.println(evaluate(expr));
		String[] expr2 = new String[] { "4", "13", "5", "/", "+" };
		System.out.println(evaluate(expr2));
		
	}
	
	public static int evaluate(String[] s) {
		int result = 0;
		ArrayDeque<String> stack = new ArrayDeque<String>();
		String operators = "+-*/";
		for (int i=0; i < s.length; i++) {
			if (!operators.contains(s[i])) {
				// push to stack if not operator
				stack.push(s[i]);
			} else {
				// Perform operation on stack
				int a = Integer.valueOf(stack.pop());
				int b = Integer.valueOf(stack.pop());
				switch (s[i].charAt(0)) {
				case '+':
					stack.push(String.valueOf(b+a));
					break;
				case '-':
					stack.push(String.valueOf(b-a));
					break;
				case '*':
					stack.push(String.valueOf(b*a));
					break;
				case '/':
					stack.push(String.valueOf(b/a));
					break;
				}
			}
		}
		result = Integer.valueOf(stack.pop());
		return result;
	}
}
