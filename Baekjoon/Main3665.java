import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main3665 {
	
	public static int[] inputDegree;
	public static ArrayList<Integer>[] nextList;
	public static ArrayList<Integer> result;
	public static int N;
	
	public static void solution() {
		result = new ArrayList<>();
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i = 0; i < inputDegree.length; i++) {
			if(inputDegree[i] == 0) {
				queue.add(i);
			}
		}
		
		int loopCnt = 0;
		while(!queue.isEmpty()) {
			if(queue.size() > 1) {
				System.out.println("?");
				return;
			}
			loopCnt++;
			int now = queue.poll();
			result.add(now);
			
			for(int next : nextList[now]) {
				inputDegree[next]--;
				if(inputDegree[next] == 0) {
					queue.add(next);
				}
			}
			
		}
		
		if(loopCnt != N) {
			System.out.println("IMPOSSIBLE");
			return;
		}
		
		for(int n : result) {
			System.out.print(n+1 + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.valueOf(br.readLine());
		for(int i = 0; i < T; i++) {
			N = Integer.valueOf(br.readLine());
			
			inputDegree = new int[N];
			nextList = new ArrayList[N];
			for(int k = 0; k < N; k++) {
				nextList[k] = new ArrayList<>();
			}
			
			String[] split = br.readLine().split(" ");
			for(int j = 0; j < split.length; j++) {
				int a = Integer.valueOf(split[j]);
				for(int k = j + 1; k < split.length; k++) {
					int b = Integer.valueOf(split[k]);
					nextList[a-1].add(b-1);
					inputDegree[b-1]++;
				}
			}
			
			int M = Integer.valueOf(br.readLine());
			for(int k = 0; k < M; k++) {
				split = br.readLine().split(" ");
				int a = Integer.valueOf(split[0]);
				int b = Integer.valueOf(split[1]);
				if(nextList[a-1].contains(Integer.valueOf(b-1))) {
					nextList[b-1].add(a-1);
					nextList[a-1].remove(Integer.valueOf(b-1));
					inputDegree[a-1]++;
					inputDegree[b-1]--;
				}else {
					nextList[a-1].add(b-1);
					nextList[b-1].remove(Integer.valueOf(a-1));
					inputDegree[b-1]++;
					inputDegree[a-1]--;
				}
			}
			solution();
		}
	}

}
