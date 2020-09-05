
public class Problem5 {
	
//    public static String longestPalindrome(String s) {
//    	if(s.length() == 0) {
//    		return s;
//    	}
//        String answer = s.charAt(0)+"";
//        
//        for(int i = 0; i < s.length(); i++) {
//        	for(int j = i + 1; j < s.length(); j++) {
//        		if(s.charAt(i) == s.charAt(j)) {
//        			if(isPalindrome(s.substring(i + 1, j))) {
//        				if(answer.length() < s.substring(i, j+1).length()) {
//        					answer = s.substring(i, j+1);
//        				}
//        			}
//        		}
//        	}
//        }
//        
//        return answer;
//    }
    
    public static String longestPalindrome(String s) {
    	if(s.length() == 0) {
    		return s;
    	}
    	boolean[][] isPalindrome = new boolean[s.length()][s.length()];
    	for(int i = 0; i < s.length(); i++) {
    		isPalindrome[i][i] = true;
    	}
    	
    	String answer = s.charAt(0)+"";
    	
    	for(int i = 0; i < s.length()-1; i++) {
    		if(s.charAt(i) == s.charAt(i+1)) {
    			isPalindrome[i][i+1] = true;
    			answer = s.substring(i, i + 2);
    		}
    	}
    	
    	// Keep increasing the distance until it covers all the distances. 
        for (int dist = 2; dist < s.length(); dist++) {
            for (int i = 0; i < s.length() - dist; i++) {
                isPalindrome[i][i + dist] = isPalindrome[i + 1][i + dist - 1] &&
                                            s.charAt(i) == s.charAt(i + dist);
                
                if (isPalindrome[i][i + dist]) {
                	answer = s.substring(i, i + dist + 1);
                }
            }
        }
    	
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcba";
		System.out.println(longestPalindrome(s));

	}

}
