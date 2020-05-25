import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Main2252 {
	
	public static HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
	public static ArrayList<Integer> order = new ArrayList<>();
	public static int[] numOfChild;
	public static void solution(int N, int M) {
		Queue<Integer> queue = new LinkedList<>();
		
		for(int key : map.keySet()) {
			if(numOfChild[key] == 0) {
				queue.add(key);
			}
		}
		
		for(int i = 0; i < N; i++) {
			int key = queue.poll();
			for(int n : map.get(key)) {
				numOfChild[n]--;
				if(numOfChild[n] == 0) {
					queue.add(n);
				}
			}
			order.add(key);
		}
	
		for(int n : order) {
			System.out.print(n + " ");
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		int N = Integer.valueOf(split[0]);
		int M = Integer.valueOf(split[1]);
		
		for(int i = 1; i <= N; i++) {
			map.put(i, new ArrayList<>());
		}
		
		numOfChild = new int[N + 1];
		
		for(int i = 0; i < M; i++) {
			split = br.readLine().split(" ");
			int a = Integer.valueOf(split[0]);
			int b = Integer.valueOf(split[1]);
			map.get(a).add(b);
			numOfChild[b]++;
		}
		
		solution(N, M);
	}

}
