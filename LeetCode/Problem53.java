import java.util.ArrayList;
import java.util.Comparator;

public class Problem53 {
	
    public int maxSubArray(int[] nums) {
    	int max_sum = -1;
        int sum = 0;
        int size = 1;
        while(size < nums.length) {
            for(int i = 0; i < nums.length; i++) {
            	for(int j = i; j < j + size; j++) {
            		if(j > nums.length - 1) {
            			continue;
            		}
            		sum = sum + nums[j];
            	}
            	max_sum = Math.max(max_sum, sum);
            	sum = 0;
            }
            size++;
        }
        ArrayList<String> list = new ArrayList<>();
        return max_sum;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
