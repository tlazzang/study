import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem763 {
	
    public static List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        HashMap<Character, Integer> lastIndexMap = new HashMap<>();
        for(int i = 0; i < S.length(); i++) {
        	lastIndexMap.put(S.charAt(i), i);
        }
        
        int max = Integer.MIN_VALUE;
        for(int i = 0, start = 0; i < S.length(); i++) {
        	int lastIdx = lastIndexMap.get(S.charAt(i));
        	max = Math.max(max, lastIdx);
        	if(i == max) {
        		result.add(max - start + 1);
        		start = max + 1;
        	}
        }
        return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ababcbacadefegdehijhklij";
//		String s = "qiejxqfnqceocmy";

		List<Integer> result = partitionLabels(s);
		for(int n : result) {
			System.out.print(n + " ");
		}
	}

}
