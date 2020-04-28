import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main17822 {
	
	public static int[] dr = {-1, 1, 0, 0};
	public static int[] dc = {0, 0, -1, 1};
	
	public static int[][] map;
	public static boolean[][] visited;
	public static int[][] T;
	public static int N, M;
	
	public static final int CLOCK_WISE = 0;
	public static final int COUNTER_CLOCK_WISE = 1;
	
	public static boolean isExistAdjNumber = false;
	public static boolean flag = false;
	public static int solution() {
		rotateTest(map[1]);
		for(int t = 0; t < T.length; t++) {
			flag = false;
			visited = new boolean[N+1][M+1];
			rotate(T[t][0], T[t][1], T[t][2]);
			
			for(int i = 1; i < N + 1; i++) {
				for(int j = 1; j < M + 1; j++) {
					if(map[i][j] != 0 && !visited[i][j]) {
						isExistAdjNumber = false;
						dfs(i, j);
						if(isExistAdjNumber) flag = true;
					}
				}
			}
			
			if(!flag) {
				plusOrMinus();
			}
		}
		return getSum();
	}
	
	public static void dfs(int row, int col) {
		visited[row][col] = true;
		
		for(int i = 0; i < 4; i++) {
			int nextRow = row + dr[i];
			int nextCol = col + dc[i];

			if(nextRow == 0) {
				continue;
			}
			if(nextRow == N + 1) {
				continue;
			}
			
			if(nextCol == 0) {
				nextCol = M;
			}
			if(nextCol == M + 1) {
				nextCol = 1;
			}
			
			if(!visited[nextRow][nextCol] && map[row][col] == map[nextRow][nextCol]) {
				isExistAdjNumber = true;
				dfs(nextRow, nextCol);
			}
		}
		
		if(isExistAdjNumber) {
			map[row][col] = 0;
		}
	}
	
	public static int getSum() {
		int result = 0;
		for(int i = 1; i < N + 1; i++) {
			for(int j = 1; j < M + 1; j++) {
				if(map[i][j] != 0) result += map[i][j];
			}
		}
		return result;
	}
	
	public static void plusOrMinus() {
		int sum = 0;
		int cnt = 0;
		for(int i = 1; i < N + 1; i++) {
			for(int j = 1; j < M + 1; j++) {
				if(map[i][j] != 0) {
					sum += map[i][j];
					cnt++;
				}
			}
		}
		
		if(cnt > 0) {
			double avg = (double)sum / cnt;
			for(int i = 1; i < N + 1; i++) {
				for(int j = 1; j < M + 1; j++) {
					if(map[i][j] != 0) {
						if(map[i][j] > avg) {
							map[i][j]--;
						}else if(map[i][j] < avg) {
							map[i][j]++;
						}
					}
				}
			}
		}
	}
	
	public static void rotate(int x, int direction, int k) {
		for(int i = 1; i < N + 1; i++) {
			if(i % x != 0) continue;
			for(int c = 0; c < k; c++) {
				if(direction == CLOCK_WISE) {
					int last = map[i][map[i].length - 1];
					for(int j = map[i].length - 1; j >= 2; j--) {
						map[i][j] = map[i][j - 1];
					}
					map[i][1] = last;
				}
				if(direction == COUNTER_CLOCK_WISE) {
					int first = map[i][1];
					for(int j = 1; j < map[i].length - 1; j++) {
						map[i][j] = map[i][j + 1];
					}
					map[i][map[i].length - 1] = first;
				}
			}
		}
	}
	
	public static void rotateTest(int[] arr) {
		int last = arr[arr.length - 1];
		for(int j = arr.length - 1; j >= 2; j--) {
			arr[j] = arr[j - 1];
		}
		arr[1] = last;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		N = Integer.valueOf(split[0]);
		M = Integer.valueOf(split[1]);
		int numOfT = Integer.valueOf(split[2]);
		map = new int[N + 1][M + 1];
		visited = new boolean[N + 1][M + 1];
		T = new int[numOfT][3];
		for(int i = 1; i < N + 1; i++) {
			split = br.readLine().split(" ");
			for(int j = 1; j < M + 1; j++) {
				map[i][j] = Integer.valueOf(split[j-1]);
			}
		}
		for(int i = 0; i < T.length; i++) {
			split = br.readLine().split(" ");
			T[i][0] = Integer.valueOf(split[0]);
			T[i][1] = Integer.valueOf(split[1]);
			T[i][2] = Integer.valueOf(split[2]);
		}
		System.out.println(solution());
	}

}
