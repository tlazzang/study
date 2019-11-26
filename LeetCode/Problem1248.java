
public class Problem1248 {
	
    public static int numberOfSubarrays(int[] nums, int k) {
        int answer = 0;
        for(int c = 0; c < nums.length; c++) {
	        for(int i = c; i < nums.length; i++) {
	        	int numOfOdd = 0;
	        	for(int j = c; j <= i; j++) {
	        		if(nums[j] % 2 == 1) {
	        			numOfOdd++;
	        		}
	        	}
                if(numOfOdd == k) {
                    answer++;
                }
	        }
        }
        return answer;
    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,2,1,1};
		int k = 2;
		numberOfSubarrays(nums, k);
	}

}
