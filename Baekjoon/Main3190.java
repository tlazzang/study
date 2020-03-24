package SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Pair{
	int row;
	int col;
	
	public Pair(int row, int col) {
		this.row = row;
		this.col = col;
	}
}

public class Main3190 {
	
	public static final int DIRECTION_UP = 0;
	public static final int DIRECTION_DOWN = 1;
	public static final int DIRECTION_LEFT = 2;
	public static final int DIRECTION_RIGHT = 3;
	
	public static final int APPLE = 100;
	public static final int SNAKE = 200;
	public static final int NON_APPLE = 0;
	
	public static int now_direction = DIRECTION_RIGHT;
	public static Queue<String> directionInfo = new LinkedList<>();
	public static Queue<Pair> snakeTraceInfo = new LinkedList<>();
	public static int[][] board;
	
	public static int solution() {
		int nowTime = 0;
		int headRow = 0;
		int headCol = 0;
		snakeTraceInfo.add(new Pair(0,0));
		board[0][0] = SNAKE;
		
		while(true) {
			switch(now_direction) {
				case DIRECTION_UP:{
					headRow = headRow - 1;
					break;
				}
				case DIRECTION_DOWN:{
					headRow = headRow + 1;		
					break;
				}
				case DIRECTION_LEFT:{
					headCol = headCol - 1;
					break;
				}
				case DIRECTION_RIGHT:{
					headCol = headCol + 1;
					break;
				}
			}
			if(headRow < 0 || headRow > board.length - 1 || headCol < 0 || headCol > board.length - 1) return nowTime + 1;
			//헤드 다음칸으로 이동.
			if(board[headRow][headCol] == NON_APPLE) {
				snakeTraceInfo.add(new Pair(headRow, headCol));
				board[headRow][headCol] = SNAKE;
				Pair p = snakeTraceInfo.poll();
				board[p.row][p.col] = NON_APPLE;
			}else if(board[headRow][headCol] == APPLE){
				board[headRow][headCol] = SNAKE;
				snakeTraceInfo.add(new Pair(headRow, headCol));
			}else if(board[headRow][headCol] == SNAKE) {
				return nowTime + 1;
			}
			
			nowTime++;
			
			if(!directionInfo.isEmpty() && nowTime == Integer.valueOf(directionInfo.peek().split(" ")[0])) {
				switch(now_direction) {
					case DIRECTION_UP:{
						if(directionInfo.peek().split(" ")[1].equals("L")){
							now_direction = DIRECTION_LEFT;
						}
						else {
							now_direction = DIRECTION_RIGHT;
						}
						break;
					}
					case DIRECTION_DOWN:{
						if(directionInfo.peek().split(" ")[1].equals("L")){
							now_direction = DIRECTION_RIGHT;
						}
						else {
							now_direction = DIRECTION_LEFT;
						}
						break;
					}
					case DIRECTION_LEFT:{
						if(directionInfo.peek().split(" ")[1].equals("L")){
							now_direction = DIRECTION_DOWN;
						}
						else {
							now_direction = DIRECTION_UP;
						}
						break;
					}
					case DIRECTION_RIGHT:{
						if(directionInfo.peek().split(" ")[1].equals("L")){
							now_direction = DIRECTION_UP;
						}
						else {
							now_direction = DIRECTION_DOWN;
						}
						break;
					}
				}
				directionInfo.poll();
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());
		board = new int[N][N];
		int numOfApple = Integer.valueOf(br.readLine());
		for(int i = 0; i < numOfApple; i++) {
			String[] split = br.readLine().split(" ");
			int row = Integer.valueOf(split[0]);
			int col = Integer.valueOf(split[1]);
			board[row - 1][col - 1] = APPLE;
		}
		int numOfTransition = Integer.valueOf(br.readLine());
		for(int i = 0; i < numOfTransition; i++) {
			directionInfo.add(br.readLine());
		}
		System.out.println(solution());
	}
}
