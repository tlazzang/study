package SummerWinterCoding;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Delivery {
	
	public static class Vertex{
		int num;
		ArrayList<Road> roadList;
		
		public Vertex(int num) {
			this.num = num;
			roadList = new ArrayList<>();
		}
	}
	
	public static class Road implements Comparable<Road> {
		int destination;
		int cost;
		
		public Road(int destination, int cost) {
			this.destination = destination;
			this.cost = cost;
		}

		@Override
		public int compareTo(Road o) {
			// TODO Auto-generated method stub
			return this.cost - o.cost;
		}

	}
	
	public static Vertex[] vertex;
	public static int[] distance;
	public static int answer = 0;
	
    public static int solution(int N, int[][] road, int K) {
        vertex = new Vertex[N+1];
        distance = new int[N+1];
        
        for(int i = 1; i < vertex.length; i++) {
        	vertex[i] = new Vertex(i);
        }
        
        for(int i = 0; i < road.length; i++) {
        	int a = road[i][0];
        	int b = road[i][1];
        	int cost = road[i][2];
        	vertex[a].roadList.add(new Road(b, cost));
        	vertex[b].roadList.add(new Road(a, cost));
        }
        
        for(int i = 1; i < distance.length; i++) {
        	distance[i] = Integer.MAX_VALUE;
        }
        
        djkstra();
        
        for(int i = 1; i < distance.length; i++) {
        	if(distance[i] <= K) answer++;
        }
        return answer;
    }
    
    public static void djkstra() {
    	PriorityQueue<Road> pq = new PriorityQueue<>();
    	pq.add(new Road(1, 0));
    	distance[1] = 0;
    	
    	while(!pq.isEmpty()) {
    		int now = pq.peek().destination;
    		int cost = pq.peek().cost;
    		pq.poll();
    		if(distance[now] < cost) continue;
    		
    		for(Road road : vertex[now].roadList) {
    			if(distance[road.destination] > cost + road.cost) {
    				distance[road.destination] = cost + road.cost;
    				pq.add(new Road(road.destination, cost + road.cost));
    			}
    		}
    	}
    }
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		int[][] road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
//		int N = 5;
//		int K = 3;
		
		int[][] road = {{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}};
		int N = 6;
		int K = 4;
		
//		int[][] road = {{1,1,50}};
//		int N = 1;
//		int K = 0;
		
		System.out.println(solution(N, road, K));
	}
	

}
