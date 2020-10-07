
public class Problem300 {
	
    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int result = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            int max  = 0;
            for(int j = 0; j <= i; j++){
                if(nums[i] > nums[j]){
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
            result = Math.max(result, max);
        }
        return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
		System.out.println(lengthOfLIS(nums));
	}

}
