import java.util.HashMap;
import java.util.Map;

public class Problem424 {
	
    public static int characterReplacement(String s, int k) {
        int start = 0, end = 0, maxLength = 0, repeatFrequency = 0;
        Map<Character, Integer> map = new HashMap<>();
        
        for(end = 0; end < s.length(); end++)
        {
            char right = s.charAt(end);
            map.put(right, map.getOrDefault(right , 0)+1);
            repeatFrequency = Math.max(repeatFrequency, map.get(right));
            
            if(end-start+1-repeatFrequency > k)
            {
                char left = s.charAt(start);
                map.put(left, map.getOrDefault(left,0)-1);
                start++; 
            }
            
            maxLength = Math.max(maxLength, end-start+1);         
        }
        return maxLength;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ABBACCCCDDCCCC";
//		String s = "ABBAC";
		int k = 2;
		System.out.println((characterReplacement(s, k)));
	}

}
