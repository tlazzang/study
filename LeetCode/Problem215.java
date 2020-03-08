import java.util.Arrays;

public class Problem215 {
	
    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,4,6,7};
		int k = 2;
		findKthLargest(a, k);
	}
}
