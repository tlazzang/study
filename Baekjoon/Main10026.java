package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main10026 {
	int[][] map;
	boolean visited[][];
	int nowColor;
	int[] dx = {-1, 1, 0, 0};
	int[] dy = {0, 0, -1, 1};
	public int solution(int[][] map) {
		this.map = map;
		this.visited = new boolean[map.length][map.length];
		int answer = 0;
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map.length; j++) {
				if(!visited[i][j]) {
					nowColor = map[i][j];
					answer++;
					dfs(i,j);
				}
			}
		}
		return answer;
	}
	
	public void dfs(int row, int col) {
		visited[row][col] = true;
		for(int i = 0; i < 4; i++) {
			int nextRow = row + dx[i];
			int nextCol = col + dy[i];
			if(nextRow >=0 && nextRow < map.length && nextCol >= 0 && nextCol < map.length) {
				if(!visited[nextRow][nextCol] && map[nextRow][nextCol] == nowColor) {
					dfs(nextRow, nextCol);
				}
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		Main10026 m = new Main10026();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] normal = new int[N][N];
		int[][] abnormal = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			for(int j = 0; j < N; j++) {
				if(line.charAt(j) == 'R') {
					normal[i][j] = 0;
					abnormal[i][j] = 0;
				}
				if(line.charAt(j) == 'G') {
					normal[i][j] = 1;
					abnormal[i][j] = 0;
				}
				if(line.charAt(j) == 'B') {
					normal[i][j] = 2;
					abnormal[i][j] = 1;
				}
			}
		}
		
		System.out.print(m.solution(normal)+" ");
		System.out.print(m.solution(abnormal));

	}

}
