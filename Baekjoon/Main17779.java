import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main17779 {
	
	public static int x,y,d1,d2;
	public static int[] arr = new int[4];
	public static int[][] population;
	public static int[][] area;
	public static int N;
	public static boolean[][] visited;
	public static int[] dr = {-1, 1, 0, 0};
	public static int[] dc = {0, 0, -1, 1};
	
	public static int result = Integer.MAX_VALUE;
	public static int solution() {
		pick(0);
		return result;
	}
	
	public static void pick(int picked) {
		if(picked == 4) {
			x = arr[0];
			y = arr[1];
			d1 = arr[2];
			d2 = arr[3];
			if(x >= 1 && x + d1 + d2 <= N) {
				if(y - d1 >= 1 && y > y - d1 && y < y + d2 && y + d2 <= N) {
					area = new int[N + 1][N + 1];
					setArea(0);
					result = Math.min(result, getDiffMaxAndMin());
						
				}
			}
			return;
		}
		for(int i = 1; i <= 20; i++) {
			arr[picked] = i;
			pick(picked + 1);
			arr[picked] = 0;
		}
	}
	
	public static void setArea(int p) {
		for(int i = 0; i <= d1 ; i++) {
			int row = x + i;
			int col = y - i;
			area[row][col] = 5;
		}
		
		for(int i = 0; i <= d2; i++) {
			int row = x + i;
			int col = y + i;
			area[row][col] = 5;
		}
		
		for(int i = 0; i <= d2; i++) {
			int row = x + d1 + i;
			int col = y - d1 + i;
			area[row][col] = 5;
		}
		
		for(int i = 0; i <= d1; i++) {
			int row = x + d2 + i;
			int col = y + d2 - i;
			area[row][col] = 5;
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(area[i][j] == 5) {
					boolean isFind = false;
					int idx = 0;
					for(int k = j + 1; k <= N; k++) {
						if(area[i][k] == 5) {
							isFind = true;
							idx = k;
							break;
						}
					}
					if(isFind) {
						for(int a = j; a < idx; a++) {
							area[i][a] = 5;
						}
					}
				}
			}
		}
		
		
		if(p % 2 == 0) {
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					if(area[i][j] == 5) continue;
					if(1 <= i && i < x + d1 && j >= 1 && j <= y) {
						area[i][j] = 1;
					}else if(1 <= i && i <= x + d2 && y < j && j <= N) {
						area[i][j] = 2;
					}else if(x + d1 <= i && i <= N && 1 <= j && j < y - d1 + d2) {
						area[i][j] = 3;
					}else if(x + d2 < i && i <= N && y - d1 + d2 <= j && j <= N) {
						area[i][j] = 4;
					}
				}
			}
		}
		else {
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					if(area[i][j] == 5) continue;
					if(1 <= i && i <= x + d1 && j >= 1 && j < y) {
						area[i][j] = 1;
					}else if(1 <= i && i <= x + d2 + 1 && y <= j && j <= N) {
						area[i][j] = 2;
					}else if(x + d1 + 1 <= i && i <= N && 1 <= j && j < y - d1 + d2 - 1) {
						area[i][j] = 3;
					}else if(x + d2 + 1 < i && i <= N && y - d1 + d2  - 1 <= j && j <= N) {
						area[i][j] = 4;
					}
				}
			}
		}
	}
	
	public static int getDiffMaxAndMin() {
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i = 1; i <= N ; i++) {
			for(int j = 1; j <= N ; j++) {
				if(map.containsKey(area[i][j])) {
					map.put(area[i][j], map.get(area[i][j]) + population[i][j]);
				}else {
					map.put(area[i][j], population[i][j]);
				}
			}
		}
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int n : map.values()) {
			min = Math.min(min, n);
			max = Math.max(max, n);
		}

		return max - min;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.valueOf(br.readLine());
		area = new int[N+1][N+1];
		population = new int[N+1][N+1];
		visited = new boolean[N+1][N+1];
		for(int i = 1; i <= N; i++) {
			String[] split = br.readLine().split(" ");
			for(int j = 1; j <= N; j++) {
				population[i][j] = Integer.valueOf(split[j - 1]);
			}
		}
		System.out.println(solution());
	}

}
