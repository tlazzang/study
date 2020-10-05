import java.util.Arrays;

public class Problem416 {
	
    public static boolean canPartition(int[] nums) {
    	int sum = 0;
    	int[] cnt = new int[201];
    	for(int n : nums) {
    		sum += n;
    		cnt[n]++;
    	}
    	if(sum % 2 == 1) return false;
    	
        boolean[] dp = new boolean[(sum/2) + 1];
        int[][] left = new int[(sum/2) + 1][101];
        
        dp[0] = true;
        left[0] = cnt;
        		
        for(int i = 1; i <= sum/2; i++) {
        	for(int n : nums) {
    			if(i - n >= 0 && dp[i-n]) {
    				if(left[i-n][n] - 1 >= 0) {
    					dp[i] = true;
    					int[] tmp = Arrays.copyOf(left[i-n], left[i-n].length);
    					tmp[n]--;
    					left[i] = tmp;
    					break;
    				}
    			}
        	}
        }
        
        return dp[4];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,1,2,4};
		System.out.println(canPartition(nums));
	}

}
