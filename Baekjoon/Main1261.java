import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main1261 {
	
	public static int N, M;
	public static int[][] map;
	public static int[][] minDistance;
	public static int[] dr = {-1, 1, 0, 0};
	public static int[] dc = {0, 0, -1, 1};
	
	public static class Room implements Comparable<Room>{
		int row;
		int col;
		int numOfWall;
		
		public Room(int row, int col, int numOfWall) {
			this.row = row;
			this.col = col;
			this.numOfWall = numOfWall;
		}

		@Override
		public int compareTo(Room o) {
			// TODO Auto-generated method stub
			return this.numOfWall - o.numOfWall;
		}
	}
	
	public static int solution() {
		dijkstra();
		return minDistance[M-1][N-1];
	}
	
	public static void dijkstra() {
		for(int i = 0; i < minDistance.length; i++) {
			Arrays.fill(minDistance[i], Integer.MAX_VALUE);
		}
		
		PriorityQueue<Room> pq = new PriorityQueue<>();
		pq.add(new Room(0, 0, 0));
		minDistance[0][0] = 0;
		
		while(!pq.isEmpty()) {
			Room now = pq.poll();
			
			if(minDistance[now.row][now.col] < now.numOfWall) continue;
			
			for(int i = 0; i < 4; i++) {
				int nextRow = now.row + dr[i];
				int nextCol = now.col + dc[i];
				if(rangeCheck(nextRow, nextCol)) {
					int nextNumOfWall = map[nextRow][nextCol] == 1 ? 1 : 0;
					nextNumOfWall += now.numOfWall;
					if(minDistance[nextRow][nextCol] > nextNumOfWall) {
						minDistance[nextRow][nextCol] = nextNumOfWall;
						pq.add(new Room(nextRow, nextCol, nextNumOfWall));
					}
				}
			}
		}
	}
	
	public static boolean rangeCheck(int row, int col) {
		return row >= 0 && row < M && col >= 0 && col < N;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		N = Integer.valueOf(split[0]);
		M = Integer.valueOf(split[1]);
		map = new int[M][N];
		minDistance = new int[M][N];
		
		for(int i = 0; i < M; i++) {
			split = br.readLine().split("");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.valueOf(split[j]);
			}
		}
		
		System.out.println(solution());
	}

}
