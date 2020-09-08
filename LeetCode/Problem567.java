import java.util.HashMap;

public class Problem567 {
	
    public static boolean checkInclusion(String s1, String s2) {
    	HashMap<Character, Integer> map1 = new HashMap<>();
    	HashMap<Character, Integer> map2 = new HashMap<>();
//    	int[] map1 = new int[26];
//    	int[] map2 = new int[26];
    	if(s1.length() > s2.length()) return false;
    	
        for(int i = 0; i < s1.length(); i++) {
        	map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0) + 1);
        	map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i), 0) + 1);
        }
        
       	if(isEqualMap(map1, map2)) {
    		return true;
    	}
    	
    	int l = 0;
        int r = s1.length();
        
        while(r < s2.length()) {
        	if(isEqualMap(map1, map2)) {
        		return true;
        	}
        	if(map2.get(s2.charAt(l)) == 1) {
        		map2.remove(s2.charAt(l));
        	}else {
        		map2.put(s2.charAt(l), map2.get(s2.charAt(l)) - 1);
        	}
        	map2.put(s2.charAt(r), map2.getOrDefault(s2.charAt(r), 0) + 1);
        	l++;
        	r++;
 
        }
        
    	if(isEqualMap(map1, map2)) {
    		return true;
    	}
    	
        return false;
    }
    
    public static boolean isEqualMap(HashMap<Character, Integer> map1, HashMap<Character, Integer> map2) {
    	if(map1.size() != map2.size()) return false;
    	for(char c : map1.keySet()) {
    		if(!map2.containsKey(c)) return false;
    		if((int)map2.get(c) != (int)map1.get(c)) return false;
    	}
    	return true;
    }
    


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Character, Integer> map1 = new HashMap<>();
		HashMap<Character, Integer> map2 = new HashMap<>();
		map1.put('c', 12345678);
		map2.put('c', 12345678);
		System.out.println(map1.get('c') + "==" + map2.get('c'));
		System.out.println(map1.get('c') == map2.get('c'));
		String s1 = "adc";
		String s2 = "dcda";
		System.out.println(checkInclusion(s1, s2));
	}

}
