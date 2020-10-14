import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main11047 {
	
	public static int solution(int[] coins, int k) {
		int answer = 0;
		for(int i = coins.length - 1; i >= 0; i--) {
			answer += (k / coins[i]);
			k = k % coins[i];
		}
		return answer;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		int N = Integer.valueOf(split[0]);
		int K = Integer.valueOf(split[1]);
		int[] coins = new int[N];
		for(int i = 0; i < N; i++) {
			coins[i] = Integer.valueOf(br.readLine());
		}
		System.out.println(solution(coins, K));
	}

}
