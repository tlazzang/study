import java.util.HashSet;

public class Problem3 {
	
//    public static int lengthOfLongestSubstring(String s) {
//        int result = 0;
//        HashSet<Character> set = new HashSet<>();
//        for(int i = 0; i < s.length(); i++) {
//        	int cnt = 0;
//        	set.clear();
//        	for(int j = i; j < s.length(); j++) {
//        		if(set.contains(s.charAt(j))) break;
//        		set.add(s.charAt(j));
//        		cnt++;
//        	}
//        	result = Math.max(result, cnt);
//        }
//        return result;
//    }
    
    public static int lengthOfLongestSubstring(String s) {
        int result = 0;
        HashSet<Character> set = new HashSet<>();
        int i = 0;
        int j = 0;
        int cnt = 0;
        
        while(i < s.length() && j < s.length()) {
        	if(!set.contains(s.charAt(j))) {
        		cnt++;
        		set.add(s.charAt(j++));
        		result = Math.max(result, cnt);
        	}else {
        		set.remove(s.charAt(i++));
        		cnt--;
        	}
        }
        
        return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "pwwkew";
		System.out.println(lengthOfLongestSubstring(s));
	}

}
