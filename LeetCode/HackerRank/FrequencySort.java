package HackerRank;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class FrequencySort {
	
	public static int[] solution(int[] arr){
		int[] result = new int[arr.length];
		Integer[] arr2 = Arrays
				.stream(arr)
				.boxed()
				.toArray(Integer[]::new);
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < arr.length; i++) {
			if(map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			}else {
				map.put(arr[i], 1);
			}
		}
		Arrays.sort(arr2, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
//				if(map.get(o2) == map.get(o1)) {
//					return o1.compareTo(o2);
//				}else {
					return map.get(o2).compareTo(map.get(o1));
//				}
			}
		});
		for(int i = 0; i < arr2.length; i++) {
			result[i] = arr2[i];
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {5,5,3,3,3,2,5};
		int[] result = solution(arr);
		for(int n : result) {
			System.out.print(n + " ");
		}
	}

}
