import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Problem996 {
	public static int answer = 0;
	public static HashSet<List<Integer>> set = new HashSet<>();
    public static int numSquarefulPerms(int[] A) {
    	permutation(A, 0, A.length, A.length);
    	for(List<Integer> list : set) {
    		if(inspectPerm(list)) {
    			answer++;
    		}
    	}
        return answer;
    }
    
	public static void permutation(int[] arr, int depth, int n, int r) {
	     if(depth == r) {
        	 List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        	 set.add(list);
	         return;
	     }
	  
	     for(int i = depth; i < n; i++) {
	         swap(arr, depth, i);
	         permutation(arr, depth + 1, n, r);
	         swap(arr, depth, i);
	     }
	 }
	  
	public static void swap(int[] arr, int depth, int i) {
	     int temp = arr[depth];
	     arr[depth] = arr[i];
	     arr[i] = temp;
	 }
    
	public static boolean inspectPerm(List<Integer> list) {
		for(int i = 0; i < list.size() -1; i++) {
			int sum = list.get(i) + list.get(i + 1);
			double sqrt = Math.sqrt(sum);
			if(sqrt - (int)sqrt != 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] A = {1, 17, 8};
		int[] A = {2, 2, 2};
		int answer = numSquarefulPerms(A);
		System.out.println(answer);
	}
}
