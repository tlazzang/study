import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Main4949 {
	
	public static void solution(ArrayList<String> list) {
		Stack<Character> stack = new Stack<>();
		for(String s : list) {
			stack = new Stack<>();
			boolean isBalanced = true;
			for(Character c : s.toCharArray()) {
				if(c == '(' || c == '[') {
					stack.push(c);
				}else if(c == ')') {
					if(stack.isEmpty() || stack.pop() != '(') {
						isBalanced = false;
						break;
					}
				}else if(c == ']') {
					if(stack.isEmpty() || stack.pop() != '[') {
						isBalanced = false;
						break;
					}
				}
			}
			System.out.println(isBalanced && stack.isEmpty() ? "yes" : "no");
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		ArrayList<String> list = new ArrayList<>();
		while((input = br.readLine()) != null) {
			if(input.equals(".")) break;
			list.add(input);
		}
		solution(list);
	}

}
