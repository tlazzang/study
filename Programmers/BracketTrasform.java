package KakaoBlind2020;

import java.util.Stack;

public class BracketTrasform {
	
    public static String solution(String p) {
        String answer = "";
        if(isRightString(p)) return p;
        answer = transform(p);
        return answer;
    }
    
    public static String transform(String w) {
    	if(w.isEmpty()) {
    		return "";
    	}
    	
    	String u = "";
    	String v = "";
		for(int i = 2; i <= w.length(); i += 2) {
			u = w.substring(0, i);
			v = w.substring(i);
			if(isBalancedString(u) && isBalancedString(v)) {
				break;
			}
			
		}
    	
    	if(isRightString(u)) {
    		return u += transform(v);
    	}else {
    		String s = "(" + transform(v) + ")";
    		for(int i = 0; i < u.length(); i++) {
    			if(i == 0 || i == u.length() -1) continue;
    			if(u.charAt(i) == '(') {
    				s += ")";
    			}else {
    				s += "(";
    			}
    		}
    		return s;
    	}
    }
    
    public static boolean isRightString(String s) {
    	Stack<Character> stack = new Stack<>();
    	for(char c : s.toCharArray()) {
    		if(c == '(') {
    			stack.push('(');
    		}else {
    			if(stack.isEmpty()) return false;
    			stack.pop();
    		}
    	}   	
    	return stack.isEmpty() ? true : false;
    }
    
    public static boolean isBalancedString(String s) {
    	int cnt = 0;
    	for(char c : s.toCharArray()) {
    		if(c == '(') cnt++;
    		else cnt--;
    	}
    	return cnt == 0 ? true : false;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String p = "()))((()";
		System.out.println(solution(p));
	}

}
