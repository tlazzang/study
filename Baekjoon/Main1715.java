import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main1715 {
	
	public static PriorityQueue<Integer> pq = new PriorityQueue<>();
	
	public static int solution() {
		int answer = 0;
		while(pq.size() >= 2) {
			int sum = pq.poll() + pq.poll();
			answer += sum;
			pq.add(sum);
		}
		return answer;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		for(int i = 0; i < n; i++) {
			pq.add(Integer.valueOf(br.readLine()));
		}
		System.out.println(solution());
	}

}
