import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main4963 {
	
	public static int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
	public static int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};
	public static boolean[][] visited;
	public static int[][] map;
	
	public static int solution() {
		int answer = 0;
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[0].length; j++) {
				if(!visited[i][j] && map[i][j] == 1) {
					dfs(i, j);
					answer++;
				}
			}
		}
		return answer;
	}
	
	public static void dfs(int row, int col) {
		visited[row][col] = true;
		
		for(int i = 0; i < 8; i++) {
			int nextRow = row + dr[i];
			int nextCol = col + dc[i];
			if(rangeCheck(nextRow, nextCol) && !visited[nextRow][nextCol] && map[nextRow][nextCol] == 1) {
				dfs(nextRow, nextCol);
			}
		}
	}
	
	public static boolean rangeCheck(int row, int col) {
		return row >= 0 && row < map.length && col >= 0 && col < map[0].length;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String[] split = br.readLine().split(" ");
			int w = Integer.valueOf(split[0]);
			int h = Integer.valueOf(split[1]);
			
			if(w == 0 && h == 0) break;
			
			map = new int[h][w];
			visited = new boolean[h][w];
			
			for(int i = 0; i < h; i++) {
				split = br.readLine().split(" ");
				for(int j = 0; j < w; j++) {
					map[i][j] = Integer.valueOf(split[j]);
				}
			}
			
			System.out.println(solution());
		}
	}

}
