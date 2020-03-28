package SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main1987 {
	
	public static char[][] board;
	public static boolean[][] visited;
	public static HashMap<Character, Boolean> map = new HashMap<>();
	public static int result = Integer.MIN_VALUE;
	public static int[] dr = {-1, 1, 0, 0};
	public static int[] dc = {0, 0, -1, 1};
	public static int solution() {
		dfs(0, 0, 1);
		return result;
	}
	
	public static void dfs(int row, int col, int cnt) {
		result = Math.max(result, cnt);
		map.put(board[row][col], true);
		visited[row][col] = true;
		
		for(int i = 0; i < 4; i++) {
			int nextRow = row + dr[i];
			int nextCol = col + dc[i];
			if(nextRow >= 0 && nextRow < board.length && nextCol >= 0 && nextCol < board[0].length) {
				if(!map.containsKey(board[nextRow][nextCol]) && !visited[nextRow][nextCol]) {
					dfs(nextRow, nextCol, cnt + 1);
				}
			}
		}
		
		map.remove(board[row][col]);
		visited[row][col] = false;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		int row = Integer.valueOf(split[0]);
		int col = Integer.valueOf(split[1]);
		board = new char[row][col];
		visited = new boolean[row][col];
		for(int i = 0; i < row; i++) {
			board[i] = br.readLine().toCharArray();
		}
		System.out.println(solution());
	}

}
