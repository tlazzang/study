import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main1753 {
	
	public static int V, E, start;
	public static Vertex[] vertex;
	public static int[] minDistance;
	
	public static class Edge implements Comparable<Edge>{
		int destination;
		int weight;
		
		public Edge(int destination, int weight) {
			this.destination = destination;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}
	}
	
	public static class Vertex{
		int num;
		ArrayList<Edge> edgeList = new ArrayList<>();
		public Vertex(int num) {
			this.num = num;
		}
	}
	
	public static void solution() {
		dijkstra();
		
		for(int n : minDistance) {
			if(n == Integer.MAX_VALUE) {
				System.out.println("INF");
			}else {
				System.out.println(n);
			}
		}
	}
	
	public static void dijkstra() {
		minDistance = new int[V];
		for(int i = 0; i < minDistance.length; i++) {
			minDistance[i] = Integer.MAX_VALUE;
		}
		
		minDistance[0] = 0;
		PriorityQueue<Edge> queue = new PriorityQueue<>();
		queue.add(new Edge(0, 0));
		
		while(!queue.isEmpty()) {
			Edge edge = queue.poll();
			int now = edge.destination;
			int weight = edge.weight;
			
			if(minDistance[now] < weight) continue;
			
			for(Edge e : vertex[now].edgeList) {
				if(minDistance[e.destination] > minDistance[now] + e.weight) {
					queue.add(e);
					minDistance[e.destination] = minDistance[now] + e.weight;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		V = Integer.valueOf(split[0]);
		E = Integer.valueOf(split[1]);
		start = Integer.valueOf(br.readLine());
		
		vertex = new Vertex[V];
		for(int i = 0; i < vertex.length; i++) {
			vertex[i] = new Vertex(i-1);
		}
		for(int i = 0; i < E; i++) {
			split = br.readLine().split(" ");
			int u = Integer.valueOf(split[0]);
			int v = Integer.valueOf(split[1]);
			int w = Integer.valueOf(split[2]);
			vertex[u-1].edgeList.add(new Edge(v-1, w));
		}
		solution();
	}

}
