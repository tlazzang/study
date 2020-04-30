import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main12100 {
	
	public static int[][] originalMap;
	public static int[][] tmpMap;
	
	public static boolean[][] visited;
	public static int[] directions = new int[5];
	
	public static final int UP = 1;
	public static final int DOWN = 2;
	public static final int LEFT = 3;
	public static final int RIGHT = 4;
	
	public static int[] dr = {0, -1, 1, 0, 0};
	public static int[] dc = {0, 0, 0, -1, 1};

	public static int answer = Integer.MIN_VALUE;
	
	public static int solution() {
		perm(4, 5, 0);
		return answer;
	}
	
	public static void perm(int n, int r, int depth) {
		if(depth == r) {
			tmpMap = copyMap(originalMap);
			for(int d : directions) {
				move(d);
			}
			answer = Math.max(answer, getMaxBlock());
			return;
		}
		
		for(int i = 1; i <= n; i++) {
			directions[depth] = i;
			perm(n, r, depth + 1);
		}
	}
	
    public static int[][] copyMap(int[][] map){
    	int[][] newMap = new int[map.length][map.length];
    	for(int i = 0; i < newMap.length; i++) {
    		for(int j = 0; j < newMap[0].length; j++) {
    			newMap[i][j] = map[i][j];
    		}
    	}
    	return newMap;
    }
	
	public static int getMaxBlock() {
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < tmpMap.length; i++) {
			for(int j = 0; j < tmpMap[0].length; j++) {
				max = Math.max(max, tmpMap[i][j]);
			}
		}
		return max;
	}
	
	public static void move(int direction) {
		visited = new boolean[originalMap.length][originalMap.length];
		
		switch(direction) {
			case UP:{
				for(int j = 0; j < tmpMap[0].length; j++) {
					for(int i = 0; i < tmpMap.length; i++) {
						moveBlock(i, j, direction);
					}
				}
				break;
			}
			case DOWN:{
				for(int j = 0; j < tmpMap[0].length; j++) {
					for(int i = tmpMap.length - 1; i >= 0; i--) {
						moveBlock(i, j, direction);
					}
				}
				break;
			}
			case LEFT:{
				for(int i = 0; i < tmpMap.length; i++) {
					for(int j = 0; j < tmpMap[0].length; j++) {
						moveBlock(i, j, direction);
					}
				}
				break;
			}
			case RIGHT:{
				for(int i = 0; i < tmpMap.length; i++) {
					for(int j = tmpMap[0].length - 1; j >= 0; j--) {
						moveBlock(i, j, direction);
					}
				}
				break;
			}
		}
	}
	
	public static void moveBlock(int row, int col, int direction) {
		int nextRow = row;
		int nextCol = col;
		boolean isMerged = false;
		while(true) {
			if(!rangeCheck(nextRow + dr[direction], nextCol + dc[direction])) break;
			if(tmpMap[nextRow + dr[direction]][nextCol + dc[direction]] != 0) {
				if(tmpMap[row][col] == tmpMap[nextRow + dr[direction]][nextCol + dc[direction]]) {
					if(!visited[nextRow + dr[direction]][nextCol + dc[direction]]) {
						visited[nextRow + dr[direction]][nextCol + dc[direction]] = true;
						tmpMap[nextRow + dr[direction]][nextCol + dc[direction]] += tmpMap[row][col];
						nextRow += dr[direction];
						nextCol += dc[direction];
						isMerged = true;
					}
				}
				break;
			}
			nextRow += dr[direction];
			nextCol += dc[direction];
		}
		
		if(!(row == nextRow && col == nextCol)) {
			if(!isMerged) {
				tmpMap[nextRow][nextCol] = tmpMap[row][col];
			}
			tmpMap[row][col] = 0;
		}
	}
	
	public static boolean rangeCheck(int row, int col) {
		return row >= 0 && row < tmpMap.length && col >= 0 && col < tmpMap[0].length;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());
		originalMap = new int[N][N];
		tmpMap = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			String[] split = br.readLine().split(" ");
			for(int j = 0; j < N; j++) {
				originalMap[i][j] = Integer.valueOf(split[j]);
			}
		}
		
		System.out.println(solution());
	}

}
