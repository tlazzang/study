import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main1655 {
	
	public static PriorityQueue<Integer> min_pq = new PriorityQueue<>((a,b) -> a - b);
	public static PriorityQueue<Integer> max_pq = new PriorityQueue<>((a,b) -> b - a);

	public static ArrayList<Integer> list = new ArrayList<>();
	public static void solution(int n) {
		
		if(min_pq.size() == max_pq.size()) {
			max_pq.add(n);
		}else {
			min_pq.add(n);
		}
		
		if(!min_pq.isEmpty() && max_pq.peek() < min_pq.peek()) {
			min_pq.add(max_pq.poll());
			max_pq.add(min_pq.poll());
		}
		
		System.out.println(max_pq.peek());
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
