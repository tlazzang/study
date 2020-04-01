package SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main14503 {
	
	public static int startDirection;
	public static int startRow, startCol;
	public static int[][] board;
	public static boolean[][] visited;
	public static int result = 0;
	public static int N, M;
	
	public static int solution() {
		dfs(startRow, startCol, startDirection);
		return result + 1;
	}
	
	public static void clean(int row, int col, int direction) {
		visited[row][col] = true;
		boolean canGo = false;
		
		while(true) {
			
			canGo = false;
			int nextRow = 0, nextCol = 0, nextDirection = 0;
			
			for(int i = 0; i < 4; i++) {
				switch(direction) {
					case 0:{
						nextRow = row;
						nextCol = col - 1;
						nextDirection = 3;
						break;
					}
					case 1:{
						nextRow = row - 1;
						nextCol = col;
						nextDirection = 0;
						break;
					}
					case 2:{
						nextRow = row;
						nextCol = col + 1;
						nextDirection = 1;
						break;
					}
					case 3:{
						nextRow = row + 1;
						nextCol = col;
						nextDirection = 2;
						break;
					}
				}
				
				if(board[nextRow][nextCol] == 0 && !visited[nextRow][nextCol]) {
					row = nextRow;
					col = nextCol;
					direction = nextDirection;
				
					result++;
					visited[row][col] = true;
					canGo = true;
					break;
				}
				
				direction--;
				if(direction == -1) direction = 3;
			}
			
			if(!canGo) {
				switch(direction) {
					case 0:{
						nextRow = row + 1;
						nextCol = col;
						nextDirection = direction;
						break;
					}
					case 1:{
						nextRow = row;
						nextCol = col - 1;
						nextDirection = direction;
						break;
					}
					case 2:{
						nextRow = row - 1;
						nextCol = col;
						nextDirection = direction;
						break;
					}
					case 3:{
						nextRow = row;
						nextCol = col + 1;
						nextDirection = direction;
						break;
					}
				}
				if(board[nextRow][nextCol] == 1) {
					return;
				}else {
					row = nextRow;
					col = nextCol;
					direction = nextDirection;
				}
			}
		}
	}
	
	public static void dfs(int row, int col, int direction) {
		visited[row][col] = true;
		boolean canGo = false;
		
		int nextRow = 0, nextCol = 0, nextDirection = 0;
		for(int i = 0; i < 4; i++) {
			switch(direction) {
				case 0:{
					nextRow = row;
					nextCol = col - 1;
					nextDirection = 3;
					break;
				}
				case 1:{
					nextRow = row - 1;
					nextCol = col;
					nextDirection = 0;
					break;
				}
				case 2:{
					nextRow = row;
					nextCol = col + 1;
					nextDirection = 1;
					break;
				}
				case 3:{
					nextRow = row + 1;
					nextCol = col;
					nextDirection = 2;
					break;
				}
			}

			direction--;
			if(direction == -1) direction = 3;
			if(board[nextRow][nextCol] == 0 && !visited[nextRow][nextCol]) {
				canGo = true;
				result++;
				dfs(nextRow, nextCol, nextDirection);
				break;
			}
		}
		
		if(!canGo) {
			switch(direction) {
				case 0:{
					nextRow = row + 1;
					nextCol = col;
					nextDirection = direction;
					break;
				}
				case 1:{
					nextRow = row;
					nextCol = col - 1;
					nextDirection = direction;
					break;
				}
				case 2:{
					nextRow = row - 1;
					nextCol = col;
					nextDirection = direction;
					break;
				}
				case 3:{
					nextRow = row;
					nextCol = col + 1;
					nextDirection = direction;
					break;
				}
			}
			if(board[nextRow][nextCol] == 1) {
				return;
			}else {
				dfs(nextRow, nextCol, nextDirection);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		N = Integer.valueOf(split[0]);
		M = Integer.valueOf(split[1]);
		board = new int[N][M];
		visited = new boolean[N][M];
		split = br.readLine().split(" ");
		startRow = Integer.valueOf(split[0]);
		startCol = Integer.valueOf(split[1]);
		startDirection = Integer.valueOf(split[2]);
		for(int i = 0; i < N; i++) {
			split = br.readLine().split(" ");
			for(int j = 0; j < split.length; j++) {
				board[i][j] = Integer.valueOf(split[j]);
			}
		}
		System.out.println(solution());
	}

}
