import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1806 {
	
	public static long solution(int[] arr, int S) {
//		if(S == 0) return 1;
		long answer = Long.MAX_VALUE;
		int l = 0, r = 0;
		long sum = 0;
		while(l < arr.length || r < arr.length) {
			if(sum < S) {
				sum += arr[r++];
			}else {
				sum -= arr[l++];
			}
			
			if(sum >= S) {
				answer = Math.min(answer, (r - l));
			}
		}
//		while(l < arr.length && sum >= S) {
//			sum -= arr[l++];
//			if(sum >= S) {
//				answer = Math.min(answer, (r - l));
//			}
//		}
		return answer == Long.MAX_VALUE ? 0 : answer;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		int N = Integer.valueOf(split[0]);
		int S = Integer.valueOf(split[1]);
		int[] arr = new int[N];
		split = br.readLine().split(" ");
		for(int i = 0; i < arr.length; i++) {
			arr[i] = Integer.valueOf(split[i]);
		}
		System.out.println(solution(arr, S));
	}

}
