import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main13913 {

	public static int min = Integer.MAX_VALUE;
	public static int subin, brother;
	public static int[] map = new int[100001];
	public static int[] parent = new int[100001];
	public static boolean[] visited = new boolean[100001];
	public static int depth = 0;
	
	public static void solution() {
		bfs(subin);
	}
	
	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			
			if(now == brother) {
				System.out.println(map[now]);
				
		        Stack<Integer> stack = new Stack<>();
		        stack.push(brother);
		        int index = brother;

		        while (index != subin) {
		            stack.push(parent[index]);
		            index = parent[index];
		        }
		        
		        StringBuilder sb = new StringBuilder();
		        while (!stack.isEmpty()) {
		            sb.append(stack.pop() + " ");
		        }

		        System.out.println(sb.toString());
				return;
			}
			
			int next = now + 1;
			if(rangeCheck(next) && !visited[next]) {
				map[next] = map[now] + 1;
				parent[next] = now;
				StringBuilder newSb = new StringBuilder();
				queue.add(next);
				visited[next] = true;
			}
			
			next = now - 1;
			if(rangeCheck(next) && !visited[next]) {
				map[next] = map[now] + 1;
				parent[next] = now;
				queue.add(next);
				visited[next] = true;
			}
			
			next = now * 2;
			if(rangeCheck(next) && !visited[next]) {
				map[next] = map[now] + 1;
				parent[next] = now;
				queue.add(next);
				visited[next] = true;
			}
		}
	}
	
	public static boolean rangeCheck(int n) {
		return n >= 0 && n < map.length;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		subin = Integer.valueOf(split[0]);
		brother = Integer.valueOf(split[1]);
		solution();
	}

}
