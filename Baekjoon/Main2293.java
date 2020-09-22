import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2293 {
	
	public static int solution(int[] arr, int target) {
		int[] dp = new int[target + 1];
		
		dp[0] = 1;
		
		for(int i = 0; i < arr.length; i++) {
			int n = arr[i];
			for(int j = n; j <= target; j++) {
				dp[j] += dp[j - n];
			}
		}
		
		return dp[target];
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		int N = Integer.valueOf(split[0]);
		int K = Integer.valueOf(split[1]);
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.valueOf(br.readLine());
		}
		System.out.println(solution(arr, K));
	}
}
