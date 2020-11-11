import java.util.ArrayList;
import java.util.Comparator;

public class Problem53 {
	
    public int maxSubArray(int[] nums) {
    	int maxSum = nums[0];
    	int maxUntilNow = nums[0];
    	for(int i = 1; i < nums.length; i++) {
    		maxUntilNow = Math.max(maxUntilNow + nums[i], nums[i]);
    		maxSum = Math.max(maxSum, maxUntilNow);
    	}
    	return maxSum;
    }

    public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
