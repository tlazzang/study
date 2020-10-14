import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main2014 {
	
	public static long[] arr;
	public static int N;
	
	public static long solution() {
		long answer = 0;
		
		PriorityQueue<Long> pq = new PriorityQueue<>();
		for(long n : arr) {
			pq.add(n);
		}
		
		for(int i = 0; i < N; i++) {
			answer = pq.poll();
//			while(!pq.isEmpty() && answer == (long)pq.peek()) {
//				pq.poll();
//			}
			for(int j = 0; j < arr.length; j++) {
				if(answer * arr[j] > Integer.MAX_VALUE) break;
				pq.add(answer * arr[j]);
	            if (answer % arr[j] == 0) {
	                break;
	            }
			}
			
//			answer = pq.poll();

		}
		
		return answer;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		int K = Integer.valueOf(split[0]);
		N = Integer.valueOf(split[1]);
		arr = new long[K];
		split = br.readLine().split(" ");
		for(int i = 0; i < K; i++) {
			arr[i] = Long.valueOf(split[i]);
		}
		System.out.println(solution());
	}

}
