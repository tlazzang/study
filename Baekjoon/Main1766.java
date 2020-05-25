import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main1766 {
	
	public static int N, M;
	public static ArrayList<Integer>[] parentList;
	public static int[] numOfChild;
	
	public static void solution() {
		ArrayList<Integer> answer = new ArrayList<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				if(numOfChild[o1] == numOfChild[o2]) {
					return o1 - o2;
				}else {
					return numOfChild[o1] - numOfChild[o2];
				}
			}
			
		});
		
		for(int i = 1; i < numOfChild.length; i++) {
			if(numOfChild[i] == 0) pq.add(i);
		}
		
		while(!pq.isEmpty()) {
			int now = pq.poll();
			for(int next : parentList[now]) {
				numOfChild[next]--;
				if(numOfChild[next] == 0) {
					pq.add(next);
				}
			}
			answer.add(now);
		}
		
		for(int n : answer) {
			System.out.print(n + " ");
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		N = Integer.valueOf(split[0]);
		M = Integer.valueOf(split[1]);
		parentList = new ArrayList[N+1];
		numOfChild = new int[N+1];
		for(int i = 0; i < parentList.length; i++) {
			parentList[i] = new ArrayList<>();
		}
		for(int i = 0; i < M; i++) {
			split = br.readLine().split(" ");
			int a = Integer.valueOf(split[0]);
			int b = Integer.valueOf(split[1]);
			parentList[a].add(b);
			numOfChild[b]++;
		}
		solution();
	}

}
