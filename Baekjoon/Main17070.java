import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main17070 {
	
	public static int[][] map;
	public static int answer = 0;
	
	public static final int HORIZONTAL = 0;
	public static final int VERTICAL = 1;
	public static final int CROSS = 2;
	
	public static int solution() {
		dfs(0, 0, HORIZONTAL);
		return answer;
	}
	
	public static void dfs(int row, int col, int direction) {
		if(direction == HORIZONTAL) {
			if(row == map.length-1 && col == map[0].length-1 || row == map.length-1 && col + 1 == map[0].length-1) {
				answer++;
			}
		}else if(direction == VERTICAL) {
			if(row == map.length-1 && col == map[0].length-1 || row+1 == map.length-1 && col == map[0].length-1) {
				answer++;
			}
		}else {
			if(row == map.length-1 && col == map[0].length-1 || row + 1 == map.length-1 && col + 1 == map[0].length-1) {
				answer++;
			}
		}
			
		int nextRow, nextCol, nextDirection;
		switch(direction) {
			case HORIZONTAL:{
				nextRow = row;
				nextCol = col+1;
				nextDirection = HORIZONTAL;
				if(rangeCheck(nextRow, nextCol, nextDirection)) {
					dfs(nextRow, nextCol, nextDirection);
				}
				
				nextRow = row;
				nextCol = col+1;
				nextDirection = CROSS;
				if(rangeCheck(nextRow, nextCol, nextDirection)) {
					dfs(nextRow, nextCol, nextDirection);
				}
				break;
			}
			case VERTICAL:{
				nextRow = row + 1;
				nextCol = col;
				nextDirection = VERTICAL;
				if(rangeCheck(nextRow, nextCol, nextDirection)) {
					dfs(nextRow, nextCol, nextDirection);
				}
				
				nextRow = row + 1;
				nextCol = col;
				nextDirection = CROSS;
				if(rangeCheck(nextRow, nextCol, nextDirection)) {
					dfs(nextRow, nextCol, nextDirection);
				}
				break;
			}
			case CROSS:{
				nextRow = row + 1;
				nextCol = col + 1;
				nextDirection = HORIZONTAL;
				if(rangeCheck(nextRow, nextCol, nextDirection)) {
					dfs(nextRow, nextCol, nextDirection);
				}
				
				nextRow = row + 1;
				nextCol = col + 1;
				nextDirection = VERTICAL;
				if(rangeCheck(nextRow, nextCol, nextDirection)) {
					dfs(nextRow, nextCol, nextDirection);
				}
				
				nextRow = row + 1;
				nextCol = col + 1;
				nextDirection = CROSS;
				if(rangeCheck(nextRow, nextCol, nextDirection)) {
					dfs(nextRow, nextCol, nextDirection);
				}
				break;
			}
		}
	}
	
	public static boolean rangeCheck(int row, int col, int direction) {
		int nextRow, nextCol;
		if(direction == HORIZONTAL) {
			nextRow = row;
			nextCol = col + 1;
		}else if(direction == VERTICAL) {
			nextRow = row + 1;
			nextCol = col;
		}else {
			nextRow = row + 1;
			nextCol = col + 1;
			if(0 <= nextRow && nextRow < map.length && 0 <= nextCol && nextCol < map[0].length) {
				if(map[nextRow][nextCol] == 1 || map[nextRow][nextCol - 1] == 1 || map[nextRow - 1][nextCol] == 1) {
					return false;
				}
			}
		}
		return 0 <= nextRow && nextRow < map.length && 0 <= nextCol && nextCol < map[0].length && map[nextRow][nextCol] != 1;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());
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
