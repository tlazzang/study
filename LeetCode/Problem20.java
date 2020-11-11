import java.util.Stack;

public class Problem20 {
	
    public boolean isValid(String s) {
    	Stack<Character> stack = new Stack<>();
    	for(char c : s.toCharArray()) {
    		if(c == ')') {
    			if(stack.isEmpty() || stack.pop() != '(') return false;
    		}else if(c == ']'){
    			if(stack.isEmpty() || stack.pop() != '[') return false;
    		}else if(c == '}') {
    			if(stack.isEmpty() || stack.pop() != '{') return false;
    		}else {
    			stack.push(c);
    		}
    	}
    	
    	if(!stack.isEmpty()) return false;
    	
        return true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
