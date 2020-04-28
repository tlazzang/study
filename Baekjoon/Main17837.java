import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main17837 {
	
	public static class Horse{
		int num;
		int row;
		int col;
		int direction;
		
		public Horse(int num, int row, int col, int direction){
			this.num = num;
			this.row = row;
			this.col = col;
			this.direction = direction;
		}
	}
	public static final int RIGHT = 1;
	public static final int LEFT = 2;
	public static final int UP = 3;
	public static final int DOWN = 4;
	public static int[] dr = {0, 0, 0, -1, 1};
	public static int[] dc = {0, 1, -1, 0, 0};
	
	public static int N, K;
	public static int[][] map;
	public static ArrayList<Horse>[][] horseInfo;
	public static ArrayList<Horse> horseList = new ArrayList<>();
	
	public static int solution() {
		int result = 1;
		while(true) {
			
			if(result > 1000) return -1;
			
			for(Horse horse: horseList) {
				
				int nextRow = 0;
				int nextCol = 0;
				
				switch(horse.direction) {
					case RIGHT:{
						nextRow = horse.row + dr[RIGHT];
						nextCol = horse.col + dc[RIGHT];
						break;
					}
					case LEFT:{
						nextRow = horse.row + dr[LEFT];
						nextCol = horse.col + dc[LEFT];
						break;
					}
					case UP:{
						nextRow = horse.row + dr[UP];
						nextCol = horse.col + dc[UP];
						break;
					}
					case DOWN:{
						nextRow = horse.row + dr[DOWN];
						nextCol = horse.col + dc[DOWN];
						break;
					}
				}
				
				if(!rangeCheck(nextRow, nextCol) || map[nextRow][nextCol] == 2) {
					switch(horse.direction) {
						case RIGHT:{
							horse.direction = LEFT;
							nextRow = horse.row + dr[LEFT];
							nextCol = horse.col + dc[LEFT];
							break;
						}
						case LEFT:{
							horse.direction = RIGHT;
							nextRow = horse.row + dr[RIGHT];
							nextCol = horse.col + dc[RIGHT];
							break;
						}
						case UP:{
							horse.direction = DOWN;
							nextRow = horse.row + dr[DOWN];
							nextCol = horse.col + dc[DOWN];
							break;
						}
						case DOWN:{
							horse.direction = UP;
							nextRow = horse.row + dr[UP];
							nextCol = horse.col + dc[UP];
							break;
						}
					}
				}
				
				if(!rangeCheck(nextRow, nextCol) || map[nextRow][nextCol] == 2) {
					continue;
				}
				
				ArrayList<Horse> nowList = horseInfo[horse.row][horse.col];
				ArrayList<Horse> nextList = horseInfo[nextRow][nextCol];
				
				int startIdx = 0;
				for(int i = 0; i < nowList.size(); i++) {
					if(nowList.get(i).num == horse.num) {
						startIdx = i;
						break;
					}
				}
				
				ArrayList<Horse> tmp = new ArrayList<>();
				for(int i = startIdx; i < nowList.size(); i++) {
					nowList.get(i).row = nextRow;
					nowList.get(i).col = nextCol;
					tmp.add(nowList.get(i));
				}
				
				if(map[nextRow][nextCol] == 0) {
					nextList.addAll(tmp);
				}else if(map[nextRow][nextCol] == 1) {
					Collections.reverse(tmp);
					nextList.addAll(tmp);
				}
				
				nowList.subList(startIdx, nowList.size()).clear();
				
				if(nextList.size() >= 4) {
					return result;
				}
			}
			result++;
		}
	}
	
	public static boolean rangeCheck(int row, int col) {
		return row >= 0 && row < N && col >= 0 && col < N;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		N = Integer.valueOf(split[0]);
		K = Integer.valueOf(split[1]);
		map = new int[N][N];
		horseInfo = new ArrayList[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				horseInfo[i][j] = new ArrayList<Horse>();
			}
		}
		for(int i = 0; i < N; i++) {
			split = br.readLine().split(" ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.valueOf(split[j]);
			}
		}
		
		for(int i = 0; i < K; i++) {
			split = br.readLine().split(" ");
			int row = Integer.valueOf(split[0]) - 1;
			int col = Integer.valueOf(split[1]) - 1;
			int direction = Integer.valueOf(split[2]);
			Horse horse = new Horse(i, row, col, direction);
			horseList.add(horse);
			horseInfo[row][col].add(horse);
		}
		
		System.out.println(solution());
	}

}
