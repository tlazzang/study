import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main10799 {
	
	public static int solution(String s) {
		int answer = 0;
		int razer = 0;
		Stack<Character> stack = new Stack<>();
		Stack<Integer> razerStack = new Stack<>();
		for(int i = 0; i < s.length(); i++) {
			if(i < s.length() - 1 && s.charAt(i) == '(' && s.charAt(i+1) == ')') {
				answer += stack.size();
				i++;
			}else if(s.charAt(i) == '(') {
				stack.push(s.charAt(i));
			}else if(s.charAt(i) == ')') {
				answer++;
				stack.pop();
			}
		}
		return answer;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(solution(br.readLine()));
	}

}
