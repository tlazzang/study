
public class Problem283 {
    public void moveZeroes(int[] nums) {
        int current = 0;
		// Get all non-zero numbers to the beginning
        for(int num : nums) {
            if(num != 0)
                nums[current++] = num;
        }
		// Fill the remaining array with 0's
        for(int i = current; i < nums.length; i++)
            nums[i] = 0;
    }
}
