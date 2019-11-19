
public class Problem647 {
	
    public static int countSubstrings(String s) {
    	int answer = 0;
        for(int i = 0; i < s.length(); i++) {
        	for(int j = 0; j < s.length() - i; j++) {
        		System.out.println(s.substring(j, j+i+1));
        		if(isPalindrome(s.substring(j, j+i+1))) {
        			answer++;
        		}
        	}
        }
        return answer;
    }
    public static boolean isPalindrome(String s){
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.reverse();
        String reverseString = new String(sb);
        if(s.equals(reverseString)) {
        	return true;
        }
        else {
        	return false;
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "aaa";
		System.out.println(countSubstrings(str));
	}

}
