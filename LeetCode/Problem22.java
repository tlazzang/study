import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem22 {
	
	List<String> list = new ArrayList<>();
	
	public List<String> generateParenthesis(int n) {
		
		dfs(new StringBuilder() , n * 2);
		for(String s : list) {
			System.out.println(s);
		}
		return list;
	}
	
	public void dfs(StringBuilder sb, int n) {
		if(sb.length() == n) {
			if(isValidString(sb.toString())) {
				list.add(sb.toString());
			}
			return;
			//유효성 검사 후에 list에 추
		}
		dfs(sb.append("("), n);
		sb.deleteCharAt(sb.length() - 1);
		dfs(sb.append(")"), n);
		sb.deleteCharAt(sb.length() - 1);
	}
	
	public boolean isValidString(String str) {
		Stack<String> stack = new Stack<>();
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '(') {
				stack.push("(");
			}
			else {
				if(stack.isEmpty()) {
					return false;
				}
				stack.pop();
			}
		}
		return stack.isEmpty() ? true : false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Problem22 p = new Problem22();
		p.generateParenthesis(3);

	}
}
