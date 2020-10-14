import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2468 {
	
	public static int[][] map;
	public static boolean[][] isSafe;
	public static boolean[][] visited;
	public static int N;
	
	public static int[] dr = {-1,1,0,0};
	public static int[] dc = {0,0,-1,1};
	
	public static int solution() {
		int max = 1;
		
		for(int k = 1; k <= 100; k++) {
			isSafe = new boolean[N][N];
			visited = new boolean[N][N];
			int numOfSafeArea = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] > k) isSafe[i][j] = true;
					else isSafe[i][j] = false;
				}
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(isSafe[i][j] && !visited[i][j]) {
						dfs(i, j);
						numOfSafeArea++;
					}
				}
			}
			
			max = Math.max(max, numOfSafeArea);
		}
		
		return max;
	}
	
	public static void dfs(int row, int col) {
		visited[row][col] = true;
		
		for(int i = 0; i < 4; i++) {
			int nextRow = row + dr[i];
			int nextCol = col + dc[i];
			if(rangeCheck(nextRow, nextCol) && isSafe[nextRow][nextCol] && !visited[nextRow][nextCol]) {
				dfs(nextRow, nextCol);
			}
		}
	}
	
	public static boolean rangeCheck(int row, int col) {
		return row >= 0 && row < map.length && col >= 0 && col < map[0].length;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.valueOf(br.readLine());
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			String[] split = br.readLine().split(" ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.valueOf(split[j]);
			}
		}
		System.out.println(solution());
	}

}
