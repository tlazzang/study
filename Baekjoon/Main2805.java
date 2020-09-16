import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2805 {
	
	public static int solution(int[] arr, int m) {
		int l = 0;
		int r = 1000000000;
		int answer = 0;
		
		while(l <= r) {
			int mid = (l + r) / 2;
			int sum = 0;
			for(int i = 0; i < arr.length; i++) {
				if(arr[i] - mid > 0) {
					sum += arr[i] - mid;
				}
			}
			
			if(sum >= m) {
				if(answer < mid) {
					answer = mid;
				}
				l = mid + 1;
			}else {
				r = mid - 1;
			}
		}

		return answer;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		int N = Integer.valueOf(split[0]);
		int M = Integer.valueOf(split[1]);
		int[] trees = new int[N];
		split = br.readLine().split(" ");
		for(int i = 0; i < trees.length; i++) {
			trees[i] = Integer.valueOf(split[i]);
		}
		System.out.println(solution(trees, M));
	}

}
