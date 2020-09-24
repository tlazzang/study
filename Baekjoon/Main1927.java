import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main1927 {
	
	public static void solution(int[] operand) {
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1.compareTo(o2));
		StringBuilder sb = new StringBuilder();
		for(int n : operand) {
			if(n == 0) {
				sb.append(pq.isEmpty() ? "0" : pq.poll());
				sb.append("\n");
			}else {
				pq.add(n);
			}
		}
		System.out.println(sb.toString());
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());
		int[] operand = new int[N];
		for(int i = 0; i < N; i++) {
			operand[i] = Integer.valueOf(br.readLine());
		}
		solution(operand);
	}

}
