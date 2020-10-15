import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main9012 {
	
	public static StringBuilder sb = new StringBuilder();
	public static Stack<Character> stack;
	
	public static void solution(String s) {
		stack = new Stack<>();
		for(Character c : s.toCharArray()) {
			if(c == '(') {
				stack.push('(');
			}else {
				if(stack.isEmpty()) {
					sb.append("NO\n");
					return;
				}else {
					stack.pop();
				}
			}
		}
		
		if(!stack.isEmpty()) {
			sb.append("NO\n");
		}else {
			sb.append("YES\n");
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());
		for(int i = 0; i < N; i++) {
			solution(br.readLine());
		}
		System.out.print(sb.toString());
	}

}
