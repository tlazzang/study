import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main12865 {
	
	public static int[][] dp;
	public static int[][] stuff;
	public static int N, K;
	public static int answer = Integer.MIN_VALUE;
	
	public static void solution() {
		dp = new int[stuff.length][K + 1];
		for(int j = 1; j < dp[0].length; j++) {
			if(j >= stuff[0][0]) {
				dp[0][j] = stuff[0][1];
			}
		}
		
		for(int i = 1; i < dp.length; i++) {
			for(int j = 1; j < dp[0].length; j++) {
				if(j < stuff[i][0]) {
					dp[i][j] = dp[i-1][j];
				}else {
					dp[i][j] = Math.max(stuff[i][1] + dp[i-1][j - stuff[i][0]], dp[i-1][j]);
				}
			}
		}
		System.out.println(dp[stuff.length - 1][K]);
	}
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		N = Integer.valueOf(split[0]);
		K = Integer.valueOf(split[1]);
		stuff = new int[N][2];
		for(int i = 0; i < N; i++) {
			split = br.readLine().split(" ");
			stuff[i][0] = Integer.valueOf(split[0]);
			stuff[i][1] = Integer.valueOf(split[1]);
		}
		solution();
	}

}
