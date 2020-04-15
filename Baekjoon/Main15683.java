import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Main15683 {
	
	public static class Cctv{
		int row;
		int col;
		int type;
		
		public Cctv(int row, int col, int type) {
			this.row = row;
			this.col = col;
			this.type = type;
		}
	}
	
	public static int[][] dir = {{0},{0,2},{0,3},{0,2,3},{0,1,2,3}};
	public static int[] dr = {0, 1, 0, -1};
	public static int[] dc = {1, 0, -1, 0};
	public static int[][] map;
	public static int numOfCCTV = 0;
	public static boolean[][] watched;
	public static int answer = Integer.MAX_VALUE;
	public static ArrayList<Cctv> cctvPosition = new ArrayList<>();
	
	public static int solution() {
		dfs(0, 0, watched);
		return answer;
	}
	
	public static void dfs(int startIdx, int picked, boolean[][] watched) {
		if(picked == numOfCCTV) {
			answer = Math.min(answer, getNumOfBlindSpot(watched));
			return;
		}
//		for(int i = startIdx; i < cctvPosition.size(); i++) {
			Cctv c = cctvPosition.get(startIdx);
			for(int k = 0; k < 4; k++) {
				boolean[][] newWatched = copy(watched);
				for(int l = 0; l < dir[c.type - 1].length; l++) {
					int direction = (dir[c.type - 1][l] + k) % 4;
					int row = c.row;
					int col = c.col;
					while(rangeCheck(row, col) && map[row][col] != 6) {
						newWatched[row][col] = true;
						row = row + dr[direction];
						col = col + dc[direction];
					}
				}
				dfs(startIdx + 1, picked + 1, newWatched);
			}
//		}
	}
	
	public static boolean rangeCheck(int row, int col) {
		return row >= 0 && row < map.length && col >= 0 && col < map[0].length;
	}
	
	public static boolean[][] copy(boolean[][] arr) {
		boolean[][] tmp = new boolean[arr.length][arr[0].length];
		for(int i = 0; i < tmp.length; i++) {
			for(int j = 0; j < tmp[0].length; j++) {
				tmp[i][j] = arr[i][j];
			}
		}
		return tmp;
	}
//	public static void unwatchOffice(int cnt) {
//		for(int i = 0; i < cnt; i++) {
//			Pair p = stack.pop();
//			watched[p.row][p.col] = false;
//		}
//	}
//	public static void watchOffice(int row, int col, int direction) {
//		switch(direction) {
//			case 0:{
//				for(int j = col; j < map[0].length; j++) {
//					if(map[row][j] == 6) break;
//					watched[row][j] = true;
//				}
//				break;
//			}
//			case 1:{
//				for(int i = row; i < map.length; i++) {
//					if(map[i][col] == 6) break;
//					watched[i][col] = true;
//				}
//				break;
//			}
//			case 2:{
//				for(int j = col; j >= 0; j--) {
//					if(map[row][j] == 6) break;
//					watched[row][j] = true;
//				}		
//				break;
//			}
//			case 3:{
//				for(int i = row; i >= 0; i--) {
//					if(map[i][col] == 6) break;
//					watched[i][col] = true;
//				}
//				break;
//			}
//		}
//	}
	
//	public static int watchOffice(int row, int col, int type, int direction) {
//		int cnt = 0;
//		switch(type) {
//		case 1:{
//			if(direction == 0) {
//				for(int j = col; j < map[0].length; j++) {
//					if(map[row][j] == 6) break;
//					if(!watched[row][j]) {
//						watched[row][j] = true;
//						stack.add(new Pair(row, j));
//						cnt++;
//					}
//				}
//			}
//			if(direction == 1) {
//				for(int i = row; i < map.length; i++) {
//					if(map[i][col] == 6) break;
//					if(!watched[i][col]) {
//						watched[i][col] = true;
//						stack.add(new Pair(i, col));
//						cnt++;
//					}
//				}
//			}
//			if(direction == 2) {
//				for(int j = col; j >= 0; j--) {
//					if(map[row][j] == 6) break;
//					if(!watched[row][j]) {
//						stack.add(new Pair(row, j));
//						watched[row][j] = true;
//						cnt++;
//					}
//				}			
//			}
//			if(direction == 3) {
//				for(int i = row; i >= 0; i--) {
//					if(map[i][col] == 6) break;
//					if(!watched[i][col]) {
//						stack.add(new Pair(i, col));
//						watched[i][col] = true;
//						cnt++;
//					}
//				}
//			}
//			break;
//		}
//		case 2:{
//			if(direction == 0 || direction == 2) {
//				for(int j = col; j >= 0; j--) {
//					if(map[row][j] == 6) break;
//					if(!watched[row][j]) {
//						watched[row][j] = true;
//						stack.add(new Pair(row, j));
//						cnt++;
//					}
//				}
//				
//				for(int j = col; j < map[0].length; j++) {
//					if(map[row][j] == 6) break;
//					if(!watched[row][j]) {
//						watched[row][j] = true;
//						stack.add(new Pair(row, j));
//						cnt++;
//					}
//				}
//			}
//			if(direction == 1 || direction == 3) {
//				for(int i = row; i >= 0; i--) {
//					if(map[i][col] == 6) break;
//					if(!watched[i][col]) {
//						watched[i][col] = true;
//						stack.add(new Pair(i, col));
//						cnt++;
//					}
//				}
//				
//				for(int i = row; i < map.length; i++) {
//					if(map[i][col] == 6) break;
//					if(!watched[i][col]) {
//						watched[i][col] = true;
//						stack.add(new Pair(i, col));
//						cnt++;
//					}
//				}
//			}
//			break;
//		}
//		case 3:{
//			if(direction == 0) {
//				for(int i = row; i >= 0; i--) {
//					if(map[i][col] == 6) break;
//					if(!watched[i][col]) {
//						watched[i][col] = true;
//						stack.add(new Pair(i, col));
//						cnt++;
//					}
//				}
//				
//				for(int j = col; j < map[0].length; j++) {
//					if(map[row][j] == 6) break;
//					if(!watched[row][j]) {
//						watched[row][j] = true;
//						stack.add(new Pair(row, j));
//						cnt++;
//					}
//				}
//			}
//			if(direction == 1) {
//				for(int i = row; i < map.length; i++) {
//					if(map[i][col] == 6) break;
//					if(!watched[i][col]) {
//						watched[i][col] = true;
//						stack.add(new Pair(i, col));
//						cnt++;
//					}
//				}
//				
//				for(int j = col; j < map[0].length; j++) {
//					if(map[row][j] == 6) break;
//					if(!watched[row][j]) {
//						watched[row][j] = true;
//						stack.add(new Pair(row, j));
//						cnt++;
//					}
//				}
//			}
//			if(direction == 2) {
//				for(int i = row; i < map.length; i++) {
//					if(map[i][col] == 6) break;
//					if(!watched[i][col]) {
//						watched[i][col] = true;
//						stack.add(new Pair(i, col));
//						cnt++;
//					}
//				}
//				
//				for(int j = col; j >= 0; j--) {
//					if(map[row][j] == 6) break;
//					if(!watched[row][j]) {
//						watched[row][j] = true;
//						stack.add(new Pair(row, j));
//						cnt++;
//					}
//				}
//			}
//			if(direction == 3) {
//				for(int i = row; i >= 0; i--) {
//					if(map[i][col] == 6) break;
//					if(!watched[i][col]) {
//						watched[i][col] = true;
//						stack.add(new Pair(i, col));
//						cnt++;
//					}
//				}
//				
//				for(int j = col; j >= 0; j--) {
//					if(map[row][j] == 6) break;
//					if(!watched[row][j]) {
//						watched[row][j] = true;
//						stack.add(new Pair(row, j));
//						cnt++;
//					}
//				}
//			}
//			break;
//		}
//		case 4:{
//			if(direction == 0) {
//				for(int j = col; j >= 0; j--) {
//					if(map[row][j] == 6) break;
//					if(!watched[row][j]) {
//						watched[row][j] = true;
//						stack.add(new Pair(row, j));
//						cnt++;
//					}
//				}
//				
//				for(int i = row; i >= 0; i--) {
//					if(map[i][col] == 6) break;
//					if(!watched[i][col]) {
//						watched[i][col] = true;
//						stack.add(new Pair(i, col));
//						cnt++;
//					}
//				}
//				
//				for(int j = col; j < map[0].length; j++) {
//					if(map[row][j] == 6) break;
//					if(!watched[row][j]) {
//						watched[row][j] = true;
//						stack.add(new Pair(row, j));
//						cnt++;
//					}
//				}
//			
//			}
//			if(direction == 1) {
//				for(int i = row; i >= 0; i--) {
//					if(map[i][col] == 6) break;
//					if(!watched[i][col]) {
//						watched[i][col] = true;
//						stack.add(new Pair(i, col));
//						cnt++;
//					}
//				}
//				
//				for(int j = col; j < map[0].length; j++) {
//					if(map[row][j] == 6) break;
//					if(!watched[row][j]) {
//						watched[row][j] = true;
//						stack.add(new Pair(row, j));
//						cnt++;
//					}
//				}
//				
//				for(int i = row; i < map.length; i++) {
//					if(map[i][col] == 6) break;
//					if(!watched[i][col]) {
//						watched[i][col] = true;
//						stack.add(new Pair(i, col));
//						cnt++;
//					}
//				}
//			}
//			if(direction == 2) {
//				for(int i = row; i < map.length; i++) {
//					if(map[i][col] == 6) break;
//					if(!watched[i][col]) {
//						watched[i][col] = true;
//						stack.add(new Pair(i, col));
//						cnt++;
//					}
//				}
//				
//				for(int j = col; j >= 0; j--) {
//					if(map[row][j] == 6) break;
//					if(!watched[row][j]) {
//						watched[row][j] = true;
//						stack.add(new Pair(row, j));
//						cnt++;
//					}
//				}
//				
//				for(int j = col; j < map[0].length; j++) {
//					if(map[row][j] == 6) break;
//					if(!watched[row][j]) {
//						watched[row][j] = true;
//						stack.add(new Pair(row, j));
//						cnt++;
//					}
//				}
//			}
//			if(direction == 3) {
//				for(int i = row; i < map.length; i++) {
//					if(map[i][col] == 6) break;
//					if(!watched[i][col]) {
//						watched[i][col] = true;
//						stack.add(new Pair(i, col));
//						cnt++;
//					}
//				}
//				
//				for(int j = col; j >= 0; j--) {
//					if(map[row][j] == 6) break;
//					if(!watched[row][j]) {
//						watched[row][j] = true;
//						stack.add(new Pair(row, j));
//						cnt++;
//					}
//				}
//				
//				for(int i = row; i >= 0; i--) {
//					if(map[i][col] == 6) break;
//					if(!watched[i][col]) {
//						watched[i][col] = true;
//						stack.add(new Pair(i, col));
//						cnt++;
//					}
//				}
//			}
//			break;
//		}
//		case 5:{
//			for(int i = row; i < map.length; i++) {
//				if(map[i][col] == 6) break;
//				if(!watched[i][col]) {
//					watched[i][col] = true;
//					stack.add(new Pair(i, col));
//					cnt++;
//				}
//			}
//			
//			for(int j = col; j >= 0; j--) {
//				if(map[row][j] == 6) break;
//				if(!watched[row][j]) {
//					watched[row][j] = true;
//					stack.add(new Pair(row, j));
//					cnt++;
//				}
//			}
//			
//			for(int i = row; i >= 0; i--) {
//				if(map[i][col] == 6) break;
//				if(!watched[i][col]) {
//					watched[i][col] = true;
//					stack.add(new Pair(i, col));
//					cnt++;
//				}
//			}
//			
//			for(int j = col; j < map[0].length; j++) {
//				if(map[row][j] == 6) break;
//				if(!watched[row][j]) {
//					watched[row][j] = true;
//					stack.add(new Pair(row, j));
//					cnt++;
//				}
//			}
//			break;
//		}
//	}
//		return cnt;
//	}
	
	public static int getNumOfBlindSpot(boolean[][] watched) {
		int result = 0;
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[0].length; j++) {
				if(map[i][j] == 0 && !watched[i][j]) {
					result++;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		int row = Integer.valueOf(split[0]);
		int col = Integer.valueOf(split[1]);
		map = new int[row][col];
		watched = new boolean[row][col];
		for(int i = 0; i < row; i++) {
			split = br.readLine().split(" ");
			for(int j = 0; j < col; j++) {
				if(Integer.valueOf(split[j]) > 0 && Integer.valueOf(split[j]) < 6) {
					Cctv c = new Cctv(i, j, Integer.valueOf(split[j]));
					cctvPosition.add(c);
					numOfCCTV++;
				}
				map[i][j] = Integer.valueOf(split[j]);
			}
		}
		System.out.println(solution());
	}

}
