import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Main2623 {
	
	public static int N, M;
	public static int[] inputDegree;
//	public static HashSet<Integer>[] previousSet;
	public static ArrayList<Integer>[] nextList;
	public static ArrayList<Integer> resultList = new ArrayList<>();
	
	public static void solution() {
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return inputDegree[o1] - inputDegree[o2];
			}
			
		});
		for(int i = 0; i < inputDegree.length; i++) {
			if(inputDegree[i] == 0) {
				pq.add(i);
			}
		}
		
		while(!pq.isEmpty()) {
			int now = pq.poll();
			resultList.add(now);
			
			for(int next : nextList[now]) {
				inputDegree[next]--;
				if(inputDegree[next] == 0) {
					pq.add(next);
				}
			}
		}
		
		for(int n : resultList) {
			System.out.println(n + 1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		N = Integer.valueOf(split[0]);
		M = Integer.valueOf(split[1]);
		inputDegree = new int[N];
		nextList = new ArrayList[N];
		
		for(int i = 0 ; i < N; i++) {
			nextList[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < M; i++) {
			split = br.readLine().split(" ");
			for(int j = 1; j < split.length - 1; j++) {
				int a = Integer.valueOf(split[j]);
				int b = Integer.valueOf(split[j+1]);
				nextList[a-1].add(b-1);
				inputDegree[b-1]++;
			}
		}
		
		solution();
	}

}
