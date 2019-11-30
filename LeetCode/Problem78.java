import java.util.ArrayList;
import java.util.List;

public class Problem78 {
	
	List<List<Integer>> list = new ArrayList<>();
	
	public void combination(int[] arr, boolean[] visited, int start, int n, int r) {
	    if(r == 0) {
	    	List<Integer> subset = new ArrayList<>();
	        for(int i=0; i<n; i++) {
	            if(visited[i] == true) {
	            	subset.add(arr[i]);
	            }
	        }
	        list.add(subset);
	        return;
	    } else {
	        for(int i=start; i<n; i++) {
	            visited[i] = true;
	            combination(arr, visited, i + 1, n, r - 1);
	            visited[i] = false;
	        }
	    }
	}

	
    public List<List<Integer>> subsets(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        for(int i = 1; i <= nums.length; i++) {
        	combination(nums, visited, 0, nums.length, i);	
        }
        list.add(new ArrayList<Integer>()); //empty set
        return list;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Problem78 p = new Problem78();
		int[] nums = {1,2,3};
		p.subsets(nums);
		for(List<Integer> subset : p.list) {
			for(int n : subset) {
				System.out.print(n + ", ");
			}
			System.out.println();
		}
	}

}
