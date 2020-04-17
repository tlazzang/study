import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main16234 {
	public static class Pair{
		int row;
		int col;
		public Pair(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	public static int N, L, R;
	public static boolean[][] visited;
	public static boolean[][][][] border;
	public static int[][] map;
	public static int answer = 0;
	public static int[] dr = {-1, 1, 0, 0};
	public static int[] dc = {0, 0, -1, 1};
	public static ArrayList<Pair> unionList = new ArrayList<>();
	public static int sum = 0;
	public static boolean flag = false;
	
	public static int solution() {
		while(true) {
			flag = false;
			visited = new boolean[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(!visited[i][j]) {
						dfs(i,j);
						int population = sum / unionList.size();
						for(Pair p : unionList) {
							map[p.row][p.col] = population;
						}
						sum = 0;
						unionList = new ArrayList<>();
					}
				}
			}
			if(!flag) break;
			answer++;
		}
		return answer;
	}
	
	public static void dfs(int row, int col) {
		sum = sum + map[row][col];
		unionList.add(new Pair(row, col));
		visited[row][col] = true;
		
		for(int i = 0; i < 4; i++) {
			int nextRow = row + dr[i];
			int nextCol = col + dc[i];
			if(rangeCheck(nextRow, nextCol) && !visited[nextRow][nextCol]) {
				int diff = Math.abs(map[row][col] - map[nextRow][nextCol]);
				if(diff >= L && diff <= R) {
					dfs(nextRow, nextCol);
					flag = true;
				}
			}
		}
	}
	
	public static boolean rangeCheck(int row, int col) {
		return row >= 0 && row < N && col >= 0 && col < N;
	}
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		N = Integer.valueOf(split[0]);
		L = Integer.valueOf(split[1]);
		R = Integer.valueOf(split[2]);
		map = new int[N][N];
		visited = new boolean[N][N];
		border = new boolean[N][N][N][N];
		for(int i = 0; i < N; i++) {
			split = br.readLine().split(" ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.valueOf(split[j]);
			}
		}
		System.out.println(solution());
	}

}
