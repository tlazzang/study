import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main11286 {
	
	public static PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
			return Math.abs(o1) == Math.abs(o2) ? o1 - o2 : Math.abs(o1) - Math.abs(o2);
		}
	);
	
	public static void solution(int n) {
		if(n == 0) {
			if(pq.isEmpty()) {
				System.out.println(0);
				return;
			}
			System.out.println(pq.poll());
		}else {
			pq.add(n);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());
		for(int i = 0; i < N; i++) {
			solution(Integer.valueOf(br.readLine()));
		}
	}

}
