package SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1018 {
	
	public static int N, M;
	public static char[][] board;
	public static int min = Integer.MAX_VALUE;
	
	public static int solution() {
		for(int c = 0; c <= N - 8; c++) {
			for(int k = 0; k <= M - 8; k++) {
				min = Math.min(min, getRepaintCnt(c, k));
			}
		}
		return min;
	}
	
	public static int getRepaintCnt(int row, int col) {
		int cnt = 0;
		int min = Integer.MAX_VALUE;
		for(int k = 0; k < 2; k++) {
			char prev = (k == 0) ? 'W' : 'B';
			cnt = (prev == board[row][col]) ? 0 : 1;
			for(int i = row; i < row + 8; i++) {
				for(int j = col; j < col + 8; j++) {
					if(i == row && j == col) {
						continue;
					}
					if(j == col) {
						if(prev != board[i][j]) {
							cnt++;
						}
						continue;
					}
					
					if(prev == board[i][j]) {
						cnt++;
					}
					prev = (prev == 'W') ? 'B' : 'W';
				}
			}			
			min = Math.min(min, cnt);
		}
		return min;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		N = Integer.valueOf(split[0]);
		M = Integer.valueOf(split[1]);
		board = new char[N][M];
		for(int i = 0; i < N; i++) {
			board[i] = br.readLine().toCharArray();
		}
		System.out.println(solution());
	}

}
