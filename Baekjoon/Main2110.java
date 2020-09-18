import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2110 {
	
	public static int solution(int[] home, int C) {
		int answer = 0;
		Arrays.sort(home);
		int l = 0;
		int r = 1000000000;
		while(l <= r) {
			int cnt = 0;
			int prevHome = 0;
			int mid = (l + r) / 2;
			for(int i = 0; i < home.length; i++) {
				if(i==0) {
					cnt++;
					prevHome = home[i];
					continue;
				}
				if(home[i] - prevHome >= mid) {
					cnt++;
					prevHome = home[i];
				}
				
				if(cnt == C) break;
			}
			if(cnt < C) {
				r = mid - 1;
			}else {
				answer = Math.max(answer, mid);
				l = mid + 1;
			}
		}
		return answer;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		int N = Integer.valueOf(split[0]);
		int C = Integer.valueOf(split[1]);
		int[] home = new int[N];
		for(int i = 0; i < N; i++) {
			home[i] = Integer.valueOf(br.readLine());
		}
		System.out.println(solution(home, C));
	}

}
