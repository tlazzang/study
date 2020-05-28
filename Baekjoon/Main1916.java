import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main1916 {
	
	public static int N, M, start, end;
	public static int[] minDistance;
	public static City[] cities;
	
	public static class City{
		ArrayList<Bus> busList = new ArrayList<>();
	}
	
	public static class Bus implements Comparable<Bus>{
		int destination;
		int cost;
		
		public Bus(int destination, int cost) {
			this.destination = destination;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Bus o) {
			// TODO Auto-generated method stub
			return this.cost - o.cost;
		}
	}
	
	public static void dijkstra() {
		minDistance = new int[N];
		Arrays.fill(minDistance, Integer.MAX_VALUE);
		PriorityQueue<Bus> pq = new PriorityQueue<>();
		minDistance[start-1] = 0;
		pq.add(new Bus(start-1, 0));
		
		while(!pq.isEmpty()) {
			Bus now = pq.poll();
			
			if(minDistance[now.destination] < now.cost) continue;
			
			for(Bus b : cities[now.destination].busList) {
				if(minDistance[b.destination] > minDistance[now.destination] + b.cost) {
					pq.add(new Bus(b.destination, minDistance[now.destination] + b.cost));
					minDistance[b.destination] = minDistance[now.destination] + b.cost;
				}
			}
		}
	}
	
	public static void solution() {
		dijkstra();
		System.out.println(minDistance[end-1]);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.valueOf(br.readLine());
		M = Integer.valueOf(br.readLine());
		cities = new City[N];
		
		for(int i = 0; i < cities.length; i++) {
			cities[i] = new City();
		}
		
		for(int i = 0; i < M; i++) {
			String[] split = br.readLine().split(" ");
			int s = Integer.valueOf(split[0]);
			int e = Integer.valueOf(split[1]);
			int c = Integer.valueOf(split[2]);
			cities[s-1].busList.add(new Bus(e-1, c));
		}
		
		String[] split = br.readLine().split(" ");
		start = Integer.valueOf(split[0]);
		end = Integer.valueOf(split[1]);
		
		solution();
	}

}
