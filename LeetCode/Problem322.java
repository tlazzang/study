
public class Problem322 {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        int min;
        for(int i = 1; i < dp.length; i++){
            min = Integer.MAX_VALUE;
            for(int c : coins){
                int n = i - c;
                if(n >= 0){
                    min = Math.min(min, dp[n]);
                }
            }
            dp[i] = (min == Integer.MAX_VALUE) ? Integer.MAX_VALUE : min + 1;
        }
        return (dp[amount] == Integer.MAX_VALUE) ? -1 : dp[amount];
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
