import java.util.Stack;

public class Main1918 {
	
	public static void solution(String infixExpression) {
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		for(char c : infixExpression.toCharArray()) {
			if(Character.isAlphabetic(c)) {
				sb.append(c);
			}else {
				switch(c) {
					case '(':{
						stack.push(c);
						break;
					}
					case '*':
					case '/':
						while(!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/')) {
							sb.append(stack.pop());
						}
						stack.push(c);
						break;
					case '+':
					case '-':
						while(!stack.isEmpty() && stack.peek() != '(') {
							sb.append(stack.pop());
						}
						stack.push(c);
						break;

					case ')':
						while(!stack.isEmpty() && stack.peek() != '(') {
							sb.append(stack.pop());
						}
						stack.pop();
						break;
				}
			}
		}
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		System.out.println(sb.toString());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution("A*(B+C)");
	}

}
