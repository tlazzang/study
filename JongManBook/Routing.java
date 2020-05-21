import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Routing {
	
	public static class Vertex{
		ArrayList<Edge> adjList;
		
		public Vertex() {
			adjList = new ArrayList<>();
		}
	}
	
	public static class Edge implements Comparable<Edge>{
		int destination;
		double cost;
		
		public Edge(int destination, double cost) {
			this.destination = destination;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Double.compare(this.cost, o.cost);
		}
	}
	
	public static double[] distance;
	public static int T, N, M;
	public static Vertex[] vertex;
	
	public static double solution(){
		distance = new double[N];
		dijkstra();
		return distance[distance.length - 1];
	}
	
	public static void dijkstra() {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(0, 1));
		distance[0] = 1;
		
		for(int i = 1; i < distance.length; i++) {
			distance[i] = Double.MAX_VALUE;
		}
		
		while(!pq.isEmpty()) {
			int now = pq.peek().destination;
			double cost = pq.peek().cost;
			pq.poll();
			if(distance[now] < cost) continue;
			
			for(Edge edge : vertex[now].adjList) {
				if(distance[edge.destination] > cost * edge.cost) {
					distance[edge.destination] = cost * edge.cost;
					pq.add(new Edge(edge.destination, cost * edge.cost));
				}
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.valueOf(br.readLine());
		for(int i = 0; i < T; i++) {
			String[] split = br.readLine().split(" ");
			N = Integer.valueOf(split[0]);
			M = Integer.valueOf(split[1]);
			
			vertex = new Vertex[N];
			for(int l = 0; l < vertex.length; l++) {
				vertex[l] = new Vertex();
			}
			
			for(int k = 0; k < M; k++) {
				split = br.readLine().split(" ");
				int a = Integer.valueOf(split[0]);
				int b = Integer.valueOf(split[1]);
				double c = Double.valueOf(split[2]);
				vertex[a].adjList.add(new Edge(b, c));
				vertex[b].adjList.add(new Edge(a, c));
			}
			
			System.out.printf("%.10f\n", solution());
		}
	}

}
