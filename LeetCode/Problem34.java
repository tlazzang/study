
public class Problem34 {
	
	public static int first = Integer.MAX_VALUE;
	public static int last = Integer.MIN_VALUE;
	
//    public static int[] searchRange(int[] nums, int target) {
//        getFirstAndLastPosition(0, nums.length - 1, nums, target);
//        int[] answer = new int[2];
//        if(first == Integer.MAX_VALUE) {
//        	answer[0] = -1;
//        	answer[1] = -1;
//        }else {
//        	answer[0] = first;
//        	answer[1] = last;
//        }
//        return answer;
//    }
    
    public static int[] searchRange(int[] nums, int target) {
    	StringBuilder sb = new StringBuilder();

        getFirstAndLastPosition(0, nums.length - 1, nums, target);
        int[] answer = new int[2];
        if(first == Integer.MAX_VALUE) {
        	answer[0] = -1;
        	answer[1] = -1;
        }else {
        	answer[0] = first;
        	answer[1] = last;
        }
        return answer;
    }
    
    public static void getFirstAndLastPosition(int left, int right, int[] nums, int target){
    	if(left == right) {
    		if(nums[left] == target) {
        		first = Math.min(first, left);
        		last = Math.max(last, right);
    		}
    		return;
    	}
        int mid = (left + right) / 2;
        getFirstAndLastPosition(left, mid, nums, target);
        getFirstAndLastPosition(mid + 1, right, nums, target);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {5,7,7,8,8,10};
		int target = 7;
		int[] answer = searchRange(nums, target);
		for(int n : answer) {
			System.out.print(n + " , ");
		}
	}

}
