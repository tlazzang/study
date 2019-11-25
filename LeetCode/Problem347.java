import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Problem347 {
	
    public List<Integer> topKFrequent(int[] nums, int k) {
    	List<Integer> answerList = new ArrayList<>();
        List<Integer> list;
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
        	set.add(nums[i]);
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            else{
                map.put(nums[i], 1);
            }
        }
        list = new ArrayList<>(set);
        Collections.sort(list, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return Integer.compare(map.get(o2), map.get(o1));
			}
        	
        });
        for(int i = 0; i < k; i++) {
        	answerList.add(list.get(i));
        }
        return answerList;
    
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Problem347 p = new Problem347();
		int[] nums = {1};
		int k = 1;
		List<Integer> list = p.topKFrequent(nums, k);
		for(int num : list) {
			System.out.print(num + " ");
		}
		String s = "cba";
		char[] array = s.toCharArray();
		Arrays.sort(array);
		System.out.println(String.valueOf(array));
		

	}

}
