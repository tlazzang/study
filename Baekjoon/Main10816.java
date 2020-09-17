import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main10816 {
	
	public static int lower_bound(int[] arr, int toSearch) {
	    int mid, start, end;
	    start = 0; end = arr.length - 1;
	 
	    while (end > start){
	        mid = (start + end) / 2;
	        if (arr[mid] >= toSearch)
	            end = mid;
	        else start = mid + 1;
	    }
	    return end;
	}
	
	public static int upper_bound(int[] arr, int toSearch) {
		int s = 0, e = arr.length - 1;
		int mid;
		while (e - s > 0) {
			mid = (s + e) / 2;

			if (arr[mid] <= toSearch) { s = mid + 1; } // 상한은 같은 수를 더 작은 수로 판단
			else e = mid;
		}

		if (arr[e] != toSearch) { e -= 1; }

		return e;
	}
	
	public static void solution(int[] arr, int[] toSearch) {
		int[] answer = new int[toSearch.length];
		Arrays.sort(arr);
		
	
		for(int i = 0; i < toSearch.length; i++) {
			int l = 0;
			int r = arr.length - 1;
			int minIdx = lower_bound(arr, toSearch[i]);
			int maxIdx = upper_bound(arr, toSearch[i]);
			
			
//			while(l <= r) {
//				int mid = (l + r) / 2;
//				int midValue = arr[mid];
//				if(midValue >= toSearch[i]) {
//					minIdx = mid;
//					r = mid - 1;
//				}else {
//					l = mid + 1;
//				}
//			}
//			
//			l = 0;
//			r = arr.length - 1;
//			
//			while(l <= r) {
//				int mid = (l + r) / 2;
//				int midValue = arr[mid];
//				if(midValue > toSearch[i]) {
//					maxIdx = mid;
//					r = mid - 1;
//				}else {
//					l = mid + 1;
//				}
//			}
	      
			
	        if(arr[minIdx] == toSearch[i]) {
	        	answer[i] = (maxIdx - minIdx) + 1;
	        }else {
	        	answer[i] = 0;
	        }
			
		}
		
		for(int n : answer) {
			System.out.print(n + " ");
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());
		int[] arr = new int[N];
		String[] split = br.readLine().split(" ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.valueOf(split[i]);
		}
		int M = Integer.valueOf(br.readLine());
		int[] toSearch = new int[M];
		split = br.readLine().split(" ");
		for(int i = 0; i < M; i++) {
			toSearch[i] = Integer.valueOf(split[i]);
		}
		solution(arr, toSearch);
	}

}
