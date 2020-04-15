import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main15684 {
	
	public static int N, M, H;
	public static int[][] ladder;
	public static int answer = Integer.MAX_VALUE;
	
	public static int solution() {
		for(int i = 0; i <= 3; i++) {
			dfs(0, 1, 0, i);
			if(answer != Integer.MAX_VALUE) break;
		}
		return answer == Integer.MAX_VALUE ? -1 : answer;
	}
	
	public static void dfs(int row, int col, int picked, int cnt) {
		
		if(picked == cnt) {
			if(check()) {
				System.out.println(picked);
				System.exit(0);
				answer = picked;
			}
			return;
		}

		for(int j = col; j < ladder[0].length - 1; j++) {
			for(int i = row; i < ladder.length; i++) {
				if(j == 0) continue;
				if(ladder[i][j] == 0 && ladder[i][j - 1] != j && ladder[i][j + 1] == 0) {
					ladder[i][j] = j + 1;
					ladder[i][j + 1] = j;	
					dfs(i, j, picked + 1, cnt);
					ladder[i][j] = 0;
					ladder[i][j + 1] = 0;
				}
			}
            row = 0;
		}

	}
	
	public static boolean check() {
		boolean result = true;
		for(int j = 1; j < ladder[0].length; j++) {
			int now = j;
			for(int i = 0; i < ladder.length; i++) {
				if(ladder[i][now] != 0) {
					now = ladder[i][now];
				}
			}
			if(now != j) return false;
		}

		return result;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		N = Integer.valueOf(split[0]);
		M = Integer.valueOf(split[1]);
		H = Integer.valueOf(split[2]);
		ladder = new int[H][N+1];
		for(int i = 0; i < M; i++) {
			split = br.readLine().split(" ");
			int a = Integer.valueOf(split[0]);
			int b = Integer.valueOf(split[1]);
			ladder[a-1][b] = b + 1;
			ladder[a-1][b+1] = b;
		}
		System.out.println(solution());
	}

}
