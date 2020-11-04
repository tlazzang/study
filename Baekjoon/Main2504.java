import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main2504 {
	
	public static int solution(String s) {
		int answer = 0;
		Stack<String> stack = new Stack<>();
		for(char c : s.toCharArray()) {
			if(c == '(' || c == '[') {
				stack.push(c+"");
			}else {
				if(stack.isEmpty()) return 0;
				
				if(c == ')' && stack.peek().equals("(")) {
					stack.pop();
					stack.push(2+"");
				}else if(c == ']' && stack.peek().equals("[")) {
					stack.pop();
					stack.push(3+"");
				}else {
					int sum = 0;
					if(c == ')') {
						while(!stack.isEmpty() && !stack.peek().equals("(")) {
							try {
								sum += Integer.valueOf(stack.pop());
							}catch(Exception e) {
								return 0;
							}
						}
						if(stack.isEmpty()) return 0;
						stack.pop();
						stack.push(String.valueOf(sum * 2));
//						answer += sum * 2;
						
					}else if(c == ']') {
						while(!stack.isEmpty() && !stack.peek().equals("[")) {
							try {
								sum += Integer.valueOf(stack.pop());
							}catch(Exception e) {
								return 0;
							}
						}
//						answer += sum * 3;
						if(stack.isEmpty()) return 0;
						stack.pop();
						stack.push(String.valueOf(sum * 3));
					}
				}
			}
		}
		
		while(!stack.isEmpty()) {
			int value;
			try {
				value = Integer.valueOf(stack.pop());
			}catch(Exception e) {
				return 0;
			}
			answer += value;
		}
		return answer;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(solution(br.readLine()));
	}

}
