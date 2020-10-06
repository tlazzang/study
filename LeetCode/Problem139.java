import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem139 {
	
	public static boolean wordBreak(String s, List<String> wordDict) {
		Set<String> set = new HashSet<>();
		for(String e : wordDict) {set.add(e);}
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		
		// i is actually a right bound, 0 is the left bound, j is the middle pointer
		// j is to find where dp[j] = true, so that we can check substring[j+1,i]
		for(int i = 1; i < dp.length; i++){
			for(int j = 0; j < dp.length; j++){
			    // if dp[j] is found true in the dictionary
				if(dp[j] == true) {
				    // we just need to take a look at the right side substring [j+1, i]
					if(set.contains(s.substring(j,i))) {
						dp[i] = true;
//						break;         // we break because there is no need to continue looping
					}
				}
			}
		}
		return dp[dp.length - 1];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "leetcode";
//		String s = "leetcode";
		List<String> wordDict = new ArrayList<>();
		
		wordDict.add("leet");
		wordDict.add("etcode");
//		wordDict.add("b");
//		wordDict.add("cd");
		
//		wordDict.add("leet");
//		wordDict.add("code");
//		wordDict.add("hello");
		
		System.out.println(wordBreak(s, wordDict));
		
		String s1 = "leetcode";
//		System.out.println(s1.substring(2,1));
		String s2 = "leet";

	}

}
