import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1654 {
	
	public static long solution(int[] lanCable, int N) {
		long answer = 0;
		long l = 0;
		long r = (long)Math.pow(2, 32) - 1;
		
		while(l <= r) {
			int sum = 0;
			long mid = (l + r) / 2;
			for(int cableLength : lanCable) {
				sum += cableLength / mid;
			}
			
			if(sum >= N) {
				answer = Math.max(answer, mid);
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
		int K = Integer.valueOf(split[0]);
		int N = Integer.valueOf(split[1]);
		int[] lanCable = new int[K];
		for(int i = 0; i < K; i++) {
			lanCable[i] = Integer.valueOf(br.readLine());
		}
		System.out.println(solution(lanCable, N));
	}

}
