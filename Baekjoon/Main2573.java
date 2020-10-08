import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main2573 {
	
	public static class Pair{
		int row;
		int col;
		
		public Pair(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
	public static int[][] map;
	public static int[][] tmpMap;
	public static boolean[][] visited;
	
	public static int[] dr = {-1, 1, 0, 0};
	public static int[] dc = {0, 0, -1, 1};
	
	public static int solution() {
		int answer = 0;
		while(true) {
//			printMap();
//			if(answer == 2) break;
			int numOfIceberg = 0;
			tmpMap = new int[map.length][map[0].length];
			visited = new boolean[map.length][map[0].length];
			
			for(int i = 1; i < map.length - 1; i++) {
				for(int j = 1; j < map[0].length - 1; j++) {
					if(map[i][j] > 0 && !visited[i][j]) {
						numOfIceberg++;
						dfs(i,j);
					}
				}
			}
			
			if(numOfIceberg >= 2 || numOfIceberg == 0) {
				break;
			}
			
			melt();
			answer++;
		}
		return answer;
	}
	
	public static void melt() {
		for(int i = 0; i < map.length; i++) {
			tmpMap[i] = Arrays.copyOf(map[i], map[i].length);
		}
		
		for(int i = 1; i < map.length - 1; i++) {
			for(int j = 1 ; j < map[0].length - 1; j++) {
				
				if(map[i][j] == 0) continue;
				
				int numOfNearSeaWater = 0;
				
				for(int k = 0; k < 4; k++) {
					int nextRow = i + dr[k];
					int nextCol = j + dc[k];
					if(map[nextRow][nextCol] == 0) numOfNearSeaWater++;
				}
				
				if(map[i][j] - numOfNearSeaWater < 0) {
					map[i][j] = 0;
				}else {
					map[i][j] -= numOfNearSeaWater;
				}
				
				if(tmpMap[i][j] - numOfNearSeaWater < 0) {
					tmpMap[i][j] = 0;
				}else {
					tmpMap[i][j] -= numOfNearSeaWater;
				}
				
			}
		}
		
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[0].length; j++) {
				map[i][j] = tmpMap[i][j];
			}
		}
	}
	
	public static void printMap() {
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void dfs(int row, int col) {
		
//		System.out.println(row + ", " + col);
		
		visited[row][col] = true;
		
		for(int i = 0; i < 4; i++) {
			int nextRow = row + dr[i];
			int nextCol = col + dc[i];
			if(map[nextRow][nextCol] > 0 && !visited[nextRow][nextCol]) {
				dfs(nextRow, nextCol);
			}
		}
	}
	
	public static void bfs(Pair start) {
		Queue<Pair> queue = new LinkedList<>();
		visited[start.row][start.col] = true;
		queue.add(start);
		
		while(!queue.isEmpty()) {
			Pair now = queue.poll();
			for(int i = 0; i < 4; i++) {
				int nextRow = now.row + dr[i];
				int nextCol = now.col + dc[i];
				if(map[nextRow][nextCol] > 0 && !visited[nextRow][nextCol]) {
					queue.add(new Pair(nextRow, nextCol));
					visited[nextRow][nextCol] = true;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		int rowLength = Integer.valueOf(split[0]);
		int colLength = Integer.valueOf(split[1]);
		map = new int[rowLength][colLength];
		visited = new boolean[rowLength][colLength];
		for(int i = 0; i < rowLength; i++) {
			split = br.readLine().split(" ");
			for(int j = 0; j < colLength; j++) {
				map[i][j] = Integer.valueOf(split[j]);
			}
		}
		System.out.println(solution());
	}

}
