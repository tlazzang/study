import java.util.ArrayList;
import java.util.Collections;

public class Problem628 {
	
    public static int maximumProduct(int[] nums) {
        int max = nums[0] * nums[1] * nums[2];
        int minElement = Math.min(Math.min(nums[0], nums[1]), nums[2]);
        ArrayList<Integer> elementList = new ArrayList<Integer>();
        elementList.add(nums[0]);
        elementList.add(nums[1]);
        elementList.add(nums[2]);
        for(int i = 3; i < nums.length; i++) {
        	if(minElement < nums[i]) {
        		elementList.remove((Integer)minElement);
        		elementList.add(nums[i]);
        		max = elementList.get(0) * elementList.get(1) * elementList.get(2); 
        		Collections.sort(elementList);
        		minElement = elementList.get(0);
        	}
        }
        return max;
    }
	
//    public static int maximumProduct(int[] nums) {
//        int max = Integer.MIN_VALUE;
//        for(int i = 0; i < nums.length; i++) {
//        	for(int j = 0; j < nums.length; j++) {
//        		for(int k = 0; k < nums.length; k++) {
//        			if(i == j || i == k || j == k) continue;
//        			int product = nums[i] * nums[j] * nums[k];
//        			max = Math.max(max, product);
//        		}
//        	}
//        }
//        return max;
//    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums = {-4,-3,-2,-1,60};
		System.out.println(maximumProduct(nums));

		
	}

}
