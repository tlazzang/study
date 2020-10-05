import java.util.HashMap;

public class Problem560 {
	
    public static int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap < Integer, Integer > map = new HashMap < > ();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
	
//    public static int subarraySum(int[] nums, int k) {
//        int answer = 0;
//        int l = 0, r = 0;
//        int sum = 0;
//        
//        while(l <= r && r < nums.length){
//            if(sum < k || r - l == 0){
//                sum += nums[r++];
//            }else{
//                sum -= nums[l++];
//            }
//            
//            if(sum == k && r - l > 0) answer++;
//        }
//        
//        while(sum != k && l < r){
//            sum -= nums[l++];
//            if(sum == k && r - l > 0) answer++;
//        }
//        
//        return answer;
//    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = {-19, -82, -70, -46, -29, 7, 15, -72, -7, 100, 303};
		int[] arr = {-1,1, 5, -1, 1};
		System.out.println(subarraySum(arr, 5));
	}

}
