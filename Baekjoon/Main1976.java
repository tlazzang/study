import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main1976 {
	
	public static int[][] adj;
	public static boolean[] visited;
	
	public static void solution(int[] visitList) {
		for(int i = 0; i < visitList.length - 1; i++) {
			if(!isExistPath(visitList[i]-1, visitList[i+1]-1)){
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}
	
	public static boolean isExistPath(int from, int to) {
		visited = new boolean[adj.length];
		Queue<Integer> queue = new LinkedList<>();
		visited[from] = true;
		queue.add(from);
		while(!queue.isEmpty()) {
			int now = queue.poll();
			
			if(now == to) return true;
			
			for(int j = 0; j < adj[0].length; j++) {
				if(adj[now][j] == 1 && !visited[j]) {
					visited[j] = true;
					queue.add(j);
				}
			}
		}
		return false;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());
		int M = Integer.valueOf(br.readLine());
		adj = new int[N][N];
		for(int i = 0; i < N; i++) {
			String[] split = br.readLine().split(" ");
			for(int j = 0; j < N; j++) {
				adj[i][j] = Integer.valueOf(split[j]);
			}
		}
		int[] visitList = new int[M];
		String[] split = br.readLine().split(" ");
		for(int i = 0; i < M ; i++) {
			visitList[i] = Integer.valueOf(split[i]);
		}
		solution(visitList);
	}

}
