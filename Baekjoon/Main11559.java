import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main11559 {

	public static class Pair{
		int row;
		int col;
		
		public Pair(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
	public static boolean[][] visited;
	public static char[][] map;
	public static ArrayList<Pair> visitedList = new ArrayList<>();
	public static ArrayList<Pair> toDestroyList = new ArrayList<>();
	public static int[] dr = {-1, 1, 0, 0};
	public static int[] dc = {0, 0, -1, 1};
	
	public static int solution() {
		int answer = 0;
		boolean isRearranged = true;
		while(isRearranged) {
			
			isRearranged = false;
			visited = new boolean[map.length][map[0].length];
			toDestroyList.clear();
			
			for(int i = 0; i < map.length; i++) {
				for(int j = 0; j < map[0].length; j++) {
					if(!visited[i][j] && map[i][j] != '.') {
						visitedList.clear();
						dfs(i,j);
						if(visitedList.size() >= 4) {
							toDestroyList.addAll(visitedList);
							isRearranged = true;
						}
					}
				}
			}
			
			if(isRearranged) {
				answer++;
				destroy();
				pullToBottom();
			}
			
		}
		
		return answer;
	}
	
	public static void dfs(int row, int col) {
		visitedList.add(new Pair(row, col));
		visited[row][col] = true;
		for(int i = 0; i < 4; i++) {
			int nextRow = row + dr[i];
			int nextCol = col + dc[i];
			if(rangeCheck(nextRow, nextCol) && !visited[nextRow][nextCol]) {
				if(map[row][col] == map[nextRow][nextCol]) {
					dfs(nextRow, nextCol);
				}
			}
		}
	}
	
	public static boolean rangeCheck(int row, int col) {
		return row >= 0 && row < map.length && col >= 0 && col < map[0].length;
	}
	
	public static void destroy() {
		for(Pair p : toDestroyList) {
			map[p.row][p.col] = '.';
		}
	}
	
	public static void pullToBottom() {
		for(int i = map.length - 2; i >= 0; i--) {
			for(int j = 0; j < map[0].length; j++) {
				if(map[i][j] != '.') {
					int nowRow = i;
					int nowCol = j;
					while(true) {
						
						nowRow++;
						
						if(map[nowRow][nowCol] != '.') {
							nowRow--;
							break;
						}
						
						if(nowRow == map.length - 1) {
							break;
						}
					}
					char tmp = map[i][j];
					map[i][j] = '.';
					map[nowRow][nowCol] = tmp;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[12][6];
		for(int i = 0; i < 12; i++) {
			map[i] = br.readLine().toCharArray();
		}
		System.out.println(solution());
	}

}
