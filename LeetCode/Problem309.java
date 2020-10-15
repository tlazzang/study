
public class Problem309 {
	
    public int maxProfit(int[] prices) {
		int[] buy = new int[prices.length];
		int[] sell = new int[prices.length];
		int[] rest = new int[prices.length];
		buy[0] = 0;
		sell[0] = 0;
		rest[0] = 0;
		
		for(int i = 1 ; i < prices.length; i++) {
			buy[i] = Math.max(rest[i-1] - prices[i], buy[i-1]);
			sell[i] = Math.max(buy[i-1] + prices[i], sell[i-1]);
			rest[i] = Math.max(sell[i-1], Math.max(buy[i-1], rest[i-1]));
		}
        return sell[prices.length];
    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
