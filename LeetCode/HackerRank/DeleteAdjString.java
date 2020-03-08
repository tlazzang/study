package HackerRank;

public class DeleteAdjString {

    // Complete the alternatingCharacters function below.
    static int alternatingCharacters(String s) {
    	int res = 0;
    	for(int i = 0; i < s.length();) {
    		int j = i;
    		while(j < s.length() - 1 && s.charAt(j) == s.charAt(j+1)) {
    			res++;
    			j++;
    		}
    		i = j + 1;
    	}
    	return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aaabaaab";
		System.out.println(alternatingCharacters(s));
	}

}
