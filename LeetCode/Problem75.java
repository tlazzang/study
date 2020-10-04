
public class Problem75 {
	
    public static void sortColors(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
        	int min = nums[i];
        	int minIdx = i;
        	for(int j = i; j < nums.length; j++) {
        		if(min > nums[j]) {
        			min = nums[j];
        			minIdx = j;
        		}
        	}
        	swap(nums, i, minIdx);
        }
        
        for(int n : nums) {
        	System.out.print(n + " ");
        }
    }
    
    public static void swap(int[] nums, int i, int j) {
    	int tmp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = tmp;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3,2,5,1,4};
		sortColors(nums);
	}

}
