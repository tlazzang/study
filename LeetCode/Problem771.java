import java.util.Arrays;

public class Problem771 {
	
    public static int numJewelsInStones(String J, String S) {
    	char[] jArray = J.toCharArray();
    	char[] sArray = S.toCharArray();
    	Arrays.sort(jArray);
    	Arrays.sort(sArray);
    	String sortedJ = new String(jArray);
    	String sortedS = new String(sArray);
    	
    	int answer = 0;
    	for(int i = 0; i < sortedJ.length(); i++) {
    		int startIdx = sortedS.indexOf(sortedJ.charAt(i));
    		int lastIdx = sortedS.lastIndexOf(sortedJ.charAt(i));
    		if(startIdx != -1) {
    			answer = answer + (lastIdx - startIdx) + 1;
    		}
    	}
    	return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String J = "aA", S = "aAAbbbb";
		System.out.println(numJewelsInStones(J,S));
	}

}
