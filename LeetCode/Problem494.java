
public class Problem494 {
	
    int result = 0;
    public int findTargetSumWays(int[] nums, int S) {
        dfs(nums, 0, 0, S);
        return result;
    }
    public void dfs(int[] nums, int idx, int sum, int S){
        if(nums.length == idx){
            if(sum == S) result++;
            return;
        }
        dfs(nums, idx + 1, sum + nums[idx], S);
        dfs(nums, idx + 1, sum - nums[idx], S);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
